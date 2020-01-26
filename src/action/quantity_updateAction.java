package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CartService;
import svc.Quantity_updateService;
import vo.ActionForward;

public class quantity_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {

		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int product_num = Integer.parseInt(request.getParameter("product_num"));

		
		Quantity_updateService quantity_updateService = new Quantity_updateService();
		boolean isUpdateSuccess = quantity_updateService.quantity_update(quantity,product_num);


		return null;
	}

}
