package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class jdbcUtil {

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext(); // 톰캣으로부터 컨텍스트 객체 가져오기
			Context envCtx = (Context) initCtx.lookup("java:comp/env"); // context.xml 파일의 Resource 정의 컨텍스트 가져오기
			DataSource ds = (DataSource) envCtx.lookup("jdbc/MySQL"); // DataSource 객체 가져오기
			con = ds.getConnection(); // DataSource 객체로부터 저장되어 있는 Connection 객체 가져오기
			con.setAutoCommit(false); // 트랜잭션에 대한 자동 커밋(적용) 기능 해제(기본값은 true)
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return con;
	}
	
<<<<<<< HEAD
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("Commit success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("Rollback success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
=======
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("Commit success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("Rollback success!");
		} catch (SQLException e) {
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
			e.printStackTrace();
		}
	}
}
