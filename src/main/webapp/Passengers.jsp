<%@ page import="org.nhnacademy.airticket_reservation_system.list.Passenger" %>
<%@ page import="java.util.List" %>
<%@ page import="org.nhnacademy.airticket_reservation_system.PassengerRepository" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Passenger List</title>
</head>
<body>
<h1><%= "승객 명단" %></h1>
<br/>
</body>
<table border="1">
    <thead>
        <tr>
            <th>PassengerName</th>
            <th>Grade</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <%
            PassengerRepository list = new PassengerRepository();
            List<Passenger> passengers = list.getPassengers();
            for (int i = 0; i < passengers.size(); i++) {
        %>
        <tr>
            <td><a href="/ReservationInfo.jsp?PassengerNo=<%=passengers.get(i).getPassengerNo()%>"><%=passengers.get(i).getPassengerName()%></a></td>
            <td><%=passengers.get(i).getGrade() %></td>
            <td><%=passengers.get(i).getAge() %></td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</html>