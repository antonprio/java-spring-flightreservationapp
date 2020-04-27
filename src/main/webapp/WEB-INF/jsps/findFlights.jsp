<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find Flights</title>
</head>
<body>
<h2>Find Flights</h2>
<form action="findFlights" method="post">
    <table>
        <tr>
            <td>From</td>
            <td>:</td>
            <td>
                <input name="from" type="text"/>
            </td>
            <td>To</td>
            <td>:</td>
            <td>
                <input name="to" type="text"/>
            </td>
            <td>Departure Date</td>
            <td>:</td>
            <td>
                <input name="departureDate" type="text"/>
            </td>
        </tr>

        <tr>
            <td>
                <input value="Search" type="submit"/>
            </td>
        </tr>

    </table>
</form>
</body>
</html>