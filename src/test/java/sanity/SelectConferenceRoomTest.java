package sanity;

import static extensions.UIActions.clearTextBox;
import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectConferenceRoomTest extends CommonOps 
{

	@Test(description = "Test20 - Verify User is able to select conference room")
    @Description("This test verifies that User is able to select conference room")
    public void test20_SelectConferenceRoom() throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select("Delhi-NCR"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Berger Delhi One"));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("25"));
    	click(conferenceRoom.selectDate("25"));
    	scrollToElement(conferenceRoom.select("10:00 AM"));
    	click(conferenceRoom.select("10:00 AM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	click(conferenceRoom.select("Confirm & Pay"));
    	
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        click(payment.checkoutEmail);
        clearTextBox(payment.checkoutEmail);
        updateText(payment.checkoutEmail, getData("email"));
        click(payment.emailMeCheckbox);
        updateDropDown(payment.countryDropdown, "India");
        clearTextBox(payment.firstName);
        updateText(payment.firstName, getData("name"));
        clearTextBox(payment.lastName);
        updateText(payment.lastName, getData("lastName"));
        clearTextBox(payment.companyName);
        updateText(payment.companyName, getData("companyName"));
        clearTextBox(payment.address);
        updateText(payment.address, getData("address"));
        clearTextBox(payment.landmark);
        updateText(payment.landmark, getData("landMark"));
        clearTextBox(payment.city);
        updateText(payment.city, getData("city"));
        updateDropDown(payment.state, "Karnataka");
        clearTextBox(payment.PINcode);
        updateText(payment.PINcode, getData("pincode"));
        clearTextBox(payment.phoneNumber);
        updateText(payment.phoneNumber, getData("phoneNumber"));
        click(payment.saveInfoCheckbox);
        updateText(payment.coupon, getData("couponCode"));
        click(payment.applyBtn);
        String actualText = payment.couponValidationMsg.getText();
        Verifications.verifyText(actualText,"Enter a valid discount code or gift card");
        clearTextBox(payment.coupon);
        Thread.sleep(4000);
        scrollToElement(payment.continuePayment);
        mouseHover(payment.continuePayment);
        scrollToElement(payment.completeOrder);
        mouseHover(payment.completeOrder);
		
		
    }
	
}
