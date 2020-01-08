package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.InventoryService;
import svc.RevenueService;
import vo.ActionForward;
import vo.TradeBean;

public class RevenueAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("RevenueAction");
		ActionForward forward = null;
		
		int revenue = 0;
		ArrayList<TradeBean> tradeList = null;
		
		
		RevenueService revenueService = new RevenueService();
		tradeList = revenueService.getRevenue();
		
		for(TradeBean tb:tradeList) {
			int price = tb.getProduct_price()*tb.getTrade_quantity();
			int sale = (tb.getProduct_price()*tb.getTrade_quantity())*tb.getTrade_sale()/100;
			price = price - sale;
			revenue = revenue + price;
		}
		revenue = revenue / 10000;
		System.out.println(revenue);
		
		request.setAttribute("revenue_12", revenue);
		
		forward = new ActionForward();
		forward.setPath("/user/Revenue_Management.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
