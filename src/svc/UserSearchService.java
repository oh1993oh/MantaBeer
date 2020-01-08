package svc;

import static db.jdbcUtil.*;
import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;

public class UserSearchService {

	public UserBean searchUser() {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserBean user = userDAO.SearchUser();
		
		close(con);
		
		
		
		
		
		return user;
	}

}
