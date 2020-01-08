package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Cart_removeService;
import vo.ActionForward;

public class Cart_removeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		int trade_num = Integer.parseInt(request.getParameter("trade_num"));
		System.out.println(trade_num);
		
		Cart_removeService cart_removeService = new Cart_removeService();
		
		cart_removeService.cart_delete(trade_num);
		
		return null;
	}

}
