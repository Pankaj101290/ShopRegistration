package com.ShopRegistration.Service;

import java.sql.SQLException;
import java.util.List;

import com.ShopRegistration.DTOs.ShopDTO;
import com.ShopRegistration.Entity.Shop;
import com.ShopRegistration.EnumsDBconException.ShopType;


public interface ShopService {

	public ShopDTO registerShop(ShopDTO shopDTO) throws ClassNotFoundException, SQLException;
	
	public List<ShopDTO> viewAllShop();
	
	public ShopDTO serchShopbyName(String shopName);

	public String updateShopbyContactNo(String contactNo, String newcontactNo);

	public String deleteShop(String shopName);
	
	public List<ShopDTO> findShopsByShopType(ShopType shopType);
}
