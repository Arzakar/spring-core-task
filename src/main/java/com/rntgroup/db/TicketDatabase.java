package com.rntgroup.db;

import com.rntgroup.db.util.IdGenerator;
import com.rntgroup.model.Ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketDatabase extends AbstractDatabase<Long, Ticket> {

    static final Logger LOG = LoggerFactory.getLogger(TicketDatabase.class.getSimpleName());

    Map<Long, Ticket> data = new HashMap<>();

    public List<Ticket> selectByEventId(long eventId) {
        LOG.debug("Method {}#selectByEventId was called with param: eventId = {}", this.getClass().getSimpleName(), eventId);
        return getData().values().stream()
                .filter(ticket -> ticket.getEventId() == eventId)
                .collect(Collectors.toList());
    }

    public List<Ticket> selectByUserId(long userId) {
        LOG.debug("Method {}#selectByUserId was called with param: userId = {}", this.getClass().getSimpleName(), userId);
        return getData().values().stream()
                .filter(ticket -> ticket.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public Ticket selectByEventIdAndPlace(long eventId, int place) {
        LOG.debug("Method {}#selectByEventIdAndPlace was called with params: eventId = {}, place = {}",
                this.getClass().getSimpleName(), eventId, place);
        return getData().values().stream()
                .filter(ticket -> ticket.getEventId() == eventId && ticket.getPlace() == place)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Long generateId() {
        return IdGenerator.generate(data);
    }
}
