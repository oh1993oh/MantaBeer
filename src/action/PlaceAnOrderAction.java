package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.PlaceAnOrderService;
import vo.ActionForward;

public class PlaceAnOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PlaceAnOrderAction");
		ActionForward forward = null;
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		int adress_table_num = Integer.parseInt(request.getParameter("adress_table_num"));


		PlaceAnOrderService placeAnOrderService = new PlaceAnOrderService();
		boolean trade_success = placeAnOrderService.placeAnOrder(user_num,adress_table_num);
		

		forward = new ActionForward();
		forward.setPath("BeerMain.me");
		forward.setRedirect(true);
		
		return forward;
	}

}
