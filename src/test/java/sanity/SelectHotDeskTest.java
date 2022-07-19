package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
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

public class SelectHotDeskTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to select hot desk option. (Navigate to header in home page and select hotdesk option from workspace dropdown)")
	@Description("This test verifies that User is able to select hot desk option. (Navigate to header in home page and select hotdesk option from workspace dropdown)")
	public void test01_SelectHotDesk() throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		
		click(webLoading.workspaceDrpdwn);
		click(webLoading.opt("Hot desk"));
		String subscriptionType = webLoading.subscriptionType.getText();
    	if(subscriptionType.contains("Hot Desk"))
    	{
    		click(webLoading.loctnDropdown2);
    		click(webLoading.select("Mumbai"));
    		click(webLoading.buildingDropdown);
    		click(webLoading.select("Zenia"));
    		click(webLoading.select("Book a workspace"));
    		updateText(webLoading.nameField, getData("Username"));
    		updateText(webLoading.emailField, getData("email"));
    		updateText(webLoading.phonenNumberField, getData("phoneNumber"));
            scrollToElement(webLoading.plusIcon);
    		UIActions.selectNoOfPeople(3);
    		UIActions.selectDate("2024", "September", "26");
            click(webLoading.continueBtn);
    		Verifications.elementIsVisible(webLoading.thankyouText);
    		String actualText = webLoading.thankyouText.getText();
    		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
    		click(webLoading.backToHomePageBtn);
    		WebFlows.logoutOfApplication();
    	}
    	else
    	{
    		Assert.assertTrue(false, "Subscription type mismatch");
    	}
	}

	@Test(description = "Test02 - Verify User is able to select Hotdesk in Pune. (Scroll down in home page and select workspaces)", dataProvider = "PuneHotdeskWorkspaces")
	@Description("This test verifies that User is able to select Hotdesk in Pune. (Scroll down in home page and select workspaces)")
	public void test02_SelectHotdeskInPune(String city, String location, String buildingName)
			throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String hotdeskOptnBtn = webLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled")) 
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.hotDeskOptn);
			click(webLoading.bookNowBtn);
			String subscriptionType = webLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
				updateText(webLoading.username, getData("Username"));
				updateText(webLoading.userEmail, getData("email"));
				updateText(webLoading.userPhnNumber, getData("phoneNumber"));
				scrollToElement(webLoading.plusIcon);
				UIActions.selectNoOfPeople(4);
				UIActions.selectDate("2024", "September", "26");
				click(webLoading.continueBtn);
				Verifications.elementIsVisible(webLoading.thankyouText);
				String actualText = webLoading.thankyouText.getText();
				Verifications.elementIsVisible(webLoading.thankyouText);
				Verifications.verifyText(actualText, "Thank you for contacting WeWork");
				click(webLoading.backToHomePageBtn);
				WebFlows.logoutOfApplication();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
			
		}
	}

	@Test(description = "Test03 - Verify User is able to select Hotdesk in Hyderabad. (Scroll down in home page and select workspaces)", dataProvider = "HyderabadHotdeskWorkspaces")
	@Description("This test verifies that User is able to select Hotdesk in Hyderabad. (Scroll down in home page and select workspaces)")
	public void test03_SelectHotdeskInHyderabad(String city, String location, String buildingName)
			throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String hotdeskOptnBtn = webLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled")) 
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.hotDeskOptn);
			click(webLoading.bookNowBtn);
			String subscriptionType = webLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
				updateText(webLoading.username, getData("Username"));
				updateText(webLoading.userEmail, getData("email"));
				updateText(webLoading.userPhnNumber, getData("phoneNumber"));
				scrollToElement(webLoading.plusIcon);
				UIActions.selectNoOfPeople(4);
				UIActions.selectDate("2024", "September", "26");
				click(webLoading.continueBtn);
				Verifications.elementIsVisible(webLoading.thankyouText);
				String actualText = webLoading.thankyouText.getText();
				Verifications.elementIsVisible(webLoading.thankyouText);
				Verifications.verifyText(actualText, "Thank you for contacting WeWork");
				click(webLoading.backToHomePageBtn);
				WebFlows.logoutOfApplication();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
			
		}
	}

	@Test(description = "Test04 - Verify User is able to select Hotdesk in Delhi-NCR. (Scroll down in home page and select workspaces)", dataProvider = "DelhiNCRHotdeskWorkspaces")
	@Description("This test verifies that User is able to select Hotdesk in Delhi-NCR. (Scroll down in home page and select workspaces)")
	public void test04_SelectHotdeskInDelhiNCR(String city, String location, String buildingName)
			throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String hotdeskOptnBtn = webLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled")) 
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.hotDeskOptn);
			click(webLoading.bookNowBtn);
			String subscriptionType = webLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
				updateText(webLoading.username, getData("Username"));
				updateText(webLoading.userEmail, getData("email"));
				updateText(webLoading.userPhnNumber, getData("phoneNumber"));
				scrollToElement(webLoading.plusIcon);
				UIActions.selectNoOfPeople(4);
				UIActions.selectDate("2024", "September", "26");
				click(webLoading.continueBtn);
				Verifications.elementIsVisible(webLoading.thankyouText);
				String actualText = webLoading.thankyouText.getText();
				Verifications.elementIsVisible(webLoading.thankyouText);
				Verifications.verifyText(actualText, "Thank you for contacting WeWork");
				click(webLoading.backToHomePageBtn);
				WebFlows.logoutOfApplication();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
			
		}
	}

	@Test(description = "Test05 - Verify User is able to select Hotdesk in Bengaluru. (Scroll down in home page and select workspaces)", dataProvider = "BengaluruHotdeskWorkspaces")
	@Description("This test verifies that User is able to select Hotdesk in Bengaluru. (Scroll down in home page and select workspaces)")
	public void test05_SelectHotdeskInBengaluru(String city, String location, String buildingName)
			throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String hotdeskOptnBtn = webLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled")) 
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.hotDeskOptn);
			click(webLoading.bookNowBtn);
			String subscriptionType = webLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
				updateText(webLoading.username, getData("Username"));
				updateText(webLoading.userEmail, getData("email"));
				updateText(webLoading.userPhnNumber, getData("phoneNumber"));
				scrollToElement(webLoading.plusIcon);
				UIActions.selectNoOfPeople(4);
				UIActions.selectDate("2024", "September", "26");
				click(webLoading.continueBtn);
				Verifications.elementIsVisible(webLoading.thankyouText);
				String actualText = webLoading.thankyouText.getText();
				Verifications.elementIsVisible(webLoading.thankyouText);
				Verifications.verifyText(actualText, "Thank you for contacting WeWork");
				click(webLoading.backToHomePageBtn);
				WebFlows.logoutOfApplication();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
			
		}

	}

	@Test(description = "Test06 - Verify User is able to select Hotdesk in Mumbai. (Scroll down in home page and select workspaces)", dataProvider = "MumbaiHotdeskWorkspaces")
	@Description("This test verifies that User is able to select Hotdesk in Mumbai. (Scroll down in home page and select workspaces)")
	public void test06_SelectHotdeskInMumbai(String city, String location, String buildingName)
			throws InterruptedException 
	{
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
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
		String hotdeskOptnBtn = webLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled")) 
		{
			mouseHover(webLoading.closeIcon);
			WebFlows.logoutOfApplication();
		} else 
		{
			click(webLoading.hotDeskOptn);
			click(webLoading.bookNowBtn);
			String subscriptionType = webLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
				updateText(webLoading.username, getData("Username"));
				updateText(webLoading.userEmail, getData("email"));
				updateText(webLoading.userPhnNumber, getData("phoneNumber"));
				scrollToElement(webLoading.plusIcon);
				UIActions.selectNoOfPeople(4);
				UIActions.selectDate("2024", "September", "26");
				click(webLoading.continueBtn);
				Verifications.elementIsVisible(webLoading.thankyouText);
				String actualText = webLoading.thankyouText.getText();
				Verifications.elementIsVisible(webLoading.thankyouText);
				Verifications.verifyText(actualText, "Thank you for contacting WeWork");
				click(webLoading.backToHomePageBtn);
				WebFlows.logoutOfApplication();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
			
		}
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
			{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //hotdesk not available
			
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
