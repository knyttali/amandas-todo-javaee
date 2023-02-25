package com.ltp.todoliststuff.service;

import java.util.List;

import com.ltp.todoliststuff.entity.Todo;
import com.ltp.todoliststuff.entity.TodoList;

public interface TodoListService {
    TodoList getTodoList(Long id);
    void saveTodoList(TodoList todoList);
    void deleteTodoList(Long id);
    List<TodoList> getAllTodoLists();
    TodoList addTodo(Long todoListId, Todo todo); 
}