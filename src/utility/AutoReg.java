package utility;

import java.io.InputStream;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import izlet.IzletMetode;

public class AutoReg {
	
	//Metoda za automatsko registrovanje korisnika iz exela
	public static void exelReg(WebDriver driver) throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name1);
		
		//IzletMetode.goToPage(driver);
		
		int rowCount = ExcelUtils.getWorkSheet().getLastRowNum();
		int a = 0, b = 1, c = 2, d = 3, e = 4;
		for(int i = 1; i <= rowCount; i++) {
		
		IzletMetode.fullName(driver, ExcelUtils.getCellData(i, a), ExcelUtils.getCellData(i, b));
		
		IzletMetode.userName(driver, ExcelUtils.getCellData(i, c));
		
		IzletMetode.eMail(driver, ExcelUtils.getCellData(i, d));
		
		IzletMetode.passWord(driver, ExcelUtils.getCellData(i, e));
		
		IzletMetode.regButton(driver);
		
		}
	}
		
	//Metoda za automatsko prijavljivanje korisnika iz exela
	public static void exelLog(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name1);
		int rowCount = ExcelUtils.getWorkSheet().getLastRowNum();
		int c = 2, e = 4;
		for(int i = 1; i <= rowCount; i++) {
		IzletMetode.logIn(driver, ExcelUtils.getCellData(i, c), ExcelUtils.getCellData(i, e));
		IzletMetode.logOut(driver);
		}
	}
	
	//Metoda za rucno prijavljivanje
	public static void manuelLog(WebDriver driver, InputStream is) {
		Scanner sc = new Scanner(is);
		try {
		Logger.println("Unesi vazece korisnicko ime");
		String un = sc.nextLine();
		Logger.println("Unesi vazecu sifru");
		Logger.println("");
		Logger.println("Ukoliko ste uneli ne vazece podatke pritisnite BACK dugme");
		String pass = sc.nextLine();
		IzletMetode.logIn(driver, un, pass);
		}catch(Exception e) {
			Logger.println("PRITISNI BACK DUGME");
		}
	}

}
