<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Withdraw Money</h1>

       <form:form method="post" action="/Final_Project/savewithdraw">  
      	<table > 
      	<tr>
      	<td></td>  
         <td><form:hidden  path="Acc_id" /></td>
         </tr>   
         <tr>
      	<td></td>  
         <td><form:hidden  path="Profile_id" /></td>
         </tr>    
         <tr>  
          <td>Account Number :</td>  
          <td><form:input  path="Acc_num"  readonly="true"/></td>
         </tr> 
         <tr>  
          <td>Account Type :</td>  
          <td><form:input  path="Acc_type"    readonly="true"/></td>
         </tr> 
         
         <tr>  
          <td>Account Balance</td>  
          <td><form:input  path="Acc_bal"  readonly="true"/></td>
         </tr> 
         <tr>  
          <td>Withdraw Amount :</td>  
          <td><form:input  path="Temp_amount"   /></td>
         </tr> 
         
            <tr>  
          <td> </td>  
          <td><input type="submit" value="Withdraw" /></td>  
         </tr>  
        </table>  
       </form:form> 
       
       
        <a href="/Final_Project/Logout">Logout</a>
        <a href="/Final_Project/Home">Home</a>
