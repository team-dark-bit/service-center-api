package com.enterprise.servicecenter.common.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDateTime toLocalDateTime(String date) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        return offsetDateTime.toLocalDateTime();
    }
}
