package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.UserDAO;


public class UserListDeleteService {

	public boolean ListDeleteUser(String delete_id) {
		// TODO Auto-generated method stub
		
		boolean deleteResult = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int deleteCount = userDAO.deleteListUser(delete_id);
		
		if(deleteCount > 0 ) {
			commit(con);
			deleteResult = true;
			
		} else {
			rollback(con);
			
		}
		
		close(con);
		
		return deleteResult;
	}

}
