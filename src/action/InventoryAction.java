package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.InventoryService;
import vo.ActionForward;
import vo.ShopBean;

public class InventoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InventoryAction");
		ActionForward forward = null;
		ArrayList<ShopBean> productList = null;
		
		
		InventoryService inventoryService = new InventoryService();
		productList = inventoryService.getInventory();
		
		
		
		request.setAttribute("productList", productList);
		forward = new ActionForward();
		forward.setPath("/user/Inventory_Management.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
