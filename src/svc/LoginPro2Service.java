package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;

import dao.ShopDAO;

public class LoginPro2Service {

	public String getUser(String id) {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		String user = shopDAO.selectUser_id(id);

		close(con);

		return user;
	}

}
