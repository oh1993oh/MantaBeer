package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CartService;
import svc.LoginPro2Service;
import vo.ActionForward;

public class LoginPro2Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		String id = request.getParameter("user_id");
		String pass = request.getParameter("user_pass");
		
		LoginPro2Service loginPro2Service = new LoginPro2Service();
		String user = loginPro2Service.getUser(id);
		
		if (user == null) {
			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('유저정보가 없습니다!!.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('유저정보가 있습니다!!.')");
			out.println("alert('"+user+"')");
			out.println("</script>");

			forward = new ActionForward();
			forward.setPath("BeerMain.me");
			forward.setRedirect(true);
				

		}
		
		return forward;
	}

}
