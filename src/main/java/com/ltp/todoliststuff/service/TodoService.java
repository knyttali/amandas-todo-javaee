package com.ltp.todoliststuff.service;

import java.util.List;
import java.util.Set;

import com.ltp.todoliststuff.entity.Todo;

public interface TodoService {
    Todo getTodo(Long id);
    Todo saveTodo(Todo todo);
    void deleteTodo(Long id);    
    List<Todo> getTodos();
}