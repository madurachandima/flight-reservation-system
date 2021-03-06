<%--
  Created by IntelliJ IDEA.
  User: Madura
  Date: 4/7/2021
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Flight Details</title>
</head>
<body>
<h3>Flights : </h3>
<table>
    <tr>
        <th>AirLine</th>
        <th>Departure City</th>
        <th>Arrival City</th>
        <th>Departure Time</th>
    </tr>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.operatingAirline}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.estimatedDepartureTime}</td>
            <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
