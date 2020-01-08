package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CommentUpdateProService;
import vo.ActionForward;
import vo.CommentBean;

public class CommentUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("CommentUpdateProAction");
		
		int comment_blog_num = Integer.parseInt(request.getParameter("comment_blog_num"));
		int comment_num=Integer.parseInt(request.getParameter("comment_num"));
		String comment_name =request.getParameter("comment_name");
		String comment_content = request.getParameter("comment_content");
		
		CommentBean comment = new CommentBean();
		comment.setComment_num(Integer.parseInt(request.getParameter("comment_num")));;
		comment.setComment_name(request.getParameter("comment_name"));
		comment.setComment_content(request.getParameter("comment_content"));
		
		CommentUpdateProService cmUpdateProService = new CommentUpdateProService();
		boolean isUpdateSuccess = cmUpdateProService.modifyArticle(comment);
		
		if(!isUpdateSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('댓글 수정실패!')");
			out.println("history.back();");
			out.println("</script>");
		} else {	
			forward = new ActionForward();
			forward.setPath("BlogDetail.bl?blog_num="+comment_blog_num);
			forward.setRedirect(true);	
			
		}

		return forward;
	}

}
