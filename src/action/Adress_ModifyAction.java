package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Adress_Service;
import vo.ActionForward;
import vo.AdressBean;

public class Adress_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Adress_InsertAction");
//		ActionForward forward = null;
		AdressBean adressBean = new AdressBean();
//		ArrayList<String> msgList = null;
		
		adressBean.setAdress_user_num(Integer.parseInt(request.getParameter("adress_user_num")));
		adressBean.setAdress_table_num(Integer.parseInt(request.getParameter("adress_table_num")));
		adressBean.setAdress_table_name(request.getParameter("adress_table_name"));
		adressBean.setAdress_adress(request.getParameter("adress_adress"));
		adressBean.setAdress_details(request.getParameter("adress_details"));
		adressBean.setAdress_post_num(Integer.parseInt(request.getParameter("adress_post_num")));
		adressBean.setAdress_phone_num(request.getParameter("adress_phone_num"));
		
		Adress_Service adress_Service = new Adress_Service();
		boolean isModifySuccess = adress_Service.adress_Modify(adressBean);
		
		return null;
	}

}
