package com.rntgroup.repository;

import com.rntgroup.db.EventDatabase;
import com.rntgroup.model.Event;
import com.rntgroup.repository.util.Page;
import com.rntgroup.repository.util.SearchResult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Objects;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRepository extends AbstractRepository<Event, Long> {

    EventDatabase database;

    public SearchResult<Event> findByTitle(String title, Page page) {
        return SearchResult.pack(getDatabase().selectByTitle(title), page);
    }

    public SearchResult<Event> findByDate(Date date, Page page) {
        return SearchResult.pack(getDatabase().selectByDate(date), page);
    }

    public void setDatabase(EventDatabase database) {
        this.database = database;
        if (Objects.nonNull(database)) {
            System.out.println("База данных " + database.getClass().getSimpleName() +
                    " успешно внедрена в " + this.getClass().getSimpleName());
        } else {
            System.out.println("Произошла ошибка во время внедрения базы данных в " + this.getClass().getSimpleName());
        }
    }
}
