package com.ltp.todoliststuff.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.ltp.todoliststuff.entity.Todo;
import com.ltp.todoliststuff.entity.TodoList;
import com.ltp.todoliststuff.exception.EntityNotFoundException;
import com.ltp.todoliststuff.repository.TodoListRepository;
import com.ltp.todoliststuff.repository.TodoRepository;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private TodoListRepository todoListRepository;
    
    @Override
    public Todo getTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return unwrapTodo(todo, id);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {  
        todoRepository.deleteById(id);      
    }

    @Override
    public List<Todo> getTodos() {
        return (List<Todo>)todoRepository.findAll();
    }


    static Todo unwrapTodo(Optional<Todo> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Todo.class);
    }


}
