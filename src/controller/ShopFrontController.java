package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Adress_ModifyAction;
import action.Adress_RemoveAction;
import action.Adress_InsertAction;
import action.CartAction;
import action.Cart_removeAction;
import action.Cart_toCheckOutAction;
import action.CheckOutAction;
import action.InsertReviewAction;

import action.PlaceAnOrderAction;
import action.Product_SingleAction;
import action.ShopAction;
import action.Product_onCartAction;
import action.ReviewDeleteAction;
import action.ReviewModifyAction;
import action.ReviewModifyProAction;
import vo.ActionForward;

@WebServlet("*.shop")
public class ShopFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Action action;
		ActionForward forward = null;
		String command = request.getServletPath();

		if (command.contentEquals("/Main.shop")) {
			action = new ShopAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Detail.shop")) {
			action = new Product_SingleAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Cart.shop")) {
			action = new CartAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Trade_onCart.shop")) {
			action = new Product_onCartAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Cart_toCheckOut.shop")) {
			action = new Cart_toCheckOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/CheckOut.shop")) {
			action = new CheckOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/PlaceAnOrder.shop")) {
			action = new PlaceAnOrderAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Cart_remove.shop")) {
			action = new Cart_removeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Adress_Insert.shop")) {
			action = new Adress_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Adress_Modify.shop")) {
			action = new Adress_ModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/test.shop")) {
			action = new TestAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/Adress_Remove.shop")) {
			action = new Adress_RemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/insertReview.shop")) {
			action = new InsertReviewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/ReviewDelete.shop")) {
			action = new ReviewDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/ReviewModify.shop")) {
			action = new ReviewModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/ReviewModifyPro.shop")) {
			action = new ReviewModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/event.shop")) {
			forward = new ActionForward();			
			forward.setPath("/event.jsp");
		}
		
		
		
//		if(command.contentEquals("/BoardMain.bo")) {
//			action = new boardAction();
//			try {
//				forward=new ActionForward();
//				forward.setPath("./index.jsp");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardWriteForm.bo")) {
//			
//			
//			forward= new ActionForward();
//			forward.setPath("./board/qna_board_write.jsp");
//			
//		}else if(command.contentEquals("/BoardWritePro.bo")) {
//			action = new boardWriteProAction();
//			try {
//				forward=action.excute(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardList.bo")) {
//			action = new BoardListAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardDetail.bo")) {
//			action = new BoardDetailAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardModifyForm.bo")) {
//			action = new BoardModifyFormAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardModifyPro.bo")) {
//			action = new BoardModifyProAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardDeleteForm.bo")) {
//			forward = new ActionForward();
//			forward.setPath("/board/qna_board_delete.jsp");
//			
//		}else if(command.contentEquals("/BoardDeletePro.bo")) {
//			action = new BoardDeleteProAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardReplyForm.bo")) {
//			action = new BoardReplyFormAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else if(command.contentEquals("/BoardReplyPro.bo")) {
//			action = new BoardReplyProAction();
//			try {
//				forward=action.excute(request, response);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}

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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
