package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;
import org.apache.logging.log4j.*;
@Listeners(utilities.Listeners.class)
public class SelectSubscriptionsTest extends CommonOps 
{
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(SelectSubscriptionsTest.class.getName());
	
	@Test(description = "Test01 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions")
    @Description("This test verifies that User is able to select subscriptions")
    public void test01_SelectSubscriptionsForDelhi(String officeType , String selectOption, String textInHeader) throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	log.info("Logged in to the application");
    	click(webLoading.workspaceDrpdwn);
    	log.info("Clicked on workspace dropdown");
    	click(webLoading.opt(officeType));
    	String subscriptionType = webLoading.subscriptionType.getText();
    	if(subscriptionType.contains(textInHeader))
    	{
    		click(webLoading.loctnDropdown2);
        	click(webLoading.select("Delhi-NCR"));
        	click(webLoading.buildingDropdown);
        	click(webLoading.select("Blue One Square"));
        	Verifications.elementIsVisible(webLoading.select(selectOption));
        	click(webLoading.select(selectOption));
        	log.info("Selected location as Delhi - Blue One square");
        	Verifications.elementIsVisible(webLoading.nameField);
        	updateText(webLoading.nameField, getData("name"));
            updateText(webLoading.emailField, getData("email"));
            updateText(webLoading.phonenNumberField, getData("phoneNumber"));
            log.info("Entered username , email and phone number details");
            scrollToElement(webLoading.plusIcon);
			UIActions.selectNoOfPeople(2);
			UIActions.selectDate("2024", "September", "26");
			log.info("Selected number of people and date");
            click(webLoading.continueBtn);
            String actualText = webLoading.thankyouText.getText();
            Verifications.verifyText(actualText,"Thank you for contacting WeWork");
            log.info("Form submission successful");
            click(webLoading.backToHomePageBtn);
            WebFlows.logoutOfApplication();
            log.info("Logged out of the application");
    	}
    	else
    	{
    		log.error("Subscription type mismatched in the header");
    		Assert.assertTrue(false, "Subscription type mismatch");
    		
    	}
    		
        
    }
	
	@DataProvider(name="Subscriptions")
	public Object[][] subscriptions()
	{
		return new Object[][] { 
			{"Ready-to-move-in private offices","Know more","Private Office Space"},
			{"Hot desk", "Book a workspace","Hot Desk"},
			{"All Access","Book a workspace","All Access"},
			{"Office suite","Enquire now","Office Suite"}
			};
		
	}

}
