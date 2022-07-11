package com.rntgroup.service;

import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;

import java.util.List;

public interface TicketService {

    Ticket create(Ticket ticket);

    List<Ticket> findByUser(User user);
    List<Ticket> findByEvent(Event event);

    Ticket deleteById(long id);
}
