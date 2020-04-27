<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flight Result</title>
</head>
<body>
<h2>Search Result</h2>

<table border="1">
    <tr>
        <th>Airlines</th>
        <th>Departure City</th>
        <th>Arrival City</th>
        <th>Departure Date</th>
    </tr>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.operatingAirlines}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.estimatedDepartureTime}</td>
            <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>