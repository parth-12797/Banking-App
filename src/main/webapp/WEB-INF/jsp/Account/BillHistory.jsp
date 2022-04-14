 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<% if(session.getAttribute("usr")==null) { 
response.sendRedirect("Login");
}
else
{
	%>
	<h1>Account List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Account Type</th><th>Amount</th><th>Biller Name</th>
	
	</tr>
    <c:forEach var="bk" items="${command}"> 
    <tr>
    <td>${bk.acc_type}</td>
    <td>${bk.amt}</td>
    <td>${bk.biller_name}</td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="/Final_Project/Home">Home</a>
     <a href="/Final_Project/Logout">Logout</a>
     <%
}
%>  