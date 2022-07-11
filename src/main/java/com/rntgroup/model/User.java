package com.rntgroup.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * TODO: User id should be unique
 * TODO: User email should be unique
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    long id;
    String name;
    String email;

    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
//    long getId();
//    void setId(long id);
//    String getName();
//    void setName(String name);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
//    String getEmail();
//    void setEmail(String email);
}
