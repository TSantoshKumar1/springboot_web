<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update-Registration</title>
</head>
<body>


<form action="updateRegRecord" method="post">  

<pre> 

<input type="hidden" name="id" value="${registration.id}"/>
First Name <input type="text" name="firstname" value= "${registration.firstname}"/>
Last Name <input type="text" name ="lastname" value="${registration.lastname}" />
Email <input type="text" name="email" value="${registration.email}"/>
Mobile<input type="text" name="mobile" value="${registration.mobile}"/> 
<input type="submit" value="update"/>

  </pre> 

 </form>

</body>
</html>