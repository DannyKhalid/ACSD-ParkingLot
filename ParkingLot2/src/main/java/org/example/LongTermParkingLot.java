package org.example;

public class LongTermParkingLot implements ParkingLot {

    @Override
    public int calculateFee(Ticket ticket) {
        int days = ticket.getDays();
        int hours = ticket.getHours();
        int minutes = ticket.getMinutes();

        if (days == 0 && hours == 0 && minutes <= 30) {
            return 0;
        }

        int feeForDay = hours * 2;
        if (minutes > 0) {
            feeForDay += 2;
        }

        feeForDay = Math.min(feeForDay, 15);

        return days * 15 + feeForDay;
    }

}