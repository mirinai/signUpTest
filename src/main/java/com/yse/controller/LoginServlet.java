package com.yse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yse.dao.MemberDAO;
import com.yse.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")!=null) {
			url = "main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
		
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		int result = mdao.userCheck(userid,pwd);
			
		if(result == 1) {
			MemberVO mvo = mdao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			session.setAttribute("message", "로그인 됨");
			url = "main.jsp";
			
		}
		else if(result == 0) {
			request.setAttribute("message", "비밀번호가 틀림");
		}
		else if(result == -1) {
			request.setAttribute("message", "없는 유저임");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
