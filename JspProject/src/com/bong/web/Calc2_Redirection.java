package com.bong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//강의 33강 - Redirection
//Redirection : 매우 중요!
//강의 34강 - 동적인 페이지(서버 페이지)

@WebServlet("/calc2-redirection")
public class Calc2_Redirection extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

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

			int x = 0;

			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y = v;

			String operator = "";

			for (Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}

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
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/calc2-cookie");
			opCookie.setPath("/calc2-cookie");
			
			valueCookie.setMaxAge(60*60*24);
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
//			사용자가 입력하면 url을 열어준다.
			response.sendRedirect("Calc2_Redirection.html");

		}

	}

}
