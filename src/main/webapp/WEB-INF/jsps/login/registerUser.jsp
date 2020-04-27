<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
</head>
<body>
<form action="registerUser" method="post">
    <h2>User Registration</h2>
    <table>
        <tr>
            <td>First Name</td>
            <td>:</td>
            <td>
                <input name="firstName" type="text"/>
            </td>
        </tr>

        <tr>
            <td>Last Name</td>
            <td>:</td>
            <td>
                <input name="lastName" type="text"/>
            </td>
        </tr>

        <tr>
            <td>Username</td>
            <td>:</td>
            <td>
                <input name="email" type="text"/>
            </td>
        </tr>

        <tr>
            <td>Password</td>
            <td>:</td>
            <td>
                <input name="password" type="password"/>
            </td>
        </tr>

        <tr>
            <td>Confirm Password</td>
            <td>:</td>
            <td>
                <input name="confirmPassword" type="password"/>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>

</form>
</body>
</html>