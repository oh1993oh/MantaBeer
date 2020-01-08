package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.UserDeleteService;
import svc.UserInfoService;
import vo.ActionForward;
import vo.UserBean;

public class UserDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UserDeleteFormAction");
		
		ActionForward forward =null;
		
		HttpSession session = request.getSession();
		String sid = session.getAttribute("user_id").toString();
		System.out.println("id= " + sid);
			
		UserInfoService userinfoservice = new UserInfoService();
		
		
		
		UserBean user = userinfoservice.getUser(sid);
		
		request.setAttribute("user",user);
		
		
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/user/user_delete_Form.jsp");
			
		
		return forward;
	}

}
