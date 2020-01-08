package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReservationProService;
import svc.ReservationdeleteService;
import vo.ActionForward;
import vo.ReservationBean;

public class manager_Reservation_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String  sid = (String)session.getAttribute("user_id");
		int r_num=Integer.parseInt( request.getParameter("r_num"));
		int u_num=Integer.parseInt( request.getParameter("u_num"));
		
		System.out.println("예약자의 예약번호 : " + r_num);
		System.out.println("예약자의 유저번호 : " + u_num);
		
		System.out.println("manager_Reservation_deleteAction ID : " + sid);
		
		ReservationdeleteService  reservationdeleteService  = new ReservationdeleteService();
		boolean isOk =reservationdeleteService.managerReservationdelete(u_num,r_num);
		
		if(isOk==false) {
			System.out.println("실패!");
		}else {
			System.out.println("성공!");
		
			ReservationProService reservationProService = new ReservationProService();
			ArrayList<ReservationBean> managerreservationList = reservationProService.managerselectReservation();
			
			System.out.println("reservationList 딜리트 : " + managerreservationList);
			request.setAttribute("managerreservationList", managerreservationList);
			
			forward = new ActionForward();
			forward.setPath("./user/manager_reservation_select.jsp");
			
			
		}
		return forward;
	}

}
