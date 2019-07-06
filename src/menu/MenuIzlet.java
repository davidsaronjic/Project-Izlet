package menu;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.Testovi;
import utility.Logger;

public class MenuIzlet   {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		MainFrame mf =new MainFrame("Izlet Menu", driver);
		Testovi.testChrome(driver);
		
		mf.setVisible(true);
		Logger.println("                                                         IZLET");
		Logger.println("                                 kada zelite da pobegnete na dan...");
		Logger.println("\n                            Dobrodosli u meni za testiranje sajta 'Izlet'");
		mf.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				if(driver!=null)
					try {
					driver.quit();
					}catch (Exception e2) {
					
					}
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
			
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

	}


}
