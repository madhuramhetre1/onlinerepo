<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user123" method="post">
		<table>
			<!-- <tr>
				<td>User ID</td>
				<td><input type="text" name="userId" /></td>
			</tr> -->
			<tr>
				<td>UserName</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobileno" /></td>
			</tr>
			<tr>
			    <td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>