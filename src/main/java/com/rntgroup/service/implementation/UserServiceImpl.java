package com.rntgroup.service.implementation;

import com.rntgroup.model.User;
import com.rntgroup.repository.UserRepository;
import com.rntgroup.repository.util.Page;
import com.rntgroup.service.UserService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

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
    public List<User> findByName(String name, int pageSize, int pageNum) {
        return userRepository.findByName(name, Page.of(pageSize, pageNum))
                .getContent();
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
