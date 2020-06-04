<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bong.web.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pass = request.getParameter("password");

Connection conn = DBUtil.getMySQLConnection();

String sql = "SELECT * FROM member where id =?";
PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1,id);
ResultSet rs = pstmt.executeQuery();
String password;

while(rs.next()){
	password = rs.getString("password");
	if(password.equals(pass)){
		out.println("<script>");
		out.println("alert('Sign In Successfully!')");
		out.println("location.href='main.jsp'");
		out.println("</script>");
		break;
	} else if(!password.equals(pass) || pass.equals("")){
		out.println("<script>");
		out.println("alert('Sign In Failed! Check Again')");
		out.println("location.href='main.jsp'");
		out.println("</script>");
		break;
	}
}



DBUtil.close(rs);
DBUtil.close(pstmt);
DBUtil.close(conn);

	

%>


</body>
</html>