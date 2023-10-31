package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LongTermParkingLotTest {

    private LongTermParkingLot parkingLot;
    private Ticket mockTicket;

    @BeforeEach
    public void setup() {
        parkingLot = new LongTermParkingLot();
        mockTicket = Mockito.mock(Ticket.class);
    }

    @Test
    public void testFirstHalfHourFree() {
        when(mockTicket.getDays()).thenReturn(0);
        when(mockTicket.getHours()).thenReturn(0);
        when(mockTicket.getMinutes()).thenReturn(29);

        int fee = parkingLot.calculateFee(mockTicket);

        assertEquals(0, fee);
    }

    @Test
    public void testBasicFee() {
        when(mockTicket.getDays()).thenReturn(0);
        when(mockTicket.getHours()).thenReturn(1);
        when(mockTicket.getMinutes()).thenReturn(0);

        int fee = parkingLot.calculateFee(mockTicket);

        assertEquals(2, fee);
    }

    @Test
    public void testRoundingUp() {
        when(mockTicket.getDays()).thenReturn(0);
        when(mockTicket.getHours()).thenReturn(4);
        when(mockTicket.getMinutes()).thenReturn(2);

        int fee = parkingLot.calculateFee(mockTicket);

        assertEquals(10, fee);
    }

    @Test
    public void testDailyMax() {
        when(mockTicket.getDays()).thenReturn(1);
        when(mockTicket.getHours()).thenReturn(8);
        when(mockTicket.getMinutes()).thenReturn(0);

        int fee = parkingLot.calculateFee(mockTicket);

        assertEquals(30, fee);
    }

}

