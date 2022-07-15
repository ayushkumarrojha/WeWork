package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;
import static extensions.UIActions.*;


@Listeners(utilities.Listeners.class)
public class WebAppTest extends CommonOps 
{
	@Test(description = "Test01 - Verify Website Opens on Chrome Browser")
    @Description("This test verifies that the website is opening on the chrome browser")
    public void test01_verifyWebsite() throws InterruptedException {
        WebFlows.loadWebsite();
    }

    @Test(description = "Test02 - Verify User is able to Login and logout")
    @Description("This test verifies that User is able to login and logout")
    public void test02_verifyLoginandLogout() throws InterruptedException{
    	WebFlows.loadWebsite();
        String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(webLogin.weWorkLoginButton);
        click(webLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);
        updateText(webLogin.emailTestField, getData("Username"));
        updateText(webLogin.passwordTestField, getData("Password"));
        click(webLogin.submitButton);
        switchToParentWindow(currentWindow);
        waitForLoad();
        Verifications.verifyTextInElement(webLogin.userName, getData("user"));
        scrollToElement(webLoading.logout);
	    Verifications.elementIsVisible(webLoading.logout);
	    click(webLoading.logout); 
        
    }

    @Test(description = "Test03 - Verify User is able to navigate to terms and services")
    @Description("This test verifies that User is able to navigate to terms and services")
    public void test03_verifyTermsAndConditions() throws InterruptedException {
    	WebFlows.loadWebsite();
        scrollToElement(webLoading.termsAndServices);
        Verifications.elementIsVisible(webLoading.termsAndServices);
        click(webLoading.termsAndServices);
        Verifications.verifyUrl(getPageUrl(), getData("TS"));
        scrollToElement(webLoading.logout);
	    Verifications.elementIsVisible(webLoading.logout);
	    click(webLoading.logout);
    }
    
    @Test(description = "Test04 - Verify User is able to Select hotdesk Workspace")
    @Description("This test verifies that User is able to Select hotdesk  Workspace")
    public void test04_VerifySelectHotDeskWorkspace() throws InterruptedException {
    	WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
        scrollToElement(webLoading.cityDropdown);
        click(webLoading.cityDropdown);
        click(webLoading.CityOne);
        click(webLoading.buildingsDropdown);
        click(webLoading.locationOne);
        click(webLoading.buildingOne);
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.name, getData("name"));
        updateText(webLoading.addemail, getData("email"));
        updateText(webLoading.phoneNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.clickOnDate);
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        WebFlows.logoutOfApplication();
    } 
    
        
    
	@Test(description = "Test05 - Verify User is able to Select Enterprise (Day pass option)")
    @Description("This test verifies that User is able to Select Enterprise (Day pass option)")
    public void test05_VerifySelectenterprise() throws InterruptedException
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
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    	
    }	
	
    
	@Test(description = "Test06 - Verify User is able to Select Event spaces")
    @Description("This test verifies that User is able to Select Event spaces")
    public void test06_VerifyEventspace() throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.eventSpacesBtn);
    	click(webLoading.eventSpacesBtn);
    	click(webLoading.locationDropdown);
    	click(webLoading.cityOne);
    	click(webLoading.buildingTwo);
    	click(webLoading.noOfPplDrpdwn);
    	click(webLoading.noOfPpl);
    	click(webLoading.exploreSolnBtn);
    	updateText(webLoading.name, getData("Username"));
        updateText(webLoading.workemail, getData("email"));
        updateText(webLoading.phoneNumber, getData("phoneNumber"));
        scrollToElement(webLoading.getInTouchButton);
        click(webLoading.getInTouchButton);
        click(webLoading.closeIcon); 
        WebFlows.logoutOfApplication();
    }
	
    @Test(description = "Test07 - Verify User is able to Book a Tour")
    @Description("This test verifies that User is able to Book a Tour")
    public void test07_VerifyBookATour() throws InterruptedException
    {
    	WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	scrollToElement(webLoading.bookATourBtn);
    	click(webLoading.bookATourBtn);
    	updateText(webLoading.fullName, getData("name"));
        updateText(webLoading.email, getData("email"));
        updateText(webLoading.phnNumber, getData("phoneNumber"));
        click(webLoading.loctnDropdown1);
        click(webLoading.CityTwo);
        click(webLoading.buildingsDrpdwn);
        click(webLoading.buildingThree);
        click(webLoading.iAmIntrestedInDrpdwn); 
        click(webLoading.events); 
        click(webLoading.calendarIcon);
        click(webLoading.clickOnDate);
        mouseHover(webLoading.clockIcon);
        mouseHover(webLoading.hour);
        mouseHover(webLoading.minute);
        scrollToElement(webLoading.getInTouchBtn);
        click(webLoading.getInTouchBtn);
        WebFlows.logoutOfApplication();
    	
    }

	@Test(description = "Test08 - Verify User is able to select why wework option" )
    @Description("This test verifies that User is able to select why wework option")
    public void test08_SelectWhyWework() throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(webhome.whyWEWorkButton);
		click(webLoading.select("Discover workspaces"));
		click(webLoading.allAccessButton);
		click(webLoading.loctnDropdown2);
    	click(webLoading.select("Delhi-NCR"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Blue One Square"));
    	click(webLoading.select("Book a workspace"));
    	updateText(webLoading.fullName, getData("name"));
        updateText(webLoading.email, getData("email"));
        updateText(webLoading.phnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.clickOnDate);
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test09 - Verify User is able to Select contact us option")
    @Description("This test verifies that User is able to Select contact us option")
    public void test09_VerifyContactUsFeature() throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	click(webLoading.contactUsBtn);
    	scrollToElement(webLoading.fullName);
    	Verifications.elementIsVisible(webLoading.fullName);
    	updateText(webLoading.fullName, getData("name"));
        updateText(webLoading.email, getData("email"));
        updateText(webLoading.phnNumber, getData("phoneNumber"));
        scrollToElement(webLoading.loctnDropdown);
        click(webLoading.loctnDropdown); 
        click(webLoading.CityTwo);
        mouseHover(webLoading.scheduleVistiBtn); 
        click(webLoading.getInTouchBtn);
        WebFlows.logoutOfApplication();
    	
    } 
	
}
