package org.example;

public class PremiumLot implements ParkingLot {

    private static final int BASIC_FEE = 4;
    private static final int DAILY_MAX = 27;

    @Override
    public int calculateFee(Ticket ticket) {
        int days = ticket.getDays();
        int hours = ticket.getHours();
        int minutes = ticket.getMinutes();

        int freeDays = days / 7;
        int billableDays = days - freeDays;

        int dayFee = billableDays * DAILY_MAX;

        int hoursFee;
        if (days > 0 && hours == 0 && minutes == 0) {
            hoursFee = 0;
        } else {
            hoursFee = (minutes > 0) ? (hours + 1) * BASIC_FEE : hours * BASIC_FEE;
            hoursFee = Math.min(hoursFee, DAILY_MAX);
        }

        return dayFee + hoursFee;
    }
}
