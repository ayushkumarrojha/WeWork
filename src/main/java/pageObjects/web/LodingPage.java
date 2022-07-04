package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class LodingPage extends CommonOps{

//    @FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/div[3]/a")
//    public WebElement enterpriseButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), ''{0}'')]")
    public static WebElement commonlocator;
	
    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[3]/div/div/div/div[3]/div/a[2]")
    public WebElement termsAndServices;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[1]")
    public static  WebElement cityDropdown;
    
    @FindBy(how = How.XPATH, using = "//p[text()='Bengaluru']")
    public static WebElement CityOne;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[2]")
    public static WebElement buildingsDropdown;
    
    @FindBy(how = How.XPATH, using = "//p[text()='MG Road']")
    public static WebElement locationOne;
    
    @FindBy(how = How.XPATH, using = "//p[text()='Galaxy']")
    public static WebElement buildingOne;
    
    @FindBy(how = How.XPATH, using = "//button[text()='Explore Solutions']")
    public static WebElement exploreBtn;
    
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Hot desk')]")
    public static WebElement hotDeskOptn;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Book Now')]")
    public static WebElement bookNowBtn;
    
    @FindBy(how = How.XPATH, using = "(//input[@name='full_name'])[2]")
    public static WebElement name;
    
    @FindBy(how = How.XPATH, using = "(//input[@name='email'])[2]")
    public static WebElement addemail;

    @FindBy(how = How.XPATH, using = "(//input[@name='phone_number'])[2]")
    public static WebElement phoneNumber;
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
    public static WebElement plusIcon;
    
    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public static WebElement calendarIcon;
    
    @FindBy(how = How.XPATH, using = "//button[text()='30']")
    public static WebElement clickOnDate;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
    public static WebElement continueBtn;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Back to homepage')]")
    public static WebElement backToHomePageBtn;
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Logout')]")
    public static WebElement logout;
    
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Thank you for contacting WeWork')]")
    public static  WebElement thankyouText;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='navWithIcon'])[1]")
    public static WebElement loc;
    
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'userName')]")
    public static WebElement userName;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiTab-iconWrapper'])[2]")
    public static WebElement enterpriseBtn;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[1]")
    public static WebElement locationDropdown;
    
    @FindBy(how = How.XPATH, using = "(//p[@class='cityName'])[1]")
    public static WebElement cityOne;
    
    @FindBy(how = How.XPATH, using = "(//p[@class='building_name'])[2]")
    public static WebElement buildingTwo;
    
    @FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[2]")
    public static WebElement noOfPplDrpdwn;
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'1-20')]")
    public static WebElement noOfPpl;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Explore Solutions')]")
    public static WebElement exploreSolnBtn;
    
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Day-pass for teams')]")
    public static WebElement dayPassOptn;
    
    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[2]")
    public static WebElement getInTouchButton;
    
    @FindBy(how = How.XPATH, using = "(//input[@type='email'])[2]")
    public static WebElement workemail;
    
    @FindBy(how = How.XPATH, using = "(//div[@aria-haspopup='listbox'])[2]")
    public static WebElement companySizeDrpdwn;
    
    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[1]")
    public static WebElement optnOne;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[8]")
    public static WebElement brokerRadioBtn;
    
    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CloseIcon']")
    public static WebElement closeIcon;
    
    public static void commonLocator(String locator)
    {
    	driver.findElement((By) commonlocator);
    	
    }
    
    
}
