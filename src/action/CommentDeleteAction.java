package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

import dao.CommentDAO;
import svc.CommentDeleteService;
import vo.ActionForward;

public class CommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentDeleteAction");
		ActionForward forward = null;
		int blog_num = Integer.parseInt(request.getParameter("comment_blog_num"));
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		System.out.println(comment_num+","+blog_num);
//		PrintWriter out = response.getWriter();
		CommentDeleteService commentDeleteService = new CommentDeleteService();
		boolean commentDelete = commentDeleteService.isArticleDelete(comment_num);
//		CommentDAO dao = CommentDAO.getInstance();
//		boolean commentDelete = dao.deleteComment(comment_num);
		
		
		if(commentDelete) {
//			out.println(1);
//			out.close();
//			System.out.println(1);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BlogDetail.bl?blog_num="+blog_num);
//			JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?");
		} 
			
		return forward;
//		return null;
	}
	
}
