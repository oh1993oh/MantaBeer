package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartService;
import svc.Cart_toCheckOutService;
import vo.ActionForward;
import vo.TradeBean;

public class Cart_toCheckOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Cart_toCheckOutAction");
		Cart_toCheckOutService cart_toCheckOutService = null;
		ActionForward forward = null;
		boolean isUpdateSuccess = false;
		
		
		String quantity = (String)request.getParameter("quantity");
		String trade_num = (String)request.getParameter("trade_num");
		String trade_notice = (String)request.getParameter("trade_notice");
		String[] quantity_array = quantity.split(",");
		String[] trade_num_array = trade_num.split(",");
		

		


		cart_toCheckOutService = new Cart_toCheckOutService();
		isUpdateSuccess = cart_toCheckOutService.update_quantity(quantity_array,trade_num_array,trade_notice);
		

		
		if(!isUpdateSuccess) {
			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('수량변경실패!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
			
			forward = new ActionForward();
			forward.setPath("CheckOut.shop");
			forward.setRedirect(true);
		}

		return forward;
	}

}
