package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.CommonOps;

import static extensions.UIActions.click;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text Element As Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch: text.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element, For Two Elements")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element, For A Single Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Refresh Page")
    public static void refreshPage (){
        driver.navigate().refresh();
    }

    @Step("Switch to Login Window")
    public static void switchToLoginWindow(String currentWindow){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows) {
            if(window != currentWindow){
                driver.switchTo().window(window);
            }
        }
    }

    @Step("Switch to Parent Window")
    public static void switchToParentWindow(String currentWindow) throws InterruptedException{
        driver.switchTo().window(currentWindow);
        Thread.sleep(3000);
    }
    
    @Step("Get Current Window Handel")
    public static String getWindowHandels(){
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        String parentWindow = window.next();
        String childwindow1 = window.next();
        return childwindow1;
        
    }
    
    @Step("Get Current Window Handel")
    public static String getWindowHandels2(){
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        String parentWindow = window.next();
        String childwindow1 = window.next();
        String childwindow2 = window.next();
        return childwindow2;
    }
    
    @Step("Get Current Window Handel")
    public static String getWindowHandel(){
        return driver.getWindowHandle();
    }

    @Step ("Get current page title")
    public static String getPageTitle(){
        return driver.getTitle();
    }

    @Step ("Get current page title")
    public static String getPageUrl(){
        return driver.getCurrentUrl();
    }

    @Step ("Scroll to Element")
    public static void scrollToElement (WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
    }
    
    @Step ("Clear text box")
    public static void clearTextBox (WebElement element) throws InterruptedException {
    	element.clear();
    }
    
    @Step ("Select date in Calander UI")
    public static void selectDate(String year, String month, String date) throws InterruptedException
    {
		webLoading.calendarIcon.click();
		Verifications.elementIsVisible(webLoading.yearDropdown);
		webLoading.yearDropdown.click();
		Thread.sleep(1000);
		int yearINT = Integer.parseInt(year);
		
		if(yearINT < 2022)
			Assert.assertTrue(false, "Invalid year selection");
		
		List<WebElement> yearsList = driver.findElements(
				By.xpath("//div[@class='PrivatePickersYear-root PrivatePickersYear-modeDesktop css-j9zntq']//button"));
		Thread.sleep(3000);
		for (int i = 0; i < yearsList.size(); i++) 
		{
			String currentyear = yearsList.get(i).getText();
			if (currentyear.equalsIgnoreCase(year)) 
			{
				if (yearsList.get(i).isEnabled()) 
				{
					yearsList.get(i).click();
					break;
				}
			}
		}
		while (!webLoading.monthName.getText().contains(month)) 
		{
			webLoading.rightArrowBtn.click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'dayWithMargin')]"));
		int count = dates.size();
		for (int j = 0; j < count; j++) 
		{
			String currentDate = dates.get(j).getText();
			if (currentDate.contains(date)) 
			{
				dates.get(j).click();
				Thread.sleep(1000);
				break;
			}
		}
    			
    }
    
    @Step ("Get current page title")
    public static void selectNoOfPeople(int count)
    {
    	if(count == 1)
    	{
    		return;
    	}
    		
    	for(int i=1;i<count;i++)
    	{
    		click(webLoading.plusIcon);
    	}
    	
    }

    @Step ("Select date in Calander UI")
    public static void selectDate(String month, String date) throws InterruptedException
    {
    	while (!webLoading.monthName.getText().contains(month)) 
		{
			webLoading.rightArrowBtn.click();
		}
    	
		List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'dayWithMargin')]"));
		int count = dates.size();
		for (int j = 0; j < count; j++) 
		{
			String currentDate = dates.get(j).getText();
			if (currentDate.contains(date)) 
			{
				String attributeValue = dates.get(j).getAttribute("class");
				if(attributeValue.contains("Mui-disabled"))
				{
					System.out.println("Please select weeekdays");
					
				}
				else
				{
					dates.get(j).click();
					Thread.sleep(1000);
					break;
				}
				
			}
		}
		
    
    }
    
    @Step ("Get current page title")
    public static void closeCurrentWindow(){
         driver.close();
    }
}
