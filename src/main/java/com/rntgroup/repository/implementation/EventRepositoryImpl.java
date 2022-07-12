package com.rntgroup.repository.implementation;

import com.rntgroup.model.Event;
import com.rntgroup.repository.EventRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EventRepositoryImpl implements EventRepository {

    Map<Long, Event> events = new HashMap<>();

    @Override
    public List<Event> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Event> findByDate(Date date) {
        return null;
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public Event deleteById(Long aLong) {
        return null;
    }
}
