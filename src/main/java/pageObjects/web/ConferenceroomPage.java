package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class ConferenceroomPage extends CommonOps
{
	public WebElement select(String locator) 
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));
		
	}
	public WebElement selectDate(String locator) 
	{
		return driver.findElement(By.xpath("//button[text()='"+locator+"']"));
		
	}
	
	public WebElement selectTime(String locator) 
	{
		return driver.findElement(By.xpath("//span[contains(text(),"+locator+"')]"));
		
	}
	
	//span[contains(text(),'9:00 AM')]
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'+')]")
    public WebElement plusIcon;
	
	@FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public WebElement calendarIcon;
	
	@FindBy(how = How.XPATH, using = "//div[@class='addBtnRow']")
    public WebElement addBtn;
	
	//span[contains(text(),'Continue')]  Confirm & Pay'
	
}
