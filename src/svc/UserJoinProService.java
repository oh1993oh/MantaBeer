package svc;

import vo.AdressBean;
import vo.UserBean;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.UserDAO;

public class UserJoinProService {

	public boolean regisUser(UserBean user) {
		// TODO Auto-generated method stub
		boolean isRegisSuccees = false;

		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

		int insertCount = userDAO.insertUser(user);

		if (insertCount > 0) {
			commit(con);
			isRegisSuccees = true;
		} else {
			rollback(con);

		}

		close(con);
		return isRegisSuccees;

	}

	public boolean regisUserAdress(AdressBean adress) {
		// TODO Auto-generated method stub
		boolean isRegisSuccees = false;

		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

		int insertCount = userDAO.insertAdress(adress);

		if (insertCount > 0) {
			commit(con);
			isRegisSuccees = true;
		} else {
			rollback(con);

		}

		close(con);
		return isRegisSuccees;
	}

	public int getUser_num(String user_id) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

		int user_num = userDAO.selectUser_num(user_id);


		close(con);
		return user_num;
	}

}
