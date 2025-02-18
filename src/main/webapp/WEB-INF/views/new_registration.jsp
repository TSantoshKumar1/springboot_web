<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Registration </title>
</head>
<body>

<h1>New Registration Form....</h1>

<form action="saveReg" method="post">  

<pre> 

First Name <input type="text" name="firstname"/>
Last Name <input type="text" name ="lastname" />
Email <input type="text" name="email"/>
Mobile<input type="text" name="mobile"/> 
<input type="submit" value="save"/>

  </pre> 

 </form>

<h1>${msg}</h1>

</body>
</html>