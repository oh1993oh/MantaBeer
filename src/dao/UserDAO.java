package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.AdressBean;
import vo.ReservationBean;
import vo.TradeBean;
import vo.UserBean;

import static db.jdbcUtil.*;

public class UserDAO {

	private UserDAO() {

	}

	private static UserDAO instance = new UserDAO();
	private Connection con = null;

	public static UserDAO getInstance() {

		return instance;
	}

	public void setConnection(Connection con) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		this.con = con;

	}

	public int selectUserLogin(String id, String pass) {
		// TODO Auto-generated method stub

		int loginResult = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT user_pass FROM user WHERE user_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (pass.equals(rs.getString(1))) {
					loginResult = 1;
				} else {
					loginResult = -1;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUserLogin sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginResult;
	}

	public int insertUser(UserBean user) {
		// TODO Auto-generated method stub

		int insertCount = 0;

		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		String sql = "INSERT INTO user(user_id,user_pass,user_name,user_type,user_email,user_number) VALUES(?,?,?,?,?,?)";

		try {

			pstmt = con.prepareStatement(sql);
			System.out.println(user.getUser_email()+"!!!");
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pass());
			pstmt.setString(3, user.getUser_name());
			// pstmt.setString(4, user.getUser_type());
			pstmt.setString(4, "");
			pstmt.setString(5, user.getUser_email());
			pstmt.setString(6, user.getUser_number());
			// pstmt.setString(6, "");
			// User_per 삭제 후 , user_number 로 테이블 수정 후 회원 연락처를 저장 후 사용.

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public UserBean getUser(String sid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean user = null;
		System.out.println(sid);

		try {
			String sql = "SELECT * FROM user WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("hello!");
				user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_type(rs.getString("user_type"));
				user.setUser_number(rs.getString("user_number"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return user;

	}

	public UserBean selectArticle(int user_num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserBean Userbean = null;

		try {
			String sql = "SELECT * FROM user WHERE user_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();

			// 게시물이 존재할 경우 BoardBean 객체에 모든 데이터 저장
			if (rs.next()) {
				Userbean = new UserBean();
				Userbean.setUser_num(rs.getInt("user_num"));
				Userbean.setUser_id(rs.getString("user_id"));
				Userbean.setUser_pass(rs.getString("user_pass"));
				Userbean.setUser_name(rs.getString("user_name"));
				Userbean.setUser_email(rs.getString("user_email"));
				Userbean.setUser_type(rs.getString("user_type"));
				Userbean.setUser_number(rs.getString("user_number"));
			}

		} catch (SQLException e) {
			System.out.println("selectArticle() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return Userbean;

	}

	public int updateUser(UserBean user) {
		// TODO Auto-generated method stub
		int sujeng = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE USER SET user_name=?, user_email=?,user_number=? WHERE user_pass=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_email());
			pstmt.setString(3, user.getUser_number());
			pstmt.setString(4, user.getUser_pass());
			System.out
					.println(user.getUser_name() + user.getUser_email() + user.getUser_number() + user.getUser_pass());
			sujeng = pstmt.executeUpdate();

			System.out.println(sujeng);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return sujeng;
	}

	public int deleteUser(UserBean user) {
		// TODO Auto-generated method stub

		int goodbye = 0;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM user WHERE user_id=?;";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			goodbye = pstmt.executeUpdate();

			System.out.println("탈퇴 완료 ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);

		}

		return goodbye;
	}

	public int idCheck(String user_id) {
		
		System.out.println(user_id);
		int idcheck = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			// 1단계 드라이버 불러오기// 2단계 디비연결 jspdb1 jspid jsppass
			// 3단계 - 연결정보를 이용해서 sql구문을 만들고 실행할 객체생성 select
//		       디비에 id정보가 있는지 조회(가져오기)
			String sql = "select * from user where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			// 4단계 - 만든 객체 실행 select => 결과 저장 내장객체
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 아이디있음
				idcheck = 1;
			} else {
				idcheck = 0;// 아이디없음
			}
		} catch (Exception e) {
			System.out.println("UserDAO - idCheck 오류"+e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return idcheck;
	}

	public int delusercheck(UserBean user) {
		// TODO Auto-generated method stub
		int check = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user where user_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_pass());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 아이디있음
				if (user.getUser_pass().equals(rs.getString("user_pass"))) {
					check = 1;// 비밀번호 맞음
				} else {
					check = 0;// 비밀번호틀림
				}
			} else {
				check = -1;// 아이디없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 마무리
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return check;
	}

	// MVC 패턴 회원 목록 조회(☆ 관리자 페이지)
	public ArrayList<UserBean> selectUserList() {
		// TODO Auto-generated method stub

		ArrayList<UserBean> userlist = new ArrayList<UserBean>();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM USER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new UserBean();
					mb.setUser_id(rs.getString("user_id"));
					mb.setUser_pass(rs.getString("user_pass"));
					mb.setUser_name(rs.getString("user_name"));
					mb.setUser_type(rs.getString("user_type"));
					mb.setUser_email(rs.getString("user_email"));
					mb.setUser_number(rs.getString("user_number"));
					userlist.add(mb);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("※ selectUserList 오류발생 내용=" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return userlist;
	}

// MVC 패턴 회원 상세 내용 조회(☆ 관리자 페이지)
	public UserBean selectUser(String id) {
		// TODO Auto-generated method stub

		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from USER where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new UserBean();
				mb.setUser_id(rs.getString("user_id"));
				mb.setUser_pass(rs.getString("user_pass"));
				mb.setUser_name(rs.getString("user_name"));
				mb.setUser_type(rs.getString("user_type"));
				mb.setUser_email(rs.getString("user_email"));
				mb.setUser_number(rs.getString("user_number"));
			}
		} catch (Exception ex) {
			System.out.println("※ selectUserListView 오류발생 내용=" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return mb;
	}

//MVC 패턴 회원 목록 및 데이터 삭제 하기 (☆ 관리자 페이지)
	public int deleteListUser(String delete_id) {
		// TODO Auto-generated method stub

		int deleteCount = 0;
		PreparedStatement pstmt = null;

		try {
			// (이 구역에서는 필요 없음) con=getConnection();
			String sql = "DELETE FROM USER WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delete_id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("deleteListUser 오류발생 =  " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

// 회원 검색 기능 - 상세 조회 기능( ★ 관리자 페이지 전용 )
	public List getUser_search(String name) {
		// TODO Auto-generated method stub

		List userList = new ArrayList();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from USER where user_name=? or user_id=? or user_number=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				mb = new UserBean();
				mb.setUser_id(rs.getString("user_id"));
				mb.setUser_pass(rs.getString("user_pass"));
				mb.setUser_name(rs.getString("user_name"));
				mb.setUser_type(rs.getString("user_type"));
				mb.setUser_email(rs.getString("user_email"));
				mb.setUser_number(rs.getString("user_number"));
				userList.add(mb);

			}
		} catch (Exception ex) {
			System.out.println("※ getUser_search 오류발생 내용=" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return userList;
	}

	public UserBean SearchUser() {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM USER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new UserBean();
					mb.setUser_id(rs.getString("user_id"));
					mb.setUser_pass(rs.getString("user_pass"));
					mb.setUser_name(rs.getString("user_name"));
					mb.setUser_type(rs.getString("user_type"));
					mb.setUser_email(rs.getString("user_email"));
					mb.setUser_number(rs.getString("user_number"));
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("※  SearchUser 오류발생 내용=" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
	
	public ArrayList<TradeBean> getdepositList() {
		// TODO Auto-generated method stub
		
		ArrayList<TradeBean> depositList=new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql= "SELECT a.trade_classification, b.user_name, a.product_name,a.trade_quantity,a.trade_date,a.trade_state , a.trade_num ,"
						+ " a.product_price,sum(a.trade_quantity * a.product_price),CONCAT(c.adress_adress, ' ' ,c.adress_details) "
						+ " FROM trade a, user b, adress c"
						+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num and trade_state=?"
						+ " group by a.trade_classification";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "deposit_completed");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
					tb=new TradeBean();
					tb.setTrade_num(rs.getInt("a.trade_num"));
					tb.setTrade_classification(rs.getInt("trade_classification"));
					tb.setUser_name(rs.getString("b.user_name"));
					tb.setProduct_name(rs.getString("product_name"));
					tb.setTrade_quantity(rs.getInt("trade_quantity"));
					tb.setProduct_price(rs.getInt("product_price"));
				    tb.setTotalprice(rs.getInt("sum(a.trade_quantity * a.product_price)"));
				    tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				    tb.setTrade_state(rs.getString("a.trade_state"));
				    tb.setTrade_date(rs.getDate("trade_date"));
				    depositList.add(tb);
			}
		}catch(Exception ex){
			System.out.println("※ getdepositList 오류발생 내용=" + ex);	
		}finally{
			close(rs);
			close(pstmt);
		}
		return depositList;
	}

	public ArrayList<TradeBean> getdepositdetailList(int trade_classification) {
		
		ArrayList<TradeBean> depositdetailList=new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql= "SELECT a.trade_classification,a.trade_num , b.user_name, a.product_name,a.trade_quantity,a.trade_date,a.trade_state , "
						+ " a.product_price, a.trade_quantity * a.product_price ,CONCAT(c.adress_adress, ' ' ,c.adress_details) "
						+ " FROM trade a, user b, adress c"
						+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num  and a.trade_classification=?";

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, trade_classification);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
					tb=new TradeBean();
					tb.setTrade_num(rs.getInt("a.trade_num"));
					tb.setTrade_classification(rs.getInt("trade_classification"));
					tb.setUser_name(rs.getString("b.user_name"));
					tb.setProduct_name(rs.getString("product_name"));
					tb.setTrade_quantity(rs.getInt("trade_quantity"));
					tb.setTrade_date(rs.getDate("trade_date"));
					tb.setTrade_state(rs.getString("a.trade_state"));
					tb.setProduct_price(rs.getInt("product_price"));
				    tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				    tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				    depositdetailList.add(tb);
			}
		}catch(Exception ex){
			System.out.println("※ getdepositdetailList 오류발생 내용=" + ex);	
		}finally{
			close(rs);
			close(pstmt);
		}
		return depositdetailList;
	}
	
	public ArrayList<TradeBean> usergetdepositList(String user_id) {
		ArrayList<TradeBean> userdepositList=new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql ="select a.user_name, b.user_user_num"
					  + " from user a, trade b "
					  + " where b.user_user_num = a. user_num and user_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			System.out.println("1");
			while(rs.next()){
				tb=new TradeBean();
				tb.setUser_name(rs.getString("user_name"));
				tb.setUser_user_num(rs.getInt("user_user_num"));
			}
			System.out.println("User_num :" + tb.getUser_user_num());
			
			 sql=   "	SELECT a.trade_classification, b.user_name, a.trade_num ,a.product_name,a.trade_quantity, a.product_price, a.trade_quantity * a.product_price, CONCAT(c.adress_adress, ' ' ,c.adress_details),a.trade_date,a.trade_state "
						+ " FROM trade a, user b, adress c"
						+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num and trade_state in(?,'delivery_completed','deal_completed') and a.user_user_num =? " 
						+ " group by a.trade_classification";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "deposit_completed");
			pstmt.setInt(2, tb.getUser_user_num());
			rs=pstmt.executeQuery();
			System.out.println("hi!!!!!");
			while(rs.next()){
				System.out.println("hello!");
					tb=new TradeBean();
					tb.setTrade_num(rs.getInt("a.trade_num"));
					tb.setTrade_classification(rs.getInt("trade_classification"));
					tb.setUser_name(rs.getString("b.user_name"));
					tb.setProduct_name(rs.getString("product_name"));
					tb.setTrade_quantity(rs.getInt("trade_quantity"));
					tb.setProduct_price(rs.getInt("product_price"));
					tb.setTrade_state(rs.getString("a.trade_state"));
				    tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				    tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				    tb.setTrade_date(rs.getDate("trade_date"));
				    userdepositList.add(tb);
			}
		}catch(Exception ex){
			System.out.println("※ getdepositList 오류발생 내용=" + ex);	
		}finally{
			close(rs);
			close(pstmt);
		}
		return userdepositList;
	}
	//사용자용
	public ArrayList<TradeBean> usergetdepositdetailList(int trade_classification,String user_id) {
		
		ArrayList<TradeBean> userdepositdetailList=new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql ="select a.user_name, b.user_user_num"
					  + " from user a, trade b "
					  + " where b.user_user_num = a. user_num and user_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			System.out.println("1");
			while(rs.next()){
				tb=new TradeBean();
				tb.setUser_name(rs.getString("user_name"));
				tb.setUser_user_num(rs.getInt("user_user_num"));
			}
			System.out.println("User_num :" + tb.getUser_user_num());
			
			
			sql= "SELECT a.trade_classification, b.user_name,a.trade_num , a.product_name,a.trade_quantity,a.trade_date,a.trade_state ,a.trade_sale, "
						+ " a.product_price, a.trade_quantity * a.product_price ,CONCAT(c.adress_adress, ' ' ,c.adress_details) "
						+ " FROM trade a, user b, adress c"
						+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num  and a.trade_classification=? and a.user_user_num=?";

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, trade_classification);
			pstmt.setInt(2, tb.getUser_user_num());
			rs=pstmt.executeQuery();
			
			while(rs.next()){
					tb=new TradeBean();
					tb.setTrade_num(rs.getInt("a.trade_num"));
					tb.setTrade_classification(rs.getInt("trade_classification"));
					tb.setUser_name(rs.getString("b.user_name"));
					tb.setProduct_name(rs.getString("product_name"));
					tb.setTrade_quantity(rs.getInt("trade_quantity"));
					tb.setTrade_date(rs.getDate("trade_date"));
					tb.setTrade_sale(rs.getInt("a.trade_sale"));
					tb.setTrade_state(rs.getString("a.trade_state"));
					tb.setProduct_price(rs.getInt("product_price"));
				    tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				    tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				    userdepositdetailList.add(tb);
			}
		}catch(Exception ex){
			System.out.println("※ getdepositdetailList 오류발생 내용=" + ex);	
		}finally{
			close(rs);
			close(pstmt);
		}
		return userdepositdetailList;
	}

	
	//
	public JSONArray checkroom(ReservationBean rebean) {
		System.out.println("checkArticle진입");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray roomList = null;
		System.out.println(rebean.getReser_date());
		System.out.println(rebean.getReser_time());
		System.out.println("checkid : 쿼리문 전");
		try {
			String sql = "select a.reservation_room, b.reservation_maxroom - count(a.reservation_roomnum) \"InRoomCount\""
						+"from reservation a join reservation_maxroom b "
						+"on (a.reservation_room = b.reservation_roomid) "
						+"where reservation_date=? and reservation_time=? "
						+"group by reservation_room "
						+"having InRoomCount=0;";
			System.out.println("checkid : 쿼리문 후");		
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, rebean.getReser_date());
			pstmt.setString(2, rebean.getReser_time());
			rs = pstmt.executeQuery();
			roomList = new JSONArray();
			while(rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("roomcount", rs.getInt("InRoomCount"));
				jo.put("roomid", rs.getString("reservation_room"));
				roomList.add(jo);
			}
			System.out.println("roomList : " +roomList);
				
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("checkid  에러 "+e.getMessage());
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		
		

		return roomList;
	}
	//db에 방 입력
	public int insertArticles(ReservationBean rebean,String sid) {
		// Service 클래스로부터 BoardBean 객체를 전달받아 DB 에 INSERT 작업을 수행한 후 결과(int타입) 리턴
		System.out.println("insertArticles DAO 진입 :");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int user_num = 0;
		int num = 0;
		int insertCount = 0;
		System.out.println("insertArticles id : "+ sid);
		try {
			// 현재 게시물의 최대 번호를 조회하여 새로운 글번호를 결정(+1)
			String sql = "select a.user_num, max(b.reservation_num) maxNum " + 
					"from user a, reservation b " + 
					"where user_id = ?"; // 가장 큰 번호 조회
			
			pstmt = con.prepareStatement(sql);
			System.out.println("2");
			pstmt.setString(1, sid);
			System.out.println("1");
			rs = pstmt.executeQuery();
			System.out.println("0");
			
			if(rs.next()) { // 등록된 게시물이 하나라도 존재할 경우
				num = rs.getInt("maxNum") + 1; // 새 글 번호 = 현재 게시물 가장 큰 번호 + 1
				user_num = rs.getInt("user_num");
			} else { // 등록된 게시물이 하나도 없을 경우
				num = 1; // 새 글 번호 = 1
				user_num = rs.getInt("user_num");
			}
			System.out.println("user_num :" +user_num);
			
			// 전달받은 데이터를 사용하여 INSERT 작업 수행
			// => 마지막 필드인 board_date(게시물 작성일) 는 데이터베이스 now() 함수 사용하여 현재 시각 사용
			sql = "INSERT INTO reservation VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, rebean.getReservation_date());
			pstmt.setString(3, rebean.getReservation_time());
			pstmt.setString(4, rebean.getReservation_room());
			pstmt.setString(5, rebean.getReservation_notice());
			pstmt.setInt(6, rebean.getReservation_roomnum()+1);
			pstmt.setInt(7, user_num);
			
			
			
			
			insertCount = pstmt.executeUpdate(); // INSERT 실행 결과 값을 int형 변수로 저장
			
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("insertArticle-reservation() 오류 - " + e);
		} finally {
			close(rs);
			close(pstmt);
//			close(con); // 주의!! DAO 내에서 Connection 객체를 닫지 않도록 주의할 것!!!!
			// => Service 클래스에서 commit, rollback 여부를 결정한 후 Connection 에 접근해야하기 때문에
		}
		
		return insertCount;
	}
	public ArrayList<ReservationBean> selectReservation(String sid) {
		System.out.println("selectReservation DAO 진입");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationBean rebean = null;
		UserBean ub = null;
		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();
		System.out.println("selectReservation ID : " + sid);
		
		try {
			String sql = "select user_num,user_name from user where user_id=?";
						// 나중에 바꿀때  "select user_num,user_name from user where user_name=?" 바꾸면됨
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				ub = new UserBean();
				ub.setUser_num(rs.getInt("user_num"));
				
				System.out.println("user_num : " + ub.getUser_num());
			}
			
			sql = "select  a.user_name, b.reservation_num ,b.reservation_date , b.reservation_time , b.reservation_room , b.reservation_notice, "
					+ " b.reservation_roomnum,b.reservation_user_num "
					+ " from user a, reservation b "
					+ " where  a.user_num =b.reservation_user_num and b.reservation_user_num= ? ";
//			select  a.user_num, b.reservation_user_num,reservation_num ,b.reservation_date , reservation_time , reservation_room , reservation_notice 
//					from user a reservation b
//					where  a.user_num = b.reservation_user_num and b.reservation_user_num= ; 
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1,ub.getUser_num());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rebean = new ReservationBean();
				rebean.setReservation_user_num(rs.getInt("b.Reservation_user_num"));
				rebean.setReservation_num(rs.getInt("b.reservation_num"));
				rebean.setReservation_date(rs.getString("b.reservation_date"));
				rebean.setReservation_time(rs.getString("b.reservation_time"));
				rebean.setReservation_room(rs.getString("b.reservation_room"));
				rebean.setReservation_notice(rs.getString("b.reservation_notice"));
				rebean.setReservation_roomnum(rs.getInt("b.reservation_roomnum"));
				rebean.setReservation_user_num(rs.getInt("b.reservation_user_num"));
				reservationList.add(rebean);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectReservation 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		
		
		return reservationList;
	}
	//사용자용 삭제 메서드
	public int deleteReservation(int r_num) {
		
		PreparedStatement pstmt = null;
		
		int isOk =0;
		String sql = "DELETE FROM reservation  where reservation_num=?";
		try {
			
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			isOk = pstmt.executeUpdate();
			System.out.println("DAO : isOk :"+isOk);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deleteReservation 에러 : "+e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return isOk;
	}
	//관리자 조회 
	public ArrayList<ReservationBean> managerselectReservation() {
		System.out.println("managerselectReservation DAO진입");
		ArrayList<ReservationBean> managerreservationList = new ArrayList<ReservationBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationBean rebean = null;
		System.out.println("1");
		try {
			String sql = "select a.*,b.user_name "
					   + "from reservation a, user b "
					   + "where reservation_user_num = user_num ";
			System.out.println("2");
			pstmt = con.prepareStatement(sql);
			System.out.println("3");
			rs = pstmt.executeQuery();
			System.out.println("4");
			while(rs.next()) {
				System.out.println("5");
				rebean = new ReservationBean();
				rebean.setReservation_num(rs.getInt("reservation_num"));
				rebean.setReservation_date(rs.getString("reservation_date"));
				rebean.setReservation_time(rs.getString("reservation_time"));
				rebean.setReservation_room(rs.getString("reservation_room"));
				rebean.setReservation_notice(rs.getString("reservation_notice"));
				rebean.setReservation_user_num(rs.getInt("reservation_user_num"));
				rebean.setReservation_user_name(rs.getString("user_name"));
				managerreservationList.add(rebean);
				System.out.println("6");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("managerselectReservation 에러 : " +e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		
		return managerreservationList;
	}
	//관리자 예약 삭제
	public int managerdeleteReservation(int u_num, int r_num) {

		PreparedStatement pstmt = null;
		
		int isOk =0;
		try {
			String sql = "DELETE FROM reservation where reservation_num=? and reservation_user_num=?";
				
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, r_num);
				pstmt.setInt(2, u_num);
				isOk = pstmt.executeUpdate();
				System.out.println("DAO : isOk :"+isOk);
				
				System.out.println("DAO managerDelete : " + isOk);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("managerdeleteReservation 에러 : " +e.getMessage());
		}
		
		
		return isOk;
	}

	public int insertAdress(AdressBean adressBean) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;

		try {

			sql = "insert into adress values(null,?,?,?,?,?,?,?,'false')";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, adressBean.getAdress_user_num());
			pstmt.setString(2, adressBean.getAdress_adress());
			pstmt.setString(3, adressBean.getAdress_details());
			pstmt.setInt(4, 1);
			pstmt.setString(5, "기본배송지");
			pstmt.setInt(6, adressBean.getAdress_post_num());
			pstmt.setString(7, adressBean.getAdress_phone_num());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("adress_Insert 에러 :" + e);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int selectUser_num(String user_id) {
		int user_num = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM user WHERE user_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user_num = rs.getInt("user_num");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return user_num;
	}

	public ArrayList<TradeBean> selectRevenue() {
		ArrayList<TradeBean> revenue = new ArrayList<TradeBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT trade_quantity,trade_sale,product_price FROM trade WHERE trade_date LIKE '2019-12-%'";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TradeBean tbean = new TradeBean();
				tbean.setTrade_quantity(rs.getInt("trade_quantity"));
				tbean.setTrade_sale(rs.getInt("trade_sale"));
				tbean.setProduct_price(rs.getInt("product_price"));
				
				
				revenue.add(tbean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("revenue.size = "+revenue.size());
=======
		this.con = con;

	}

	public int selectUserLogin(String id, String pass) {

		int loginResult = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT user_id FROM user WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "SELECT user_pass FROM user WHERE user_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					if (pass.equals(rs.getString("user_pass"))) {
						loginResult = 1;
					} else {
						loginResult = -1;
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginResult;
	}

	public int insertUser(UserBean user) {

		int insertCount = 0;

		PreparedStatement pstmt = null;

		String sql = "INSERT INTO user(user_id,user_pass,user_name,user_type,user_email,user_number) VALUES(?,?,?,?,?,?)";

		try {

			pstmt = con.prepareStatement(sql);
			System.out.println(user.getUser_email() + "!!!");
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pass());
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, "");
			pstmt.setString(5, user.getUser_email());
			pstmt.setString(6, user.getUser_number());
			// User_per 삭제 후 , user_number 로 테이블 수정 후 회원 연락처를 저장 후 사용.

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public UserBean getUser(String sid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean user = null;
		System.out.println(sid);

		try {
			String sql = "SELECT * FROM user WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("hello!");
				user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_type(rs.getString("user_type"));
				user.setUser_number(rs.getString("user_number"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return user;

	}

	public UserBean selectArticle(int user_num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserBean Userbean = null;

		try {
			String sql = "SELECT * FROM user WHERE user_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();

			// 게시물이 존재할 경우 BoardBean 객체에 모든 데이터 저장
			if (rs.next()) {
				Userbean = new UserBean();
				Userbean.setUser_num(rs.getInt("user_num"));
				Userbean.setUser_id(rs.getString("user_id"));
				Userbean.setUser_pass(rs.getString("user_pass"));
				Userbean.setUser_name(rs.getString("user_name"));
				Userbean.setUser_email(rs.getString("user_email"));
				Userbean.setUser_type(rs.getString("user_type"));
				Userbean.setUser_number(rs.getString("user_number"));
			}

		} catch (SQLException e) {
			System.out.println("selectArticle() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return Userbean;

	}

	public int updateUser(UserBean user) {
		int sujeng = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE user SET user_name=?, user_email=?,user_number=? WHERE user_pass=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_email());
			pstmt.setString(3, user.getUser_number());
			pstmt.setString(4, user.getUser_pass());
			System.out
					.println(user.getUser_name() + user.getUser_email() + user.getUser_number() + user.getUser_pass());
			sujeng = pstmt.executeUpdate();

			System.out.println(sujeng);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return sujeng;
	}

	public int deleteUser(UserBean user) {

		int goodbye = 0;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM user WHERE user_id=?;";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			goodbye = pstmt.executeUpdate();

			System.out.println("탈퇴 완료 ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);

		}

		return goodbye;
	}

	public int idCheck(String user_id) {

		System.out.println(user_id);
		int idcheck = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1단계 드라이버 불러오기// 2단계 디비연결 jspdb1 jspid jsppass
			// 3단계 - 연결정보를 이용해서 sql구문을 만들고 실행할 객체생성 select
//		       디비에 id정보가 있는지 조회(가져오기)
			String sql = "select * from user where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			// 4단계 - 만든 객체 실행 select => 결과 저장 내장객체
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 아이디있음
				idcheck = 1;
			} else {
				idcheck = 0;// 아이디없음
			}
		} catch (Exception e) {
			System.out.println("UserDAO - idCheck 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return idcheck;
	}

	public int delusercheck(UserBean user) {
		int check = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user where user_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_pass());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 아이디있음
				if (user.getUser_pass().equals(rs.getString("user_pass"))) {
					check = 1;// 비밀번호 맞음
				} else {
					check = 0;// 비밀번호틀림
				}
			} else {
				check = -1;// 아이디없음
			}
		} catch (Exception e) {
			System.out.println("UserDAO - delusercheck 오류" + e.getMessage());
		} finally {
			// 마무리
			close(rs);
		}
		return check;
	}

	// MVC 패턴 회원 목록 조회(☆ 관리자 페이지)
	public ArrayList<UserBean> selectUserList() {

		ArrayList<UserBean> userlist = new ArrayList<UserBean>();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new UserBean();
					mb.setUser_id(rs.getString("user_id"));
					mb.setUser_pass(rs.getString("user_pass"));
					mb.setUser_name(rs.getString("user_name"));
					mb.setUser_type(rs.getString("user_type"));
					mb.setUser_email(rs.getString("user_email"));
					mb.setUser_number(rs.getString("user_number"));
					userlist.add(mb);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - selectUserList 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return userlist;
	}

// MVC 패턴 회원 상세 내용 조회(☆ 관리자 페이지)
	public UserBean selectUser(String id) {

		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new UserBean();
				mb.setUser_id(rs.getString("user_id"));
				mb.setUser_pass(rs.getString("user_pass"));
				mb.setUser_name(rs.getString("user_name"));
				mb.setUser_type(rs.getString("user_type"));
				mb.setUser_email(rs.getString("user_email"));
				mb.setUser_number(rs.getString("user_number"));
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - selectUser 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return mb;
	}

//MVC 패턴 회원 목록 및 데이터 삭제 하기 (☆ 관리자 페이지)
	public int deleteListUser(String delete_id) {

		int deleteCount = 0;
		PreparedStatement pstmt = null;

		try {
			// (이 구역에서는 필요 없음) con=getConnection();
			String sql = "DELETE FROM USER WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delete_id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("UserDAO - deleteListUser 오류" + ex.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

// 회원 검색 기능 - 상세 조회 기능( ★ 관리자 페이지 전용 )
	public List getUser_search(String name) {

		List userList = new ArrayList();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user where user_name=? or user_id=? or user_number=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				mb = new UserBean();
				mb.setUser_id(rs.getString("user_id"));
				mb.setUser_pass(rs.getString("user_pass"));
				mb.setUser_name(rs.getString("user_name"));
				mb.setUser_type(rs.getString("user_type"));
				mb.setUser_email(rs.getString("user_email"));
				mb.setUser_number(rs.getString("user_number"));
				userList.add(mb);

			}
		} catch (Exception ex) {
			System.out.println("UserDAO - getUser_search 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return userList;
	}

	public UserBean SearchUser() {
		UserBean user = new UserBean();
		UserBean mb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new UserBean();
					mb.setUser_id(rs.getString("user_id"));
					mb.setUser_pass(rs.getString("user_pass"));
					mb.setUser_name(rs.getString("user_name"));
					mb.setUser_type(rs.getString("user_type"));
					mb.setUser_email(rs.getString("user_email"));
					mb.setUser_number(rs.getString("user_number"));
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - SearchUser 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}

	public ArrayList<TradeBean> getdepositList() {

		ArrayList<TradeBean> depositList = new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT a.trade_classification, b.user_name, a.product_name,a.trade_quantity,a.trade_date,a.trade_state , a.trade_num ,"
					+ " a.product_price,sum(a.trade_quantity * a.product_price),CONCAT(c.adress_adress, ' ' ,c.adress_details) "
					+ " FROM trade a, user b, adress c"
					+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num and trade_state=?"
					+ " group by a.trade_classification";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "deposit_completed");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tb = new TradeBean();
				tb.setTrade_num(rs.getInt("a.trade_num"));
				tb.setTrade_classification(rs.getInt("trade_classification"));
				tb.setUser_name(rs.getString("b.user_name"));
				tb.setProduct_name(rs.getString("product_name"));
				tb.setTrade_quantity(rs.getInt("trade_quantity"));
				tb.setProduct_price(rs.getInt("product_price"));
				tb.setTotalprice(rs.getInt("sum(a.trade_quantity * a.product_price)"));
				tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				tb.setTrade_state(rs.getString("a.trade_state"));
				tb.setTrade_date(rs.getDate("trade_date"));
				depositList.add(tb);
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - getdepositList 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return depositList;
	}

	public ArrayList<TradeBean> getdepositdetailList(int trade_classification) {

		ArrayList<TradeBean> depositdetailList = new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT a.trade_classification,a.trade_num , b.user_name, a.product_name,a.trade_quantity,a.trade_date,a.trade_state , "
					+ " a.product_price, a.trade_quantity * a.product_price ,CONCAT(c.adress_adress, ' ' ,c.adress_details) "
					+ " FROM trade a, user b, adress c"
					+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num  and a.trade_classification=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, trade_classification);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tb = new TradeBean();
				tb.setTrade_num(rs.getInt("a.trade_num"));
				tb.setTrade_classification(rs.getInt("trade_classification"));
				tb.setUser_name(rs.getString("b.user_name"));
				tb.setProduct_name(rs.getString("product_name"));
				tb.setTrade_quantity(rs.getInt("trade_quantity"));
				tb.setTrade_date(rs.getDate("trade_date"));
				tb.setTrade_state(rs.getString("a.trade_state"));
				tb.setProduct_price(rs.getInt("product_price"));
				tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				depositdetailList.add(tb);
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - getdepositdetailList 오류" + ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return depositdetailList;
	}

	public ArrayList<TradeBean> usergetdepositList(String user_id) {
		ArrayList<TradeBean> userdepositList = new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select a.user_name, b.user_user_num" + " from user a, trade b "
					+ " where b.user_user_num = a. user_num and user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			System.out.println("1");
			while (rs.next()) {
				tb = new TradeBean();
				tb.setUser_name(rs.getString("user_name"));
				tb.setUser_user_num(rs.getInt("user_user_num"));
			}
			System.out.println("User_num :" + tb.getUser_user_num());

			sql = "	SELECT a.trade_classification, b.user_name, a.trade_num ,a.product_name,a.trade_quantity, a.product_price, a.trade_quantity * a.product_price, CONCAT(c.adress_adress, ' ' ,c.adress_details),a.trade_date,a.trade_state "
					+ " FROM trade a, user b, adress c"
					+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num and trade_state in(?,'delivery_completed','deal_completed') and a.user_user_num =? "
					+ " group by a.trade_classification";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "deposit_completed");
			pstmt.setInt(2, tb.getUser_user_num());
			rs = pstmt.executeQuery();
			System.out.println("hi!!!!!");
			while (rs.next()) {
				System.out.println("hello!");
				tb = new TradeBean();
				tb.setTrade_num(rs.getInt("a.trade_num"));
				tb.setTrade_classification(rs.getInt("trade_classification"));
				tb.setUser_name(rs.getString("b.user_name"));
				tb.setProduct_name(rs.getString("product_name"));
				tb.setTrade_quantity(rs.getInt("trade_quantity"));
				tb.setProduct_price(rs.getInt("product_price"));
				tb.setTrade_state(rs.getString("a.trade_state"));
				tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				tb.setTrade_date(rs.getDate("trade_date"));
				userdepositList.add(tb);
			}
		} catch (Exception ex) {
			System.out.println("UserDAO - getdepositList 오류"+ex.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return userdepositList;
	}

	// 사용자용
	public ArrayList<TradeBean> usergetdepositdetailList(int trade_classification, String user_id) {

		ArrayList<TradeBean> userdepositdetailList = new ArrayList<TradeBean>();
		TradeBean tb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select a.user_name, b.user_user_num" + " from user a, trade b "
					+ " where b.user_user_num = a. user_num and user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			System.out.println("1");
			while (rs.next()) {
				tb = new TradeBean();
				tb.setUser_name(rs.getString("user_name"));
				tb.setUser_user_num(rs.getInt("user_user_num"));
			}
			System.out.println("User_num :" + tb.getUser_user_num());

			sql = "SELECT a.trade_classification, b.user_name,a.trade_num , a.product_name,a.trade_quantity,a.trade_date,a.trade_state ,a.trade_sale, "
					+ " a.product_price, a.trade_quantity * a.product_price ,CONCAT(c.adress_adress, ' ' ,c.adress_details) "
					+ " FROM trade a, user b, adress c"
					+ " where a.user_user_num = b.user_num and a.adress_adress_num = c.adress_num  and a.trade_classification=? and a.user_user_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, trade_classification);
			pstmt.setInt(2, tb.getUser_user_num());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tb = new TradeBean();
				tb.setTrade_num(rs.getInt("a.trade_num"));
				tb.setTrade_classification(rs.getInt("trade_classification"));
				tb.setUser_name(rs.getString("b.user_name"));
				tb.setProduct_name(rs.getString("product_name"));
				tb.setTrade_quantity(rs.getInt("trade_quantity"));
				tb.setTrade_date(rs.getDate("trade_date"));
				tb.setTrade_sale(rs.getInt("a.trade_sale"));
				tb.setTrade_state(rs.getString("a.trade_state"));
				tb.setProduct_price(rs.getInt("product_price"));
				tb.setTotalprice(rs.getInt("a.trade_quantity * a.product_price"));
				tb.setAdress(rs.getString("CONCAT(c.adress_adress, ' ' ,c.adress_details)"));
				userdepositdetailList.add(tb);
			}
		} catch (Exception ex) {
			System.out.println("※ getdepositdetailList 오류발생 내용=" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return userdepositdetailList;
	}

	public JSONArray checkroom(ReservationBean rebean) {
		System.out.println("checkArticle진입");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray roomList = null;
		System.out.println(rebean.getReser_date());
		System.out.println(rebean.getReser_time());
		System.out.println("checkid : 쿼리문 전");
		try {
			String sql = "select a.reservation_room, b.reservation_maxroom - count(a.reservation_roomnum) \"InRoomCount\""
					+ "from reservation a join reservation_maxroom b "
					+ "on (a.reservation_room = b.reservation_roomid) "
					+ "where reservation_date=? and reservation_time=? " + "group by reservation_room "
					+ "having InRoomCount=0;";
			System.out.println("checkid : 쿼리문 후");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rebean.getReser_date());
			pstmt.setString(2, rebean.getReser_time());
			rs = pstmt.executeQuery();
			roomList = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("roomcount", rs.getInt("InRoomCount"));
				jo.put("roomid", rs.getString("reservation_room"));
				roomList.add(jo);
			}
			System.out.println("roomList : " + roomList);

		} catch (SQLException e) {
			System.out.println("checkid  에러 " + e.getMessage());
		} finally {
			close(pstmt);
			close(rs);
		}

		return roomList;
	}

	// db에 방 입력
	public int insertArticles(ReservationBean rebean, String sid) {
		// Service 클래스로부터 BoardBean 객체를 전달받아 DB 에 INSERT 작업을 수행한 후 결과(int타입) 리턴
		System.out.println("insertArticles DAO 진입 :");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int user_num = 0;
		int num = 0;
		int insertCount = 0;
		System.out.println("insertArticles id : " + sid);
		try {
			// 현재 게시물의 최대 번호를 조회하여 새로운 글번호를 결정(+1)
			String sql = "select a.user_num, max(b.reservation_num) maxNum " + "from user a, reservation b "
					+ "where user_id = ?"; // 가장 큰 번호 조회

			pstmt = con.prepareStatement(sql);
			System.out.println("2");
			pstmt.setString(1, sid);
			System.out.println("1");
			rs = pstmt.executeQuery();
			System.out.println("0");

			if (rs.next()) { // 등록된 게시물이 하나라도 존재할 경우
				num = rs.getInt("maxNum") + 1; // 새 글 번호 = 현재 게시물 가장 큰 번호 + 1
				user_num = rs.getInt("user_num");
			} else { // 등록된 게시물이 하나도 없을 경우
				num = 1; // 새 글 번호 = 1
				user_num = rs.getInt("user_num");
			}
			System.out.println("user_num :" + user_num);

			// 전달받은 데이터를 사용하여 INSERT 작업 수행
			// => 마지막 필드인 board_date(게시물 작성일) 는 데이터베이스 now() 함수 사용하여 현재 시각 사용
			sql = "INSERT INTO reservation VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, rebean.getReservation_date());
			pstmt.setString(3, rebean.getReservation_time());
			pstmt.setString(4, rebean.getReservation_room());
			pstmt.setString(5, rebean.getReservation_notice());
			pstmt.setInt(6, rebean.getReservation_roomnum() + 1);
			pstmt.setInt(7, user_num);

			insertCount = pstmt.executeUpdate(); // INSERT 실행 결과 값을 int형 변수로 저장

		} catch (SQLException e) {
			System.out.println("insertArticle-reservation() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
//			close(con); // 주의!! DAO 내에서 Connection 객체를 닫지 않도록 주의할 것!!!!
			// => Service 클래스에서 commit, rollback 여부를 결정한 후 Connection 에 접근해야하기 때문에
		}

		return insertCount;
	}

	public ArrayList<ReservationBean> selectReservation(String sid) {
		System.out.println("selectReservation DAO 진입");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationBean rebean = null;
		UserBean ub = null;
		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();
		System.out.println("selectReservation ID : " + sid);

		try {
			String sql = "select user_num,user_name from user where user_id=?";
			// 나중에 바꿀때 "select user_num,user_name from user where user_name=?" 바꾸면됨
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ub = new UserBean();
				ub.setUser_num(rs.getInt("user_num"));

				System.out.println("user_num : " + ub.getUser_num());
			}

			sql = "select  a.user_name, b.reservation_num ,b.reservation_date , b.reservation_time , b.reservation_room , b.reservation_notice, "
					+ " b.reservation_roomnum,b.reservation_user_num " + " from user a, reservation b "
					+ " where  a.user_num =b.reservation_user_num and b.reservation_user_num= ? ";
//			select  a.user_num, b.reservation_user_num,reservation_num ,b.reservation_date , reservation_time , reservation_room , reservation_notice 
//					from user a reservation b
//					where  a.user_num = b.reservation_user_num and b.reservation_user_num= ; 
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ub.getUser_num());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rebean = new ReservationBean();
				rebean.setReservation_user_num(rs.getInt("b.Reservation_user_num"));
				rebean.setReservation_num(rs.getInt("b.reservation_num"));
				rebean.setReservation_date(rs.getString("b.reservation_date"));
				rebean.setReservation_time(rs.getString("b.reservation_time"));
				rebean.setReservation_room(rs.getString("b.reservation_room"));
				rebean.setReservation_notice(rs.getString("b.reservation_notice"));
				rebean.setReservation_roomnum(rs.getInt("b.reservation_roomnum"));
				rebean.setReservation_user_num(rs.getInt("b.reservation_user_num"));
				reservationList.add(rebean);
			}

		} catch (SQLException e) {
			System.out.println("selectReservation 에러 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return reservationList;
	}

	// 사용자용 삭제 메서드
	public int deleteReservation(int r_num) {

		PreparedStatement pstmt = null;

		int isOk = 0;
		String sql = "DELETE FROM reservation  where reservation_num=?";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			isOk = pstmt.executeUpdate();
			System.out.println("DAO : isOk :" + isOk);

		} catch (SQLException e) {
			System.out.println("deleteReservation 에러 : " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return isOk;
	}

	// 관리자 조회
	public ArrayList<ReservationBean> managerselectReservation() {
		System.out.println("managerselectReservation DAO진입");
		ArrayList<ReservationBean> managerreservationList = new ArrayList<ReservationBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationBean rebean = null;
		System.out.println("1");
		try {
			String sql = "select a.*,b.user_name " + "from reservation a, user b "
					+ "where reservation_user_num = user_num ";
			System.out.println("2");
			pstmt = con.prepareStatement(sql);
			System.out.println("3");
			rs = pstmt.executeQuery();
			System.out.println("4");
			while (rs.next()) {
				System.out.println("5");
				rebean = new ReservationBean();
				rebean.setReservation_num(rs.getInt("reservation_num"));
				rebean.setReservation_date(rs.getString("reservation_date"));
				rebean.setReservation_time(rs.getString("reservation_time"));
				rebean.setReservation_room(rs.getString("reservation_room"));
				rebean.setReservation_notice(rs.getString("reservation_notice"));
				rebean.setReservation_user_num(rs.getInt("reservation_user_num"));
				rebean.setReservation_user_name(rs.getString("user_name"));
				managerreservationList.add(rebean);
				System.out.println("6");
			}

		} catch (SQLException e) {
			System.out.println("managerselectReservation 에러 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return managerreservationList;
	}

	// 관리자 예약 삭제
	public int managerdeleteReservation(int u_num, int r_num) {

		PreparedStatement pstmt = null;

		int isOk = 0;
		try {
			String sql = "DELETE FROM reservation  where reservation_num=? and reservation_user_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			pstmt.setInt(2, u_num);
			isOk = pstmt.executeUpdate();
			System.out.println("DAO : isOk :" + isOk);

			System.out.println("DAO managerDelete : " + isOk);
		} catch (SQLException e) {
			System.out.println("managerdeleteReservation 에러 : " + e.getMessage());
		}

		return isOk;
	}

	public int insertAdress(AdressBean adressBean) {
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;

		try {

			sql = "insert into adress values(null,?,?,?,?,?,?,?,'false')";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, adressBean.getAdress_user_num());
			pstmt.setString(2, adressBean.getAdress_adress());
			pstmt.setString(3, adressBean.getAdress_details());
			pstmt.setInt(4, 1);
			pstmt.setString(5, "기본배송지");
			pstmt.setInt(6, adressBean.getAdress_post_num());
			pstmt.setString(7, adressBean.getAdress_phone_num());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("adress_Insert 에러 :" + e.getMessage());
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int selectUser_num(String user_id) {
		int user_num = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM user WHERE user_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user_num = rs.getInt("user_num");
			}

		} catch (Exception e) {
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return user_num;
	}

	public ArrayList<TradeBean> selectRevenue() {
		ArrayList<TradeBean> revenue = new ArrayList<TradeBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT trade_quantity,trade_sale,product_price FROM trade WHERE trade_date LIKE '2019-12-%'";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TradeBean tbean = new TradeBean();
				tbean.setTrade_quantity(rs.getInt("trade_quantity"));
				tbean.setTrade_sale(rs.getInt("trade_sale"));
				tbean.setProduct_price(rs.getInt("product_price"));

				revenue.add(tbean);
			}

		} catch (Exception e) {
			System.out.println("selectUser_num sql구문요청 에러 :" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("revenue.size = " + revenue.size());
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
		return revenue;
	}

}
