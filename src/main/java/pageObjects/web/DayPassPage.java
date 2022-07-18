package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class DayPassPage  extends CommonOps
{
	public WebElement select(String locator) 
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));
		
	}
	public WebElement commonlocator(String locator) 
	{
		return driver.findElement(By.xpath("//li[text()='"+locator+"']"));
	}
	
	public WebElement opt(String locator) 
	{
		return driver.findElement(By.linkText(locator));
	}
	
	public WebElement selectDate(String locator) 
	{
		return driver.findElement(By.xpath("//button[contains(text(),'"+locator+"')]"));
	}
	
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
    public WebElement continueBtn;
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Skip & Pay')]")
    public WebElement skipAndPayBtn;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm & Pay')]")
    public WebElement confirmAndPayBtn;
    
    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Day Pass at')]")
    public WebElement dayPassHeader;
    
    
  
  
  
	
}
