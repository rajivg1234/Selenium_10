package Jenkin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class pollscm {
	@Test
	public void test() {
		WebDriver driver=new ChromeDriver();
		Reporter.log("pollscm added", true);
		
	}
	

}
