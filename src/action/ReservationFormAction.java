package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class ReservationFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("ReservationFormAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String  sid = (String)session.getAttribute("user_id");
		
		System.out.println("ReservationFormAction ID : " + sid);
		
		if(sid==null) {
			System.out.println("ID : null일경우");
			
			respone.setContentType("text/html;charset=UTF-8");
	   		PrintWriter out=respone.getWriter();
	   		out.println("<script>");
	   		out.println("alert('로그인이 필요한 서비스 입니다.')");
	   		out.println("history.back()");
	   		out.println("</script>");
		}else if(sid != null) {
			forward = new ActionForward();
			forward.setPath("./reservation.jsp");
			
		}
		
		
		
		
		
		
		return forward;
	}

}
