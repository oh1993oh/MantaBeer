package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Product_onCartService;
import vo.ActionForward;
import vo.TradeBean;

public class Product_onCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("Product_onCartAction");
		int product_num = Integer.parseInt(request.getParameter("product_num"));
		String from = request.getParameter("from");
		
		int quantity = 1;
		if(request.getParameter("quantity") != null) {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		TradeBean tradeBean = null;
		Product_onCartService product_onCartService = null;
		ActionForward forward = null;
		if(request.getParameter("page")!=null) {
			from=from+"?page="+request.getParameter("page");
		}

		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");
		// "USER"로 바인딩된 객체를 돌려준다. ("USER"로 바인딩된 객체가 없다면 null)

		if (user_id == null) {
			System.out.println("로그인 하신후 사용하실수 있는 기능입니다");

			respone.setContentType("text/html;charset=UTF-8");
			PrintWriter out = respone.getWriter();
			out.println("<script>");
			out.println("alert('로그인 하신후 사용하실수 있는 기능입니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			product_onCartService = new Product_onCartService();
			int user_num = product_onCartService.getUser_num(user_id);

			// 유저번호에 해당하는 장바구니에 현재 물품이 존재하는가?
			boolean isPossible_onCart = product_onCartService.getPossible_onCart(user_num, product_num);

			if (!isPossible_onCart) {
				System.out.println("이미장바구니에 담겨있는 제품입니다");

				respone.setContentType("text/html;charset=UTF-8");
				PrintWriter out = respone.getWriter();
				out.println("<script>");
				out.println("alert('이미장바구니에 담겨있는 제품입니다')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				tradeBean = product_onCartService.getProductInfo(product_num);
				tradeBean.setUser_user_num(user_num);
				tradeBean.setTrade_classification(0);
				tradeBean.setProduct_product_num(product_num);
				tradeBean.setTrade_quantity(quantity);
				tradeBean.setTrade_state("cart");
				//물건이름

				boolean isCartSuccess = product_onCartService.setTrade_onCart(tradeBean);

				// 카트에 제품이 성공적으로 담겼을때
				
				if (isCartSuccess) {
					System.out.println("카트에 물건이 제대로 담겼을때");

					respone.setContentType("text/html;charset=UTF-8");
					PrintWriter out = respone.getWriter();
					out.println("<script>");
					out.println("alert('제품등록성공!');");

//					out.println("location.href='Cart.Shop';");   

					out.println("location.href='"+from+"';");    
					out.println("</script>");

				}

			}

		}

		return forward;
	}

}
