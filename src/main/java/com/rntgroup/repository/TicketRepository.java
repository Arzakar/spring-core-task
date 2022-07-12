package com.rntgroup.repository;

import com.rntgroup.db.TicketDatabase;
import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;
import com.rntgroup.repository.AbstractRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketRepository extends AbstractRepository<Ticket, Long> {

    TicketDatabase database;

    public List<Ticket> findByUser(User user) {
        return getDatabase().selectByUserId(user.getId());
    }

    public List<Ticket> findByEvent(Event event) {
        return getDatabase().selectByEventId(event.getId());
    }

    public boolean existByPlace(Ticket ticket) {
        return Objects.nonNull(getDatabase().selectByEventIdAndPlace(ticket.getEventId(), ticket.getPlace()));
    }
}
