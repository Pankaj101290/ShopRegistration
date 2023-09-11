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

public class UI extends UIMethods {
//	private static ShopService shopService = new ShopServiceImpl();

	public static void methodCalling() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Enter the Type of operation do you want to perform(Select 0 for Shop Registration, 1 for View List of registered Shops, 2 for Search shop by Name, "
						+ "3 for Update Shop Contact No , 4 for Delete Shop details from database, 5 for search list of shop by Shop type) ");
		Integer i = scanner.nextInt();
		if (i == 0) {
			registerShop();
		} else if (i == 1)
			viewListOfRegisteredShop();
		else if (i == 2)
			searchShopByName();
		else if (i == 3)
			updateShopContactNo();
		else if (i == 4)
			deleteShop();
		else if (i == 5)
			searchListOfShopByShopType();
//		scanner.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner1 = new Scanner(System.in);
		String c;
		do {
			methodCalling();
			System.out.println("Enter y to perform more operations and Enter n to exit the program");
			c = scanner1.next().toLowerCase();
		} while (c.equals("y") || c.equals("yes")); //
		System.out.println("Thank you. Please visit again!");
		scanner1.close();
	}

}
