package com.ltp.todoliststuff.repository;

import org.springframework.data.repository.CrudRepository;

import com.ltp.todoliststuff.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}