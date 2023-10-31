package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketImpl implements Ticket {
    private final long checkInTime;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public TicketImpl(long checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public long getCheckInTime() {
        return checkInTime;
    }


    @Override
    public int getDays() {
        Duration duration = Duration.between(entryTime, exitTime);
        long days = duration.toDays();
        return (int) days;

    }

    @Override
    public int getHours() {
        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHoursPart();
        return (int) hours;
    }

    @Override
    public int getMinutes() {
        Duration duration = Duration.between(entryTime, exitTime);
        long minutes = duration.toMinutesPart();
        return (int) minutes;
    }

    @Override
    public void setEntryTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        entryTime = LocalDateTime.parse(time, formatter);
    }

    @Override
    public void setExitTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        exitTime = LocalDateTime.parse(time, formatter);
    }


}
