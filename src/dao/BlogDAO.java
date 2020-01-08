package dao;

<<<<<<< HEAD
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BlogBean;

import static db.jdbcUtil.*;

public class BlogDAO {
	
	private BlogDAO() {}
	
	private static BlogDAO instance;

	public static BlogDAO getInstance() {
		if(instance == null) {
			instance = new BlogDAO();
		}
		
		return instance;
	}
	// -------------------------------------------------------------------------------

	Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertArticle(BlogBean blogBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		int num = 0;
		int insertCount = 0;
		
		try {
			String sql = "SELECT MAX(blog_num) FROM blog"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				num = rs.getInt(1) + 1; 
			} else {
				num = 1; 
			}
			
			sql = "INSERT INTO blog VALUES(?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, blogBean.getBlog_pass());
			pstmt.setString(3, blogBean.getBlog_subject());
			pstmt.setString(4, blogBean.getBlog_content());
			pstmt.setString(5, blogBean.getBlog_file());
			pstmt.setInt(6, blogBean.getReadcount());
			
			insertCount = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("insertArticle() 에서 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}
	public int deleteArticle(int blog_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from blog where blog_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, blog_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return deleteCount;
	}
	
	public int updateArticle(BlogBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update blog set blog_subject=?,blog_content=?,blog_file=? where blog_num=?  ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBlog_subject());
			pstmt.setString(2, article.getBlog_content());
			pstmt.setString(3, article.getBlog_file());
			pstmt.setInt(4, article.getBlog_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateArticle()에서 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	public boolean isBlogArticleWriter(int blog_num, String blog_pass) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			boolean isArticleWriter = false;
			
			String sql = "select blog_pass from blog where blog_num = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, blog_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(blog_pass.equals(rs.getString("blog_pass"))) {
						isArticleWriter=true;
					} 
			}	
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return isArticleWriter;
		}
	
