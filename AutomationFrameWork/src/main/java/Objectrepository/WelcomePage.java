package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	@FindBy(linkText = "Log in")
	private WebElement login;
	
	@FindBy(linkText = "Register")
	private WebElement register;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getRegister() {
		return register;
	}
	
}


