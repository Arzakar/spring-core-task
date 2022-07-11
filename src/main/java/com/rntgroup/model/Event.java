package com.rntgroup.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * TODO: Event id should be unique
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    long id;
    String title;
    Date date;

    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
//    long getId();
//    void setId(long id);
//    String getTitle();
//    void setTitle(String title);
//    Date getDate();
//    void setDate(Date date);
}
