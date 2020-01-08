package action;

import java.io.PrintWriter;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserLoginProService;
import vo.ActionForward;

public class UserLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ActionForward forward = null;

		String id = request.getParameter("user_id");
		String pass = request.getParameter("user_pass");
		System.out.println(id + " , " + pass);

		UserLoginProService userloginproservice = new UserLoginProService();
		int loginResult = userloginproservice.UserLogin(id, pass);


		
		if (loginResult == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
			out.println("<script>");
			out.println("alert('입력하신 ID는 없거나 올바르지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (loginResult == -1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
			out.println("<script>");
			out.println("alert('입력하신 비밀번호는 없거나 올바르지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (loginResult == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BeerMain.me");

		}

=======


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserLoginProService;
import vo.ActionForward;


public class UserLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		
		
		String id = request.getParameter("user_id");
		String pass = request.getParameter("user_pass");
		System.out.println(id + " , " + pass);
		
		UserLoginProService userloginproservice = new UserLoginProService();
		int loginResult = userloginproservice.UserLogin(id,pass);
		
		 if(loginResult== 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
				out.println("<script>");
				out.println("alert('입력하신 ID는 없거나 올바르지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
		    } else if(loginResult== -1){
		    	response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
				out.println("<script>");
				out.println("alert('입력하신 비밀번호는 없거나 올바르지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
		    } else if(loginResult== 1) {
		    	HttpSession session = request.getSession();
		    	session.setAttribute("user_id", id);
		    	forward = new ActionForward();
		    	forward.setRedirect(true);
		    	forward.setPath("BeerMain.me");
		    	
		    	
		    	
		    }
			
		
		
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
		return forward;
	}

}
