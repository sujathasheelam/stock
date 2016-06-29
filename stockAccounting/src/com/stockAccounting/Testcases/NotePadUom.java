package com.stockAccounting.Testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.stockAccounting.Master.StockMaster;

public class NotePadUom {

	public static void main(String[] args) throws IOException, InterruptedException {
		StockMaster sm=new StockMaster();
		String x="";
		String path="C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UOM.txt";
		String Rpath="C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Results\\UomRes.txt";
		FileReader fr=new FileReader(path);
		BufferedReader br=new BufferedReader(fr);
		br.readLine();
		FileWriter fw=new FileWriter(Rpath);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Uid&Desc&Result");
		bw.newLine();
		sm.stockAccount_Launch(sm.URL);
		sm.stockAccount_Login(sm.uname, sm.pword);
		while((x=br.readLine())!=null)
		{
			System.out.println(x);
			String[] split=x.split("&");
			String U=split[0];
			String D=split[1];
			System.out.println(U+"--"+D);
			String res=sm.stockAcc_UnitofMcreation(U, D);
			bw.write(x+"&"+res);
			bw.newLine();
		}
		bw.close();
		br.close();
		sm.stockAccount_Logout();
		sm.stockAccount_Close();
	}

}
