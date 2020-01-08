package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;

import static db.jdbcUtil.*;
import vo.ReViewBean;

public class ReviewListService {

	public ArrayList<ReViewBean> getReviewList(int board_num) {
		System.out.println("ReviewListService--getReviewList");
		
		Connection con = getConnection();
		
		ShopDAO dao = ShopDAO.getInstence();
		dao.setConnection(con);
		
		ArrayList<ReViewBean> reviewList = dao.getReviewList(board_num);
		
		close(con);
		return reviewList;
	}
	
}
