package org.nhnacademy.airticket_reservation_system;

import org.nhnacademy.airticket_reservation_system.list.Passenger;
import org.nhnacademy.airticket_reservation_system.list.Reservation;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";

    Connection myConnection = DBUtils.getConnection();

    List<Passenger> passengerList = new ArrayList<>();
    List<Reservation> reservationList = new ArrayList<>();

    private void loadDriver(String driverName) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> getPassengers() {
        loadDriver(driverName);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "SELECT PassengerName, Grade, Age FROM Passenger";
            preparedStatement = myConnection.prepareStatement(sqlQuery);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                this.passengerList.add(new Passenger(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passengerList;
    }

    public List<Reservation> getReservations() {
        loadDriver(driverName);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery =
                    "SELECT R.ReservedDate, P.PassengerName, F.FlightDate, F.Departures, F.Arrival, F.Price" +
                            "FROM Passenger AS P " +
                            "JOIN Reservation AS R ON P.PassengerNo = R.PassengerNo " +
                            "JOIN Flight AS F ON R.FlightNo = F.FlightNo";

            preparedStatement = myConnection.prepareStatement(sqlQuery);

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
