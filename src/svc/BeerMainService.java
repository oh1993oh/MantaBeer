package svc;


import static db.jdbcUtil.*;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.ShopBean;

public class BeerMainService {

	public ArrayList<ShopBean> getBestList() {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		ArrayList<ShopBean> articleList = null;
		articleList = shopDAO.selectBestList();
		
		close(con);
		return articleList;
	}

	public ArrayList<ShopBean> getSaleList() {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		ArrayList<ShopBean> articleList = null;
		
		articleList = shopDAO.selectSaleList();
		
		close(con);
		return articleList;
	}

	public ArrayList<ShopBean> getNewList() {
		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);
		
		ArrayList<ShopBean> articleList = null;
		
		articleList = shopDAO.selectNewList();
		
		close(con);
		return articleList;
	}

}
