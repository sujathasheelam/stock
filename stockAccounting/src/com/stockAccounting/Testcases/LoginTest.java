package com.stockAccounting.Testcases;

import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class LoginTest {

	public static void main(String[] args) throws IOException {
		StockMaster sm=new StockMaster();
		String res=sm.stockAccount_Launch(sm.URL);
		System.out.println(res);
		res=sm.stockAccount_Login("admin", "master");
	System.out.println(res);

	}

}
