package com.stockAccounting.Testcases;

import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class CategoryCreationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		StockMaster sm=new StockMaster();
		sm.stockAccount_Launch(sm.URL);
		sm.stockAccount_Login("admin", "master");
		sm.stocK_Category_Creation("keyboards");
		sm.stockAccount_Logout();
		sm.stockAccount_Close();
		
	}

}
