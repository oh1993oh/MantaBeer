package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;

import static db.jdbcUtil.*;

import vo.ShopBean;
import vo.TradeBean;

public class Product_onCartService {

	public int getUser_num(String user_id) {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		int user_num = shopDAO.selectUser_num(user_id);

		close(con);

		return user_num;
	}

	public boolean setTrade_onCart(TradeBean tradeBean) {
		// TODO Auto-generated method stub
		boolean isInsertSuccess = false;

		Connection con = getConnection();

		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		int insertCount = shopDAO.insertTrade_onCart(tradeBean);

		if (insertCount > 0) {
			commit(con);
			isInsertSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isInsertSuccess;
	}

	public boolean getPossible_onCart(int user_num, int product_num) {
		// TODO Auto-generated method stub
		boolean isPossible = false;

		Connection con = getConnection();

		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		isPossible = shopDAO.getPossible_onCart(user_num, product_num);



		close(con);

		
		return isPossible;
	}

	

	public TradeBean getProductInfo(int product_num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		TradeBean tradeBean = shopDAO.selectProductInfo(product_num);
		
		close(con);
		
		return tradeBean;
	}


}
