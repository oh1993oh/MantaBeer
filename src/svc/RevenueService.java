package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import vo.TradeBean;

public class RevenueService {

	public ArrayList<TradeBean> getRevenue() {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		
		ArrayList<TradeBean> revenue = userDAO.selectRevenue();
		
		
		
		 
		
		
		
		
		close(con);
		return revenue;
	}

}



	
	