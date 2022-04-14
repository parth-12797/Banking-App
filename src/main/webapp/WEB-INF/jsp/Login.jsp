<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

		<h1>Login</h1>
       <form:form method="post" action="loginauthentication">  
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
         <tr>  
          <td> </td>  
          <td><input type="submit" value="login" /></td>  
         </tr>  
        </table>  
       </form:form> 
       <a href="Register">Don't have an account?? Register</a> 
       <a href="index.jsp">Home</a> 