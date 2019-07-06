package izlet;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.Objave;
import test.TestObjave;
import test.Testovi;
import utility.AutoReg;

public class IzletGlavna {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\driver\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		
		try {
			
			//Testovi.testChrome(driver);
			
			//Testovi.testSveObjave(driver);
			
			
			

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
