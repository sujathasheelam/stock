package com.stockAccounting.Testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.stockAccounting.Master.StockMaster;

public class KeywordDrivenScript
{
	@Test
	public void driverscript() throws IOException, InterruptedException
	{
		StockMaster sm=new StockMaster();
		String res = null;
		String xlpath="C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\keyword.xlsx";
		String xlOut="C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Results\\keyout.xlsx";
		FileInputStream fi=new FileInputStream(xlpath);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws1=wb.getSheet("TestCase");
		XSSFSheet ws2=wb.getSheet("TestSteps");
		XSSFSheet ws3=wb.getSheet("Testdata");
		
		int tcRc=ws1.getLastRowNum();
		int tsRc=ws2.getLastRowNum();
		
		for (int i = 1; i <= tcRc; i++) 
		{
			String tcExe=ws1.getRow(i).getCell(2).getStringCellValue();
			
			if (tcExe.equalsIgnoreCase("Y"))
			{
				String tcId=ws1.getRow(i).getCell(0).getStringCellValue();
				
				for (int j = 0; j < tsRc; j++)
				{
					String tsId=ws2.getRow(j).getCell(0).getStringCellValue();
					if (tcId.equalsIgnoreCase(tsId)) 
					{
						String key=ws2.getRow(j).getCell(3).getStringCellValue();
						switch (key)
						{
						case "sLanch":
							res=sm.stockAccount_Launch(sm.URL);
							break;
							
						case "sLogin":	
							res=sm.stockAccount_Login(sm.uname, sm.pword);
							break;
						case "sLogout":	
							res=sm.stockAccount_Logout();
							sm.stockAccount_Close();
							break;
						case "sSupplier":
							String supname=ws3.getRow(1).getCell(0).getStringCellValue();
							String add=ws3.getRow(1).getCell(1).getStringCellValue();
							String city=ws3.getRow(1).getCell(2).getStringCellValue();
							String cntry=ws3.getRow(1).getCell(3).getStringCellValue();
							String cperson=ws3.getRow(1).getCell(4).getStringCellValue();
							String pno=ws3.getRow(1).getCell(5).getStringCellValue();
							String email=ws3.getRow(1).getCell(6).getStringCellValue();
							String mno=ws3.getRow(1).getCell(7).getStringCellValue();
							String notes=ws3.getRow(1).getCell(8).getStringCellValue();
							res=sm.stockAcc_Supplier(supname, add, city, cntry, cperson, pno, email, mno, notes);
							break;
						case "sCat":
							String catname=ws3.getRow(1).getCell(9).getStringCellValue();
							res=sm.stockAcc_stockcatCreation(catname);
							break;
						case "sUom":
							String Uid=ws3.getRow(1).getCell(10).getStringCellValue();
							String Udesc=ws3.getRow(1).getCell(11).getStringCellValue();
							res=sm.stockAcc_UnitofMcreation(Uid, Udesc);
							break;
							
						default:
							System.out.println("Select a proper keyword");
							break;
						}
						ws2.getRow(j).createCell(4).setCellValue(res);
						
						
						if (!ws2.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail")) 
						{
							ws1.getRow(i).createCell(3).setCellValue(res);
						}
						else
						{
							ws1.getRow(i).createCell(3).setCellValue("Fail");
						}
						
					}
					
				}
				
			}
			else
			{
				ws1.getRow(i).createCell(3).setCellValue("BLOCKED");
			}
			FileOutputStream fo=new FileOutputStream(xlOut);
			wb.write(fo);
			wb.close();
		}
		
		
	}
	

}

	
	

