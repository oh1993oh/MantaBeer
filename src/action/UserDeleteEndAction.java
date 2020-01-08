package action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import svc.UserDeleteEndService;



import vo.ActionForward;
import vo.UserBean;

public class UserDeleteEndAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UserDeleteFormAction");
		
		
		ActionForward forward =null;
		
		HttpSession session = request.getSession();
		String sid = session.getAttribute("user_id").toString();
		System.out.println(sid);
		
		UserDAO dao = UserDAO.getInstance();
		UserBean user = dao.getUser(sid);
		
		request.setAttribute("user", user);
		
		
		UserDeleteEndService userDeleteendservice = new UserDeleteEndService();
		boolean isnaiyong4 = userDeleteendservice.delendUser(user);
	
		
		
		if(!isnaiyong4) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('잘못된 접근으로 탈퇴가 불가합니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			forward = new ActionForward();	
			forward.setRedirect(true);
			session.invalidate();
			forward.setPath("BeerMain.me");
		}
		
		return forward;
	}

}
