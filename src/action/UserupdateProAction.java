package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import svc.UserUpdateService;
import vo.ActionForward;
import vo.UserBean;

public class UserupdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UserupdateFromAction");
		
		ActionForward forward = null;
		
		UserBean user = new UserBean();
		user.setUser_id(request.getParameter("user_id"));
		user.setUser_pass(request.getParameter("user_pass"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_email(request.getParameter("user_email"));
		user.setUser_type(request.getParameter("user_type"));
		user.setUser_number(request.getParameter("user_number"));

	     UserUpdateService userupdateservice = new UserUpdateService();
		 boolean isnaiyong2 = userupdateservice.updateUser(user);

         
		 request.setAttribute("user",user);
	     
	
			
	
		if(!isnaiyong2) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('회원님의 비밀번호를 정확히 입력해야 수정이 가능합니다.')");
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

