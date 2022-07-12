package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;

import org.testng.annotations.DataProvider;
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
        closeCurrentWindow();
    }

    @Test(description = "Test02 - Verify User is able to Login and logout")
    @Description("This test verifies that User is able to login and logout")
    public void test02_verifyLoginandLogout() throws InterruptedException{
       
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
        
        scrollToElement(webLoading.termsAndServices);
        Verifications.elementIsVisible(webLoading.termsAndServices);
        click(webLoading.termsAndServices);
        Verifications.verifyUrl(getPageUrl(), getData("TS"));
        scrollToElement(webLogin.weWorkLoginButton);
    }
    
    @Test(description = "Test04 - Verify User is able to Select Workspace")
    @Description("This test verifies that User is able to Select Workspace")
    public void test04_VerifySelectWorkspace() throws InterruptedException {
        
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
    
        
    
	@Test(description = "Test05 - Verify User is able to Select Enterprise")
    @Description("This test verifies that User is able to Select Enterprise")
    public void test05_VerifySelectenterprise() throws InterruptedException
    {
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
    	updateText(webLoading.name, getData("Username"));
        updateText(webLoading.workemail, getData("email"));
        updateText(webLoading.phoneNumber, getData("phoneNumber"));
        scrollToElement(webLoading.companySizeDrpdwn);
        click(webLoading.companySizeDrpdwn);
        click(webLoading.optnOne);
        scrollToElement(webLoading.brokerRadioBtn);
        mouseHover(webLoading.brokerRadioBtn);
        click(webLoading.getInTouchButton);
        String actualText = webLoading.FormSubbmittedMsg.getText();
        Verifications.verifyText(actualText,"Form Submitted Successfully");
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    	
    }	
	@Test(description = "Test06 - Verify User is able to Select contact us option")
    @Description("This test verifies that User is able to Select contact us option")
    public void test06_ContactUs() throws InterruptedException
    {
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
    
	@Test(description = "Test07 - Verify User is able to Select Event spaces")
    @Description("This test verifies that User is able to Select Event spaces")
    public void test07_VerifyEventspace() throws InterruptedException
    {
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
	
    @Test(description = "Test08 - Verify User is able to Book a Tour")
    @Description("This test verifies that User is able to Book a Tour")
    public void test08_BookATour() throws InterruptedException
    {
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
	
	@Test(description = "Test09 - Verify User is able to select day pass")
    @Description("This test verifies that User is able to select day pass")
    public void test09_SelectDaypass() throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	String currentWindow = getWindowHandel();
    	click(webLoading.workspace);
    	click(webLoading.opt("Day pass"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select("Mumbai"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Zenia"));
    	click(webLoading.select("Book a workspace"));
    	mouseHover(webLoading.selectDate("Jul 28, 2022"));
    	click(webLoading.continueButton);
    	click(webLoading.select("Skip & Pay"));
    	click(webLoading.select("Confirm & Pay"));
    	String childwindow = getWindowHandels();
    	switchToParentWindow(childwindow);
    	Thread.sleep(4000);
    	switchToParentWindow(currentWindow);
    	click(webLoading.closeIcon); 
    	WebFlows.logoutOfApplication();
    	
    }
	
	@Test(description = "Test10 - Verify User is able to select hot desk option")
    @Description("This test verifies that User is able to select hot desk option")
    public void test10_SelectHotDesk() throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	Thread.sleep(4000);
    	click(webLoading.workspace);
    	click(webLoading.opt("Hot desk"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select("Mumbai"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Zenia"));
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
	
	@Test(description = "Test11 - Verify User is able to select private offices")
    @Description("This test verifies that User is able to select private offices")
    public void test11_SelectPrivateOfficeSpace() throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	click(webLoading.workspace);
    	click(webLoading.opt("Ready-to-move-in private offices"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select("Delhi-NCR"));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select("Blue One Square"));
    	click(webLoading.select("Know more"));
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
	
	@Test(description = "Test12 - Verify User is able to Select virtual office")
    @Description("This test verifies that User is able to Select virtual office")
    public void test12_VerifySelectVirtualOffice() throws InterruptedException
    {
    	scrollToElement(webLoading.cityDropdown);
        click(webLoading.cityDropdown);
        click(webLoading.select("Bengaluru"));
        click(webLoading.buildingsDropdown);
        click(webLoading.select("MG Road"));
        click(webLoading.select("Galaxy"));
        click(webLoading.exploreBtn);
        String currentWindow = getWindowHandel();
        scrollToElement(webLoading.virtualOffice);
        click(webLoading.virtualOffice);
        click(webLoading.bookNowBtn);
        switchToLoginWindow(currentWindow);
        updateText(webLogin.emailTestField, getData("Username"));
        updateText(webLogin.passwordTestField, getData("Password"));
        click(webLogin.submitButton);
        switchToParentWindow(currentWindow);
        mouseHover(webLoading.bookNowBtn);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select("Prestige Cube, Koramangala"));
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select("Prestige Cube, Koramangala"));
        	mouseHover(virtualOffice.nextBtn);
        }
        Verifications.elementIsVisible(webLoading.select("24 Months"));
        if(virtualOffice.checkoutBtn.isEnabled()) //checkout btn
        {
        		click(webLoading.select("Checkout"));
        }
        else
        {
        	click(webLoading.select("24 Months"));
        	mouseHover(virtualOffice.checkoutBtn);
        }
        Verifications.elementIsVisible(webLoading.select("Proceed to Payment"));
        scrollToElement(webLoading.select("Proceed to Payment"));
        click(webLoading.select("Proceed to Payment"));
        String paymentWindow = getWindowHandels2();
        switchToParentWindow(paymentWindow);
        
        click(payment.changeBtn1);
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
        
        //closeCurrentWindow();
        //switchToParentWindow(VirtualOfficeWindow);
        //closeCurrentWindow();
        //switchToParentWindow(currentWindow);
        //click(webLoading.closeIcon);
        //WebFlows.logoutOfApplication();
        //switchToPaymentWindow(); 
        

    }

	@Test(description = "Test13 - Verify User is able to select why wework option" )
    @Description("This test verifies that User is able to select why wework option")
    public void test13_SelectWhyWework() throws InterruptedException
    {
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
	
	@Test(description = "Test14 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions")
    @Description("This test verifies that User is able to select subscriptions")
    public void test14_SelectSubscriptions(String officeType , String selectOption) throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	click(webLoading.workspace);
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
	
	@Test(description = "Test15 - Verify User is able to select Hotdesk in Pune" ,dataProvider = "PuneHotdeskWorkspaces")
    @Description("This test verifies that User is able to select Hotdesk in Pune")
    public void test15_SelectHotdeskInPune(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
        click(webLoading.cityDropdown);
        click(webLoading.select(city));
        click(webLoading.buildingsDropdown);
        click(webLoading.select(location));
        click(webLoading.select(buildingName));
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.username, getData("Username"));
        updateText(webLoading.userEmail, getData("email"));
        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.date("30"));
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test16 - Verify User is able to select Hotdesk in Hyderabad" ,dataProvider = "HyderabadHotdeskWorkspaces")
    @Description("This test verifies that User is able to select Hotdesk in Hyderabad")
    public void test16_SelectHotdeskInHyderabad(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
        click(webLoading.cityDropdown);
        click(webLoading.select(city));
        click(webLoading.buildingsDropdown);
        click(webLoading.select(location));
        click(webLoading.select(buildingName));
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.username, getData("Username"));
        updateText(webLoading.userEmail, getData("email"));
        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.date("30"));
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test17 - Verify User is able to select Hotdesk in Delhi-NCR" ,dataProvider = "DelhiNCRHotdeskWorkspaces")
    @Description("This test verifies that User is able to select Hotdesk in Delhi-NCR")
    public void test17_SelectHotdeskInDelhiNCR(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
        click(webLoading.cityDropdown);
        click(webLoading.select(city));
        click(webLoading.buildingsDropdown);
        click(webLoading.select(location));
        click(webLoading.select(buildingName));
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.username, getData("Username"));
        updateText(webLoading.userEmail, getData("email"));
        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.date("30"));
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
       // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test18 - Verify User is able to select Hotdesk in Bengaluru" ,dataProvider = "BengaluruHotdeskWorkspaces")
    @Description("This test verifies that User is able to select Hotdesk in Bengaluru")
    public void test18_SelectHotdeskInBengaluru(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
        click(webLoading.cityDropdown);
        click(webLoading.select(city));
        click(webLoading.buildingsDropdown);
        click(webLoading.select(location));
        click(webLoading.select(buildingName));
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.username, getData("Username"));
        updateText(webLoading.userEmail, getData("email"));
        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.date("30"));
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.elementIsVisible(webLoading.thankyouText);
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        Thread.sleep(4000);
       // WebFlows.logoutOfApplication();
        
    } 
	
	@Test(description = "Test19 - Verify User is able to select Hotdesk in Mumbai" ,dataProvider = "MumbaiHotdeskWorkspaces")
    @Description("This test verifies that User is able to select Hotdesk in Mumbai")
    public void test19_SelectHotdeskInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
        click(webLoading.cityDropdown);
        click(webLoading.select(city));
        click(webLoading.buildingsDropdown);
        scrollToElement(webLoading.select(location));
        click(webLoading.select(location));
        scrollToElement(webLoading.select(buildingName));
        click(webLoading.select(buildingName));
        scrollToElement(webLoading.exploreBtn);
        click(webLoading.exploreBtn);
        click(webLoading.hotDeskOptn);
        click(webLoading.bookNowBtn);
        updateText(webLoading.username, getData("Username"));
        updateText(webLoading.userEmail, getData("email"));
        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
        click(webLoading.plusIcon);
        click(webLoading.calendarIcon);
        click(webLoading.date("30"));
        click(webLoading.continueBtn);
        String actualText = webLoading.thankyouText.getText();
        Verifications.elementIsVisible(webLoading.thankyouText);
        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
        click(webLoading.backToHomePageBtn);
        Thread.sleep(4000);
       // WebFlows.logoutOfApplication();
        
        
    } 
	
	
	@Test(description = "Test20 - Verify User is able to select conference room")
    @Description("This test verifies that User is able to select conference room")
    public void test20_SelectConferenceRoom() throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspace);
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
    
	@Test(description = "Test21 - Verify User is able to select events and workspaces")
    @Description("This test verifies that User is able to select events and workspaces")
    public void test21_SelectEventsAndWorkspaces() throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspace);
        click(webLoading.opt("Event and shoot spaces"));
        click(webLoading.getInTouchButton);
        scrollToElement(events.select("Name*"));
        updateText(events.opt("Name*"), getData("name"));
        updateText(events.opt("Email*"), getData("email"));
        updateText(events.opt("Company name*"), getData("companyName"));
        updateText(events.opt("Phone*"), getData("phoneNumber"));
        mouseHover(events.noRadioBtn1);
        Thread.sleep(4000);
        click(events.calendarIcon);
        click(events.selectDate("29"));
        click(events.clockIcon);
        scrollToElement(events.selectHour("6 hours"));
        mouseHover(events.selectHour("6 hours"));
       // click(events.selectHour("6"));
        scrollToElement(events.selectMinute("40 minutes"));
        mouseHover(events.selectMinute("40 minutes"));
       // click(events.selectMinute("30"));
        click(events.plusIcon);
        mouseHover(events.cityDropdown);
       // click(events.cityDropdown);
        //scrollToElement(events.select("Pune"));
        mouseHover(events.selectlocation("Pune"));
        scrollToElement(events.buildingDropdown);
        mouseHover(events.buildingDropdown);
        mouseHover(events.selectlocation("Panchshil Futura"));
        Thread.sleep(2000);
        mouseHover(events.yesRadioBtn2);
       // scrollToElement(events.select("Panchshil Futura"));
       
        scrollToElement(events.eventTypeDropdown);
        mouseHover(events.eventTypeDropdown);
        scrollToElement(events.select("Shoots"));
        mouseHover(events.select("Shoots"));
        Thread.sleep(2000);
        mouseHover(events.yesRadioBtn3);
        mouseHover(events.productionRadioBtn);
        mouseHover(events.select("Submit Enquiry"));
       
        
    }
	
	@Test(description = "Test22 - Verify User is able to select private office in Pune",dataProvider = "PuneHotdeskWorkspaces")
    @Description("This test verifies that User is able to select private office in Pune")
    public void test22_SelectPrivateOfficeInPune(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.privateOfficeOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test23 - Verify User is able to select private office in Hyderabad",dataProvider = "HyderabadHotdeskWorkspaces")
    @Description("This test verifies that User is able to select private office in Hyderabad")
    public void test23_SelectPrivateOfficeInHyderabad(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.privateOfficeOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test24 - Verify User is able to select private office in Delhi",dataProvider = "DelhiNCRHotdeskWorkspaces")
    @Description("This test verifies that User is able to select private office in Delhi")
    public void test24_SelectPrivateOfficeInDelhi(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.privateOfficeOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test25 - Verify User is able to select private office in Bengaluru",dataProvider = "BengaluruHotdeskWorkspaces")
    @Description("This test verifies that User is able to select private office in Bengaluru")
    public void test25_SelectPrivateOfficeInBengaluru(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.privateOfficeOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test26 - Verify User is able to select private office in Mumbai",dataProvider = "MumbaiHotdeskWorkspaces")
    @Description("This test verifies that User is able to select private office in Mumbai")
    public void test26_SelectPrivateOfficeInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loginToApplication();
				scrollToElement(webLoading.workspaceBtn);
		        click(webLoading.cityDropdown);
		        click(webLoading.select(city));
		        click(webLoading.buildingsDropdown);
		        scrollToElement(webLoading.select(location));
		        click(webLoading.select(location));
		        scrollToElement(webLoading.select(buildingName));
		        click(webLoading.select(buildingName));
		        scrollToElement(webLoading.exploreBtn);
		        click(webLoading.exploreBtn);
		        click(webLoading.privateOfficeOptn);
		        click(webLoading.bookNowBtn);
		        updateText(webLoading.username, getData("Username"));
		        updateText(webLoading.userEmail, getData("email"));
		        updateText(webLoading.userPhnNumber, getData("phoneNumber"));
		        click(webLoading.plusIcon);
		        click(webLoading.calendarIcon);
		        click(webLoading.date("30"));
		        click(webLoading.continueBtn);
		        String actualText = webLoading.thankyouText.getText();
		        Verifications.elementIsVisible(webLoading.thankyouText);
		        Verifications.verifyText(actualText,"Thank you for contacting WeWork");
		        click(webLoading.backToHomePageBtn);
		        Thread.sleep(4000);
		       // WebFlows.logoutOfApplication();             
     
        
    }
	
	@Test(description = "Test27 - Verify User is able to select all access in Pune",dataProvider = "PuneHotdeskWorkspaces")
    @Description("This test verifies that User is able to select all access in Pune")
    public void test27_SelectAllAccessInPune(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.AllAccessOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test28 - Verify User is able to select all access in Hyderabad",dataProvider = "HyderabadHotdeskWorkspaces")
    @Description("This test verifies that User is able to select all access in Hyderabad")
    public void test28_SelectAllAccessInHyderabad(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.AllAccessOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test29 - Verify User is able to select all access in Delhi",dataProvider = "DelhiNCRHotdeskWorkspaces")
    @Description("This test verifies that User is able to select all access in Delhi")
    public void test29_SelectAllAccessInDelhi(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.AllAccessOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test29 - Verify User is able to select all access in Bengaluru",dataProvider = "BengaluruHotdeskWorkspaces")
    @Description("This test verifies that User is able to select all access in Bengaluru")
    public void test30_SelectAllAccessInBengaluru(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.AllAccessOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test29 - Verify User is able to select all access in Mumbai",dataProvider = "MumbaiHotdeskWorkspaces")
    @Description("This test verifies that User is able to select all access in Mumbai")
    public void test31_SelectAllAccessInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
        
      //WebFlows.loginToApplication();
      scrollToElement(webLoading.workspaceBtn);
      click(webLoading.cityDropdown);
      click(webLoading.select(city));
      click(webLoading.buildingsDropdown);
      click(webLoading.select(location));
      click(webLoading.select(buildingName));
      click(webLoading.exploreBtn);
      click(webLoading.AllAccessOptn);
      click(webLoading.bookNowBtn);
      updateText(webLoading.username, getData("Username"));
      updateText(webLoading.userEmail, getData("email"));
      updateText(webLoading.userPhnNumber, getData("phoneNumber"));
      click(webLoading.plusIcon);
      click(webLoading.calendarIcon);
      click(webLoading.date("30"));
      click(webLoading.continueBtn);
      String actualText = webLoading.thankyouText.getText();
      Verifications.elementIsVisible(webLoading.thankyouText);
      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
      click(webLoading.backToHomePageBtn);
      Thread.sleep(4000);
   // WebFlows.logoutOfApplication();
        
    }
	

	@DataProvider(name="Subscriptions")
	public Object[][] data()
	{
		return new Object[][] { 
			{"Ready-to-move-in private offices","Know more"},
			{"Hot desk", "Book a workspace"},
			{"All Access","Book a workspace"},
			{"Office suite","Enquire now"}
			};
		
	}
	
	@DataProvider(name="PuneHotdeskWorkspaces")
	public Object[][] puneHotdeskWorkspaces()
	{
		return new Object[][] { 
			{"Pune","Kharadi","World Trade Center"},
			{"Pune","Magarpatta","Panchshil Futura"}
			};
		
	}
	
	@DataProvider(name="HyderabadHotdeskWorkspaces")
	public Object[][] hyderabadHotdeskWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Financial District","Rajapushpa Summit"},
			{"Hyderabad","Hitec City","Krishe Emerald"}
			};
		
	}
	
	@DataProvider(name="DelhiNCRHotdeskWorkspaces")
	public Object[][] delhiNCRHotdeskWorkspaces()
	{
		return new Object[][] { 
			{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
			{"Delhi-NCR","Cybercity","DLF Forum"},
			{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
			{"Delhi-NCR","Bristol Chowk","Platina Tower"},
			{"Delhi-NCR","Golf Course Road","Two Horizon Centre"},
			{"Delhi-NCR","Udyog Vihar","Blue One Square"},
			{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
			};
	}
	
	@DataProvider(name="BengaluruHotdeskWorkspaces")
	public Object[][] bengaluruHotdeskWorkspaces()
	{
		return new Object[][] { 
			{"Bengaluru","Koramangala","Prestige Atlanta"},
			{"Bengaluru","Koramangala","Prestige Cube"},
			
			{"Bengaluru","MG Road","The Pavilion"},
			{"Bengaluru","MG Road","Galaxy"},
			{"Bengaluru","MG Road","Embassy Quest"},
			
			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
			
			{"Bengaluru","Infantry Road","Prestige Central"},
			
			{"Bengaluru","Domlur","Sunriver, EGL"}, //hotdesk not available
			//{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //hotdesk not available
			
			{"Bengaluru","Bellandur","Embassy TechVillage"},
			{"Bengaluru","Bellandur","Vaishnavi Signature"},
			
			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
			{"Bengaluru","Hebbal","Manyata NXT"},
			
			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}
	
	@DataProvider(name="MumbaiHotdeskWorkspaces")
	public Object[][] mumbaiHotdeskWorkspaces()
	{
		return new Object[][] { 
			{"Mumbai","Nariman Point","Express Towers"},
			{"Mumbai","Goregaon East","Oberoi Commerz II"},
			{"Mumbai","Goregaon East","NESCO IT Park"},
			{"Mumbai","Vikhroli West","247 Park"},
			{"Mumbai","Thane","Zenia"},
			{"Mumbai","Andheri East","Vijay Diamond"},
			{"Mumbai","Andheri East","Raheja Platinum"},
			{"Mumbai","Powai","Chromium"},
			{"Mumbai","Navi Mumbai","Seawoods Grand Central"},
			{"Mumbai","Malad","Spectrum Tower"},
			{"Mumbai","Worli","Vaswani Chambers"},
			{"Mumbai","BKC","Enam Sambhav"}
			};
		
	}
	
  	
}
