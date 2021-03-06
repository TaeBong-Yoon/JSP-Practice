package com.bong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//강의 29강, 30강, 31강 - Cookie
//Cookie 이용하여 상태 값 유지
//Cookie ValueCookie = new Cookie(String ,String);

//Cookie의 maxAge옵션
//쿠기가 얼마까지 유지될 것인가?

@WebServlet("/calc2-cookie")
public class Calc2_Cookie extends HttpServlet {

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
			
//			어디서 사용할 것인지? ("/"), ("/notice/")
			valueCookie.setPath("/calc2-cookie");
			opCookie.setPath("/calc2-cookie");
			
//			언제까지 유지될 것인가?(만료날짜) setMaxAge(초,second)
			valueCookie.setMaxAge(60*60*24);
//			value의 쿠키는 브라우저가 닫혀도 만료날짜까지 유지된다.
//			op의 쿠키는 브라우저가 닫히는 순간 사라진다.
			
			
//			브라우저에 쿠키를 저장해준다.
			response.addCookie(valueCookie);
			response.addCookie(opCookie);

		}

	}

}
