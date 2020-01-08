package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BlogDAO;
import dao.CommentDAO;

import static db.jdbcUtil.*;
import vo.BlogBean;
import vo.CommentBean;

public class BlogDetailService {

	public BlogBean getArticle(int blog_num) {
		System.out.println("BlogDetailService");
		
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
		BlogBean article = blogDAO.selectArticle(blog_num);
		System.out.println(article.getBlog_subject());
		int updateCount = blogDAO.updateReadcount(blog_num);
		
		// 조회 수 증가 후 리턴받은 updateCount 가 0보다 크면 commit, 아니면 rollback 수행
		if(updateCount>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
//		close(con);
//		int updateCount = blogDAO.updateReadCount(blog_num);
//		
//		if(updateCount > 0) {
//			commit(con);
//		} else {
//			rollback(con);
//		}
//		boolean updateCount = blogDAO.setUpdateReadcount(blog_num);
//		if(updateCount) {
//			commit(con);
//		} else {
//			rollback(con);
//		}
		close(con);
		
		return article;
	}

//	public CommentBean getComment(int blog_num) {
//		
//		Connection con = getConnection();
//		CommentDAO commentDAO = CommentDAO.getInstance();
//		commentDAO.setConnection(con);
//
//		CommentBean commentBean = commentDAO.selectComment(blog_num);
//
//		close(con);
//			return commentBean;
//		}
	public CommentBean getComment(int comment_num) {

		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);

		CommentBean comment = commentDAO.selectArticle(comment_num);
//		System.out.println(comment.getComment_num());
		close(con);

		return comment;
	}

	public ArrayList<CommentBean> getCommentList(int blog_num) {
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		
		ArrayList<CommentBean> commentList = null;
		commentList = commentDAO.selectArticleList(blog_num);
		
		close(con);
		return commentList;
	}

}
