package com.stockAccounting.Testcases;

import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class LogOutTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		StockMaster sm=new StockMaster();
		String res=sm.stockAccount_Launch(sm.URL);
		System.out.println(res);
		res=sm.stockAccount_Login("admin", "master");
	System.out.println(res);
		sm.stockAccount_Logout();
		sm.stockAccount_Close();
	}

}
