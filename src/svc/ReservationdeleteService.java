package svc;

import static db.jdbcUtil.*;

import java.sql.Connection;


import dao.UserDAO;

public class ReservationdeleteService {

	public boolean deleteReservation(int r_num) {
		
		Connection con = getConnection();
		System.out.println(" checkID con 성공!");
		
		UserDAO userDAO =UserDAO.getInstance();
		userDAO.setConnection(con);
		 int isdelete = userDAO.deleteReservation(r_num);
		boolean isSuccess = false;
		 
		if(isdelete == 1) {
			commit(con);
			isSuccess=true;
			
		}else {
			rollback(con);
		}
		
		
		
		close(con);
		
		
		
		
		
		return isSuccess;
	}

	public boolean managerReservationdelete(int u_num, int r_num) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		System.out.println(" checkID con 성공!");
		
		UserDAO userDAO =UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int isdelete =userDAO.managerdeleteReservation(u_num,r_num);
		System.out.println("managerService : " + isdelete);
		boolean isSuccess = false;
		
		if(isdelete == 1) {
			commit(con);
			isSuccess=true;
			
		}else {
			rollback(con);
		}
		
		close(con);
		System.out.println("isSuccess : "+isSuccess );
		return isSuccess;
	}

}
