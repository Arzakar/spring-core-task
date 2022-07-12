package com.rntgroup.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * TODO: User id should be unique <br>
 * TODO: User email should be unique
 */

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Entity<Long> {

    Long id;
    String name;
    String email;

}
