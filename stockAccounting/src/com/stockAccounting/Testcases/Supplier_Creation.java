package com.stockAccounting.Testcases;

import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class Supplier_Creation {

	public static void main(String[] args) throws IOException  {
		
		StockMaster sm=new StockMaster();
		String launch=sm.stockAccount_Launch(sm.URL);
		System.out.println(launch);
		String login=sm.stockAccount_Login("admin", "master");
	System.out.println(login);
	String supplier = sm.stockAcc_Supplier("qedgetechnologies", "Ameerpet", "Hyderabad", "India", "xyz", "1111111111", "vvv", "5555555555", "provides training");
		System.out.println(supplier);

	}

}
