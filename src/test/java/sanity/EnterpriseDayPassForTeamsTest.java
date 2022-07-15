package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class EnterpriseDayPassForTeamsTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to Select Enterprise (Day pass option)")
    @Description("This test verifies that User is able to Select Enterprise (Day pass option)")
    public void test01_SelectDayPassForTeams() throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.cityOne);
    	click(webLoading.buildingTwo);
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	if(webLoading.dayPassOptn.isEnabled())
    	{
    		click(webLoading.dayPassOptn);
        	click(webLoading.getInTouchButton);
        	updateText(getInTouch.fullName, getData("Username"));
            updateText(getInTouch.workEmail, getData("email"));
            updateText(getInTouch.phoneNumber, getData("phoneNumber"));
            scrollToElement(getInTouch.companySizeDrpdwn);
            click(getInTouch.companySizeDrpdwn);
            click(getInTouch.CompanySize50);
            scrollToElement(getInTouch.noRadioBtn);
            mouseHover(getInTouch.noRadioBtn);
            click(getInTouch.getInTouchButton);
            Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
            String actualText = webLoading.FormSubbmittedMsg.getText();
            Verifications.verifyText(actualText,"Form Submitted Successfully");
    		
    	}
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test02 - Verify User is able to Select Enterprise in Pune(Day pass option)",dataProvider = "PuneDayPassWorkspaces")
    @Description("This test verifies that User is able to Select Enterprise in Pune(Day pass option)")
    public void test02_SelectDayPassForTeamsInPune(String city , String buildingName) throws InterruptedException
    {	
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.select(city));
    	click(webLoading.select(buildingName));
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	click(webLoading.dayPassOptn);
    	click(webLoading.getInTouchButton);
    	updateText(getInTouch.fullName, getData("Username"));
        updateText(getInTouch.workEmail, getData("email"));
        updateText(getInTouch.phoneNumber, getData("phoneNumber"));
        scrollToElement(getInTouch.companySizeDrpdwn);
        click(getInTouch.companySizeDrpdwn);
        click(getInTouch.CompanySize50);
        scrollToElement(getInTouch.noRadioBtn);
        mouseHover(getInTouch.noRadioBtn);
        click(getInTouch.getInTouchButton);
        Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test03 - Verify User is able to Select Enterprise in Hyderabad(Day pass option)",dataProvider = "HyderabadDayPassWorkspaces")
    @Description("This test verifies that User is able to Select Enterprise in Hyderabad(Day pass option)")
    public void test03_SelectDayPassForTeamsInHyderabad(String city , String buildingName) throws InterruptedException
    {	
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.select(city));
    	click(webLoading.select(buildingName));
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	click(webLoading.dayPassOptn);
    	click(webLoading.getInTouchButton);
    	updateText(getInTouch.fullName, getData("Username"));
        updateText(getInTouch.workEmail, getData("email"));
        updateText(getInTouch.phoneNumber, getData("phoneNumber"));
        scrollToElement(getInTouch.companySizeDrpdwn);
        click(getInTouch.companySizeDrpdwn);
        click(getInTouch.CompanySize50);
        scrollToElement(getInTouch.noRadioBtn);
        mouseHover(getInTouch.noRadioBtn);
        click(getInTouch.getInTouchButton);
        Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test04 - Verify User is able to Select Enterprise in Delhi(Day pass option)",dataProvider = "DelhiNCRDayPassWorkspaces")
    @Description("This test verifies that User is able to Select Enterprise in Delhi(Day pass option)")
    public void test04_SelectDayPassForTeamsInDelhi(String city , String buildingName) throws InterruptedException
    {	
		WebFlows.loadWebsite();
    	WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	Verifications.elementIsVisible(webLoading.locationDropdown);
    	click(webLoading.locationDropdown);
    	click(webLoading.select(city));
    	click(webLoading.select(buildingName));
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	click(webLoading.dayPassOptn);
    	click(webLoading.getInTouchButton);
    	updateText(getInTouch.fullName, getData("Username"));
        updateText(getInTouch.workEmail, getData("email"));
        updateText(getInTouch.phoneNumber, getData("phoneNumber"));
        scrollToElement(getInTouch.companySizeDrpdwn);
        click(getInTouch.companySizeDrpdwn);
        click(getInTouch.CompanySize50);
        scrollToElement(getInTouch.noRadioBtn);
        mouseHover(getInTouch.noRadioBtn);
        click(getInTouch.getInTouchButton);
        Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test05 - Verify User is able to Select Enterprise in Bengaluru(Day pass option)",dataProvider = "BengaluruDayPassWorkspaces")
    @Description("This test verifies that User is able to Select Enterprise in Bengaluru(Day pass option)")
    public void test05_SelectDayPassForTeamsInBengaluru(String city , String buildingName) throws InterruptedException
    {	
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.select(city));
    	click(webLoading.select(buildingName));
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	click(webLoading.dayPassOptn);
    	click(webLoading.getInTouchButton);
    	updateText(getInTouch.fullName, getData("Username"));
        updateText(getInTouch.workEmail, getData("email"));
        updateText(getInTouch.phoneNumber, getData("phoneNumber"));
        scrollToElement(getInTouch.companySizeDrpdwn);
        click(getInTouch.companySizeDrpdwn);
        click(getInTouch.CompanySize50);
        scrollToElement(getInTouch.noRadioBtn);
        mouseHover(getInTouch.noRadioBtn);
        click(getInTouch.getInTouchButton);
        Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test06 - Verify User is able to Select Enterprise in Mumbai(Day pass option)",dataProvider = "MumbaiDayPassWorkspaces")
    @Description("This test verifies that User is able to Select Enterprise in Mumbai(Day pass option)")
    public void test06_SelectDayPassForTeamsInMumbai(String city , String buildingName) throws InterruptedException
    {	
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.enterpriseBtn);
    	click(webLoading.enterpriseBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.select(city));
    	click(webLoading.select(buildingName));
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	click(webLoading.dayPassOptn);
    	click(webLoading.getInTouchButton);
    	updateText(getInTouch.fullName, getData("Username"));
        updateText(getInTouch.workEmail, getData("email"));
        updateText(getInTouch.phoneNumber, getData("phoneNumber"));
        scrollToElement(getInTouch.companySizeDrpdwn);
        click(getInTouch.companySizeDrpdwn);
        click(getInTouch.CompanySize50);
        scrollToElement(getInTouch.noRadioBtn);
        mouseHover(getInTouch.noRadioBtn);
        click(getInTouch.getInTouchButton);
        Verifications.elementIsVisible(webLoading.FormSubbmittedMsg);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@DataProvider(name="PuneDayPassWorkspaces")
	public Object[][] puneDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Pune","Kharadi"},
			{"Pune","Magarpatta"}
			};
	}
	
	@DataProvider(name="HyderabadDayPassWorkspaces")
	public Object[][] hyderabadDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Financial District"},
			{"Hyderabad","Hitec City"}
			};
	}
	
	@DataProvider(name="DelhiNCRDayPassWorkspaces")
	public Object[][] delhiNCRDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Delhi-NCR","Sector 15 Gurgaon"},
			{"Delhi-NCR","Cybercity"},
			{"Delhi-NCR","Noida Sector 160"},
			{"Delhi-NCR","Bristol Chowk"},
			{"Delhi-NCR","Golf Course Road"},
			{"Delhi-NCR","Udyog Vihar"}
			};
	}
	
	@DataProvider(name="BengaluruDayPassWorkspaces")
	public Object[][] bengaluruDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Bengaluru","Koramangala"},
			{"Bengaluru","MG Road"},
			{"Bengaluru","Bannerghatta Main Rd"},
			{"Bengaluru","Infantry Road"},
			{"Bengaluru","Domlur"},
			{"Bengaluru","Bellandur"},
			{"Bengaluru","Hebbal"},
			{"Bengaluru","Mahadevapura"}
			};
	}
	
	@DataProvider(name="MumbaiDayPassWorkspaces")
	public Object[][] mumbaiDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Mumbai","Nariman Point"},
			{"Mumbai","Goregaon East"},
			{"Mumbai","Vikhroli West"},
			{"Mumbai","Thane"},
			{"Mumbai","Andheri East"},
			{"Mumbai","Powai"},
			{"Mumbai","Navi Mumbai"},
			{"Mumbai","Malad"},
			{"Mumbai","Worli"},
			{"Mumbai","BKC"}
		};
	}

	
}
