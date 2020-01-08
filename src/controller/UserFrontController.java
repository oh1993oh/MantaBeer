package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BeerMainAction;
import action.GetdepositDetailListAction;
import action.GetdepositListAction;
import action.IdCheckAction;
import action.InventoryAction;
import action.ReservationCheckAction;
import action.ReservationProAction;
import action.ReservationdeleteAction;
import action.ReservationselectAction;
import action.RevenueAction;
import action.StateChangeAction;
import action.UserDeleteEndAction;
import action.UserDeleteFormAction;
import action.UserInfoAction;
import action.UserJoinProAction;
import action.UserListAction;
import action.UserListDeleteAction;
import action.UserListViewAction;
import action.UserLoginProAction;
import action.UserLogoutProAction;
import action.UserOrdertrackingAction;
import action.UserSearchFormAction;
import action.UserSearchProAction;
import action.UserupdateFromAction;
import action.UserupdateProAction;
import action.manager_Reservation_deleteAction;
import action.manager_Reservation_selectAction;
import vo.ActionForward;

@WebServlet("*.me")
public class UserFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/LoginForm.me")) {
			forward = new ActionForward();
			forward.setPath("/user/user_login_form.jsp");
		} else if (command.equals("/LoginPro.me")) {
			action = new UserLoginProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/UserJoinForm.me")) {
			forward = new ActionForward();
			forward.setPath("/user/user_join_form.jsp");

		} else if (command.equals("/LogoutPro.me")) {
			action = new UserLogoutProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/userJoinPro.me")) {
			action = new UserJoinProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/UserJoinResult.me")) {

			forward = new ActionForward();
			forward.setPath("/BeerMain.me");
		} else if (command.equals("/BeerMain.me")) {
			action = new BeerMainAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/UserlnfoFrom.me")) {
			action = new UserInfoAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Userupdateform.me")) {
			action = new UserupdateFromAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (command.equals("/UserupdatePro.me")) {
			action = new UserupdateProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Userdeleteform.me")) {

			action = new UserDeleteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/UserdeletePro.me")) {
			action = new UserDeleteEndAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("/userSearchPro.me")) {
			action = new UserSearchFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// �쁾 愿�由ъ옄 �럹�씠吏�
		} // 주문 확인 페이지
		else if (command.equals("/UserOrdertracking.me")) {
			action = new GetdepositListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/userSearchlist.me")) {
			action = new UserSearchProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// �쁾 愿�由ъ옄 �럹�씠吏�(�쉶�썝 �젙蹂� 紐⑸줉 援ы쁽)
		} else if (command.equals("/User_list.me")) {
			action = new GetdepositListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/User_listView.me")) {
			action = new UserListViewAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// �쁾 愿�由ъ옄 �럹�씠吏�(�쉶�썝 �젙蹂� <紐⑸줉> �궘�젣 援ы쁽)
		} else if (command.equals("/User_listDel.me")) {
			action = new UserListDeleteAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// �쁾 愿�由ъ옄 �럹�씠吏�(�쉶�썝 �젙蹂� <紐⑸줉> �닔�젙 援ы쁽)
		} else if (command.equals("/User_listUpd.me")) {
			action = null;

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/user_detaillist.me")) {
			action = new GetdepositDetailListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("/Inventory.me")) {
			action = new InventoryAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("/Revenue.me")) {
			action = new RevenueAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("/stateChange.me")) {
			action = new StateChangeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (command.equals("/UserIdCheck.me")) {
			action = new IdCheckAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("controller - /UserJoinForm.me"+e.getMessage());
			}
		}//예약페이지 부분
		else if(command.equals("/Reservation_write1.me")) {
			System.out.println("데이터1 (1) :"+request.getParameter("date"));
			System.out.println("데이터2 (2) :"+request.getParameter("time"));
			action = new ReservationCheckAction();
			System.out.println("Time.js ajax정상 작동");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
		}else if(command.equals("/Reservation_write_pro.me")) {
			System.out.println("Reservation_write_pro con");
			action = new ReservationProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		}else if(command.equals("/Reservation_select.me")) {
			System.out.println("Reservation_select.me 컨트롤러");
			action = new ReservationselectAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		}else if(command.equals("/Reservation_delete.me")) {
			System.out.println("Reservation_select.me 컨트롤러");
			action = new ReservationdeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		}else if(command.equals("/manager_Reservation_select.me")) {
			System.out.println("manager_Reservation_select.me 컨트롤러");
			action = new manager_Reservation_selectAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		}else if(command.equals("/manager_Reservation_delete.me")) {
			System.out.println("manager_Reservation_delete.me 컨트롤러");
			action = new manager_Reservation_deleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		}else if(command.equals("/Reservation_write.me")) {
			System.out.println("Reservation_write.me");
//			System.out.println("확인?");
			System.out.println("데이터1 :"+request.getParameter("date"));
			System.out.println("데이터2 :"+request.getParameter("time"));
			forward = new ActionForward();
//			System.out.println("forward : " + forward.toString());
			forward.setPath("./reservation.jsp");
		}
		else if(command.equals("/Reservation_write1.me")) {
			System.out.println("데이터1 (1) :"+request.getParameter("date"));
			System.out.println("데이터2 (2) :"+request.getParameter("time"));
			action = new ReservationCheckAction();
			System.out.println("Time.js ajax정상 작동");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
		}
		else if(command.equals("/Reservation_write_pro.me")) {
			
			action = new ReservationProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			} 
				
			
		} 

		
		
		
		

		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
