package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import svc.CartService;
import svc.Product_onCartService;
import vo.ActionForward;
import vo.ShopBean;
import vo.TradeBean;

public class CartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		CartService cartService = null;
		ActionForward forward = null;

		ArrayList<TradeBean> cartList = null;
		ArrayList<Integer> notSameList = null;
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");

		if (user_id == null) {
			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('장바구니는 로그인하신후 사용하실수 있습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			cartService = new CartService();
			int user_num = cartService.getUser_num(user_id);

			cartList = cartService.getCartList(user_num);
			request.setAttribute("cartList", cartList);
			request.setAttribute("notSameList", notSameList);
			forward = new ActionForward();
			forward.setPath("/product/cart.jsp");
			forward.setRedirect(false);
				

		}

		return forward;
	}

}
