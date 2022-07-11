package com.rntgroup.service;

import com.rntgroup.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User findById(long id);
    List<User> findByName(String name);
    User findByEmail(String email);

    User update(User user);

    User deleteById(long id);
}
