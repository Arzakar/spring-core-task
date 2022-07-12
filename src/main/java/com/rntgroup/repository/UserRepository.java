package com.rntgroup.repository;

import com.rntgroup.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    List<User> findByName(String name);
    Optional<User> findByEmail(String email);

}
