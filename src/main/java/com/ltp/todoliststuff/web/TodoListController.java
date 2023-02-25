package com.ltp.todoliststuff.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.todoliststuff.entity.Todo;
import com.ltp.todoliststuff.entity.TodoList;
import com.ltp.todoliststuff.repository.TodoListRepository;
import com.ltp.todoliststuff.service.TodoListService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/lists")
public class TodoListController {

    private TodoListService todoListService;
    private TodoListRepository todoListRepository;

    @GetMapping
    public ResponseEntity<List<TodoList>> getTodoLists() {
        return new ResponseEntity<>(todoListService.getAllTodoLists(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoList(@PathVariable Long id) {
        return new ResponseEntity<>(todoListService.getTodoList(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveTodoList(@Valid @RequestBody TodoList todoList) {
        todoListService.saveTodoList(todoList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addTodoToList/{id}")
    public ResponseEntity<HttpStatus> addTodoToList(@Valid @RequestBody Todo todo, @PathVariable Long id) {
        Optional<TodoList> todoListOptional = todoListRepository.findById(id);
        if (todoListOptional.isPresent()) {
            TodoList todoList = todoListOptional.get();
            todoList.addTodo(todo);
            todoListRepository.save(todoList);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   

}
