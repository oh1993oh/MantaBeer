package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;

public class UserListViewService {

	public UserBean getUser(String view_id) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserBean user = userDAO.selectUser(view_id);
		close(con);
		
		return user;
	}

}
