package com.stockAccounting.Testcases;

import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class UnitOfMeasurementTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		StockMaster sm=new StockMaster();
		sm.stockAccount_Launch(sm.URL);
		String res=sm.stockAccount_Login("admin", "master");
		System.out.println(res);
		String res1=sm.stock_UnitMeasurement_Creation("1131","Books");
		System.out.println(res1);
		Thread.sleep(5000);
		String res2=sm.stockAccount_Logout();
		System.out.println(res2);
		sm.stockAccount_Close();
	}

}
