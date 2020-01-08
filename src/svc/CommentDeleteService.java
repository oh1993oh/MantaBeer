package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.CommentDAO;
public class CommentDeleteService {

	public boolean isArticleDelete(int comment_num) {
		System.out.println("CommentDeleteService");
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		boolean isDeleteSuccess = false;
		
		int deleteCount = commentDAO.deleteComment(comment_num);
		if(deleteCount>0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return isDeleteSuccess;
	}

}
