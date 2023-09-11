package com.ShopRegistration.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ShopRegistration.DTOs.ShopDTO;
import com.ShopRegistration.EnumsDBconException.ShopType;
import com.ShopRegistration.Service.ShopService;
import com.ShopRegistration.Service.ShopServiceImpl;

public class UIMethods {
	private static ShopService shopService = new ShopServiceImpl();

	public static void registerShop() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Shop name");
		String name = sc.nextLine();

		System.out.println("Enter the shop contact number");
		String contactNo = sc.nextLine();
//		Pattern p = Pattern.compile("[6-9][0-9]{9}");
//
//		Matcher m = p.matcher(sc.nextLine());
//		if (m.matches()) {
//			contactNo = sc.nextLine();
//		} else {
//			System.out.println("Contact no is not in format");
//			System.exit(0);
//		}

		System.out.println("Enter the shop GSTno");
		String GSTno = sc.nextLine();;
//		Pattern p1 = Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}");
//
//		Matcher m1 = p1.matcher(sc.nextLine());
//		if (m1.matches()) {
//			GSTno = sc.nextLine();
//		} else {
//			System.out.println("GST no is not in format");
//			System.exit(0);
//		}

		System.out.println("Enter shop Address");
		String Address = sc.nextLine();

		System.out.println("Enter shop Description");
		String Description = sc.nextLine();

		System.out.println("Enter the ShopType(Select 0 for Cement, 1 for Curtains, 2 for Electrical, "
				+ "3 for Fabrication, 4 for Furniture, 5 for Hardware, "
				+ "6 for Plumbing, 7 for SandNBricks, 8 for TilesNCeramics)");
		int shopTypeId = sc.nextInt();
		ShopType shopType = null;
		if (shopTypeId == 0) {
			shopType = ShopType.Cement;
		} else if (shopTypeId == 1) {
			shopType = ShopType.Curtains;
		} else if (shopTypeId == 2) {
			shopType = ShopType.Electrical;
		} else if (shopTypeId == 3) {
			shopType = ShopType.Fabrication;
		} else if (shopTypeId == 4) {
			shopType = ShopType.Furniture;
		} else if (shopTypeId == 5) {
			shopType = ShopType.Hardware;
		} else if (shopTypeId == 6) {
			shopType = ShopType.Plumbing;
		} else if (shopTypeId == 7) {
			shopType = ShopType.SandNBricks;
		} else if (shopTypeId == 8) {
			shopType = ShopType.TilesNCeramics;
		}

		ShopDTO shopDTO = new ShopDTO(name, contactNo, GSTno, shopType, Address, Description);
		shopDTO = shopService.registerShop(shopDTO);
		System.out.println("Client registered Successfully" + shopDTO);
		sc.close();
	}

	public static void viewListOfRegisteredShop() {
		List<ShopDTO> list = shopService.viewAllShop();
		for (ShopDTO sd : list) {
			System.out.println(sd);
		}
	}

	public static void searchShopByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the Shop Name");
		String name = scanner.nextLine().trim();
		ShopDTO sd = shopService.serchShopbyName(name);
		System.out.println(sd);
		scanner.close();
	}

	public static void updateShopContactNo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the old contact number of shop");
		String oldNo = scanner.next().trim();
		System.out.println("Please Enter the new contact number of shop");
		String newNo = scanner.next().trim();
		String s = shopService.updateShopbyContactNo(oldNo, newNo);
		System.out.println(s);
		scanner.close();
	}

	public static void deleteShop() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the name of shop you want to delete");
		String name = scanner.nextLine().trim();
		name.equalsIgnoreCase(name);
		String s = shopService.deleteShop(name);
		System.out.println(s);
		scanner.close();
	}

	public static void searchListOfShopByShopType() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter thes shop Type do you want to search");
		System.out.println("Select 0 for Cement, 1 for Curtains, 2 for Electrical, "
				+ "3 for Fabrication, 4 for Furniture, 5 for Hardware, "
				+ "6 for Plumbing, 7 for SandNBricks, 8 for TilesNCeramics)");
		int shopTypeId = scanner.nextInt();
		ShopType shopType = null;
		if (shopTypeId == 0) {
			shopType = ShopType.Cement;
		} else if (shopTypeId == 1) {
			shopType = ShopType.Curtains;
		} else if (shopTypeId == 2) {
			shopType = ShopType.Electrical;
		} else if (shopTypeId == 3) {
			shopType = ShopType.Fabrication;
		} else if (shopTypeId == 4) {
			shopType = ShopType.Furniture;
		} else if (shopTypeId == 5) {
			shopType = ShopType.Hardware;
		} else if (shopTypeId == 6) {
			shopType = ShopType.Plumbing;
		} else if (shopTypeId == 7) {
			shopType = ShopType.SandNBricks;
		} else if (shopTypeId == 8) {
			shopType = ShopType.TilesNCeramics;
		}
		List<ShopDTO> list = shopService.findShopsByShopType(shopType);
		for (ShopDTO sd : list) {
			System.out.println(sd);
		}
		scanner.close();
	}
}
