package dao;

import static db.jdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BlogBean;
import vo.CommentBean;

public class CommentDAO {
	
	private CommentDAO() {}
	
	private static CommentDAO instance;

	public static CommentDAO getInstance() {
		if(instance == null) {
			instance = new CommentDAO();
		}
		
		return instance;
	}
	
	Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	
	public CommentBean selectComment(int blog_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentBean article = null;
		try {
			con = getConnection();
			
			String sql = "select * from blog_comment where comment_blog_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,blog_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new CommentBean();
				article.setComment_num(rs.getInt("comment_num"));
				article.setComment_name(rs.getString("comment_name"));
				article.setComment_content(rs.getString("comment_content"));
				article.setComment_date(rs.getTimestamp("comment_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
		}
		return article;
	}
	
	public ArrayList<CommentBean> selectArticleList(int blog_num){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<CommentBean> articleList = new ArrayList<CommentBean>();
		
		
		
		try {
		String sql = "SELECT * FROM blog_comment where comment_blog_num=? order by comment_date desc";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, blog_num);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			CommentBean commentBean = new CommentBean();
			commentBean.setComment_num(rs.getInt("comment_num"));
			commentBean.setComment_name(rs.getString("comment_name"));
			commentBean.setComment_content(rs.getString("comment_content"));
			commentBean.setComment_date(rs.getTimestamp("comment_date"));
			
			articleList.add(commentBean);
		}
		
		} catch(SQLException e) {
		System.out.println("selectArticleList() 에서 오류 : " + e.getMessage());
		} finally {
		close(rs);
		close(pstmt);
		}
		return articleList;
		
	
	}

	public int insertArticle(int blog_num, String user_id, CommentBean commentBean) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		int insertCount = 0;
		try {
			String sql = "select MAX(comment_num) FROM blog_comment"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				num = rs.getInt(1) + 1; 
			} else {
				num = 1; 
			}
			
			sql = "insert into blog_comment(comment_num,comment_content,comment_re_ref,comment_re_lev,comment_re_seq,comment_name,comment_date,comment_blog_num) values(?,?,?,?,?,?,sysdate(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, commentBean.getComment_content());
			pstmt.setInt(3, commentBean.getComment_re_ref());
			pstmt.setInt(4, commentBean.getComment_re_lev());
			pstmt.setInt(5, commentBean.getComment_re_seq());
//			pstmt.setString(6, commentBean.getComment_name());
			pstmt.setString(6, user_id);
			pstmt.setInt(7, commentBean.getComment_blog_num());
			insertCount = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("insertArticle() 에서 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}


	public int deleteComment(int comment_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from blog_comment where comment_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comment_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	public int updateComment(CommentBean comment) {
		PreparedStatement pstmt=null;
		int updateCount =0;
		String sql="";
		
		try {
			sql="update blog_comment set comment_content=? where comment_num=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, comment.getComment_content());
			pstmt.setInt(2, comment.getComment_num());
			updateCount=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateComment()오류"+e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}




	public CommentBean selectArticle(int comment_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentBean comment = null;
		try {
			con = getConnection();
			
			String sql = "select * from blog_comment where comment_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,comment_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				comment= new CommentBean();
				comment.setComment_num(rs.getInt("comment_num"));
				comment.setComment_name(rs.getString("comment_name"));
				comment.setComment_content(rs.getString("comment_content"));
			}
		} catch (Exception e) {
			System.out.println("selectArticle()오류"+e.getMessage());
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
		}
		return comment;	
		
	}
//	public boolean deleteComment(int comment_num) {
//		boolean result = false;
//		PreparedStatement pstmt = null;
//		int deleteCount = 0;
//		
//		try {
//			Connection con = getConnection();
//			con.setAutoCommit(false);
//			String sql = "delete from blog_comment where comment_num=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, comment_num);
//			deleteCount = pstmt.executeUpdate();
//			if(deleteCount>0) {
//				result=true;
//				con.commit();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
////		return deleteCount;
//	}
	
}
