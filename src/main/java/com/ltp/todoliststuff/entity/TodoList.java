package com.ltp.todoliststuff.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "todolist")
public class TodoList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private ArrayList<Todo> todos = new ArrayList<Todo>();

    
    public TodoList() {
        todos = new ArrayList<>();
        todos.add(new Todo("What are you going to do?"));
    }
    public TodoList(String code) {
        this.code = code;
        this.todos = new ArrayList<>();
        Todo todo = new Todo("What are you going to do?");
        todo.setId(getLastTodosId() + 1);
        this.todos.add(todo);
    }
    public void addTodo(@Valid Todo todo) {
        todo.setId(getLastTodosId());
        this.todos.add(todo);
    }



   
    public Long getLastTodosId(){
        if(this.todos.size() < 1){
            
        }

        Long lastId = this.todos.get(this.todos.size() - 1).getId();

 
        if(lastId == null){
            return Long.valueOf(1);   //måste fixa detta med id:n........ det finns nu två sätt dom får id och det kan mycket väl krocka :S
        } 
        return lastId;
    }
}