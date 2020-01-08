package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.UserSearchlistService;
import vo.ActionForward;


public class UserSearchProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// ★ 관리자 페이지 (UserSearchProAction)
		System.out.println("UserSearchProAction");
		
		String user_name=request.getParameter("user_name");
		
		
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("user_id").toString();
		System.out.println(user_id);
		
		ActionForward forward =null;
		
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
			String select_name=user_name;
			System.out.println("select_name=" + select_name);
			UserSearchlistService userSearchlistservice = new UserSearchlistService();
			List user_List=userSearchlistservice.islistnaiyong(select_name);
			request.setAttribute("user_List", user_List);
			forward.setPath("/user/user_search_Pro.jsp");	
		
		}

		
		return forward;
	}

}
