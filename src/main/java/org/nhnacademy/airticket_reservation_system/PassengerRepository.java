package org.nhnacademy.airticket_reservation_system;

import org.nhnacademy.airticket_reservation_system.list.Passenger;
import org.nhnacademy.airticket_reservation_system.list.Reservation;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {

    Connection myConnection = DBUtils.getConnection();

    List<Passenger> passengerList = new ArrayList<>();
    List<Reservation> reservationList = new ArrayList<>();

    public List<Passenger> getPassengers() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "SELECT PassengerNo, PassengerName, Grade, Age FROM Passenger";
            preparedStatement = myConnection.prepareStatement(sqlQuery);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                this.passengerList.add(new Passenger(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passengerList;
    }

    public List<Reservation> getReservations(int passengerNo) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery =
                    "SELECT R.ReservedDate, P.PassengerName, F.FlightDate, F.Departures, F.Arrival, F.Price\n" +
                            "FROM Passenger AS P JOIN Reservation AS R ON P.PassengerNo = R.PassengerNo\n" +
                            "JOIN Flight AS F ON R.FlightNo = F.FlightNo\n" +
                            "WHERE P.PassengerNo = ?";

            preparedStatement = myConnection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, passengerNo);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                this.reservationList.add(new Reservation(
                        resultSet.getDate(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBigDecimal(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationList;
    }
}
