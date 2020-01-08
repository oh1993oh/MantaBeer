package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReservationProService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReservationProAction진입");
		
		ActionForward forward = null;
		ReservationBean rebean = null;
		
		HttpSession session = request.getSession();
		String sid=(String)session.getAttribute("user_id");
		
		
		rebean=new ReservationBean();
		rebean.setReservation_date(request.getParameter("date_in"));
		rebean.setReservation_time(request.getParameter("time_in"));
		rebean.setReservation_room(request.getParameter("room_in"));
		
		rebean.setReservation_notice(request.getParameter("notice_in"));
		
		System.out.println("rebean 객체 담기 성공!");
		
		
		ReservationProService reproservice = new ReservationProService();
	
		 boolean isWriteSuccess = reproservice.registArticle(rebean,sid);
		
		 if(!isWriteSuccess) {
				
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
				out.println("<script>");
				out.println("alert('예약 실패!!')");
				out.println("history.back()");
				out.println("</script>");
			}
			else {
				forward = new ActionForward();
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
				out.println("<script>");
				out.println("alert('예약 성공!!!')");
				out.println("</script>");
				
				forward = new ActionForward();
				forward.setPath("BeerMain.me");
				forward.setRedirect(true);
			}
		 
		System.out.println("forward : "+forward);
		
		
		return forward;
	}

}
