package com.rntgroup.repository.implementation;

import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;
import com.rntgroup.repository.TicketRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TicketRepositoryImpl implements TicketRepository {

    Map<Long, Ticket> tickets = new HashMap<>();

    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public Optional<Ticket> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Ticket update(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket deleteById(Long aLong) {
        return null;
    }

    @Override
    public List<Ticket> findByUser(User user) {
        return null;
    }

    @Override
    public List<Ticket> findByEvent(Event event) {
        return null;
    }

    @Override
    public boolean existByPlace(int place) {
        return false;
    }
}
