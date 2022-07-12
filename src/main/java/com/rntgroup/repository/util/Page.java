package com.rntgroup.repository.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page {

    int size;
    int num;

    public static Page of(int size, int num) {
        return new Page(size, num);
    }
}
