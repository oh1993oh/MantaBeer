package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;

import svc.ReservationcheckIdService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReservationCheckAction 진입");
		
		ReservationBean rebean = null;
		
		rebean=new ReservationBean();
		rebean.setReser_date(request.getParameter("date"));
		rebean.setReser_time(request.getParameter("time"));
		
		System.out.println("체크 객체 담기 성공!");
		

		
		ReservationcheckIdService rcid= new ReservationcheckIdService();
		


		JSONArray checkIdList= rcid.checkroom(rebean);
		System.out.println("Action : "+checkIdList);
		
//		System.out.println("Action isCheck : "+ischeck);
		
//		for(JSONArray checkId: checkIdList) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//			out.println(checkId);
//		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		out.println(checkIdList);
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
