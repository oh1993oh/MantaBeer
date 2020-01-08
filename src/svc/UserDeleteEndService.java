package svc;

import java.sql.Connection;



import dao.UserDAO;
import vo.UserBean;

import static db.jdbcUtil.*;

public class UserDeleteEndService {

	public boolean delendUser(UserBean user) {
		// TODO Auto-generated method stub
		
        boolean  isnaiyong4 = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int goodbye = userDAO.deleteUser(user);
		
		if(goodbye != 0 ) {
			commit(con);
			 isnaiyong4 = true;
		} else {
			rollback(con);
		}
		
		
		close(con);
		
		return  isnaiyong4;
	}



}
