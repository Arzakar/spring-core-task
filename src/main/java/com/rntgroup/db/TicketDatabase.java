package com.rntgroup.db;

import com.rntgroup.db.util.IdGenerator;
import com.rntgroup.model.Ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketDatabase extends AbstractDatabase<Long, Ticket> {

    Map<Long, Ticket> data = new HashMap<>();

    public List<Ticket> selectByEventId(long eventId) {
        return getData().values().stream()
                .filter(ticket -> ticket.getEventId() == eventId)
                .collect(Collectors.toList());
    }

    public List<Ticket> selectByUserId(long userId) {
        return getData().values().stream()
                .filter(ticket -> ticket.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public Ticket selectByEventIdAndPlace(long eventId, int place) {
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
