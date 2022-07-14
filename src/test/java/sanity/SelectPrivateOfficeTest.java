package sanity;

import static extensions.UIActions.click;
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
public class SelectPrivateOfficeTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to select private offices. (Navigate to header in home page and select private office option from workspace dropdown)")
	@Description("This test verifies that User is able to select private offices. (Navigate to header in home page and select private office option from workspace dropdown)")
	public void test01_SelectPrivateOfficeSpace() throws InterruptedException {
		WebFlows.loginToApplication();
		click(webLoading.workspaceDrpdwn);
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
		Verifications.elementIsVisible(webLoading.thankyouText);
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		WebFlows.logoutOfApplication();

	}

	@Test(description = "Test02 - Verify User is able to select private office in Pune. (Scroll down in home page and select workspaces)", dataProvider = "PunePrivateOfficeWorkspaces")
	@Description("This test verifies that User is able to select private office in Pune. (Scroll down in home page and select workspaces)")
	public void test02_SelectPrivateOfficeInPune(String city, String location, String buildingName)
			throws InterruptedException {

		// WebFlows.loginToApplication();
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
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		Thread.sleep(4000);
		// WebFlows.logoutOfApplication();

	}

	@Test(description = "Test03 - Verify User is able to select private office in Hyderabad. (Scroll down in home page and select workspaces)", dataProvider = "HyderabadPrivateOfficeWorkspaces")
	@Description("This test verifies that User is able to select private office in Hyderabad. (Scroll down in home page and select workspaces)")
	public void test03_SelectPrivateOfficeInHyderabad(String city, String location, String buildingName)
			throws InterruptedException {

		// WebFlows.loginToApplication();
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
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		Thread.sleep(4000);
		// WebFlows.logoutOfApplication();

	}

	@Test(description = "Test04 - Verify User is able to select private office in Delhi. (Scroll down in home page and select workspaces)", dataProvider = "DelhiNCRPrivateOfficeWorkspaces")
	@Description("This test verifies that User is able to select private office in Delhi. (Scroll down in home page and select workspaces)")
	public void test04_SelectPrivateOfficeInDelhi(String city, String location, String buildingName)
			throws InterruptedException {

		// WebFlows.loginToApplication();
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
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		Thread.sleep(4000);
		// WebFlows.logoutOfApplication();

	}

	@Test(description = "Test05 - Verify User is able to select private office in Bengaluru. (Scroll down in home page and select workspaces)", dataProvider = "BengaluruPrivateOfficeWorkspaces")
	@Description("This test verifies that User is able to select private office in Bengaluru. (Scroll down in home page and select workspaces)")
	public void test05_SelectPrivateOfficeInBengaluru(String city, String location, String buildingName)
			throws InterruptedException {

		// WebFlows.loginToApplication();
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
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		Thread.sleep(4000);
		// WebFlows.logoutOfApplication();

	}

	@Test(description = "Test06 - Verify User is able to select private office in Mumbai. (Scroll down in home page and select workspaces)", dataProvider = "MumbaiPrivateOfficeWorkspaces")
	@Description("This test verifies that User is able to select private office in Mumbai. (Scroll down in home page and select workspaces)")
	public void test06_SelectPrivateOfficeInMumbai(String city, String location, String buildingName)
			throws InterruptedException {
		// WebFlows.loginToApplication();
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
		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
		click(webLoading.backToHomePageBtn);
		Thread.sleep(4000);
		// WebFlows.logoutOfApplication();

	}

	@DataProvider(name = "PunePrivateOfficeWorkspaces")
	public Object[][] punePrivateOfficeWorkspaces() 
	{		return new Object[][] 
				{ 
			     { "Pune", "Kharadi", "World Trade Center" },
				 {"Pune","Magarpatta","Panchshil Futura"}};
	}

	@DataProvider(name = "HyderabadPrivateOfficeWorkspaces")
	public Object[][] hyderabadPrivateOfficeWorkspaces() {
		return new Object[][] { { "Hyderabad", "Financial District", "Rajapushpa Summit" },
				{ "Hyderabad", "Hitec City", "Krishe Emerald" } };

	}

	@DataProvider(name = "DelhiNCRPrivateOfficeWorkspaces")
	public Object[][] delhiNCRPrivateOfficeWorkspaces() {
		return new Object[][] { { "Delhi-NCR", "Sector 15 Gurgaon", "32nd Milestone" },
				{ "Delhi-NCR", "Cybercity", "DLF Forum" }, { "Delhi-NCR", "Noida Sector 16", "Berger Delhi One" },
				{ "Delhi-NCR", "Bristol Chowk", "Platina Tower" },
				{ "Delhi-NCR", "Golf Course Road", "Two Horizon Centre" },
				{ "Delhi-NCR", "Udyog Vihar", "Blue One Square" }, { "Delhi-NCR", "Udyog Vihar", "Vi-John Tower" } };
	}

	@DataProvider(name = "BengaluruPrivateOfficeWorkspaces")
	public Object[][] bengaluruPrivateOfficeWorkspaces() {
		return new Object[][] { { "Bengaluru", "Koramangala", "Prestige Atlanta" },
				{ "Bengaluru", "Koramangala", "Prestige Cube" },
				{ "Bengaluru", "MG Road", "The Pavilion" }, { "Bengaluru", "MG Road", "Galaxy" },
				{ "Bengaluru", "MG Road", "Embassy Quest" },
				{ "Bengaluru", "Bannerghatta Main Rd", "Salarpuria Symbiosis" },
				{ "Bengaluru", "Infantry Road", "Prestige Central" },
				{ "Bengaluru", "Domlur", "Sunriver, EGL" }, 
			    //{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //private office not available
				{ "Bengaluru", "Bellandur", "Embassy TechVillage" },
				{ "Bengaluru", "Bellandur", "Vaishnavi Signature" },
				{ "Bengaluru", "Hebbal", "RMZ Latitude Commercial" }, { "Bengaluru", "Hebbal", "Manyata NXT" },
				{ "Bengaluru", "Mahadevapura", "Salarpuria Magnifica" } };
	}

	@DataProvider(name = "MumbaiPrivateOfficeWorkspaces")
	public Object[][] mumbaiPrivateOfficeWorkspaces() {
		return new Object[][] { { "Mumbai", "Nariman Point", "Express Towers" },
				{ "Mumbai", "Goregaon East", "Oberoi Commerz II" }, { "Mumbai", "Goregaon East", "NESCO IT Park" },
				{ "Mumbai", "Vikhroli West", "247 Park" }, { "Mumbai", "Thane", "Zenia" },
				{ "Mumbai", "Andheri East", "Vijay Diamond" }, { "Mumbai", "Andheri East", "Raheja Platinum" },
				{ "Mumbai", "Powai", "Chromium" }, { "Mumbai", "Navi Mumbai", "Seawoods Grand Central" },
				{ "Mumbai", "Malad", "Spectrum Tower" }, { "Mumbai", "Worli", "Vaswani Chambers" },
				{ "Mumbai", "BKC", "Enam Sambhav" } };

	}

}
