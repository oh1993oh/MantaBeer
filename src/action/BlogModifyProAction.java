package action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BlogModifyProService;
import vo.ActionForward;
import vo.BlogBean;

public class BlogModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BlogModifyProAction");
		int fileSize = 10 * 1024 * 1024;
		BlogBean article = new BlogBean();
		String uploadPath = request.getServletContext().getRealPath("/blogUpload");
		MultipartRequest multi = new MultipartRequest(
				request,	
				uploadPath,	
				fileSize,	
				"UTF-8",	
				new DefaultFileRenamePolicy()	
		);
		
		int blog_num = Integer.parseInt(multi.getParameter("blog_num"));
		String page = multi.getParameter("page");
		String blog_pass = multi.getParameter("blog_pass");
//		String existFile = multi.getParameter("blog_file");
//		System.out.println(page);
		ActionForward forward = null;
		BlogModifyProService blogModifyProService = new BlogModifyProService();
		boolean isRightUser = blogModifyProService.isArticleWriter(blog_num,blog_pass);
		if(!isRightUser) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한이 없습니다!')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			article = new BlogBean();
			article.setBlog_num(blog_num);
			article.setBlog_subject(multi.getParameter("blog_subject"));
			article.setBlog_content(multi.getParameter("blog_content"));
//			article.setBlog_file(multi.getParameter("blog_file"));
			article.setBlog_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
			boolean isModifySuccess = blogModifyProService.modifyArticle(article);
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('게시물 수정 실패!')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("BlogDetail.bl?blog_num="+blog_num+"&page="+page);
				System.out.println(page);
			}
			
			
		}
//		Enumeration<String> fileNames = multi.getFileNames();
//		if(fileNames.hasMoreElements()) {
//			String fileName = fileNames.nextElement();
//			String updateFile = multi.getFilesystemName(fileName);
//			
//			if(updateFile==null) {
//				article.setBlog_file(existFile);
//			} else {
//				article.setBlog_file(updateFile);
//			}
//		}
		request.setAttribute("page", page);
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("BlogDetail.bl?blog_num="+blog_num+"&page="+page);
		
		return forward;
	}
	
}
