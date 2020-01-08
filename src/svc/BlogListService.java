package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BlogDAO;
import vo.BlogBean;

import static db.jdbcUtil.*;


public class BlogListService {

	public int getListCount() {
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
		int listCount = blogDAO.selectListCount();
		
		System.out.println("게시물 총 갯수 : " + listCount);
		close(con);
		
		return listCount;
	}

	public ArrayList<BlogBean> getArticleList(int page, int limit) {
		Connection con = getConnection();
		BlogDAO blogDAO = BlogDAO.getInstance();
		blogDAO.setConnection(con);
		
		ArrayList<BlogBean> articleList = null;
		articleList = blogDAO.selectArticleList(page,limit);
		
		close(con);
		return articleList;
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
	
//	public int getCount(int blog_num) {
//		Connection con = getConnection();
//		BlogDAO blogDAO = BlogDAO.getInstance();
//		blogDAO.setConnection(con);
//		
//		int listCount = blogDAO.selectListCount(blog_num);
//		
//		System.out.println("댓글 총 갯수 : " + listCount);
//		close(con);
//		
//		return listCount;
//	}
//	
	
}	
