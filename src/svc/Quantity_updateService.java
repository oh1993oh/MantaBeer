package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.ShopDAO;

public class Quantity_updateService {

	public boolean quantity_update(int quantity, int product_num) {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int UpdateCount = shopDAO.Quantity_update(quantity,product_num);
		
		if(UpdateCount>0) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isUpdateSuccess;
		
	}

}
