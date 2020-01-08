package svc;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import vo.TradeBean;

public class getdepositList {
	//관리자용
	public ArrayList<TradeBean> getdepositList() {
		// TODO Auto-generated method stub
		
       Connection con = getConnection();
       UserDAO userDAO = UserDAO.getInstance();
       userDAO.setConnection(con);
       
       ArrayList<TradeBean> depositList = userDAO.getdepositList();
		System.out.println(depositList);
       close(con);
		
		return depositList;
	}
	
	//관리자용
	public ArrayList<TradeBean> getdepositdetailList(int trade_classification ) {
		// TODO Auto-generated method stub
		
       Connection con = getConnection();
       UserDAO userDAO = UserDAO.getInstance();
       userDAO.setConnection(con);
       
       ArrayList<TradeBean> depositdetailList = userDAO.getdepositdetailList(trade_classification);
		System.out.println(depositdetailList);
       close(con);
		
		return depositdetailList;
	}
	//사용자용
	public ArrayList<TradeBean> usergetdepositList(String user_id) {
		// TODO Auto-generated method stub
		
       Connection con = getConnection();
       UserDAO userDAO = UserDAO.getInstance();
       userDAO.setConnection(con);
       
       ArrayList<TradeBean> userdepositList = userDAO.usergetdepositList(user_id);
		System.out.println(userdepositList);
       close(con);
		
		return userdepositList;
	}
	//사용자용
	public ArrayList<TradeBean> usergetdepositdetailList(int trade_classification, String user_id) {
		 
		   Connection con = getConnection();
	       UserDAO userDAO = UserDAO.getInstance();
	       userDAO.setConnection(con);
	       
	       ArrayList<TradeBean> userdepositdetailList = userDAO.usergetdepositdetailList(trade_classification,user_id);
			System.out.println(userdepositdetailList);
	       close(con);
			
			return userdepositdetailList;
	}
	
}
