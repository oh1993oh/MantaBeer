package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ReviewListService;
import svc.ShopDetailService;
import vo.ActionForward;
import vo.BeerBean;
import vo.ReViewBean;
import vo.ShopBean;

public class Product_SingleAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
	  System.out.println("Product_SingleAction");
      int product_num = Integer.parseInt(request.getParameter("product_num"));
      String page = request.getParameter("page");//$$notNecessarily
      
//      System.out.println("board_num:"+ board_num + "page:"+ page);
      System.out.println(page);
      
      ActionForward forward = null;
      forward = new ActionForward();
      
      
      ShopDetailService shopDetailService = new ShopDetailService();
      ShopBean shopBean = shopDetailService.getArticle(product_num);
      
      BeerBean beerBean = shopDetailService.getBeerArticle(product_num);
      
      ReviewListService reviewListService = new ReviewListService();
      ArrayList<ReViewBean> reviewList = reviewListService.getReviewList(product_num);
      
      System.out.println("1");
      request.setAttribute("page", page);
      request.setAttribute("shopBean", shopBean);
      request.setAttribute("beerBean", beerBean);
      request.setAttribute("reviewList", reviewList);
      
      System.out.println("page = "+page);
      System.out.println("reviewList.size = "+reviewList.size());
      
      System.out.println("2");
      forward.setPath("/product/product_single.jsp");
      return forward;
   }

}