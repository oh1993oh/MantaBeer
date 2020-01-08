package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.ShopDAO;

public class PlaceAnOrderService {

	public boolean placeAnOrder(int user_num, int adress_table_num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int UpdateCount = shopDAO.placeAnOrder(user_num,adress_table_num);
		
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
