package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.AdressBean;
import vo.TradeBean;

public class CartService {

	public int getUser_num(String user_id) {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		int user_num = shopDAO.selectUser_num(user_id);

		close(con);

		return user_num;
	}

	public ArrayList<TradeBean> getCartList(int user_num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		
		ArrayList<TradeBean> cartList = null;
		
		cartList = shopDAO.selectCartList(user_num);
		
		
		
		
		close(con);
		return cartList;
	}

	public ArrayList<AdressBean> getAdressList(int user_num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		
		ArrayList<AdressBean> adressList = null;
		
		adressList = shopDAO.selectAdressList(user_num);
		
		
		
		
		close(con);
		return adressList;
	}

}
