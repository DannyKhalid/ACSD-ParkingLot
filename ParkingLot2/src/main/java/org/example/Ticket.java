package org.example;

public interface Ticket {
    int getDays();

    int getHours();

    int getMinutes();

    long getCheckInTime();

    void setEntryTime(String entryTime);

    void setExitTime(String exitTime);


}
