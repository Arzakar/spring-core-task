package com.rntgroup.repository;

import com.rntgroup.db.UserDatabase;
import com.rntgroup.model.User;
import com.rntgroup.repository.AbstractRepository;

import com.rntgroup.repository.util.Page;
import com.rntgroup.repository.util.SearchResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRepository extends AbstractRepository<User, Long> {

    UserDatabase database;

    public SearchResult<User> findByName(String name, Page page) {
        return SearchResult.pack(getDatabase().selectByName(name), page);
    }

    public Optional<User> findByEmail(String email) {
        return Optional.of(getDatabase().selectByEmail(email));
    }

}
