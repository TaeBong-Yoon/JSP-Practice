package com.bong.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller
@WebServlet("/mvc3")
public class Mvc3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = 0;

		String num_ = request.getParameter("n");

		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}

		String result;

		if (num % 2 != 0) {
			result = "홀수";
		} else {
			result = "짝수";
		}
		//서버 상의 저장소
		//PageContext
		//Request
		//Session
		//Page
		
		request.setAttribute("result", result);
		
		//47강 MVC model 2, EL(Expression Language)
		//redirect : 작업한 내용과 상관없는 새로운 요청
		//forward : 현재 작업한 내용을 이어갈 수 있도록 공유
		RequestDispatcher dispatcher = request.getRequestDispatcher("mvc3.jsp");
		//view로 보내준다.
		dispatcher.forward(request, response);
	}
}
