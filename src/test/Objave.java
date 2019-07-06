package test;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import izlet.IzletMetode;
import utility.AutoReg;
import utility.Constant;
import utility.ExcelUtils;
import utility.Logger;

public class Objave {

	//Metoda za manuelnu objavu
	public static void manuelObjava(WebDriver driver, InputStream is) {
		Scanner sc = new Scanner(is);
		try {
		AutoReg.manuelLog(driver, is);
		
		WebElement objButton = driver.findElement(By.xpath("//a[contains(text(),'Make a post')]"));
		objButton.click();
		
		WebElement naziv = driver.findElement(By.xpath("//input[@placeholder='Naziv']"));
		Logger.println("Unesi naziv objave");
		String nazivO = sc.nextLine();
		naziv.click();
		naziv.sendKeys(nazivO);
		
		WebElement lokacija = driver.findElement(By.xpath("//input[@placeholder='Lokacija']"));
		Logger.println("Unesi lokaciju objave");
		String lokacijaO = sc.nextLine();
		lokacija.click();
		lokacija.sendKeys(lokacijaO);
		
		String filePath = "C:\\Users\\Milan\\Desktop\\Fsp\\Fsp.jpg";
		WebElement browse = driver.findElement(By.xpath("//input[@id='image']"));
		browse.sendKeys(filePath);
		
		String walk ="//div[@class='popupPost']//option[contains(text(),'Walk')]";
		String car ="//div[@class='popupPost']//option[contains(text(),'Car')]";
		String motorbike ="//div[@class='popupPost']//option[contains(text(),'Motorbike')]";
		String bicycle ="//div[@class='popupPost']//option[contains(text(),'Bicycle')]";
		String bus ="//div[@class='popupPost']//option[contains(text(),'Bus')]";
		String transAb = "";
		Logger.println("Unesi koji transport zelis: walk, car, motorbike, bicycle, bus");
		while(true) {
			String trans = sc.nextLine();
			if(trans.contentEquals("walk")) {
				transAb = walk;
				break;
			}
			else if(trans.contentEquals("car")){
				transAb = car;
				break;
			}
			else if(trans.contentEquals("motorbike")){
				transAb = motorbike;
				break;
			}
			else if(trans.contentEquals("bicycle")){
				transAb = bicycle;
				break;
			}
			else if(trans.contentEquals("bus")){
				transAb = bus;
				break;
			}
			else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
		
		WebElement tr = driver.findElement(By.xpath("//div[@class='popupPost']//select[@name='transport']"));
		tr.click();
		WebElement tr1 = driver.findElement(By.xpath(transAb));
		tr1.click();
		
		Logger.println("Unesi opis objave");
		String opis = sc.nextLine();
		WebElement text = driver.findElement(By.xpath("//textarea[@placeholder='Opis']"));
		text.click();
		text.sendKeys(opis);
						
		WebElement sub = driver.findElement(By.xpath("//div[@class='popupPost']//input[@name='postSubmit']"));
		sub.click();
		}catch(Exception e) {
			Logger.println("PRITISNI BACK DUGME");
			//driver.navigate().back();
		}
		
		
		
	}
	
	//Metoda za auto uzimanje podataka korisnika iz exela
	public static void autoPodaci(WebDriver driver, int br, int c, int e) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name1);
		IzletMetode.logIn(driver, ExcelUtils.getCellData(br, c), ExcelUtils.getCellData(br, e));
		
		}
	
	//Metoda za auto uzimanje podataka teksta iz exela
	public static void autoText(WebDriver driver, int br, int a, int b, int c) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet_Name2);
		IzletMetode.objava(driver, ExcelUtils.getCellData(br, a), ExcelUtils.getCellData(br, b), ExcelUtils.getCellData(br, c));
	}
	
	//Metoda za pronalazenje prvog elementa iz liste po class-i
	public static void obrisiDveObj(WebDriver driver, String clas) {
		List<WebElement> postovi = driver.findElements(By.className(clas));
		WebElement fe = postovi.get(0);
		fe.click();
	}
	
	
}
