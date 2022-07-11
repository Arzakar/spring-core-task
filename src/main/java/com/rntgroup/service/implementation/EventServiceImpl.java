package com.rntgroup.service.implementation;

import com.rntgroup.model.Event;
import com.rntgroup.repository.EventRepository;
import com.rntgroup.service.EventService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Event with id = %d not found", id)));
    }

    @Override
    public List<Event> findByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    @Override
    public List<Event> findByDate(Date date) {
        return eventRepository.findByDate(date);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.update(event);
    }

    @Override
    public Event deleteById(long eventId) {
        return eventRepository.deleteById(eventId);
    }
}
