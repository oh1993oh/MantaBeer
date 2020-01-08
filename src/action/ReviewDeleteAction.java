package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Cart_removeService;
import svc.ReviewService;
import vo.ActionForward;
import vo.ReViewBean;

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("ReviewDeleteAction");
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");
		
		ReviewService reviewService = new ReviewService();
		
		ReViewBean reviewBean = reviewService.getReview(review_num);
		
		respone.setContentType("text/html; charset=UTF-8");
		PrintWriter out = respone.getWriter();	
		
		
		
		if(user_id != null) {
			if(user_id.equals(reviewBean.getUser_id())) {
				boolean isDeleteSuccess = reviewService.review_delete(review_num);
				out.println("true");
			}
		}
		
		
		return null;

		
	}

}
