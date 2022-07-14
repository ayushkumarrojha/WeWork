package sanity;

import static extensions.UIActions.clearTextBox;
import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectConferenceRoomTest extends CommonOps 
{

	@Test(description = "Test01 - Verify User is able to select conference room")
    @Description("This test verifies that User is able to select conference room")
    public void test01_SelectConferenceRoom() throws InterruptedException
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
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test02 - Verify User is able to select conference room in Pune",dataProvider = "PuneConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Pune")
    public void test02_SelectConferenceRoomInPune(String city , String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select(city));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select(buildingName));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("29"));
    	click(conferenceRoom.selectDate("29"));
    	scrollToElement(conferenceRoom.select("10:00 AM"));
    	click(conferenceRoom.select("10:00 AM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test03 - Verify User is able to select conference room in Hyderabad",dataProvider = "HyderabadConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Hyderabad")
    public void test03_SelectConferenceRoomInHyderabad(String city , String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select(city));
    	click(webLoading.buildingDropdown);
    	click(webLoading.select(buildingName));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("29"));
    	click(conferenceRoom.selectDate("29"));
    	scrollToElement(conferenceRoom.select("10:00 AM"));
    	click(conferenceRoom.select("10:00 AM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test04 - Verify User is able to select conference room in Delhi",dataProvider = "DelhiNCRConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Delhi")
    public void test04_SelectConferenceRoomInDelhi(String city , String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select(city));
    	click(webLoading.buildingDropdown);
    	scrollToElement(webLoading.select(buildingName));
    	click(webLoading.select(buildingName));
    	scrollToElement(webLoading.select("Book now"));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("29"));
    	click(conferenceRoom.selectDate("29"));
    	scrollToElement(conferenceRoom.select("10:00 AM"));
    	click(conferenceRoom.select("10:00 AM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test05 - Verify User is able to select conference room in Bengaluru",dataProvider = "BengaluruConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Bengaluru")
    public void test05_SelectConferenceRoomInBengaluru(String city , String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select(city));
    	click(webLoading.buildingDropdown);
    	scrollToElement(webLoading.select(buildingName));
    	click(webLoading.select(buildingName));
    	scrollToElement(webLoading.select("Book now"));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("29"));
    	click(conferenceRoom.selectDate("29"));
    	scrollToElement(conferenceRoom.select("10:00 AM"));
    	click(conferenceRoom.select("10:00 AM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test06 - Verify User is able to select conference room in Mumbai",dataProvider = "BengaluruConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Mumbai")
    public void test06_SelectConferenceRoomInMumbai(String city , String buildingName) throws InterruptedException
    {
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
        click(webLoading.opt("Conference room"));
    	click(webLoading.loctnDropdown2);
    	click(webLoading.select(city));
    	click(webLoading.buildingDropdown);
    	scrollToElement(webLoading.select(buildingName));
    	click(webLoading.select(buildingName));
    	scrollToElement(webLoading.select("Book now"));
    	click(webLoading.select("Book now"));
    	scrollToElement(conferenceRoom.plusIcon);
    	mouseHover(conferenceRoom.plusIcon);
    	click(conferenceRoom.calendarIcon);
    	scrollToElement(conferenceRoom.selectDate("29"));
    	click(conferenceRoom.selectDate("29"));
    	scrollToElement(conferenceRoom.select("1:30 PM"));
    	click(conferenceRoom.select("1:30 PM"));
    	scrollToElement(conferenceRoom.addBtn);
    	click(conferenceRoom.addBtn);
    	click(conferenceRoom.select("Continue"));
    	String currentWindow = getWindowHandel();
    	click(conferenceRoom.select("Confirm & Pay"));
    	String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(4000);
       // WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@DataProvider(name="PuneConferenceRoomWorkspaces")
	public Object[][] puneConferenceRoomWorkspaces()
	{
		return new Object[][] { 
			{"Pune","World Trade Center"},
			{"Pune","Panchshil Futura"}
			};
		
	}
	
	@DataProvider(name="HyderabadConferenceRoomWorkspaces")
	public Object[][] hyderabadConferenceRoomWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Rajapushpa Summit"},
			{"Hyderabad","Krishe Emerald"}
			};
		
	}
	
	@DataProvider(name="DelhiNCRConferenceRoomWorkspaces")
	public Object[][] delhiNCRConferenceRoomWorkspaces()
	{
		return new Object[][] { 
			{"Delhi-NCR","Berger Delhi One"},
			{"Delhi-NCR","Blue One Square"},
			{"Delhi-NCR","Vi-John Tower"},
			{"Delhi-NCR","32nd Milestone"},
			{"Delhi-NCR","Two Horizon Centre"},
			{"Delhi-NCR","DLF Forum"},
			{"Delhi-NCR","Platina Tower"}
			};
	}
	
	@DataProvider(name="BengaluruConferenceRoomWorkspaces")
	public Object[][] bengaluruConferenceRoomWorkspaces()
	{
		return new Object[][] { 
//			{"Bengaluru","Prestige Atlanta"},
//			{"Bengaluru","Galaxy"},
			{"Bengaluru","Prestige Central"},
			{"Bengaluru","Embassy TechVillage"},
			{"Bengaluru","RMZ Latitude Commercial"},
			{"Bengaluru","Salarpuria Magnifica"},
			{"Bengaluru","Salarpuria Symbiosis"},
			{"Bengaluru","Vaishnavi Signature"},
			{"Bengaluru","Manyata NXT"}
			//{"Bengaluru","Koramangala","Prestige Cube"},  Conference room not avilable
			//{"Bengaluru","MG Road","The Pavilion"},  Conference room not avilable
			//{"Bengaluru","MG Road","Embassy Quest"},  Conference room not avilable
			//{"Bengaluru","Domlur","Sunriver, EGL"}, Conference room not avilable
			//{"Bengaluru","Domlur","Cinnabar Hills, EGL"} Conference room not avilable
			
			};
	}
	
	@DataProvider(name="MumbaiConferenceRoomWorkspaces")
	public Object[][] mumbaiConferenceRoomWorkspaces()
	{
		return new Object[][] { 
			{"Mumbai","Express Towers"},
			{"Mumbai","247 Park"},
			{"Mumbai","Zenia"},
			{"Mumbai","Chromium"},
			{"Mumbai","Seawoods Grand Central"},
			{"Mumbai","Spectrum Tower"},
			{"Mumbai","Oberoi Commerz II"},
			{"Mumbai","Enam Sambhav"},
			{"Mumbai","Raheja Platinum"}
//			{"Mumbai","Goregaon East","NESCO IT Park"},  Conference room not avilable
//			{"Mumbai","Andheri East","Vijay Diamond"},  Conference room not avilable
//			{"Mumbai","Worli","Vaswani Chambers"}  Conference room not avilable
			};
	}
	
}
