<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservation Detail</title>
</head>
<body>
<h2>Complete Reservation</h2>
<table>
    <tr>
        <td>Airline</td>
        <td>:</td>
        <td>${flight.operatingAirlines}</td>
    </tr>

    <tr>
        <td>Departure City</td>
        <td>:</td>
        <td>${flight.departureCity}</td>
    </tr>

    <tr>
        <td>Arrival City</td>
        <td>:</td>
        <td>${flight.arrivalCity}</td>
    </tr>
</table>

<form action="completeReservation" method="post">
    <table>
        <tr>
            <td><h2>Passanger Details</h2></td>
        </tr>

        <tr>
            <td>First Name</td>
            <td>:</td>
            <td><input type="text" name="passangerFirstName" /></td>
        </tr>

        <tr>
            <td>Middle Name</td>
            <td>:</td>
            <td><input type="text" name="passangerMiddleName" /></td>
        </tr>

        <tr>
            <td>Last Name</td>
            <td>:</td>
            <td><input type="text" name="passangerLastName" /></td>
        </tr>

        <tr>
            <td>Email</td>
            <td>:</td>
            <td><input type="text" name="passangerEmail" /></td>
        </tr>

        <tr>
            <td>Phone</td>
            <td>:</td>
            <td><input type="text" name="passangerPhone" /></td>
        </tr>
    </table>

    <table>
        <tr>
            <td><h2>Card Details</h2></td>
        </tr>

        <tr>
            <td>Name on the card</td>
            <td>:</td>
            <td>
                <input type="text" name="nameOnTheCard" />
            </td>
        </tr>

        <tr>
            <td>Card No</td>
            <td>:</td>
            <td>
                <input type="text" name="cardNumber" />
            </td>
        </tr>

        <tr>
            <td>Expired Date</td>
            <td>:</td>
            <td>
                <input type="text" name="expirationDate" />
            </td>
        </tr>

        <tr>
            <td>Three Digit Security Code</td>
            <td>:</td>
            <td>
                <input type="text" name="securityCode" />
            </td>
        </tr>
        <input type="hidden" name="flightId" value="${flight.id}" />
        <tr>
            <td>
                <input type="submit" value="Submit" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>