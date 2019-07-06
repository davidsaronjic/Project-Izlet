package test;

import java.io.InputStream;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import izlet.IzletMetode;
import utility.AutoReg;
import utility.Constant;
import utility.ExcelUtils;
import utility.Logger;

public class TestObjave {

	//Metoda za auto objave po korisniku
	public static void autoObjaveSvih(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name1);
		int rowCount = ExcelUtils.getWorkSheet().getLastRowNum();
		int a = 0, b = 1, c = 2, e = 4;
		for (int i = 1; i <= rowCount; i++) {
			Objave.autoPodaci(driver, i, c, e);
			Objave.autoText(driver, i, a, b, c);
			IzletMetode.logOut(driver);
		}
	}

	//Metoda za auto objave jednog korisnika
	public static void autoObjKorisnika(WebDriver driver, InputStream is) throws Exception {
		Scanner sc = new Scanner(is);
		AutoReg.manuelLog(driver, is);
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name2);
		int rowCount = ExcelUtils.getWorkSheet().getLastRowNum();
		int a = 0, b = 1, c = 2;
		for (int i = 1; i <= rowCount; i++) {
			Objave.autoText(driver, i, a, b, c);
		}
	}

	//Metoda za brisanje objave
	public static void obrisObjava(WebDriver driver, InputStream is) {
		Scanner sc = new Scanner(is);
		try {
		AutoReg.manuelLog(driver, is);
		Logger.println("Da li zelite da obrisete nekoliko objava od prve?   da ili ne");
		String tacke = "fa-ellipsis-v";
		String korpa = "fa-trash-alt";
		while (true) {
			String odg = sc.nextLine();
			if (odg.contentEquals("da")) {
				Logger.println("Koliko objava zelite da obrisete?");
				while (true) {
					try {
						String fx = sc.nextLine();
						int fe = Integer.parseInt(fx);
						for (int i = 1; i <= fe; i++) {
							Objave.obrisiDveObj(driver, tacke);
							Objave.obrisiDveObj(driver, korpa);
						}
						break;
					} 
					catch (NumberFormatException e) {
						Logger.println("POGRESAN ODGOVOR");
						continue;
					}
				}
				break;
			}

			else if (odg.contentEquals("ne")) {
				Logger.println("Niste obrisali objave");
				break;
			} else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
		}catch(Exception e) {
			Logger.println("PRITISNI BACK DUGME");
		}
	}
	
	//Metoda za izmenu objave
	public static void editObj(WebDriver driver, InputStream is) {
		Scanner sc = new Scanner(is);
		try {
		AutoReg.manuelLog(driver, is);
		String tacke = "fa-ellipsis-v";
		String edit = "fa-edit";
		Objave.obrisiDveObj(driver, tacke);
		Objave.obrisiDveObj(driver, edit);
		
		WebElement naziv = driver.findElement(By.xpath("//input[@id='title']"));
		Logger.println("Unesite novi naziv");
		String nz = sc.nextLine();
		naziv.click();
		naziv.clear();
		naziv.sendKeys(nz);
		
		WebElement lokacija = driver.findElement(By.xpath("//input[@id='location']"));
		Logger.println("Unesite novu lokaciju");
		String lo = sc.nextLine();
		lokacija.click();
		lokacija.clear();
		lokacija.sendKeys(lo);
		
		WebElement text = driver.findElement(By.xpath("//textarea[@id='description']"));
		Logger.println("Unesite novi text");
		String tx = sc.nextLine();
		text.click();
		text.clear();
		text.sendKeys(tx);
		
		WebElement postButton = driver.findElement(By.xpath("//div[@class='popupEdit']//input[@name='postSubmit']"));
		postButton.click();
	}catch(Exception e) {
		Logger.println("PRITISNI BACK DUGME");
		}
	}
	
	
	
}
