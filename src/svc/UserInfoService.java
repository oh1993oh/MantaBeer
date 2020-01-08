package svc;

import static db.jdbcUtil.*;




import java.sql.Connection;

import dao.UserDAO;
import vo.UserBean;




public class UserInfoService {

	public boolean naiyonglnfo(String sid) {
		// TODO Auto-generated method stub
		
		boolean isnaiyong = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

	    UserBean user = userDAO.getUser(sid);
	     
		
	    if(user != null) {
	    	commit(con);	    	
	    	isnaiyong = true;
	    	
	    } else {
	    	rollback(con);
	    	
	    }
		
		close(con);
		
		return isnaiyong;
	}

	public UserBean getUser(String sid) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

	    UserBean user = userDAO.getUser(sid);
	     
		
	    if(user != null) {
	    	commit(con);	    	
	    	
	    } else {
	    	rollback(con);
	    	
	    }
		
		close(con);
		
		
		
		
		return user;
	}

	

	
	

}
