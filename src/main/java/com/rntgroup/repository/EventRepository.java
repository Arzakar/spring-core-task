package com.rntgroup.repository;

import com.rntgroup.db.EventDatabase;
import com.rntgroup.model.Event;
import com.rntgroup.repository.util.Page;
import com.rntgroup.repository.util.SearchResult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRepository extends AbstractRepository<Event, Long> {

    EventDatabase database;

    public SearchResult<Event> findByTitle(String title, Page page) {
        return SearchResult.pack(getDatabase().selectByTitle(title), page);
    }

    public SearchResult<Event> findByDate(Date date, Page page) {
        return SearchResult.pack(getDatabase().selectByDate(date), page);
    }
}
