<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Create Profile</h1>
       <form:form method="post" action="saveprofile">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="Name"  /></td>
         </tr>  
         <tr>  
          <td>Address :</td>  
          <td><form:input  path="Address" /></td>
         </tr> 
         
         <tr>  
          <td>State :</td>  
          <td><form:input  path="State" /></td>
         </tr> 
         
         <tr>  
          <td>Country :</td>  
          <td><form:input  path="Country" /></td>
         </tr> 
         
         <tr>  
          <td>Postalcode :</td>  
          <td><form:input  path="Postalcode" /></td>
         </tr> 
         <tr>  
          <td>Mobile no :</td>  
          <td><form:input  path="Mobile" /></td>
         </tr> 
        
         <tr>  
          <td>Account no :</td>  
          <td><form:input  path="Acc_num" /></td>
         </tr> 
        
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form> 
       
<button onclick="location.href = 'ViewProfile';" >View Profile</button>
<a href="/Final_Project/Home">Home</a>
 <a href="/Final_Project/Logout">Logout</a>