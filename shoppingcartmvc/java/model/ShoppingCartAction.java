package model;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShoppingService;
import service.ShoppingServiceImpl;


public class ShoppingCartAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ShoppingAction shoppingAction = ShoppingAction.getShoppingAction();
		shoppingAction.execute(request, response);
		
		String shopid = request.getParameter("shopid");
		
		HttpSession session = request.getSession();
		session.setAttribute("shopid", shopid);
	
		Enumeration<String> e = request.getParameterNames();
		
//		Map<String, List<String>> invoiceList = new LinkedHashMap<String, List<String>>();
//		List<String> items = new LinkedList<String>(); 
		
		while(e.hasMoreElements()) {
			String param = e.nextElement();
			String val[] = request.getParameterValues(param);
			
			if(val.length > 1) {				
//				System.out.println(val.length);
				Properties prop = (Properties) request.getServletContext().getAttribute("properties");
				ShoppingService shopping = ShoppingServiceImpl.getShoppingServiceImpl(prop);
				String price = String.valueOf(shopping.getProductPrice(param));  
						
				LinkedHashMap<String, LinkedList<String>> cart = (LinkedHashMap<String, LinkedList<String>>)session.getAttribute("shoppingCart");
				
				LinkedList<String> list = new LinkedList<String>();
				
				list.add(val[1]);
				list.add(val[0]);
				list.add(price);
				
				cart.put(param, list);
				
				System.out.println(cart.size());
				
				for(Map.Entry<String, LinkedList<String>> m : cart.entrySet()){
					   for(String e1 : m.getValue())
					      System.out.println(m.getKey() + " = "+ e1);
				}
				
				
				
//				session.setAttribute("invoiceList", invoiceList);
//				System.out.println(param);
//			
				
				session.setAttribute("shoppingCart", cart);
			}
			
					
		}
		return shopid;
	}
}
