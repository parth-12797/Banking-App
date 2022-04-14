 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<% if(session.getAttribute("usr")==null) { 
response.sendRedirect("Login");
}
else
{
	%>
	<h1>Profile</h1>
	<table border="2" width="70%" cellpadding="2">
	
    <c:forEach var="bk" items="${list}"> 
    <tr>
    <td>Name:</td>
    <td>${bk.name}</td>
    </tr>
    <tr>
    <td>Address:</td>
    <td>${bk.address}</td>
    </tr>
     <tr>
    <td>State:</td>
    <td>${bk.state}</td>
    </tr>
   <tr>
    <td>Country:</td>
    <td>${bk.country}</td>
    </tr>
   <tr>
    <td>PostalCode:</td>
    <td>${bk.postalcode}</td>
    </tr>
   <tr>
    <td>Mobile:</td>
    <td>${bk.mobile}</td>
    </tr>
    <tr>
    <td>Account No:</td>
    <td>${bk.acc_num}</td>
    </tr>
    <tr>
    <td>Username:</td>
    <td><%= session.getAttribute("usr")%></td>
    </tr>
   <tr>
    <td><a href="editProfile/${bk.profile_id}">Edit</a></td>
</tr>    
    
    </c:forEach>
    </table>
    <br/>
    
    
 <a href="/Final_Project/Home">Home</a>
    <a href="/Final_Project/Logout">Logout</a><%
}
%>  
