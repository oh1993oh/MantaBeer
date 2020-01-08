package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;

import dao.ShopDAO;
import vo.AdressBean;

public class Adress_Service {

	public boolean adress_Insert(AdressBean adressBean) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isInsertSuccess = false;
		
		int InsertCount = shopDAO.adress_Insert(adressBean);
		
		if(InsertCount>0) {
			commit(con);
			isInsertSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isInsertSuccess;
	}

	public boolean adress_Modify(AdressBean adressBean) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isModifySuccess = false;
		
		int updateCount = shopDAO.adress_Modify(adressBean);
		
		if(updateCount>0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}

	public boolean adress_Delete(AdressBean adressBean) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isDeleteSuccess = false;
		
		int deleteCount = shopDAO.adress_Delete(adressBean);
		
		if(deleteCount>0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isDeleteSuccess;
	}

}
