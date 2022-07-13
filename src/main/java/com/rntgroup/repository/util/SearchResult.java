package com.rntgroup.repository.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchResult<T> {

    Page page;
    List<T> content = new ArrayList<>();

    public static <T> SearchResult<T> pack(List<T> originList, Page page) {
        int firstIndex = page.getSize() * page.getNum();
        int lastIndex = firstIndex + page.getSize();

        return new SearchResult<T>()
                .setPage(page)
                .setContent(originList.subList(firstIndex, lastIndex));
    }
}
