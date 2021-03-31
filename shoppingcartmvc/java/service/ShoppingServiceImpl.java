package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Set;

import model.ShopDAO;
import model.ShopDAOImpl;
import model.ShopDTO;

public class ShoppingServiceImpl implements ShoppingService, Cloneable {
	Properties prop;
	Connection con;
	PreparedStatement st;
	
	public ShoppingServiceImpl(Properties prop) {
		this.prop = prop;
	}
	
	public static ShoppingServiceImpl shoppingServiceImpl;
	
	public static ShoppingServiceImpl getShoppingServiceImpl(Properties prop) {
		if(shoppingServiceImpl == null) {
			shoppingServiceImpl = new ShoppingServiceImpl(prop);
			return shoppingServiceImpl;
		} else {
			return shoppingServiceImpl.createClone();
		}
	}	
	
	public ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int registerShop(ShopDTO shopDTO) {
		ShopDAO shopDAO = ShopDAOImpl.getShopDAOImpl(prop);	
		return shopDAO.insertShop(shopDTO);
	}

	@Override
	public Set<ShopDTO> getShopDetails(String shopid) {
		ShopDAO shopDAO = ShopDAOImpl.getShopDAOImpl(prop);
		return shopDAO.getShopDTO(shopid);
	}
	
	@Override
	public double getProductPrice(String product_code) {
		ShopDAO shopDAO = ShopDAOImpl.getShopDAOImpl(prop);
		return shopDAO.getPriceByCode(product_code);
	}
}
