package com.rntgroup.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * TODO: Ticket id should be unique
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket implements Entity<Long> {

    Long id;
    long eventId;
    long userId;
    Category category;
    int place;

    public enum Category {
        STANDARD,
        PREMIUM,
        BAR
    }

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
//    long getId();
//    void setId(long id);
//    long getEventId();
//    void setEventId(long eventId);
//    long getUserId();
//    void setUserId(long userId);
//    Category getCategory();
//    void setCategory(Category category);
//    int getPlace();
//    void setPlace(int place);

}
