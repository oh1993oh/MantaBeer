package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.OrdertrackingService;
import vo.ActionForward;
import vo.TradeBean;

public class UserOrdertrackingAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("UserOrdertrackingAction ����");
		
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("user_id");
		
		System.out.println("ID : " + id);
		
		
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./LoginForm.me");
		}else {
			System.out.println("else");
			OrdertrackingService ordertrackingservice = new OrdertrackingService();
			ArrayList<TradeBean> ordertrackinglist =ordertrackingservice.getOrdertrackinglist(id);
			
			int size = ordertrackinglist.size();
			int[] p_num = new int[size];
			int[] name_num = new int[size];
			for (int i = 0; i < size; i++) {
				
				p_num[i] += (ordertrackinglist.get(i).getTrade_quantity() * ordertrackinglist.get(i).getProduct_price());
				name_num[i]+= ordertrackinglist.get(i).getProduct_product_num();
			}
//			System.out.println("총 가격 :" + p_num[size]);
//			System.out.println("이름 갯수" + name_num[size]);
			
			request.setAttribute("ordertrackinglist", ordertrackinglist);
			
			System.out.println(ordertrackinglist);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./user/UserOrdertracking.jsp");
			
			
		}
		
		
		return forward;
	}

}
