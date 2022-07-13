package com.rntgroup.db;

import com.rntgroup.model.Entity;

public abstract class AbstractDatabase<ID, T extends Entity<ID>> implements Database<ID, T> {

    protected AbstractDatabase() {
        System.out.println("База данных " + this.getClass().getSimpleName() + " создана");
    }

    @Override
    public T insert(T entity) {
        ID id = generateId();
        entity.setId(id);
        return getData().put(id, entity);
    }

    @Override
    public T selectById(ID id) {
        return getData().get(id);
    }

    @Override
    public T update(T entity) {
        return getData().put(entity.getId(), entity);
    }

    public T deleteById(ID id) {
        return getData().remove(id);
    }

    @Override
    public long getSize() {
        return getData().size();
    }
}
