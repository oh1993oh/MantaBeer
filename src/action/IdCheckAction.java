package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.IdCheckService;
import vo.ActionForward;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		System.out.println("IdCheckAction");
		
		String user_id = request.getParameter("id");
		
		IdCheckService idCheckService = new IdCheckService();
		boolean isRegisSuccees = idCheckService.regisUser(user_id);
		
		respone.setContentType("text/html; charset=UTF-8");
		PrintWriter out = respone.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
		
		if(isRegisSuccees) {
			out.println("사용가능");
	    } else {
	    	out.println("사용불가능");
	    }
		
		return null;
	}

}