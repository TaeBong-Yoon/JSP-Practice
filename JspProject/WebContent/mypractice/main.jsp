<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WelCome! : )</h1>
	<form action="loginCheck.jsp" method="POST">
		
		<table>
			<tr><th colspan="2"><h3>Sign In</h3></th></tr>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="id"/></td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td><input type="password" name="password"/></td>
			</tr>
			
			<tr><td colspan="2" align="center"><input type="submit" value="Sign In"></td></tr>
		</table>
	</form>
</body>
</html>