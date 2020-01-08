package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.StateChangeService;
import vo.ActionForward;

public class StateChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		String state = request.getParameter("state");
		int classification = Integer.parseInt(request.getParameter("classification"));
		ActionForward forward = null;
		
		StateChangeService stateChangeService = new StateChangeService();
		stateChangeService.stateChange(classification,state);
		
		
		forward = new ActionForward();
		forward.setPath("User_list.me");
		forward.setRedirect(true);
			


		
		
		return forward;
	}

}
