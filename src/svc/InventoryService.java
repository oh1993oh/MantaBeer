package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.ShopBean;

public class InventoryService {

	public ArrayList<ShopBean> getInventory() {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		
		ArrayList<ShopBean> productList = null;
		
		productList = shopDAO.selectInventory();
		
		
		
		
		close(con);
		return productList;
	}

}
