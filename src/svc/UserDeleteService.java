package svc;


import static db.jdbcUtil.*;


import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;

public class UserDeleteService {

	public boolean deleteUser(UserBean user) {
		// TODO Auto-generated method stub
		boolean  isnaiyong3 = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int delendusercheck = userDAO.delusercheck(user);
		
		if(delendusercheck==1) {
			 commit(con);
			 isnaiyong3 = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isnaiyong3;

	}

}