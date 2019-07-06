package test;

import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import izlet.IzletMetode;
import izlet.IzletRegLog;
import utility.AutoReg;
import utility.Logger;

public class Testovi {
	
	//Metoda za otvaranje Chrome-a i stranice
	public static void testChrome(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		IzletMetode.goToPage(driver);
	}
	
	//Metoda za registrovanje korisnika i prijavljivanje istog
	public static void testReg(WebDriver driver, InputStream is) throws Exception {
		Scanner sc = new Scanner(is);
		Logger.println("Da li zelite manuelno ili auto registraciju?   'manuelno'  'auto'");
		while (true) {
			String upit = sc.nextLine();
			if (upit.contentEquals("manuelno")) {

				IzletRegLog.regKorisnika(driver, is);
				break;
			} else if (upit.contentEquals("auto")) {

				AutoReg.exelReg(driver);
				Logger.println("Zavrsili ste, izaberite novu opciju za dalje testiranje");
				break;
			} else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}		
	}
	
	//Metoda za manuelno ili auto prijavljivanje
	public static void testLogovanje(WebDriver driver, InputStream is) throws Exception {
		Scanner sc = new Scanner(is);
		Logger.println("Da li zelite da se ulogujete manuelno ili automatski?  'manuelno'  'auto'");
		while (true) {
			String autoLog = sc.nextLine();
			if (autoLog.contentEquals("manuelno")) {
				AutoReg.manuelLog(driver, is);
				break;
			} else if (autoLog.contentEquals("auto")) {
				AutoReg.exelLog(driver);
				break;
			}
			else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}

		}
	}
	
	//
	public static void testSveObjave(WebDriver driver) throws Exception {
		testSveObjave(driver, System.in);
	}
	
	//Metoda za bisanje i izmenu objava
	public static void izmenaObjave(WebDriver driver, InputStream is) {
		Scanner sc = new Scanner(is);
		Logger.println("Da li zelite da obrisete ili da izmenite objave?    'obrisi'  'izmeni'");
		while(true) {
			String izm = sc.nextLine();
			if(izm.contentEquals("obrisi")) {
				TestObjave.obrisObjava(driver, is);
				break;
			}
			else if(izm.contentEquals("izmeni")) {
				TestObjave.editObj(driver, is);
				break;
			}
			else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
		
	
	}
	
	//Metoda za manuelno ili auto objava

	public static void testSveObjave(WebDriver driver, InputStream is) throws Exception {
		Scanner sc = new Scanner(is);
		
		Logger.println("Da li zelite manuelno, auto jednog ili auto svih korisnika?   'manuelno'  'jedan'  'svi'");
		//System.out.println("Da li zelite manuelno, auto jednog ili auto svih korisnika?      'manuelno'  'jedan'  'svi'");
		while(true) {
			//System.out.println("Ucitavam string");
			String obj = sc.nextLine();
			if(obj.contentEquals("manuelno")) {
				Objave.manuelObjava(driver, is);
				break;
			}
			else if(obj.contentEquals("jedan")) {
				TestObjave.autoObjKorisnika(driver,is);
				break;
			}
			else if(obj.contentEquals("svi")) {
				TestObjave.autoObjaveSvih(driver);
				break;
			}
			else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
		
	}
	
	//Metoda za objave i izmenu
	public static void postIzObj(WebDriver driver, InputStream is) throws Exception {
		Scanner sc = new Scanner(is);
		Logger.println("Da li zelite da postavite objavu ili zelite da izmenite postojece?  'postavi'  'izmeni'");
		
		while(true) {
			String odg = sc.nextLine();
			if(odg.contentEquals("postavi")) {
				testSveObjave(driver, is);
				break;
			}
			else if(odg.contentEquals("izmeni")) {
				izmenaObjave(driver, is);
				break;
			}
			else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
	}
	
	//Metoda za back dugme
	public static void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	//Metoda za logout
	public static void logOut(WebDriver driver) {
		WebElement lg = driver.findElement(By.xpath("//a[@id='logoutBtn']"));
		lg.click();
	}
}
