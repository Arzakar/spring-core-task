package com.rntgroup.service;

import com.rntgroup.model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    Event create(Event event);

    Event findById(long id);
    List<Event> findByTitle(String title);
    List<Event> findByDate(Date date);

    Event update(Event event);

    Event deleteById(long eventId);
}
