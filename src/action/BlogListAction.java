package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BlogListService;
import vo.ActionForward;
import vo.BlogBean;
import vo.PageInfo;

public class BlogListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BlogListAction");
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");
		
		int page = 1;
		int limit = 3;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BlogListService blogListService = new BlogListService();
		
		int listCount = blogListService.getListCount();
		System.out.println("총 게시물 수 : " + listCount);
		
		ArrayList<BlogBean> articleList = new ArrayList<BlogBean>();
		articleList = blogListService.getArticleList(page,limit);
		
		ArrayList<BlogBean> articleListRe = new ArrayList<BlogBean>();
		articleListRe = blogListService.getArticleList(limit);
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = ((int)((double)page / 10 + 0.9)-1)*10+1;
		int endPage = startPage + 10 - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		request.setAttribute("articleListRe", articleListRe);
		request.setAttribute("sid", user_id);
		ActionForward forward = new ActionForward();
		forward.setPath("/blog/beer_blog.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
