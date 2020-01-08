package svc;

import vo.CommentBean;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.CommentDAO;
public class CommentUpdateProService {
	
	
	public boolean modifyArticle(CommentBean comment) {
		System.out.println("CommentUpdateProService");
		Connection con =getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int updateCount = commentDAO.updateComment(comment);
		
		if(updateCount>0) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

	return isUpdateSuccess;
	}

}