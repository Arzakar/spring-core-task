package com.rntgroup.repository;

import com.rntgroup.db.Database;
import com.rntgroup.model.Entity;

import java.util.Optional;

public abstract class AbstractRepository<T extends Entity<ID>, ID> implements Repository<T, ID> {

    public AbstractRepository() {
        System.out.println("Репозиторий " + this.getClass().getSimpleName() + " создан");
    }

    @Override
    public T save(T entity) {
        return getDatabase().insert(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.of(getDatabase().selectById(id));
    }

    @Override
    public T update(T entity) {
        return getDatabase().update(entity);
    }

    @Override
    public T deleteById(ID id) {
        return getDatabase().deleteById(id);
    }
}