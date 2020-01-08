package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReviewService;
import vo.ActionForward;
import vo.ReViewBean;

public class ReviewModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("ReviewModifyAction");
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");

		ReviewService reviewService = new ReviewService();
		

		
		ReViewBean reviewBean = reviewService.getReview(review_num);
		
		
		if(user_id == null) {
			System.out.println("로그인안했음");
			return null;
		}else if(user_id.equals(reviewBean.getUser_id())) {
			respone.setContentType("text/html; charset=UTF-8");
			PrintWriter out = respone.getWriter();	
						
			String r = reviewBean.Review();
			int s = reviewBean.getStar();
			
//			System.out.println("{'review':'"+r+"','star':'"+s+"'}");
			out.println("true");
//			out.println("[");
//			out.println("{'review':'"+r+"','star':'"+s+"'}");
//			out.println("]");
		}


//			{"id":"kim","pass":"p123","name":"김길동"},


		
		
		return null;
	}

}
