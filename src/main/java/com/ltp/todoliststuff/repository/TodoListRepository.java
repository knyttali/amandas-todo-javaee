package com.ltp.todoliststuff.repository;

import org.springframework.data.repository.CrudRepository;

import com.ltp.todoliststuff.entity.TodoList;


public interface TodoListRepository extends CrudRepository<TodoList, Long> {

}