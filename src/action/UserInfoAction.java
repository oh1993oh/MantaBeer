package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import svc.UserInfoService;
import vo.ActionForward;
import vo.UserBean;




public class UserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("UserInfoAction");
		ActionForward forward =null;
		
		HttpSession session = request.getSession();
		String sid = session.getAttribute("user_id").toString();
		System.out.println(sid);
		

		UserInfoService userlnfoService = new UserInfoService();
     	UserBean user = userlnfoService.getUser(sid);
     			
     			
		
     	request.setAttribute("user",user);
     	
		boolean isnaiyong = userlnfoService.naiyonglnfo(sid);
		
		
		
		if(!isnaiyong) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('내용이 없거나 잘못된 접근입니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/user/user_lnfo_Form.jsp");
		}

		
		return forward;
	}

}
