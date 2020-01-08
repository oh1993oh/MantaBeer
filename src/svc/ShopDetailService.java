package svc;

import java.sql.Connection;

import dao.BeerDAO;
import dao.ShopDAO;

import static db.jdbcUtil.*;

import vo.BeerBean;
import vo.ShopBean;

public class ShopDetailService {

	public ShopBean getArticle(int product_num) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		System.out.println("ShopDetailService--getArticle");

		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		ShopBean shopBean = shopDAO.selectProduct(product_num);

		close(con);
		return shopBean;
	}

	public BeerBean getBeerArticle(int product_num) {
		
		System.out.println("ShopDetailService--getBeerArticle");
=======
		System.out.println("ShopDetailService - getArticle");

		Connection con = getConnection();
		ShopDAO shopDAO = ShopDAO.getInstence();
		shopDAO.setConnection(con);

		ShopBean shopBean = shopDAO.selectProduct(product_num);

		close(con);
		return shopBean;
	}

	public BeerBean getBeerArticle(int product_num) {
		
		System.out.println("ShopDetailService - getBeerArticle");
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git

		Connection con = getConnection();
		BeerDAO beerDAO = BeerDAO.getInstence();
		beerDAO.setConnection(con);

		BeerBean beerBean = beerDAO.selectBeer(product_num);

		close(con);
		return beerBean;
	}

}
