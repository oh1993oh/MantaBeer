package svc;
import static db.jdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class IdCheckService {

	public boolean regisUser(String user_id) {
		System.out.println("IdCheckService - regisUser()");
		boolean isRegisSuccees = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		System.out.println("IdCheckService - regisUser2()");
		int check = userDAO.idCheck(user_id);
		
		if(check == 0) {
			isRegisSuccees=true;
		}
		
		return isRegisSuccees;
	}

	
}
