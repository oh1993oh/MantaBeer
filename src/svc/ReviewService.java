package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.ReViewBean;

public class ReviewService {

	public boolean review_delete(int review_num) {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isDeleteSuccess = false;
		
		int deleteCount = shopDAO.review_delete(review_num);
		
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}

	public boolean review_update(ReViewBean reViewBean) {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int deleteCount = shopDAO.review_update(reViewBean);
		
		
		if(deleteCount > 0) {
			commit(con);
			isUpdateSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isUpdateSuccess;
	}

	public ReViewBean getReview(int review_num) {
		Connection con = getConnection();
		
		ShopDAO dao = ShopDAO.getInstence();
		dao.setConnection(con);
		
		ReViewBean reviewBean = dao.getReview(review_num);
		
		close(con);
		return reviewBean;
	}

}
