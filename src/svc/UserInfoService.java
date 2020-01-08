package svc;

import static db.jdbcUtil.*;




import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;




public class UserInfoService {


	public UserBean getUser(String sid) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

	    UserBean user = userDAO.getUser(sid);
	     
		
		close(con);
		
		
		
		
		return user;
	}

	

	
	

}
