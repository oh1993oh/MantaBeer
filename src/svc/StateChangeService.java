package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.ShopDAO;

public class StateChangeService {

	public boolean stateChange(int classification, String state) {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		boolean isUpdateSuccess = false;
		

		int updateCount = shopDAO.stateChange(classification,state);
		
		
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
