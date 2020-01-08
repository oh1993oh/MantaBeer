package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class UserLogoutProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	HttpSession session = request.getSession();
	session.invalidate();
	
	ActionForward forward = new ActionForward();
	forward.setRedirect(true);
    forward.setPath("BeerMain.me");		
		
		return forward;
	}

}
