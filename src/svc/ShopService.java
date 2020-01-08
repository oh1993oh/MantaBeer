package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.ShopBean;

import static db.jdbcUtil.*;

public class ShopService {

	public int getListCount(String category, String origin) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		int listCount = shopDAO.selectListCount(category,origin);

		
		close(con);
		return listCount;
	}

	public ArrayList<ShopBean> getProductList(int page, int limit, String category, String origin) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		ArrayList<ShopBean> articleList = null;
		
		articleList = shopDAO.selectProductList(page,limit,category,origin);
		
		
		
		
		close(con);
		return articleList;
	}

	public int getCartQuantity(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		
		int cartQuantity = shopDAO.countCartQuantity(user_id);
		close(con);
		
		
		return cartQuantity;
	}

}
