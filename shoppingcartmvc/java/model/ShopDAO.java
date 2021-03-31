package model;

import java.util.Set;

public interface ShopDAO {
	public int insertShop(ShopDTO shopDTO);
	public int updateShop(ShopDTO shopDTO);
	public int deleteShop(String shopid);
	public Set<ShopDTO> getShopDTO(String shopid);
	public ShopDTO getShopByName(String shopname);
	public double getPriceByCode(String product_code);
}
