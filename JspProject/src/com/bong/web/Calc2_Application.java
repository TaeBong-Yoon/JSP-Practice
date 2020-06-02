package com.bong.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//강의 26강
//Application 저장소 예제
@WebServlet("/calc2-application")//소문자 쓸것!
public class Calc2_Application extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		받아온 값을 저장해준다 = Collection
		ServletContext application = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;

		if (!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
//		값을 계산해줌. +,-
		if (op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value");//Object로 오기때문에 Integer 
			int y = v;
			String operator = (String)application.getAttribute("op");
			
			int result = 0;

			if (operator.equals("+")) {
				result = x + y;
			}
			if (operator.equals("-")) {
				result = x - y;
			}
			response.getWriter().printf("result is %d\n", result);
		} else {
//		값을 저장해줌. = 
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}

		
		

	}

}
