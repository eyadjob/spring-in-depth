package com.spring.in.depth.mastering.service;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss");
    boolean format;
    @Value("#{new Boolean(environment['spring.profile.active']!=dev))}")
    private boolean is24;

    public TimeService(boolean format) {
        this.format = format;

    }

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        if (is24)
            return FORMATTER_24.format(now);
        return FORMATTER_12.format(now);
    }
}
