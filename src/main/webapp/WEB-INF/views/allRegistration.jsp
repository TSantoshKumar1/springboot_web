<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all registration here</title>
</head>
<body>

<table>

<tr>
    <th>first name</th>
    <th>last name</th>
    <th>email</th>
    <th>mobile</th>
    <th>delete</th>
    <th>update</th>
</tr>

<c:forEach var="registration" items="${allregistrations}">

<tr>
       
       <td>${registration.firstname }</td>
       <td>${registration.lastname}</td>
       <td>${registration.email }</td>
       <td>${registration.mobile}</td>
       <td><a href="delete-registration?id=${registration.id}">delete</a></td>
       <td><a href="update-Registration?id=${registration.id}">update</a></td>

</tr>

    
</c:forEach>


</table>
	

</body>
</html>