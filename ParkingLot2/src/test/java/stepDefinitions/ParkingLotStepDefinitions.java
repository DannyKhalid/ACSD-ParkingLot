package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotStepDefinitions {
    long checkInTime = System.currentTimeMillis();
    Ticket ticket = new TicketImpl(checkInTime);
    ParkingLot parkingLot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Given("I am staying in the {string} parking lot")
    public void i_am_staying_in_the_parking_lot(String lotType) {
        if(lotType.equals("Long Term")) {
            parkingLot = new LongTermParkingLot();
        }
        else if(lotType.equals("Premium")) {
            parkingLot = new PremiumLot();
        }
        else {
            parkingLot = new LongTermParkingLot();
        }

    }
    @When("I enter on {string}")
    public void i_enter_on(String entryTime) {
        ticket.setEntryTime(entryTime);
        this.entryTime = LocalDateTime.parse(entryTime, formatter);

    }
    @When("I exit on {string}")
    public void i_exit_on(String exitTime) {
        ticket.setExitTime(exitTime);
        this.exitTime = LocalDateTime.parse(exitTime, formatter);

    }
    @Then("my fee is {int}")
    public void my_fee_is(Integer expectedFee) {
        Duration duration = Duration.between(entryTime, exitTime);
        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();

        System.out.println("You stayed " + days + " days, " + hours + " hours and " + minutes + " minutes");

        int actualFee = parkingLot.calculateFee(ticket);
        assertEquals(expectedFee, actualFee);
    }
}
