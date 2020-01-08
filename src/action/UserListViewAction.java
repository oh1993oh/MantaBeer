package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserListViewService;
import vo.ActionForward;
import vo.UserBean;

public class UserListViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// ★ 관리자 페이지 (UserListViewAction)
		
		System.out.println("UserListViewAction");
		
		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		
		ActionForward forward = null;
		
		if(user_id==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/LoginForm.me");
		} else if(!user_id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('죄송하지만, 관리자 계정이 아닙니다.');");
	   		out.println("history.back()");
	   		out.println("</script>");
		} else {
			forward = new ActionForward();
			String view_id=request.getParameter("id");
			UserListViewService userlistviewservice = new UserListViewService();
			UserBean user=userlistviewservice.getUser(view_id);
	   		request.setAttribute("user", user);
	   		forward.setPath("/user/user_list_info.jsp");
		}

		
		
		return forward;
	}

}
