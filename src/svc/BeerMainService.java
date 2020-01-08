package svc;

<<<<<<< HEAD
import static db.jdbcUtil.close;
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
		
		
		
=======
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
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
		
		close(con);
		return articleList;
	}

}
