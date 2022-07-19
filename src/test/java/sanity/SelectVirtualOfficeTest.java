package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.getWindowHandels2;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToLoginWindow;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateText;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectVirtualOfficeTest extends CommonOps 
{

/*	@Test(description = "Test01 - Verify User is able to Select virtual office")
    @Description("This test verifies that User is able to Select virtual office")
    public void test01_VerifySelectVirtualOfficeWithoutLogginIn() throws InterruptedException
    {
		WebFlows.loadWebsite();
    	scrollToElement(webLoading.cityDropdown);
        click(webLoading.cityDropdown);
        click(webLoading.select("Bengaluru"));
        click(webLoading.buildingsDropdown);
        click(webLoading.select("MG Road"));
        click(webLoading.select("Galaxy"));
        click(webLoading.exploreBtn);
        String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if(virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		}
		else
		{
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
			scrollToElement(webLoading.select("Salarpuria Magnificia, Old Madras Rd"));
			click(webLoading.select("Salarpuria Magnificia, Old Madras Rd"));
			mouseHover(virtualOffice.nextBtn);
	        Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
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
	        if(Verifications.elementIsPresent(payment.changeBtn1))
			{
				click(payment.changeBtn1);
				
			}
	        WebFlows.proceedWithPayment();
	        Thread.sleep(2000);
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(VirtualOfficeWindow);
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        click(webLoading.closeIcon);
	        WebFlows.logoutOfApplication();
		}
    }*/
	
	@Test(description = "Test02 - Verify User is able to Select virtual office in Pune", dataProvider = "PuneVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Pune")
    public void test02_VerifySelectVirtualOfficeInPune(String city , String location, String buildingName , String locNameInPaymentPage) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		Verifications.elementIsVisible(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled")) {
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.VirtualOfficeOptn);
			click(webLoading.bookNowBtn);
			Thread.sleep(4000);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			
			click(webLoading.select("Select Building"));
			Verifications.elementIsVisible(webLoading.select(location));
			scrollToElement(webLoading.select(location));
			click(webLoading.select(location));
			mouseHover(virtualOffice.nextBtn);
			Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
	        {
	        		click(webLoading.select("Checkout"));
	        }
	        else
	        {
	        	click(webLoading.select("24 Months"));
	        	mouseHover(virtualOffice.checkoutBtn);
	        }
	        
	        String locationInHeader = virtualOffice.verifyLocation(locNameInPaymentPage).getText();
	        if(locationInHeader.contains(locNameInPaymentPage))
	        {
	        	Thread.sleep(2000);
	        	Verifications.elementIsVisible(webLoading.select("Proceed to Payment"));
				scrollToElement(webLoading.select("Proceed to Payment"));
				click(webLoading.select("Proceed to Payment"));
				String paymentWindow = getWindowHandels2();
				switchToParentWindow(paymentWindow);
				
//				boolean value = payment.changeBtn1.isDisplayed();
//				System.out.println(value);
//				boolean value2 = payment.changeBtn1.isEnabled();
//				System.out.println(value2);
				
//				if(Verifications.elementIsPresent(payment.changeBtn1))
//				{
//					click(payment.changeBtn1);
//					
//				}
//				else
//				{
					WebFlows.proceedWithPayment();
					Thread.sleep(2000);
					UIActions.closeCurrentWindow();
					switchToParentWindow(VirtualOfficeWindow);
					UIActions.closeCurrentWindow();
					switchToParentWindow(currentWindow);
					mouseHover(webLoading.closeIcon);
					WebFlows.logoutOfApplication();
				//}
	
	        }
	        else
	        {
	        	Assert.assertTrue("Location name mismatch in Payment window", false);
	        }
	        
			
		}
		 
    }
	
