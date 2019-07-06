package izlet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IzletMetode {
	
	//Metoda za otvaranje stranice
	public static void goToPage(WebDriver driver) {
		driver.get("http://localhost/izlet/");
	}
	
	//Metoda za postavljanje imena i prezimena u registraciji
	public static void fullName(WebDriver driver, String fn, String ln) {

		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.click();
		firstName.sendKeys(fn);
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.click();
		lastName.sendKeys(ln);
	}
	
	//Metoda za postavljanje korisnickog imena u registraciji
	public static void userName(WebDriver driver, String un) {
		WebElement uName = driver.findElement(By.xpath("//div[@class='register_form']//input[@name='username']"));
		uName.click();
		uName.sendKeys(un);
	}
	
	//Metoda za postavljanje email-a u registraciji
	public static void eMail(WebDriver driver, String em) {
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.click();
		email.sendKeys(em);
	}
	
	//Metoda za postavljanje sifre u registraciji
	public static void passWord(WebDriver driver, String pas) {
		WebElement pass = driver.findElement(By.xpath("//div[@class='register_form']//input[@name='password']"));
		pass.click();
		pass.sendKeys(pas);
	}
	
	//Metoda za pritisak dugmeta za zavrsavanje registracije
	public static void regButton(WebDriver driver) {
		WebElement reg = driver.findElement(By.xpath("//input[@id='blue_btn']"));
		reg.click();
	}
	
	//Metoda za prijavljivanje korisnika koji se upravo registrovao
	public static void logIn(WebDriver driver, String name, String pass) {
		//try {
		WebElement logN = driver.findElement(By.xpath("//input[@placeholder='username']"));
		logN.click();
		logN.sendKeys(name);
		WebElement logP = driver.findElement(By.xpath("//input[@placeholder='password']"));
		logP.click();
		logP.sendKeys(pass);
		WebElement logButton = driver.findElement(By.xpath("//input[@name='login']"));
		logButton.click();
		}//catch (Exception e) {
		//	driver.navigate().back();
		//}
	//}
	
	//Metoda za odjavljivanje
	public static void logOut(WebDriver driver) {
		WebElement logO = driver.findElement(By.xpath("//a[@id='logoutBtn']"));
		logO.click();
	}
		
	//Metoda za objavu post-a
	public static void objava(WebDriver driver, String a, String b, String c) {
		WebElement objButton = driver.findElement(By.xpath("//a[contains(text(),'Make a post')]"));
		objButton.click();
		
		WebElement naziv = driver.findElement(By.xpath("//input[@placeholder='Naziv']"));
		naziv.click();
		naziv.sendKeys(b);
		
		WebElement lokacija = driver.findElement(By.xpath("//input[@placeholder='Lokacija']"));
		lokacija.click();
		lokacija.sendKeys(c);
		
		WebElement text = driver.findElement(By.xpath("//textarea[@placeholder='Opis']"));
		text.click();
		text.sendKeys(a);
						
		WebElement sub = driver.findElement(By.xpath("//div[@class='popupPost']//input[@name='postSubmit']"));
		sub.click();
	}

}
