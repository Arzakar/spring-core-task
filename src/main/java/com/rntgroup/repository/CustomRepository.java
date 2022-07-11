package com.rntgroup.repository;

import java.util.List;
import java.util.Optional;

public interface CustomRepository<T, ID> {

    T save(T t);

    List<T> findAll();
    Optional<T> findById(ID id);

    T update(T t);

    T deleteById(ID id);
}
