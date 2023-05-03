package org.nhnacademy.airticket_reservation_system.list;

import java.math.BigDecimal;
import java.util.Date;

public class Reservation {
    private final Date reservedDate;
    private final String passengerName;
    private final Date flightDate;
    private final String departures;
    private final String arrival;
    private final BigDecimal price;

    public Reservation(Date reservedDate, String passengerName, Date flightDate, String departures, String arrival, BigDecimal price) {
        this.reservedDate = reservedDate;
        this.passengerName = passengerName;
        this.flightDate = flightDate;
        this.departures = departures;
        this.arrival = arrival;
        this.price = price;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getDepartures() {
        return departures;
    }

    public String getArrival() {
        return arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
