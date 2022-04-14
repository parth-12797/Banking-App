<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Deposit Money</h1>

       <form:form method="post" action="/Final_Project/saveTransfer">  
      	<table > 
      	<tr>
      	
         <tr>  
          <td>Account From :</td>  
          <td><form:input  path="From" /></td>
         </tr> 
         <tr>  
          <td>Account To :</td>  
          <td><form:input  path="To" /></td>
         </tr> 
         
         <tr>  
          <td>Transfer Amount</td>  
          <td><form:input  path="Amt_temp" /></td>
         </tr>

         
            <tr>  
          <td> </td>  
          <td><input type="submit" value="Transfer" /></td>  
         </tr>  
        </table>  
       </form:form>
       
        <a href="/Final_Project/Logout">Logout</a> 
        <a href="/Final_Project/Home">Home</a>
       
