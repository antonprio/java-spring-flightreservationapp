<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
</head>
<body>
<form action="login" method="post">
    <h2>Login</h2>
    <table>
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
            <td>
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
    ${msg}
</form>
</body>
</html>