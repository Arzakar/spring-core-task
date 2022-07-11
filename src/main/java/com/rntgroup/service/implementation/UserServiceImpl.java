package com.rntgroup.service.implementation;

import com.rntgroup.model.User;
import com.rntgroup.repository.UserRepository;
import com.rntgroup.service.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("User with id = %d not found", id)));
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("User with email = %s not found", email)));
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User deleteById(long id) {
        return userRepository.deleteById(id);
    }
}
