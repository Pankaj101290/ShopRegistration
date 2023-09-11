package com.ShopRegistration.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ShopRegistration.Entity.Shop;
import com.ShopRegistration.EnumsDBconException.DBCon;
import com.ShopRegistration.EnumsDBconException.ShopType;

public class ShopRepositoryImpl implements ShopRepository {

	@Override
	public Shop insertShop(Shop shop) throws ClassNotFoundException, SQLException {
		Connection con = DBCon.connectDB();
		Statement st = con.createStatement();

		String query = "insert into shop_details(shopName,contactNo,GSTno,shopType,address,description) values(\""
				+ shop.getShopName() + "\",\"" + shop.getContactNo() + "\",\"" + shop.getGSTno() + "\",\""
				+ shop.getShopType() + "\",\"" + shop.getAddress() + "\",\"" + shop.getDescription() + "\");";
		System.out.println(query);
		st.executeUpdate(query);

		try {
			if (con != null || !con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("SQL Exception");
			// System.out.println(e.getMessage());
		}

		return shop;
	}

	@Override
	public List<Shop> findAllShops() {
		List<Shop> list = new ArrayList<Shop>();
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String query = "select * from shop_details;";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Shop shop = new Shop();
				// shopName,contactNo,GSTno,shopType,address,description
				Integer id = rs.getInt("id");
				String shopName = rs.getString("shopName");
				String contactNo = rs.getString("contactNo");
				String GSTno = rs.getString("GSTno");
				String shopType = rs.getString("shopType");
				String address = rs.getString("address");
				String description = rs.getString("description");

				shop.setId(id);
				shop.setShopName(shopName);
				shop.setContactNo(contactNo);
				shop.setGSTno(GSTno);
				if (shopType.equalsIgnoreCase("cement")) {
					shop.setShopType(ShopType.Cement);
				} else if (shopType.equalsIgnoreCase("curtains")) {
					shop.setShopType(ShopType.Curtains);
				} else if (shopType.equalsIgnoreCase("Electrical")) {
					shop.setShopType(ShopType.Electrical);
				} else if (shopType.equalsIgnoreCase("Fabrication")) {
					shop.setShopType(ShopType.Fabrication);
				} else if (shopType.equalsIgnoreCase("Furniture")) {
					shop.setShopType(ShopType.Furniture);
				} else if (shopType.equalsIgnoreCase("Hardware")) {
					shop.setShopType(ShopType.Hardware);
				} else if (shopType.equalsIgnoreCase("Plumbing")) {
					shop.setShopType(ShopType.Plumbing);
				} else if (shopType.equalsIgnoreCase("SandNBricks")) {
					shop.setShopType(ShopType.SandNBricks);
				} else if (shopType.equalsIgnoreCase("TilesNCeramics")) {
					shop.setShopType(ShopType.TilesNCeramics);
				}
				shop.setAddress(address);
				shop.setDescription(description);
				list.add(shop);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null || !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("SQL Exception");
				// System.out.println(e.getMessage());
			}
		}
		return list;
	}

	@Override
	public Shop searchShopByShopName(String shopName) {
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String query = "SELECT * FROM mydb.shop_details where shopName='" + shopName + "';";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				Shop shop = new Shop();
				Integer id = rs.getInt("id");
				String shopNam = rs.getString("shopName");
				String contactNo = rs.getString("contactNo");
				String GSTno = rs.getString("GSTno");
				String shopType = rs.getString("shopType");
				String address = rs.getString("address");
				String description = rs.getString("description");

				shop.setId(id);
				shop.setShopName(shopNam);
				shop.setContactNo(contactNo);
				shop.setGSTno(GSTno);
				if (shopType.equalsIgnoreCase("cement")) {
					shop.setShopType(ShopType.Cement);
				} else if (shopType.equalsIgnoreCase("curtains")) {
					shop.setShopType(ShopType.Curtains);
				} else if (shopType.equalsIgnoreCase("Electrical")) {
					shop.setShopType(ShopType.Electrical);
				} else if (shopType.equalsIgnoreCase("Fabrication")) {
					shop.setShopType(ShopType.Fabrication);
				} else if (shopType.equalsIgnoreCase("Furniture")) {
					shop.setShopType(ShopType.Furniture);
				} else if (shopType.equalsIgnoreCase("Hardware")) {
					shop.setShopType(ShopType.Hardware);
				} else if (shopType.equalsIgnoreCase("Plumbing")) {
					shop.setShopType(ShopType.Plumbing);
				} else if (shopType.equalsIgnoreCase("SandNBricks")) {
					shop.setShopType(ShopType.SandNBricks);
				} else if (shopType.equalsIgnoreCase("TilesNCeramics")) {
					shop.setShopType(ShopType.TilesNCeramics);
				}
				shop.setAddress(address);
				shop.setDescription(description);
				return shop;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null | !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("SQL Exception");
				// System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void updateContactNo(String contactNo, String newcontactNo) {
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String query = String.format("update shop_details set contactNo=\"%s\"where contactNo=\"%s\";",
					newcontactNo, contactNo);
			System.out.println(query);
			st.executeUpdate(query);

		} catch (Exception e) {
			throw new RuntimeException("Exception");
			// System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteShop(String shopName) {
		Connection connection = null;
		try {
			connection = DBCon.connectDB();
			Statement st = connection.createStatement();
			String query = String.format("delete from shop_details where shopName=\"%s\";", shopName);
			System.out.println(query);
			st.execute(query);
		} catch (Exception e) {
			throw new RuntimeException("Exception");
			// System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Shop> findAllShopsByShopType(ShopType shopType) {
		List<Shop> list = new ArrayList<Shop>();
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String query = "select * from shop_details where shopType='" + shopType + "';";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Shop shop = new Shop();
				Integer id = rs.getInt("id");
				String shopName = rs.getString("shopName");
				String contactNo = rs.getString("contactNo");
				String GSTno = rs.getString("GSTno");
				String shopTypee = rs.getString("shopType");
				String address = rs.getString("address");
				String description = rs.getString("description");

				shop.setId(id);
				shop.setShopName(shopName);
				shop.setContactNo(contactNo);
				shop.setGSTno(GSTno);
				if (shopTypee.equalsIgnoreCase("cement")) {
					shop.setShopType(ShopType.Cement);
				} else if (shopTypee.equalsIgnoreCase("curtains")) {
					shop.setShopType(ShopType.Curtains);
				} else if (shopTypee.equalsIgnoreCase("Electrical")) {
					shop.setShopType(ShopType.Electrical);
				} else if (shopTypee.equalsIgnoreCase("Fabrication")) {
					shop.setShopType(ShopType.Fabrication);
				} else if (shopTypee.equalsIgnoreCase("Furniture")) {
					shop.setShopType(ShopType.Furniture);
				} else if (shopTypee.equalsIgnoreCase("Hardware")) {
					shop.setShopType(ShopType.Hardware);
				} else if (shopTypee.equalsIgnoreCase("Plumbing")) {
					shop.setShopType(ShopType.Plumbing);
				} else if (shopTypee.equalsIgnoreCase("SandNBricks")) {
					shop.setShopType(ShopType.SandNBricks);
				} else if (shopTypee.equalsIgnoreCase("TilesNCeramics")) {
					shop.setShopType(ShopType.TilesNCeramics);
				}
				shop.setAddress(address);
				shop.setDescription(description);
				list.add(shop);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null || !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
				throw new RuntimeException("SQL Exception");
			}
		}
		return list;

	}

}
