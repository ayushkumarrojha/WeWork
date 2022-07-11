package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class VirtualOfficePage extends CommonOps
{
	
	
	 @FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	    public  WebElement nextBtn;
	  
	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
	    public  WebElement checkoutBtn;
	
}
