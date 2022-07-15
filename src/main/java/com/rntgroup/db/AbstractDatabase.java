package com.rntgroup.db;

import com.rntgroup.model.Entity;

import java.util.Objects;

public abstract class AbstractDatabase<ID, T extends Entity<ID>> implements Database<ID, T> {

    @Override
    public T insert(T entity) {
        ID id = generateId();
        entity.setId(id);
        getData().put(id, entity);
        return entity;
    }

    @Override
    public T selectById(ID id) {
        return getData().get(id);
    }

    @Override
    public T update(T entity) {
        ID id = entity.getId();

        if (Objects.nonNull(getData().get(id))) {
            getData().put(id, entity);
            return entity;
        }

        return null;
    }

    public T deleteById(ID id) {
        return getData().remove(id);
    }

    @Override
    public long getSize() {
        return getData().size();
    }
}
