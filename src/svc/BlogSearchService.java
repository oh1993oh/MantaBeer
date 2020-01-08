package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.Closeable;

import dao.BlogDAO;
import vo.BlogBean;

public class BlogSearchService {

//	public ArrayList<Search> getBlogSearchList(int startPage, int endPage,String search) {
	public int getListCount(String search) {
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
		int listCount = blogDAO.selectListCount(search);
		
		System.out.println("search에 해당하는 게시물 총 갯수 : " + listCount);
		close(con);
		
		return listCount;
	}
	
	
	public ArrayList<BlogBean> getBlogSearchList(int startPage, int endPage,String search) {
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
//		ArrayList<Search> searchList = null;
//		searchList = blogDAO.selectSearchList(startPage,endPage,search);
		
		ArrayList<BlogBean> searchList = null;
//		searchList = blogDAO.selectSearchList(startPage,endPage,search);
		searchList = blogDAO.selectArticleList(startPage,endPage,search);
				close(con);
				
		return searchList;
	}
	
	public ArrayList<BlogBean> getArticleList(int limit) {
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
		ArrayList<BlogBean> articleListRe = null;
		articleListRe = blogDAO.selectArticleList(limit);
		
		close(con);
		return articleListRe;
	}
	
	

}
