package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;

import static db.jdbcUtil.*;
import vo.TradeBean;

public class OrdertrackingService {

	public ArrayList<TradeBean> getOrdertrackinglist(String id) {

		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		ArrayList<TradeBean> ordertrackinglist =shopDAO.ordertrackinglist(id);
		System.out.println("¼­ºñ½º : " +ordertrackinglist);
		close(con);
		
		
		
		return ordertrackinglist;
	}

}
