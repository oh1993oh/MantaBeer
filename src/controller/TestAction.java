package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.AdressBean;

public class TestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		
		
		ActionForward forward = null;
		ArrayList<String> msgList = null;
		msgList = new ArrayList<String>();
		Boolean isInsertSuccess = true;
		if(isInsertSuccess) {
			msgList.add("true");
		}else {
			msgList.add("false");
		}
		
		
		request.setAttribute("msgList", msgList);
		forward = new ActionForward();
		forward.setPath("/msg/msg.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
