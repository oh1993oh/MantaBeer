package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BlogDetailService;
import vo.ActionForward;
import vo.BlogBean;
import vo.CommentBean;

public class BlogDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BlogDetailAction");
		
		int blog_num = Integer.parseInt(request.getParameter("blog_num"));
		String nowPage = request.getParameter("page");
		
		System.out.println(blog_num + ", " + nowPage);
		BlogDetailService blogDetailService = new BlogDetailService();
		BlogBean blogBean = blogDetailService.getArticle(blog_num);
		CommentBean commentBean = blogDetailService.getComment(blog_num);
		ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();
		commentList = blogDetailService.getCommentList(blog_num);
		request.setAttribute("page", nowPage);
		request.setAttribute("article", blogBean);
		request.setAttribute("comment", commentBean);
		request.setAttribute("commentList", commentList);
		request.setAttribute("blog_num", blog_num);
//		Cookie todayImageCookie = new Cookie("today"+blog_num, blogBean.getBlog_file());
//		todayImageCookie.setMaxAge(60*60*24);
//		response.addCookie(todayImageCookie);
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/blog/blog-single.jsp");
		
		return forward;
	}
	
}
