package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ShoppingAction extends Action implements Cloneable {

	public static ShoppingAction shoppingAction;
	
	public static ShoppingAction getShoppingAction() {
		if(shoppingAction == null) {
			shoppingAction = new ShoppingAction();
			return shoppingAction;
		} else {
			return shoppingAction.createClone();
		}
	}	
	
	public ShoppingAction createClone() {
		try {
			return (ShoppingAction)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");
		ShoppingService shopping = ShoppingServiceImpl.getShoppingServiceImpl(prop);
		
		String shopid = request.getParameter("shopid");
		HttpSession session = request.getSession();
		
		Set<ShopDTO> shopDTO = shopping.getShopDetails(shopid);
		session.setAttribute("shopDTO", shopDTO);
		
		if(session.getAttribute("shoppingCart") == null) {
			LinkedHashMap<String, List<String>> shoppingCart = new LinkedHashMap<String, List<String>>();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		return "shop.success";
	}
}
