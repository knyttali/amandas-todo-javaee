package com.ltp.todoliststuff.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ltp.todoliststuff.entity.Todo;
import com.ltp.todoliststuff.entity.TodoList;
import com.ltp.todoliststuff.exception.EntityNotFoundException;
import com.ltp.todoliststuff.exception.ResourceNotFoundException;
import com.ltp.todoliststuff.repository.TodoListRepository;
import com.ltp.todoliststuff.repository.TodoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;
    private TodoRepository todoRepository;

    @Override
    public TodoList addTodo(Long todoListId, Todo todo1) {
        TodoList todoList = todoListRepository.findById(todoListId)
                .orElseThrow(() -> new ResourceNotFoundException("TodoList not found with id " + todoListId));
        Todo todo = new Todo(todo1.getDescription());
        todoRepository.save(todo);
        todoList.addTodo(todo);
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList getTodoList(Long id) {
        Optional<TodoList> todoList = todoListRepository.findById(id);
        return unwrapTodoList(todoList, id);
    }

    @Override
    public void saveTodoList(TodoList todoList) {
        todoListRepository.save(todoList);
    }

    @Override
    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

    @Override
    public List<TodoList> getAllTodoLists() {
        return (List<TodoList>) todoListRepository.findAll();
    }

    static TodoList unwrapTodoList(Optional<TodoList> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(id, TodoList.class);
    }

}