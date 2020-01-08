package action;

import java.io.PrintWriter;

//import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BlogDetailService;
//import svc.CommentUpdateProService;
import vo.ActionForward;
//import vo.BlogBean;
import vo.CommentBean;

public class CommentUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("CommentUpdateFormAction");
		//request.setCharacterEncoding("UTF-8");
		
		int comment_num= Integer.parseInt(request.getParameter("comment_num"));
		int comment_blog_num = Integer.parseInt(request.getParameter("comment_blog_num"));
		HttpSession session = request.getSession(true);
		String user_id = (String)session.getAttribute("user_id");
		//System.out.println(comment_num);

		BlogDetailService blogDetailService = new BlogDetailService();
	    CommentBean comment = blogDetailService.getComment(comment_num);
		

//	      if(user_id == null) {
//	         System.out.println("로그인안했음");
//	         return null;
//	      }else if(user_id.equals(comment.getComment_name())) {
//	         response.setContentType("text/html; charset=UTF-8");
//	         PrintWriter out = response.getWriter();   
//	                  
//	         String content = comment.getComment_content();
////	         int s = comment.getStar();
//	         
////	         System.out.println("{'review':'"+r+"','star':'"+s+"'}");
//	         out.println("true");
////	         out.println("[");
////	         out.println("{'review':'"+r+"','star':'"+s+"'}");
////	         out.println("]");
//	      }
	    
		//댓글 정보를 request에 저장
	
		request.setAttribute("comment", comment);
		request.setAttribute("comment_blog_num", comment_blog_num);
			forward = new ActionForward();
			forward.setPath("./blog/blog_comment_update.jsp");
	
		return forward;
	}

}
