package com.rntgroup.service.implementation;

import com.rntgroup.model.Event;
import com.rntgroup.repository.EventRepository;
import com.rntgroup.repository.util.Page;
import com.rntgroup.service.EventService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventServiceImpl implements EventService {

    EventRepository eventRepository;

    public String getRepoInfo() {
        return eventRepository + " - eventRepository";
    }

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
    public List<Event> findByTitle(String title, int pageSize, int pageNum) {
        return eventRepository.findByTitle(title, Page.of(pageSize, pageNum))
                .getContent();
    }

    @Override
    public List<Event> findByDate(Date date, int pageSize, int pageNum) {
        return eventRepository.findByDate(date, Page.of(pageSize, pageNum))
                .getContent();
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
