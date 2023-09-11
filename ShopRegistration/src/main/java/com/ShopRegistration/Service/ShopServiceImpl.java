package com.ShopRegistration.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import com.ShopRegistration.DTOs.ShopDTO;
import com.ShopRegistration.Entity.Shop;
import com.ShopRegistration.EnumsDBconException.ShopNotFoundException;
import com.ShopRegistration.EnumsDBconException.ShopType;
import com.ShopRegistration.EnumsDBconException.ShopTypeException;
import com.ShopRegistration.Repository.ShopRepository;
import com.ShopRegistration.Repository.ShopRepositoryImpl;

public class ShopServiceImpl implements ShopService {
	private ShopRepository shopRepository = new ShopRepositoryImpl();

	@Override
	public ShopDTO registerShop(ShopDTO shopDTO) throws ClassNotFoundException, SQLException {
		Shop shop = new Shop();
		shop.setId(shopDTO.getId());
		shop.setShopName(shopDTO.getShopName());
		shop.setContactNo(shopDTO.getContactNo());
		shop.setGSTno(shopDTO.getGSTno());
		shop.setShopType(shopDTO.getShopType());
		shop.setAddress(shopDTO.getAddress());
		shop.setDescription(shopDTO.getDescription());

		shopRepository.insertShop(shop);
		return shopDTO;
	}

	@Override
	public List<ShopDTO> viewAllShop() {
		List<Shop> list = shopRepository.findAllShops();
		if (list.isEmpty() | list == null)// || list == null
			throw new ShopNotFoundException("No any Shop found"); // Custom Exception
		return list
				.stream().map(shop -> new ShopDTO(shop.getId(), shop.getShopName(), shop.getContactNo(),
						shop.getGSTno(), shop.getShopType(), shop.getAddress(), shop.getDescription()))
				.collect(Collectors.toList());

	}

	@Override
	public ShopDTO serchShopbyName(String shopName) {
		Shop shop = shopRepository.searchShopByShopName(shopName);
		if (shop == null) {
			throw new ShopNotFoundException(shopName + ": Shop not found ");
		}
		return new ShopDTO(shop.getId(), shop.getShopName(), shop.getContactNo(), shop.getGSTno(), shop.getShopType(),
				shop.getAddress(), shop.getDescription());
	}

	@Override
	public String updateShopbyContactNo(String contactNo, String newcontactNo) {
		shopRepository.updateContactNo(contactNo, newcontactNo);
		return "contact no updated successfully...";
	}

	@Override
	public String deleteShop(String shopName) {
		shopRepository.deleteShop(shopName);
		return "Client deleted Successfully...";
	}

	@Override
	public List<ShopDTO> findShopsByShopType(ShopType shopType) {
		List<Shop> list = shopRepository.findAllShopsByShopType(shopType);
		if (list == null) {
			throw new ShopTypeException(shopType + ":Type of Shop not found ");
		}
		return list
				.stream().map(shop -> new ShopDTO(shop.getId(), shop.getShopName(), shop.getContactNo(),
						shop.getGSTno(), shop.getShopType(), shop.getAddress(), shop.getDescription()))
				.collect(Collectors.toList());
	}

}
