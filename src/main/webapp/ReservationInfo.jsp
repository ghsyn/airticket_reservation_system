<%@ page import="org.nhnacademy.airticket_reservation_system.list.Reservation" %>
<%@ page import="org.nhnacademy.airticket_reservation_system.FlightRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.nhnacademy.airticket_reservation_system.list.Passenger" %><%--
  Created by IntelliJ IDEA.
  User: gimsiyeon
  Date: 2023/05/02
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Info</title>
</head>
<body>
<h1><%= "예약 내역" %></h1>
<table border="1">
    <thead>
        <tr>
            <th>ReservedDate</th>
            <th>PassengerName</th>
            <th>FlightDate</th>
            <th>Departures</th>
            <th>Arrival</th>
            <th>Price</th>
        </tr>
    </thead>
<%--    <tbody>--%>
<%--    <%--%>
<%--        FlightRepo list = new FlightRepo();--%>
<%--        List<Reservation> reservations = list.getReservations();--%>
<%--        for (int i = 0; i < reservations.size(); i++) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><a href="/ReservationInfo.jsp"><%=passengers.get(i).getPassengerName()%></a></td>--%>
<%--        <td><%=passengers.get(i).getGrade() %></td>--%>
<%--        <td><%=passengers.get(i).getAge() %></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--    </tbody>--%>
    <tbody>
    <%
        FlightRepo list = new FlightRepo();
        List<Reservation> reservations = list.getReservations();
        for (int i = 1; i < reservations.size(); i++) {
    %>
    <tr>
        <td><%=reservations.get(i).getReservedDate() %></td>
        <td><%=reservations.get(i).getPassengerName()%></td>
        <td><%=reservations.get(i).getFlightDate() %></td>
        <td><%=reservations.get(i).getDepartures() %></td>
        <td><%=reservations.get(i).getArrival() %></td>
        <td><%=reservations.get(i).getPrice() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<button type="submit">Back to Passenger List</button>
</body>
</html>
