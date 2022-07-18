package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectSubscriptionsTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions")
    @Description("This test verifies that User is able to select subscriptions")
    public void test01_SelectSubscriptionsForDelhi(String officeType , String selectOption, String textInHeader) throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	click(webLoading.workspaceDrpdwn);
    	click(webLoading.opt(officeType));
    	String subscriptionType = webLoading.subscriptionType.getText();
    	if(subscriptionType.contains(textInHeader))
    	{
    		click(webLoading.loctnDropdown2);
        	click(webLoading.select("Delhi-NCR"));
        	click(webLoading.buildingDropdown);
        	click(webLoading.select("Blue One Square"));
        	click(webLoading.select(selectOption));
        	Verifications.elementIsVisible(webLoading.nameField);
        	updateText(webLoading.nameField, getData("name"));
            updateText(webLoading.emailField, getData("email"));
            updateText(webLoading.phonenNumberField, getData("phoneNumber"));
            scrollToElement(webLoading.plusIcon);
			UIActions.selectNoOfPeople(1);
			UIActions.selectDate("2024", "September", "26");
            click(webLoading.continueBtn);
            String actualText = webLoading.thankyouText.getText();
            Verifications.verifyText(actualText,"Thank you for contacting WeWork");
            click(webLoading.backToHomePageBtn);
            WebFlows.logoutOfApplication();
    	}
    	else
    		Assert.assertTrue(false, "Subscription type mismatch");
        
    }
	
	@DataProvider(name="Subscriptions")
	public Object[][] subscriptions()
	{
		return new Object[][] { 
			{"Ready-to-move-in private offices","Know more","Private Office Space"},
			{"Hot desk", "Book a workspace","Hot desk"},
			{"All Access","Book a workspace","All Access"},
			{"Office suite","Enquire now","Office suite"}
			};
		
	}

}
