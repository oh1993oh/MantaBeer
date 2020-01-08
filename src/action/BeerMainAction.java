package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BeerMainService;
import vo.ActionForward;
import vo.ShopBean;

public class BeerMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("BeerMainAction");
		ArrayList<ShopBean> bestList = null;
		ArrayList<ShopBean> saleList = null;
		ArrayList<ShopBean> newList = null;
		
		
		BeerMainService beerMainService = new BeerMainService();
		bestList = beerMainService.getBestList();
		saleList = beerMainService.getSaleList();
		newList = beerMainService.getNewList();
		
		
		request.setAttribute("bestList", bestList);
		request.setAttribute("saleList", saleList);
		request.setAttribute("newList", newList);
		ActionForward forward = new ActionForward();
		forward.setPath("/configuration/index.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
