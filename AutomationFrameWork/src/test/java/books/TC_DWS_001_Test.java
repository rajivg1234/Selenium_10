package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListencersUtility;
import Objectrepository.HomePage;

@Listeners(ListencersUtility.class)

public class TC_DWS_001_Test extends BaseClass{
	@Test
	
	public void clickOnBooks() {
		HomePage hp=new HomePage(driver);
		hp.getBooks().click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Books","Books page is not displayed");
		test.log(Status.PASS, "Books page is not displayed");
		
	}
}
