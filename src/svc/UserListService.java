package svc;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import vo.UserBean;

public class UserListService {

	public ArrayList<UserBean> getUserList() {
		// TODO Auto-generated method stub
		System.out.println("UserListService");
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

		ArrayList<UserBean> userList = userDAO.selectUserList();

		close(con);

		return userList;
	}

}
