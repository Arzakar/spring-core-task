package com.rntgroup.db;

import com.rntgroup.db.util.IdGenerator;
import com.rntgroup.model.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventDatabase extends AbstractDatabase<Long, Event> {

    static final Logger LOG = LoggerFactory.getLogger(EventDatabase.class.getSimpleName());

    Map<Long, Event> data = new HashMap<>(
            Map.of(0L, new Event(0L, "Концерт", new Calendar.Builder().setDate(2022, 5, 1).build().getTime()),
                    1L, new Event(1L, "Театр", new Calendar.Builder().setDate(2022, 5, 2).build().getTime()))
    );

    public List<Event> selectByTitle(String title) {
        LOG.info("Method {}#selectByTitle was called with param: title = {}", this.getClass().getSimpleName(), title);
        return getData().values().stream()
                .filter(event -> event.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Event> selectByDate(Date date) {
        LOG.info("Method {}#selectByDate was called with param: date = {}", this.getClass().getSimpleName(), date);
        return getData().values().stream()
                .filter(event -> event.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Long generateId() {
        return IdGenerator.generate(data);
    }
}
