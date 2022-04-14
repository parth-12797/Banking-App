<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Create Account</h1>
      Account number:${acc_num}
       <form:form method="post" action="saveaccount">  
      	<table >   
         <tr>  
          <td>Account Type :</td>  
          <td><form:input  path="Acc_type" /></td>
         </tr> 
            <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form> 
       
<button onclick="location.href = 'Accounts';" >View Accounts</button>
 <a href="/Final_Project/Logout">Logout</a>
 <a href="/Final_Project/Home">Home</a>