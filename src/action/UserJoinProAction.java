package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserJoinProService;
import vo.ActionForward;
import vo.AdressBean;
import vo.UserBean;

public class UserJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserJoinProAction");
		ActionForward forward = null;
		UserBean user = new UserBean();

		user.setUser_id(request.getParameter("user_id"));
		user.setUser_pass(request.getParameter("user_pass"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_email(request.getParameter("email1") + "@" + request.getParameter("email2"));
		user.setUser_number(request.getParameter("user_number"));

		UserJoinProService userjoinproservice = new UserJoinProService();
		boolean isRegisSuccees = userjoinproservice.regisUser(user);

		if (!isRegisSuccees) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
			out.println("<script>");
			out.println("alert('회원가입에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			
			int adress_user_num = userjoinproservice.getUser_num(request.getParameter("user_id"));
			
			AdressBean adress = new AdressBean();
			adress.setAdress_user_num(adress_user_num);
			adress.setAdress_adress(request.getParameter("adress"));
			adress.setAdress_details(request.getParameter("adress_details"));
			adress.setAdress_phone_num(request.getParameter("user_number"));
			System.out.println(request.getParameter("post_num"));
			adress.setAdress_post_num(Integer.parseInt(request.getParameter("post_num")));
			boolean isRegisSuccees2 = userjoinproservice.regisUserAdress(adress);
			
			if (!isRegisSuccees2) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
				out.println("<script>");
				out.println("alert('회원가입에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("UserJoinResult.me");
			}
		}

		return forward;
	}

}