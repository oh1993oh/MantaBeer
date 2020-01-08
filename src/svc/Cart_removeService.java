package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.ShopDAO;

public class Cart_removeService {


	public boolean cart_delete(int trade_num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isDeleteSuccess = false;
		
		int deleteCount = shopDAO.cart_delete(trade_num);
		
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}

}
