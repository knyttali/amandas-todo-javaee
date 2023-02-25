package com.ltp.todoliststuff.service;


import java.util.List;

import com.ltp.todoliststuff.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
    List<User> getAllUsers();

}