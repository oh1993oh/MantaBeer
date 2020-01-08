package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BlogSearchService;
import vo.ActionForward;
import vo.BlogBean;
import vo.PageInfo;

public class BlogSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);
		String user_id = (String) httpSession.getAttribute("user_id");
		
		request.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		int page=1;
		int limit=3;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ActionForward forward = null;

//		int startPage = Integer.parseInt(request.getParameter("startPage"));
//		int endPage = Integer.parseInt(request.getParameter("endPage"));
		
		
		
		// Service 클래스 생성
		BlogSearchService blogSearchService = new BlogSearchService();
		int listCount = blogSearchService.getListCount(search);
		System.out.println("search에 해당하는 총 게시물 수 : " + listCount);
		
//		ArrayList<Search> searchList = new ArrayList<Search>();
		ArrayList<BlogBean> searchList = new ArrayList<BlogBean>();
		searchList = blogSearchService.getBlogSearchList(page,limit,search);
		ArrayList<BlogBean> articleListRe = new ArrayList<BlogBean>();
		articleListRe = blogSearchService.getArticleList(limit);
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = ((int)((double)page / 10 + 0.9)-1)*10+1;
		int endPage = startPage + 10 - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
		request.setAttribute("searchList", searchList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleListRe", articleListRe);
		request.setAttribute("sid", user_id);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
		
		
		
//		for (Search search : searchList) {
//			System.out.println(search);
//		}
		
//		for(int i=0;i<searchList.size();i++) {
//			page=searchList.get(i);
//		}
		
		
	//	request.setAttribute("", o);
		
		forward = new ActionForward();
		forward.setPath("/blog/beer_blog_search.jsp?search="+search);
//		forward.setPath("beer_blog_search.jsp");
		
		return forward;
	}

}
