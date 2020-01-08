package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserListDeleteService;


import vo.ActionForward;



public class UserListDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// ★ 관리자 페이지 (UserListDeleteAction)
		
				System.out.println("UserListDeleteAction");
				
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
					String delete_id=request.getParameter("id");
					UserListDeleteService userlistdeleteservice = new UserListDeleteService();
					boolean deleteResult=userlistdeleteservice.ListDeleteUser(delete_id);
	         
		
				
					if(deleteResult) {
						forward = new ActionForward();
						forward.setRedirect(true);
						forward.setPath("BeerMain.me");
				
					} else {
						response.setContentType("text/html;charset=UTF-8");
				   		PrintWriter out=response.getWriter();
				   		out.println("<script>");
				   		out.println("alert('죄송하지만, 잘못된 접근 및 방식 으로 삭제가 불가능합니다.');");
				   		out.println("history.back()");
				   		out.println("</script>");
					}

		
				}
		
				
		return forward;
	}

}
