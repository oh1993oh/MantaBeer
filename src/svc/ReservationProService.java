package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;

import static db.jdbcUtil.*;


import vo.ReservationBean;

public class ReservationProService {

	public boolean registArticle(ReservationBean rebean,String sid) {
		System.out.println("ReservationProService-진입");
		boolean isWriteSuccess = false;
		
		Connection con = getConnection(); // DB객체를 불러올 때는 import static db.jdbcUtil.*;
		System.out.println("con 성공!");				  // static 붙이자
		
		UserDAO userDAO =UserDAO.getInstance();
		
		userDAO.setConnection(con);
		
		//BoardDAO 의 insertArticle() 메서드를 호출하여 게시물 등록 작업 수행
				// => 파라미터로 Board 객체 전달
				// => 리턴값으로 executeUpdata() 메서드를 통해 쿼리 실행 결과에 대한 정수값 전달 받음
		
		int insertCount =userDAO.insertArticles(rebean,sid);
		System.out.println("insertCount : "+insertCount);
		if(insertCount > 0) {
			// commit 작업 수행 => jdbcUtil 클래스의 commit()메서드 호출 => Connection 객체 전달
			commit(con);
			
			// 성공 여부를 저장하는 변수 isWriteSuccess 를 true 로 변경
			isWriteSuccess = true;
			
		}
		else {
			//rollback  작업 수행
			rollback(con);
		}
		//Connection 자원 반환을 위해 JdbcUtil 클래스의 close() 메서드 호출
		close(con);
		
		
		System.out.println("isWriteSuccess : "+isWriteSuccess);
		return isWriteSuccess;
	}
	public ArrayList<ReservationBean> selectReservation(String sid) {
		System.out.println("selectReservation service 진입");
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		ArrayList<ReservationBean> reservationList=userDAO.selectReservation(sid);
		
		System.out.println("reservationList Service : " + reservationList);
		
		close(con);
		
		
		return reservationList;
	}
	//관리자용
	public ArrayList<ReservationBean> managerselectReservation() {
		System.out.println("managerselectReservation service 진입");
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		ArrayList<ReservationBean> managerreservationList = userDAO.managerselectReservation();
		
		System.out.println("managerreservationList : " +managerreservationList);
		
		close(con);
		return managerreservationList;
	}

}
