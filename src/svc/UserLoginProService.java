package svc;



import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.UserDAO;



public class UserLoginProService {

	public int UserLogin(String id, String pass) {
		// TODO Auto-generated method stub
	
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int loginResult = userDAO.selectUserLogin(id,pass);
		
		close(con);
		
		return loginResult;
	}

}