	public BlogBean selectArticle(int blog_num) {		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BlogBean article = null;
		try {
			
			String sql = "select * from blog where blog_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,blog_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BlogBean();
				article.setBlog_num(rs.getInt("blog_num"));
				article.setBlog_subject(rs.getString("blog_subject"));
				article.setBlog_content(rs.getString("blog_content"));
				article.setBlog_date(rs.getDate("blog_date"));
				article.setBlog_file(rs.getString("blog_file"));
				article.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
=======
//import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BlogBean;

import static db.jdbcUtil.*;

public class BlogDAO {
	
	private BlogDAO() {}
	
	private static BlogDAO instance;

	public static BlogDAO getInstance() {
		if(instance == null) {
			instance = new BlogDAO();
		}
		
		return instance;
	}
	// -------------------------------------------------------------------------------

	Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertArticle(BlogBean blogBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		int num = 0;
		int insertCount = 0;
		
		try {
			String sql = "SELECT MAX(blog_num) FROM blog"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				num = rs.getInt(1) + 1; 
			} else {
				num = 1; 
			}
			
			sql = "INSERT INTO blog VALUES(?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, blogBean.getBlog_pass());
			pstmt.setString(3, blogBean.getBlog_subject());
			pstmt.setString(4, blogBean.getBlog_content());
			pstmt.setString(5, blogBean.getBlog_file());
			pstmt.setInt(6, blogBean.getReadcount());
			
			insertCount = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("insertArticle() 에서 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}
	public int deleteArticle(int blog_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from blog where blog_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, blog_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return deleteCount;
	}
	
	public int updateArticle(BlogBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update blog set blog_subject=?,blog_content=?,blog_file=? where blog_num=?  ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBlog_subject());
			pstmt.setString(2, article.getBlog_content());
			pstmt.setString(3, article.getBlog_file());
			pstmt.setInt(4, article.getBlog_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateArticle()에서 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	public boolean isBlogArticleWriter(int blog_num, String blog_pass) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			boolean isArticleWriter = false;
			
			String sql = "select blog_pass from blog where blog_num = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, blog_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(blog_pass.equals(rs.getString("blog_pass"))) {
						isArticleWriter=true;
					} 
			}	
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return isArticleWriter;
		}
	
	public BlogBean selectArticle(int blog_num) {		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BlogBean article = null;
		try {
			
			String sql = "select * from blog where blog_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,blog_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BlogBean();
				article.setBlog_num(rs.getInt("blog_num"));
				article.setBlog_subject(rs.getString("blog_subject"));
				article.setBlog_content(rs.getString("blog_content"));
				article.setBlog_date(rs.getDate("blog_date"));
				article.setBlog_file(rs.getString("blog_file"));
				article.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs); // if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			close(pstmt); //if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
		}
		return article;
	}
	public int selectListCount(String search) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from blog where blog_subject like ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+search+'%');
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문에서 오류 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
		public int updateReadcount(int blog_num) {
		// board_num 에 해당하는 게시물 조회수(readcount) 1 증가
		
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "update blog set readcount=readcount+1 where blog_num = ?";	// ?를 빼고 +board_num으로 바로 해도됨!!
		
		try {
			// 조회수를 증가시킬 게시물 번호를 SQL 구문 작성 시 바로 결합해도 되고 하던대로 해도됨!!(2가지 방법)
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, blog_num);	// 이 문장을 빼고
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReadcount() 에서 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int selectListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from blog";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문에서 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
			
	}
	public ArrayList<BlogBean> selectArticleList(int page, int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BlogBean> articleList = new ArrayList<BlogBean>();
		
		
		int startRow = (page-1)*3;
		try {
		String sql = "SELECT * FROM blog order by blog_num desc LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2,limit);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			BlogBean blogBean = new BlogBean();
			blogBean.setBlog_num(rs.getInt("blog_num"));
			blogBean.setBlog_subject(rs.getString("blog_subject"));
			blogBean.setBlog_content(rs.getString("blog_content"));
			blogBean.setBlog_file(rs.getString("blog_file"));
			blogBean.setReadcount(rs.getInt("readcount"));
			blogBean.setBlog_date(rs.getDate("blog_date"));
			
			articleList.add(blogBean);
		}
		
		} catch(SQLException e) {
		System.out.println("selectArticleList() 에서 오류 : " + e.getMessage());
		} finally {
		close(rs);
		close(pstmt);
		}
		return articleList;
		
	
	}
	
	
	public ArrayList<BlogBean> selectArticleList(int page, int limit,String search){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BlogBean> articleList = new ArrayList<BlogBean>();
		
		
		int startRow = (page-1)*3;
		try {
		String sql = "SELECT * FROM blog where blog_subject like ? order by blog_num desc LIMIT ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, '%'+search+'%');
		pstmt.setInt(2, startRow);
		pstmt.setInt(3,limit);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			BlogBean blogBean = new BlogBean();
			blogBean.setBlog_num(rs.getInt("blog_num"));
			blogBean.setBlog_subject(rs.getString("blog_subject"));
			blogBean.setBlog_content(rs.getString("blog_content"));
			blogBean.setBlog_file(rs.getString("blog_file"));
			blogBean.setReadcount(rs.getInt("readcount"));
			blogBean.setBlog_date(rs.getDate("blog_date"));
			
			articleList.add(blogBean);
		}
		
		} catch(SQLException e) {
		System.out.println("selectArticleList() 에서 오류 : " + e.getMessage());
		} finally {
		close(rs);
		close(pstmt);
		}
		return articleList;
		
	}

	public ArrayList<BlogBean> selectArticleList(int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BlogBean> articleList = new ArrayList<BlogBean>();
		
		
//		int startRow = (page-1)*10;
		try {
		String sql = "SELECT * FROM blog order by blog_num desc LIMIT ?";
		pstmt = con.prepareStatement(sql);
//		pstmt.setInt(1, startRow);
		pstmt.setInt(1,limit);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			BlogBean blogBean = new BlogBean();
			blogBean.setBlog_num(rs.getInt("blog_num"));
			blogBean.setBlog_subject(rs.getString("blog_subject"));
			blogBean.setBlog_content(rs.getString("blog_content"));
			blogBean.setBlog_file(rs.getString("blog_file"));
			blogBean.setReadcount(rs.getInt("readcount"));
			blogBean.setBlog_date(rs.getDate("blog_date"));
			
			articleList.add(blogBean);
		}
		
		} catch(SQLException e) {
		System.out.println("selectArticleList() 에서 오류 : " + e.getMessage());
		} finally {
		close(rs);
		close(pstmt);
		}
		return articleList;
	}
	
	


	
}
