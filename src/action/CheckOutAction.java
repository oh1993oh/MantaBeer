package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartService;
import svc.Product_onCartService;
import vo.ActionForward;
import vo.AdressBean;
import vo.TradeBean;

public class CheckOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("ChectOutAction");
		
		CartService cartService = null;
		ActionForward forward = null;

		ArrayList<TradeBean> checkOutList = null;
		ArrayList<AdressBean> adressList = null;
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");

		if (user_id == null) {
			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('.로그인하신후 사용하실수 있습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			System.out.println("유저번호가져오기");
			cartService = new CartService();
			int user_num = cartService.getUser_num(user_id);
			System.out.println(user_num);
			adressList = cartService.getAdressList(user_num);
			checkOutList = cartService.getCartList(user_num);
			System.out.println("adressSize = "+adressList.size());
			System.out.println("checkOutListSize = "+checkOutList.size());
			request.setAttribute("checkOutList", checkOutList);
			request.setAttribute("adressList", adressList);


			forward = new ActionForward();
			forward.setPath("/product/checkout.jsp");
			forward.setRedirect(false);
				
			
		}

		return forward;
	}

}
