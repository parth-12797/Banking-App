<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Add New User</h1>
       <form:form method="post" action="saveregister">  
      	<table >  
         <tr>  
          <td>Username : </td> 
          <td><form:input path="User_name"  /></td>
         </tr>  
         <tr>  
          <td>Password :</td>  
          <td><form:input type="password" path="Password" /></td>
         </tr> 
         
         <tr>  
          <td>Confirm Password :</td>  
          <td><form:input type="password" path="Conf_password" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Register" /></td>  
         </tr>  
        </table>  
       </form:form> 
       
       <a href="Login">Already have and account? Login</a> 