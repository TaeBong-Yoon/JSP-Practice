<!-- 41강 : Java 코드를 사용한다는 뜻 < % java코드 % > 코드 블럭의 종류 참고! -->
<!-- 42강 : JSP 내장객체 종류 참고 -->
<%
	int x = 3;
	int y = 4;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input {
	width: 50px;
	height: 50px;
}
.output{
	heighjt: 50px;
	background: #e9e9e9;
	font-size: 24px;
	font-weight: bold;
	text-align: right;
	padding: 0px 5px;
}
</style>
</head>
<body>
<!-- 40강 41강 42강 JSP -->
<!-- 40강 : Jasper를 이용 -->
	<form action="calc3" method="post">
	<table>
	<tr>
		<td class="output" colspan="4">${3+4}</td>
	</tr>
	<tr>
		<td><input type="submit" name="operator" value="CE"></td>
		<td><input type="submit" name="operator" value="C"></td>
		<td><input type="submit" name="operator" value="BS"></td>
		<td><input type="submit" name="operator" value="/"></td>
	</tr>
	<tr>
		<td><input type="submit" name="value" value="7"></td>
		<td><input type="submit" name="value" value="8"></td>
		<td><input type="submit" name="value" value="9"></td>
		<td><input type="submit" name="operator" value="*"></td>
	</tr>
	<tr>
		<td><input type="submit" name="value" value="4"></td>
		<td><input type="submit" name="value" value="5"></td>
		<td><input type="submit" name="value" value="6"></td>
		<td><input type="submit" name="operator" value="-"></td>
	</tr>
	<tr>
		<td><input type="submit" name="value" value="1"></td>
		<td><input type="submit" name="value" value="2"></td>
		<td><input type="submit" name="value" value="3"></td>
		<td><input type="submit" name="operator" value="+"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="value" value="0"></td>
		<td><input type="submit" name="dot" value="."></td>
		<td><input type="submit" name="operator" value="="></td>
	</tr>
	</table>
	</form>
</body>
</html>