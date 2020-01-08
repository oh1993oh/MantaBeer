package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartService;
import svc.InsertReviewService;
import vo.ActionForward;

public class InsertReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertReviewAction");

		int product_num = Integer.parseInt(request.getParameter("product_num"));
		String review = request.getParameter("review");
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		int star = Integer.parseInt(request.getParameter("star"));
		String page = request.getParameter("page");

		ActionForward forward = null;

		if (user_id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('리뷰는 로그인하신 후 작성하실 수 있습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			InsertReviewService insertReviewService = new InsertReviewService();
			insertReviewService.insertreview(product_num, user_id, review, star);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("Detail.shop?product_num=" + product_num + "&page=" + page);
			

		}

		return forward;
	}

}