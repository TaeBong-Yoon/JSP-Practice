<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="joinOK.jsp" method="post">
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>"/>
		
		<table width="400" align="center">
			<tr><th colspan="2"><h2>Sign Up</h2></th></tr>
			
			<tr>
				<td width="200" align="center">ID</td>
				<td width="200" align="center"><input type="text" name="id"></td>
			</tr>
			
			<tr>
				<td width="200" align="center">Password</td>
				<td width="200" align="center"><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td width="200" align="center">Name</td>
				<td width="200" align="center"><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td width="200" align="center">Age</td>
				<td width="200" align="center"><input type="text" name="age"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Sign Up"></td>
			</tr>
			
		</table>
	
	</form>

</body>
</html>