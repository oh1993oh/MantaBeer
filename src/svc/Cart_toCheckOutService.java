package svc;
import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;

import static db.jdbcUtil.*;

public class Cart_toCheckOutService {

	public boolean update_quantity(String[] quantity_array, String[] trade_num_array, String trade_notice) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int updateCount = shopDAO.update_quantity(quantity_array,trade_num_array,trade_notice);
		
		
		if(updateCount > 0) {
			commit(con);
			isUpdateSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isUpdateSuccess;
	}

}
