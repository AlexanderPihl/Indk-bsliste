<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 02/03/2020
  Time: 10.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbsliste</title>
</head>
<body>

Welkommen til din online indkøbsliste!
<br>


<form action="LoginServlet" mehtod="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="Navn"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="Kodeord"><br><br>
    <input type="submit" value="Login">
</form>


</body>
</html>