/*	@Test(description = "Test03 - Verify User is able to Select virtual office in Hyderabad", dataProvider = "HyderabadVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Hyderabad")
    public void test03_VerifySelectVirtualOfficeInHyderabad(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		Verifications.elementIsVisible(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled")) {
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.VirtualOfficeOptn);
			click(webLoading.bookNowBtn);
			Thread.sleep(4000);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			click(webLoading.select("Select Building"));
			Verifications.elementIsVisible(webLoading.select(location));
			scrollToElement(webLoading.select(location));
			click(webLoading.select(location));
			mouseHover(virtualOffice.nextBtn);
			Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
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
			if(Verifications.elementIsPresent(payment.changeBtn1))
			{
				click(payment.changeBtn1);
				
			}
			WebFlows.proceedWithPayment();
			Thread.sleep(2000);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(currentWindow);
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		}
    }
	
	@Test(description = "Test04 - Verify User is able to Select virtual office in Delhi", dataProvider = "DelhiNCRVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Delhi")
    public void test04_VerifySelectVirtualOfficeInDelhi(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		Verifications.elementIsVisible(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled")) {
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.VirtualOfficeOptn);
			click(webLoading.bookNowBtn);
			Thread.sleep(4000);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			click(webLoading.select("Select Building"));
			Verifications.elementIsVisible(webLoading.select(location));
			scrollToElement(webLoading.select(location));
			click(webLoading.select(location));
			mouseHover(virtualOffice.nextBtn);
			Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
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
			if(Verifications.elementIsPresent(payment.changeBtn1))
			{
				click(payment.changeBtn1);
				
			}
			WebFlows.proceedWithPayment();
			Thread.sleep(2000);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(currentWindow);
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		}
    }
	
	@Test(description = "Test05 - Verify User is able to Select virtual office in Bengaluru", dataProvider = "BengaluruVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Bengaluru")
    public void test05_VerifySelectVirtualOfficeInBengaluru(String city , String location, String buildingName, String locNameInPaymentPage) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		Verifications.elementIsVisible(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled")) {
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.VirtualOfficeOptn);
			click(webLoading.bookNowBtn);
			Thread.sleep(4000);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			click(webLoading.select("Select Building"));
			Verifications.elementIsVisible(webLoading.select(buildingName));
			scrollToElement(webLoading.select(buildingName));
			click(webLoading.select(buildingName));
			mouseHover(virtualOffice.nextBtn);
			Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
	        {
	        		click(webLoading.select("Checkout"));
	        }
	        else
	        {
	        	click(webLoading.select("24 Months"));
	        	mouseHover(virtualOffice.checkoutBtn);
	        }
	        
	        String locationInHeader = virtualOffice.verifyLocation(locNameInPaymentPage).getText();
	        System.out.println(locationInHeader);
	        
	        if(locationInHeader.contains(locNameInPaymentPage))
	        {
	        	System.out.println("inside loop");
	        	Verifications.elementIsVisible(webLoading.select("Proceed to Payment"));
				scrollToElement(webLoading.select("Proceed to Payment"));
				click(webLoading.select("Proceed to Payment"));
				String paymentWindow = getWindowHandels2();
				switchToParentWindow(paymentWindow);

				 String title =UIActions.getPageTitle();
				 String url=  UIActions.getPageUrl();
				     
				 System.out.println("title is "+title);
				 System.out.println("URL  is "+url);
				 
				if(Verifications.elementIsPresent(payment.changeBtn1))
				{
					click(payment.changeBtn1);
					String title2 =UIActions.getPageTitle();
					 String url2=  UIActions.getPageUrl();
					     
					 System.out.println("title2 is "+title2);
					 System.out.println("URL2  is "+url2);
					
				}
				WebFlows.proceedWithPayment();
				Thread.sleep(2000);
				UIActions.closeCurrentWindow();
				switchToParentWindow(VirtualOfficeWindow);
				UIActions.closeCurrentWindow();
				switchToParentWindow(currentWindow);
				mouseHover(webLoading.closeIcon);
				WebFlows.logoutOfApplication();
	        }
	        
			
		}
    }
	
	@Test(description = "Test06 - Verify User is able to Select virtual office in Mumbai", dataProvider = "MumbaiVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Mumbai")
    public void test06_VerifySelectVirtualOfficeInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		Verifications.elementIsVisible(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		scrollToElement(webLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = webLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled")) {
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.VirtualOfficeOptn);
			click(webLoading.bookNowBtn);
			Thread.sleep(4000);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			click(webLoading.select("Select Building"));
			Verifications.elementIsVisible(webLoading.select(location));
			scrollToElement(webLoading.select(location));
			click(webLoading.select(location));
			mouseHover(virtualOffice.nextBtn);
			Verifications.elementIsVisible(webLoading.select("24 Months"));
	        if(virtualOffice.checkoutBtn.isEnabled()) 
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
			if(Verifications.elementIsPresent(payment.changeBtn1))
			{
				click(payment.changeBtn1);
				
			}
			WebFlows.proceedWithPayment();
			Thread.sleep(2000);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(currentWindow);
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		}
    }*/
	
	
	@DataProvider(name="PuneVirtualOfficeWorkspaces")
	public Object[][] puneVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
