package com.rntgroup.repository;

import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;

import java.util.List;

public interface TicketRepository extends Repository<Ticket, Long> {

    List<Ticket> findByUser(User user);
    List<Ticket> findByEvent(Event event);

    boolean existByPlace(int place);

}
