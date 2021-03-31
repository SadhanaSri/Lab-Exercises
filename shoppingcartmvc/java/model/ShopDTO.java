package model;

import java.io.Serializable;

public class ShopDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String shopid;
	private String shop_name;
	private String product_code;
	private String product_image;
	private String product_name;
	private int product_units;
	private double product_price;
	
	public ShopDTO(String shopid, String poduct_image, String product_name, int product_units, double product_price) {
		super();
		this.shopid = shopid;
		this.product_image = poduct_image;
		this.product_name = product_name;
		this.product_units = product_units;
		this.product_price = product_price;
	}
	
	public static ShopDTO shopDTO;
	
	public static ShopDTO getShopDTO() {
		if(shopDTO == null) {
			return new ShopDTO();
		} else {
			return shopDTO.createClone();
		}
	}
	
	public ShopDTO createClone() {
		try {
			return (ShopDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ShopDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	
	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String poduct_image) {
		this.product_image = poduct_image;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_units() {
		return product_units;
	}
	public void setProduct_units(int product_units) {
		this.product_units = product_units;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product_image == null) ? 0 : product_image.hashCode());
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(product_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_units;
		result = prime * result + ((shop_name == null) ? 0 : shop_name.hashCode());
		result = prime * result + ((shopid == null) ? 0 : shopid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopDTO other = (ShopDTO) obj;
		if (product_image == null) {
			if (other.product_image != null)
				return false;
		} else if (!product_image.equals(other.product_image))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (Double.doubleToLongBits(product_price) != Double.doubleToLongBits(other.product_price))
			return false;
		if (product_units != other.product_units)
			return false;
		if (shop_name == null) {
			if (other.shop_name != null)
				return false;
		} else if (!shop_name.equals(other.shop_name))
			return false;
		if (shopid == null) {
			if (other.shopid != null)
				return false;
		} else if (!shopid.equals(other.shopid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopDTO [shopid=" + shopid + ", shop_name=" + shop_name + ", poduct_image=" + product_image
				+ ", product_name=" + product_name + ", product_units=" + product_units + ", product_price=" + product_price + "]";
	}
}
