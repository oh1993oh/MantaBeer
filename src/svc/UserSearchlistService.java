package svc;

import static db.jdbcUtil.*;


import java.sql.Connection;

import java.util.List;

import dao.UserDAO;


public class UserSearchlistService {

	public List islistnaiyong(String select_name) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		List user_List = userDAO.getUser_search(select_name);
	
	//user_List = userDAO.getUser_search_2(select_name);
	
		//System.out.println("userList" + userList);
		close(con);
		
		
		
		
		
		
		
		return user_List;
	}

	

}
