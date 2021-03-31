package model;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class ShopDAOImpl implements ShopDAO, Cloneable {
	
	public static ShopDAOImpl shopDAOImpl;
	Properties prop;
	Connection con;
	int count;
	PreparedStatement st;
	
	public ShopDAOImpl(Properties prop) {
		this.prop = prop;
	}
	
	public static ShopDAOImpl getShopDAOImpl(Properties prop) {
		if(shopDAOImpl == null) {
			return new ShopDAOImpl(prop);
		} else {
			return shopDAOImpl.createClone();
		}
	}
	
	public ShopDAOImpl createClone() {
		try {
			return (ShopDAOImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertShop(ShopDTO shopDTO) {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("insert into shop values (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, shopDTO.getShopid());
			st.setString(2, shopDTO.getShop_name());
			st.setString(3, shopDTO.getProduct_code());
			st.setBlob(4, new FileInputStream(shopDTO.getProduct_image()));
			st.setString(5, shopDTO.getProduct_name());
			st.setInt(6, shopDTO.getProduct_units());
			st.setDouble(7, shopDTO.getProduct_price());
			
			count = st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateShop(ShopDTO shopDTO) {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("update shop set shop_name=?, product_code=?, product_name=?, product_units=?, product_price=?, where shopid=?");
			st.setString(1, shopDTO.getShop_name());
			st.setString(2, shopDTO.getProduct_code());
			st.setString(3, shopDTO.getProduct_name());
			st.setInt(4, shopDTO.getProduct_units());
			st.setDouble(5, shopDTO.getProduct_price());			
			count = st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteShop(String shopid) {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("delete from shop where shopid=?");
			st.setString(1, shopid);
			count = st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Set<ShopDTO> getShopDTO(String shopid) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("select * from shop where shopid=?");
			st.setString(1, shopid);
			
			ShopDTO shopDTO;
			ResultSet rs = st.executeQuery();
			Set<ShopDTO> set = new LinkedHashSet<>();
			
			while(rs.next()) {
				shopDTO = ShopDTO.getShopDTO();
				shopDTO.setShopid(rs.getString(1));
				shopDTO.setShop_name(rs.getString(2));
				shopDTO.setProduct_code(rs.getString(3));
				
				Blob blob = rs.getBlob(4);
				 
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				byte[] imageBytes = outputStream.toByteArray();
				 
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				shopDTO.setProduct_image(base64Image);
				shopDTO.setProduct_name(rs.getString(5));
				shopDTO.setProduct_units(rs.getInt(6));
				shopDTO.setProduct_price(rs.getDouble(7));
				set.add(shopDTO);
			}
			DBUtility.closeConnection(null);
			return set;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ShopDTO getShopByName(String shopname) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("select * from shop where shop_name=?");
			st.setString(1, shopname);
		
			ShopDTO shopDTO = ShopDTO.getShopDTO();
			ResultSet rs = st.executeQuery();
		
			while(rs.next()) {	
				shopDTO.setShopid(rs.getString(1));
				shopDTO.setShop_name(rs.getString(2));
				shopDTO.setProduct_image(rs.getString(3));
				shopDTO.setProduct_name(rs.getString(4));
				shopDTO.setProduct_units(rs.getInt(5));
				shopDTO.setProduct_price(rs.getDouble(6));
			}
			DBUtility.closeConnection(null);
			return shopDTO;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public double getPriceByCode(String product_code) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("select product_price from shop where product_code=?");
			st.setString(1, product_code);
		
			ResultSet rs = st.executeQuery();
			rs.next();
			double price = rs.getDouble(1);
			
			DBUtility.closeConnection(null);
			return price;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return 0;
		}
	}
}
