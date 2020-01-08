package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Product_onCartService;
import svc.ShopService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ShopBean;

public class ShopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		
		int page = 1;
		int limit = 12;
		String category = null;
		String origin = null;
		
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		if(request.getParameter("category") != null) {
			category = request.getParameter("category");
		}
		
		if(request.getParameter("origin") != null) {
			origin = request.getParameter("origin");
		}
		
		ShopService shopService = new ShopService();
		int listCount = shopService.getListCount(category,origin);
		
		articleList = shopService.getProductList(page,limit,category,origin);
		
		int maxPage = (int)((double)listCount/limit+0.95);
		
		int startPage = ((int)((double)page / 10 + 0.9)-1)*10+1;
		
		int endPage = startPage + 10-1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageinfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
		
		request.setAttribute("pageInfo", pageinfo);
		request.setAttribute("articleList", articleList);
		
		System.out.println(articleList.size());
		
		ActionForward forward= new ActionForward();
		forward.setPath("/product/shop.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
