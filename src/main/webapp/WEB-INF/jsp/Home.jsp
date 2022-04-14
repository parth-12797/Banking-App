<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Welcome ${sessionScope.usr }</h4>

<h5><a href="Logout">Logout</a></h5>

<button onclick="location.href = 'Profile';" >Profile</button>
<button onclick="location.href = 'CreateAccount';" >CreateAccount</button><br><br>
<button onclick="location.href = 'Accounts';" >Accounts</button>




</body>
</html>