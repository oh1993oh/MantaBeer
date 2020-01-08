package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.BeerBean;

import static db.jdbcUtil.*;

public class BeerDAO {
	Connection con;

	private BeerDAO() {
	};

	private static BeerDAO instance;

	public static BeerDAO getInstence() {

		if (instance == null) {
			instance = new BeerDAO();
		}

		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public BeerBean selectBeer(int product_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BeerBean article = null;
		
		try {
			String sql = "select * from beer where product_product_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BeerBean();
				article.setBeer_bitter(rs.getInt("beer_bitter"));
				article.setBeer_body(rs.getInt("beer_body"));
				article.setBeer_flavor(rs.getInt("beer_flavor"));
				article.setBeer_Refreshing(rs.getInt("beer_Refreshing"));
				article.setBeer_sweetness(rs.getInt("beer_sweetness"));
				article.setBeer_Thirsty(rs.getInt("beer_Thirsty"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return article;
	}
	
	
	
	
	
	
}
