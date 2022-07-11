package com.rntgroup.repository;

import com.rntgroup.model.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository extends CustomRepository<Event, Long> {

    List<Event> findByTitle(String title);
    List<Event> findByDate(Date date);

}
