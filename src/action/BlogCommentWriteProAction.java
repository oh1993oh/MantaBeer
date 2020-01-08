package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BlogCommentWriteProService;
import vo.ActionForward;
import vo.CommentBean;

public class BlogCommentWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BlogCommentWriteProAction");
		
		ActionForward forward = null;
		CommentBean commentBean = new CommentBean();
		HttpSession session = request.getSession(true);
		String user_id = (String)session.getAttribute("user_id");
		
		
		
		int blog_num = Integer.parseInt(request.getParameter("blog_num"));
		commentBean.setComment_blog_num(blog_num);
		commentBean.setComment_content(request.getParameter("comment_content"));
		commentBean.setComment_name(request.getParameter("comment_name"));
		commentBean.setComment_blog_num(blog_num);
		
		if (user_id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다!')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			// 유저번호 가져오기
			BlogCommentWriteProService blogCommentWriteProService = new BlogCommentWriteProService();
			blogCommentWriteProService.registArticle(blog_num, user_id,commentBean);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BlogDetail.bl?blog_num="+blog_num);
			forward.setRedirect(true);	
			
		}
		
//		BlogCommentWriteProService blogCommentWriteProService = new BlogCommentWriteProService();
//		boolean isWriteSuccess2 = blogCommentWriteProService.registArticle(commentBean);
//		if(!isWriteSuccess2) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();	
//			out.println("<script>");
//			out.println("alert('댓글 등록실패!')");
//			out.println("history.back();");
//			out.println("</script>");
//		}
//		else {	
//			forward = new ActionForward();
//			forward.setPath("BlogDetail.bl?blog_num="+blog_num);
//			forward.setRedirect(true);	
//			
//		}
		return forward;
	}
		
}
