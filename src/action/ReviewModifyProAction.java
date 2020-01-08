package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReviewService;
import vo.ActionForward;
import vo.ReViewBean;

public class ReviewModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("ReviewModifyProAction");
		
		ReViewBean reViewBean = new ReViewBean(); 
		reViewBean.setReview_num(Integer.parseInt(request.getParameter("review_num")));
		reViewBean.setReview(request.getParameter("review"));
		reViewBean.setStar(Integer.parseInt(request.getParameter("star")));

		
		ReviewService reviewService = new ReviewService();
		boolean isUpdateSuccess = reviewService.review_update(reViewBean);
		
		
		respone.setContentType("text/html; charset=UTF-8");
		PrintWriter out = respone.getWriter();	
		
		
		if(isUpdateSuccess) {
			out.println("true");
		}


		return null;
	}

}
