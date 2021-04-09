<%--
  Created by IntelliJ IDEA.
  User: Madura
  Date: 4/8/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Complete Reservation</title>
</head>
<body>
<h3>Complete Reservation</h3>
AirLine : ${flight.operatingAirline}<br/>
Departure City : ${flight.departureCity}<br/>
Arrival City : ${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
    <pre>
        <h2>Passenger Details</h2>

         First Name : <input type="text" name="passengerFirstName"/>
         Last Name : <input type="text" name="passengerLastName"/>
         Email : <input type="text" name="passengerEmail"/>
         Phone Number : <input type="text" name="passengerPhoneNumber"/>

         <h2>Card Details</h2>

         Name  on the card: <input type="text" name="cardName"/>
         Card no : <input type="text" name="cardNumber"/>
         Expire date : <input type="text" name="expireDate"/>
         Security Code : <input type="text" name="securityCode"/>
        <input type="hidden" name="flightId" value="${flight.id}">
        <input type="submit" value="Conform">
    </pre>
</form>
</body>
</html>
