package com.ShopRegistration.Repository;

import java.sql.SQLException;
import java.util.List;
import com.ShopRegistration.Entity.Shop;
import com.ShopRegistration.EnumsDBconException.ShopType;

public interface ShopRepository {
	public Shop insertShop(Shop shop) throws ClassNotFoundException, SQLException;

	public List<Shop> findAllShops();

	public Shop searchShopByShopName(String shopName);

	public void updateContactNo(String contactNo, String newcontactNo);

	public void deleteShop(String shopName);

	public List<Shop> findAllShopsByShopType(ShopType shopType);
}
