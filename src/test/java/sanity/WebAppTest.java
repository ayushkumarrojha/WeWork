package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import pageObjects.web.LodingPage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import static extensions.UIActions.*;

@Listeners(utilities.Listeners.class)
public class WebAppTest extends CommonOps {
    @Test(description = "Test01 - Verify Website Opens on Chrome Browser")
    @Description("This test verifies that the website is opening on the chrome browser")
    public void test01_verifyWebsite() throws InterruptedException {
        WebFlows.loadWebsite();
    }

    @Test(description = "Test02 - Verify User is able to Login and logout")
    @Description("This test verifies that User is able to login and logout")
    public void test02_verifyLogin() throws InterruptedException{
       
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
        scrollToElement(LodingPage.logout);
	    Verifications.elementIsVisible(LodingPage.logout);
	    click(LodingPage.logout);
        
        
    }

    @Test(description = "Test03 - Verify User is able to navigate to terms and services")
    @Description("This test verifies that User is able to navigate to terms and services")
    public void test03_verifyTermsAndConditions() throws InterruptedException {
        
        scrollToElement(webLonding.termsAndServices);
        Verifications.elementIsVisible(webLonding.termsAndServices);
        click(webLonding.termsAndServices);
        Verifications.verifyUrl(getPageUrl(), getData("TS"));
    }
    
    @Test(description = "Test04 - Verify User is able to Select Workspace")
    @Description("This test verifies that User is able to Select Workspace")
    public void test04_VerifyWorkspace() throws InterruptedException {
        
    	WebFlows.loginToApplication();
        scrollToElement(LodingPage.cityDropdown);
        click(LodingPage.cityDropdown);
        click(LodingPage.CityOne);
        click(LodingPage.buildingsDropdown);
        click(LodingPage.locationOne);
        click(LodingPage.buildingOne);
        click(LodingPage.exploreBtn);
        click(LodingPage.hotDeskOptn);
        click(LodingPage.bookNowBtn);
        updateText(LodingPage.name, getData("Username"));
        updateText(LodingPage.addemail, getData("email"));
        updateText(LodingPage.phoneNumber, getData("phoneNumber"));
        click(LodingPage.plusIcon);
        click(LodingPage.calendarIcon);
        click(LodingPage.clickOnDate);
        click(LodingPage.continueBtn);
        String actualText = LodingPage.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(LodingPage.backToHomePageBtn);
        WebFlows.logoutOfApplication();
        
    }
    
    
    
    
}
