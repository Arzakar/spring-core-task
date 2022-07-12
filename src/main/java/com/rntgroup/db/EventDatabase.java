package com.rntgroup.db;

import com.rntgroup.db.util.IdGenerator;
import com.rntgroup.model.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

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

    Map<Long, Event> data = new HashMap<>(
            Map.of(0L, new Event(0L, "Концерт", new Calendar.Builder().setDate(2022, 5, 1).build().getTime()),
                    1L, new Event(1L, "Театр", new Calendar.Builder().setDate(2022, 5, 2).build().getTime()))
    );

    public List<Event> selectByTitle(String title) {
        return getData().values().stream()
                .filter(event -> event.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Event> selectByDate(Date date) {
        return getData().values().stream()
                .filter(event -> event.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Long generateId() {
        return IdGenerator.generate(data);
    }
}
