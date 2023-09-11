package com.ShopRegistration.Entity;

import com.ShopRegistration.EnumsDBconException.ShopType;

public class Shop {
	private Integer id;
	private String shopName;
	private String contactNo;
	private String GSTno;
	ShopType shopType;
	private String address;
	private String description;

	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", contactNo=" + contactNo + ", GSTno=" + GSTno + ", shopType=" + shopType
				+ ", address=" + address + ", description=" + description + "]";
	}

	public Shop(String shopName, String conatctNo, String gSTno, ShopType shopType, String address,
			String description) {
		super();
		this.shopName = shopName;
		this.contactNo = conatctNo;
		GSTno = gSTno;
		this.shopType = shopType;
		this.address = address;
		this.description = description;
	}

	public Shop() {
		super();
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String conatctNo) {
		this.contactNo = conatctNo;
	}

	public String getGSTno() {
		return GSTno;
	}

	public void setGSTno(String gSTno) {
		GSTno = gSTno;
	}

	public ShopType getShopType() {
		return shopType;
	}

	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Shop(Integer id, String shopName, String contactNo, String gSTno, ShopType shopType, String address,
			String description) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.contactNo = contactNo;
		this.GSTno = gSTno;
		this.shopType = shopType;
		this.address = address;
		this.description = description;
	}

}
