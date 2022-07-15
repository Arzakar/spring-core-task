package com.rntgroup.service.implementation;

import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;
import com.rntgroup.repository.TicketRepository;
import com.rntgroup.repository.util.Page;
import com.rntgroup.service.TicketService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketServiceImpl implements TicketService {

    TicketRepository ticketRepository;

    @Override
    public Ticket create(Ticket ticket) {
        if (ticketRepository.existByPlace(ticket)) {
            throw new IllegalStateException(String.format("Ticket with place = %d already exist", ticket.getPlace()));
        }

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findByUser(User user, int pageSize, int pageNum) {
        return ticketRepository.findByUserId(user.getId(), Page.of(pageSize, pageNum))
                .getContent();
    }

    @Override
    public List<Ticket> findByEvent(Event event, int pageSize, int pageNum) {
        return ticketRepository.findByEventId(event.getId(), Page.of(pageSize, pageNum))
                .getContent();
    }

    @Override
    public Ticket deleteById(long id) {
        return ticketRepository.deleteById(id);
    }
}
