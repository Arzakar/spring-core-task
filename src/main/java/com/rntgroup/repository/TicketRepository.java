package com.rntgroup.repository;

import com.rntgroup.db.TicketDatabase;
import com.rntgroup.model.Ticket;
import com.rntgroup.repository.util.Page;
import com.rntgroup.repository.util.SearchResult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketRepository extends AbstractRepository<Ticket, Long> {

    TicketDatabase database;

    public SearchResult<Ticket> findByUserId(long userId, Page page) {
        return SearchResult.pack(getDatabase().selectByUserId(userId), page);
    }

    public SearchResult<Ticket> findByEventId(long eventId, Page page) {
        return SearchResult.pack(getDatabase().selectByEventId(eventId), page);
    }

    public boolean existByPlace(Ticket ticket) {
        return Objects.nonNull(getDatabase().selectByEventIdAndPlace(ticket.getEventId(), ticket.getPlace()));
    }
}
