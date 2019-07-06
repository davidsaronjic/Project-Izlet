package izlet;

import java.io.InputStream;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import utility.Logger;

public class IzletRegLog {

	//Metoda za registrovanje korisnika i prijavljivanje istog
	public static void regKorisnika(WebDriver driver, InputStream is) {

		Scanner sc = new Scanner(is);
		//IzletMetode.goToPage(driver);
		Logger.println("Unesi ime");
		String fn = sc.nextLine();
		Logger.println("Unesi prezime");
		String ls = sc.nextLine();
		IzletMetode.fullName(driver, fn, ls);
		Logger.println("Unesi korisnicko ime");
		String un = sc.nextLine();
		IzletMetode.userName(driver, un);
		Logger.println("Unesi email");
		String em = sc.nextLine();
		IzletMetode.eMail(driver, em);
		Logger.println("Unesi sifru");
		String pass = sc.nextLine();
		IzletMetode.passWord(driver, pass);
		IzletMetode.regButton(driver);
		Logger.println("Da li zelite da se ulogujete?   yes ili no");
		while (true) {
			String zelja = sc.nextLine();

			if (zelja.contentEquals("yes")) {
				IzletMetode.logIn(driver, un, pass);
				break;
			} else if (zelja.contentEquals("no")) {
				Logger.println("Niste ulogovani");
				break;
			} else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
		Logger.println("Da li zelite da se izlogujete?   yes ili no");
		while (true) {
			String zelja2 = sc.nextLine();
			if (zelja2.contentEquals("yes")) {
				IzletMetode.logOut(driver);
				break;
			} else if (zelja2.contentEquals("no")) {
				Logger.println("Niste se izlogovali");
				break;
			} else {
				Logger.println("POGRESAN ODGOVOR");
				continue;
			}
		}
	}

}
