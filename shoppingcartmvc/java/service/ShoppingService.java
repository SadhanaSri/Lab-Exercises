package service;

import java.util.Set;

import model.ShopDTO;

public interface ShoppingService {
	public int registerShop(ShopDTO shopDTO);
	public Set<ShopDTO> getShopDetails(String shopid);
	public double getProductPrice(String product_code);
}
