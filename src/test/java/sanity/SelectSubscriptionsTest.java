package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.updateText;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectSubscriptionsTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions")
    @Description("This test verifies that User is able to select subscriptions")
    public void test01_SelectSubscriptions(String officeType , String selectOption) throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	click(webLoading.workspaceDrpdwn);
    	click(webLoading.opt(officeType));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select("Delhi-NCR"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Blue One Square"));
    	click(webLoading.select(selectOption));
    	Verifications.elementIsVisible(webLoading.nameField);
    	updateText(webLoading.nameField, getData("name"));
        updateText(webLoading.emailField, getData("email"));
        updateText(webLoading.phonenNumberField, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.clickOnDate);
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        WebFlows.logoutOfApplication();
        
    }
	
	@DataProvider(name="Subscriptions")
	public Object[][] subscriptions()
	{
		return new Object[][] { 
			{"Ready-to-move-in private offices","Know more"},
			{"Hot desk", "Book a workspace"},
			{"All Access","Book a workspace"},
			{"Office suite","Enquire now"}
			};
		
	}

}
