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
	<tr><th>Account Number</th><th>Account Type</th><th>Account Balance</th>
	<td>Deposit</td><td>Withdraw</td><td>Transfer</td><th>paybill</th>
	</tr>
    <c:forEach var="bk" items="${list}"> 
    <tr>
    <td>${bk.acc_num}</td>
    <td>${bk.acc_type}</td>
    <td>${bk.acc_bal}</td>
    <td><a href="Deposit/${bk.acc_id}">Deposit</a></td>
    <td><a href="Withdraw/${bk.acc_id}">Withdraw</a></td>
    <td><a href="Transfer/${bk.acc_id}">Transfer</a></td>
    <td><a href="Paybill/${bk.acc_id}">Paybill</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="BillHistory/<%=session.getAttribute("profile_id")%>">Bill History</a>
    <a href="/Final_Project/Home">Home</a> 
    <a href="/Final_Project/Logout">Logout</a>
    <%
}
%>  