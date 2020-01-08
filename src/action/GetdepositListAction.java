package action;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.getdepositList;
import vo.ActionForward;
import vo.TradeBean;
import vo.UserBean;

public class GetdepositListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("GetdepositList");
		
		HttpSession session=request.getSession();
		
		String user_id=(String)session.getAttribute("user_id");
		System.out.println("user_id :"+user_id);
		
		ActionForward forward = null;
		
		
			if(user_id==null) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./LoginForm.me");
			} else if(user_id.equals("admin")) {
				System.out.println("관리자");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('관리자 페이지 입니다.');");
				out.println("history.back()");
				out.println("</script>");
				getdepositList depositservice = new getdepositList();
				ArrayList<TradeBean> getdepositservice=depositservice.getdepositList();
				
				System.out.println("depositAction : " + getdepositservice );
				
				request.setAttribute("getdepositservice", getdepositservice);
				//  주소 뽑아오는것도 처리 해야함. 
				
				
				forward = new ActionForward();
				forward.setPath("/user/user_list.jsp");
			}else {
				System.out.println("user");
				getdepositList depositservice = new getdepositList();
				ArrayList<TradeBean> getdepositservice=depositservice.usergetdepositList(user_id);
				
				System.out.println("depositAction : " + getdepositservice );
				
				request.setAttribute("getdepositservice", getdepositservice);
				//  주소 뽑아오는것도 처리 해야함. 
				
				
				forward = new ActionForward();
				forward.setPath("/user/UserOrdertracking.jsp");
			}
		
		
		
		
		return forward;
	}
}
