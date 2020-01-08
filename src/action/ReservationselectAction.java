package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReservationProService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationselectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ReservationselectAction 진입");
		
		ActionForward forward =null;
		
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("user_id");
		
		System.out.println("ReservationselectAction sid : " + sid);
		
		if(sid==null) {
			System.out.println("sid는 null");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('예약확인은 로그인하신후 사용하실수 있습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else if(sid !=null) {
			System.out.println("sid는  : " + sid);
			
			ReservationProService reservationProService = new ReservationProService();
			ArrayList<ReservationBean> reservationList = reservationProService.selectReservation(sid);
			System.out.println("Action 서비스 끝");
			request.setAttribute("reservationList", reservationList);
			
			System.out.println("reservationList : "+reservationList);
			
			
			forward = new ActionForward();
			forward.setPath("./user/user_reservation_select.jsp");
			
		}
		
		
		
		
		
		
		
		return forward;
	}

}
