package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserInfoService;
import svc.UserSearchService;
import svc.UserUpdateService;
import vo.ActionForward;
import vo.UserBean;

public class UserupdateFromAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("updateFromAction");
		
		
		ActionForward forward= null;
		HttpSession session =request.getSession();
		String sid=(String)session.getAttribute("user_id");
		String user_name=request.getParameter("user_name");
		
		System.out.println("updateAction id : " + sid);

		
		if(sid==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./LoginForm.me");
		} else {
			
			
			 UserBean user = new UserBean();
			
			 UserInfoService userinfoservice  = new UserInfoService();
			 
			 user= userinfoservice.getUser(sid);
			
			 
			 System.out.println("action  id결과 : " +user.getUser_id());
				System.out.println("action  pass결과 : " +user.getUser_pass());
				System.out.println("action  name결과 : " +user.getUser_name());
			
				
				
			forward = new ActionForward();
			
			request.setAttribute("user", user);
			forward.setPath("/user/user_update_form.jsp");
		}
			
		
		
		
		
		
		return forward;
	}

}
