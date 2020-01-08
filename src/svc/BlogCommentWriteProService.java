package svc;

import vo.CommentBean;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.CommentDAO;


public class BlogCommentWriteProService {


	public boolean registArticle(int blog_num,String user_id,CommentBean commentBean) {
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		
		int insertCount = commentDAO.insertArticle(blog_num,user_id,commentBean);
		
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
	}

}
