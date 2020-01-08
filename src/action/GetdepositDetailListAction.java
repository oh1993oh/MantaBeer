package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.getdepositList;
import vo.ActionForward;
import vo.TradeBean;

public class GetdepositDetailListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		System.out.println("GetdepositDetailListAction");
		
		int trade_classification=0;
		
		trade_classification =Integer.parseInt(request.getParameter("trade_classification"));
		System.out.println("trade_classification :" + trade_classification);
		ActionForward forward = null;
		//12-18
		HttpSession session = request.getSession();
		String user_id=(String)session.getAttribute("user_id");
				//(String)request.getParameter("user_id");
	
		System.out.println("user_id : " + user_id);
		
		
		if(trade_classification != 0) {//trade_classification값이 없는 경우
			 if(user_id.equals("admin")) {
				 System.out.println("admin");
				 getdepositList depositservice = new getdepositList();
					ArrayList<TradeBean> getdepositdetailList=depositservice.getdepositdetailList(trade_classification);
					System.out.println("getdepositdetailList :"+getdepositdetailList);
					
					request.setAttribute("getdepositdetailList", getdepositdetailList);
					
					forward = new ActionForward();
					forward.setPath("/user/user_detailList.jsp");
			 }else if(!user_id.equals("admin")) {
				 System.out.println("user");
			getdepositList depositservice = new getdepositList();
			ArrayList<TradeBean> usergetdepositdetailList=depositservice.usergetdepositdetailList(trade_classification,user_id);
			
			request.setAttribute("usergetdepositdetailList", usergetdepositdetailList);
			
			forward = new ActionForward();
			forward.setPath("/user/UserOrdertrackingDetail.jsp");
			}
		}else {
			System.out.println("실패!");
		}
		
		
		return forward;
		
	}

}