//			{"Pune","Kharadi","World Trade Center",""}, //Virtula office not available  
			{"Pune","Magarpatta","Panchshil Futura","Futura"}
			};
		
	}
	
	@DataProvider(name="HyderabadVirtualOfficeWorkspaces")
	public Object[][] hyderabadVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Financial District","Rajapushpa Summit"},
			{"Hyderabad","Hitec City","Krishe Emerald"}
			};
		
	}
	
	@DataProvider(name="DelhiNCRVirtualOfficeWorkspaces")
	public Object[][] delhiNCRVirtualOfficeWorkspaces()
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
	
	@DataProvider(name="BengaluruVirtualOfficeWorkspaces")
	public Object[][] bengaluruVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			{"Bengaluru","Koramangala","Prestige Atlanta","Prestige Atlanta, Koramangala"}, 
			{"Bengaluru","Koramangala","Prestige Cube","Prestige Cube, Koramangala"}, 
			{"Bengaluru","MG Road","The Pavilion","The Pavilion, Church Street"}, 
			{"Bengaluru","MG Road","Galaxy","Galaxy, Residency Road"}, 
			{"Bengaluru","MG Road","Embassy Quest","Embassy Quest, Magrath Road"}, 
			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis","Salarpuria Symbiosis, Bannerghatta Rd"}, 
			{"Bengaluru","Infantry Road","Prestige Central","Prestige Central, Infantry Road"}, 
			{"Bengaluru","Domlur","Sunriver, EGL"}, //Virtual office not avilable
			{"Bengaluru","Domlur","Cinnabar Hills, EGL","Embassy GolfLinks"}, //virtual office selection is not enabled, but loc is present in VO list
			{"Bengaluru","Bellandur","Embassy TechVillage","Embassy TechVillage, Bellandur"}, //
			{"Bengaluru","Bellandur","Vaishnavi Signature","Vaishnavi Signature, Bellandur"}, //
			{"Bengaluru","Hebbal","RMZ Latitude Commercial","RMZ Latitude Commercial, Hebbal"}, //
			{"Bengaluru","Hebbal","Manyata NXT","WeWork Manyata NXT"}, //
			{"Bengaluru","Mahadevapura","Salarpuria Magnifica","Salarpuria Magnificia, Old Madras Rd"} //
			};
	}
	
	@DataProvider(name="MumbaiVirtualOfficeWorkspaces")
	public Object[][] mumbaiVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			{"Mumbai","Nariman Point","Express Towers"},//not available
			{"Mumbai","Goregaon East","Oberoi Commerz II","Oberoi Commerz II, Goregaon East"},
			{"Mumbai","Goregaon East","NESCO IT Park","NESCO IT Park, Goregaon East"},
			{"Mumbai","Vikhroli West","247 Park","247 Park, Vikhroli West"},
			{"Mumbai","Thane","Zenia","Zenia, Thane"},
			{"Mumbai","Andheri East","Vijay Diamond"},//not available
			{"Mumbai","Andheri East","Raheja Platinum","K. Raheja Platinum, Andheri East"},
			{"Mumbai","Powai","Chromium","Chromium, Powai"},
			{"Mumbai","Navi Mumbai","Seawoods Grand Central","Seawoods Grand Central, Navi Mumbai"},
			{"Mumbai","Malad","Spectrum Tower","Spectrum Tower, Malad"},
			{"Mumbai","Worli","Vaswani Chambers","Vaswani Chambers, Worli"},
			{"Mumbai","BKC","Enam Sambhav","Enam Sambhav, BKC"}
			};
		
	}
}
