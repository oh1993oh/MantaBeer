package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReservationProService;
import svc.ReservationdeleteService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationdeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String  sid = (String)session.getAttribute("user_id");
		int r_num=Integer.parseInt( request.getParameter("r_num"));
	
		System.out.println("예약자의 예약번호 : " + r_num);
		
		System.out.println("ReservationdeleteAction ID : " + sid);
		
		ReservationdeleteService  reservationdeleteService  = new ReservationdeleteService();
		
		 boolean isOk =reservationdeleteService.deleteReservation(r_num);
		
		
		if(!isOk) {
			System.out.println("실패!");
		}else {
			System.out.println("성공!");
			
			ReservationProService reservationProService = new ReservationProService();
			ArrayList<ReservationBean> reservationList = reservationProService.selectReservation(sid);
			
			System.out.println("reservationList 딜리트 : " + reservationList);
			request.setAttribute("reservationList", reservationList);
			
			System.out.println("딜리트2");
			forward = new ActionForward();
			System.out.println("딜리트1");
			forward.setPath("./user/user_reservation_select.jsp");
			System.out.println("딜리트0");
		}
		
		
		
		
		
		
		
		return forward;
	}

}
