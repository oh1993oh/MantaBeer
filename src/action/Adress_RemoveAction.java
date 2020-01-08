package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Adress_Service;
import vo.ActionForward;
import vo.AdressBean;

public class Adress_RemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Adress_RemoveAction");
		AdressBean adressBean = new AdressBean();
		
		adressBean.setAdress_user_num(Integer.parseInt(request.getParameter("adress_user_num")));
		adressBean.setAdress_table_num(Integer.parseInt(request.getParameter("adress_table_num")));
		
		
		Adress_Service adress_Service = new Adress_Service();
		boolean isDeleteSuccess = adress_Service.adress_Delete(adressBean);
		return null;
	}

}
