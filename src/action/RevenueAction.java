package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.InventoryService;
import svc.RevenueService;
import vo.ActionForward;
import vo.RevenusBean;
import vo.TradeBean;

public class RevenueAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("RevenueAction");
		ActionForward forward = null;
		
		int revenue = 0;
		ArrayList<TradeBean> tradeList = null;
		ArrayList<RevenusBean> revenusList = new ArrayList<RevenusBean>();
		RevenusBean rBean = null;
		
		RevenueService revenueService = new RevenueService();
		tradeList = revenueService.getRevenue();
		int month = 0;
		for(TradeBean tb:tradeList) {
			if(tb.getTrade_date().getMonth() != month) {
				rBean = new RevenusBean();
				revenusList.add(rBean);
				month = tb.getTrade_date().getMonth();
				rBean.setMonth(month+1);
			}
			int price = tb.getProduct_price()*tb.getTrade_quantity();
			int sale = (tb.getProduct_price()*tb.getTrade_quantity())*tb.getTrade_sale()/100;
			price = price - sale;
			rBean.setRevenus(rBean.getRevenus()+price);
			
		}
		
		for(RevenusBean rb :revenusList) {
			rb.setRevenus(rb.getRevenus()/10000);
			
		}
		
		request.setAttribute("revenueList", revenusList);
		
		forward = new ActionForward();
		forward.setPath("/user/Revenue_Management.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
