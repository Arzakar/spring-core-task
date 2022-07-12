package com.rntgroup.db;

import com.rntgroup.db.util.IdGenerator;
import com.rntgroup.model.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDatabase extends AbstractDatabase<Long, User>{

    Map<Long, User> data = new HashMap<>();

    public List<User> selectByName(String name) {
        return getData().values().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public User selectByEmail(String email) {
        return getData().values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Long generateId() {
        return IdGenerator.generate(data);
    }
}
