package svc;

import static db.jdbcUtil.*;


import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;



public class UserUpdateService {

	public boolean updateUser(UserBean user) {
		// TODO Auto-generated method stub
		
		boolean isnaiyong2 = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int sujeng  = userDAO.updateUser(user);
		
		if(sujeng != 0) {
			commit(con);
			isnaiyong2 = true;
		} else {
			rollback(con);
		}
	
		
		close(con);
		
		return isnaiyong2;

	
	}

	}
