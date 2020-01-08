package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReservationProService;
import vo.ActionForward;
import vo.ReservationBean;

public class manager_Reservation_selectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String  sid = (String)session.getAttribute("user_id");
		
		System.out.println("manager_Reservation_selectAction ID : " + sid);
		ReservationProService reservationProService = new ReservationProService();
		ArrayList<ReservationBean> managerreservationList = reservationProService.managerselectReservation();
		
		System.out.println("manager_Reservation_selectAction  : " + managerreservationList);
		request.setAttribute("managerreservationList", managerreservationList);
		System.out.println("service 끝");
		forward = new ActionForward();
		forward.setPath("./user/manager_reservation_select.jsp");
		
		
		return forward;
	}

}
