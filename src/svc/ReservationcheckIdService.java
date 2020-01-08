package svc;

import java.sql.Connection;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import dao.UserDAO;

import static db.jdbcUtil.*;
import vo.ReservationBean;

public class ReservationcheckIdService {

	public JSONArray checkroom(ReservationBean rebean) {
		System.out.println("ReservationcheckIdService 진입");
	
		
		Connection con = getConnection();
		System.out.println(" checkID con 성공!");
		
		UserDAO userDAO =UserDAO.getInstance();

		
		userDAO.setConnection(con);
		
		JSONArray roomList  = userDAO.checkroom(rebean);
		System.out.println("Service : " + roomList);
//		System.out.println("1번");
//		System.out.println("checkID : " + roomid);
		
		
		
		
		commit(con);
		
		
		
		
		return roomList;
		
	}

	
	
}
