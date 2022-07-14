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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectVirtualOfficeTest extends CommonOps 
{

	@Test(description = "Test01 - Verify User is able to Select virtual office")
    @Description("This test verifies that User is able to Select virtual office")
    public void test01_VerifySelectVirtualOfficeWithoutLogginIn() throws InterruptedException
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }
	
	@Test(description = "Test02 - Verify User is able to Select virtual office in Pune", dataProvider = "PuneDayPassWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Pune")
    public void test02_VerifySelectVirtualOfficeInPune(String city , String location, String buildingName, String building ) throws InterruptedException
    {
    
        WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		click(webLoading.VirtualOfficeOptn);
		click(webLoading.bookNowBtn);
        Thread.sleep(4000);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select(building));
        scrollToElement(webLoading.select(building));
        Thread.sleep(5000);
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select(building));
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test03 - Verify User is able to Select virtual office in Hyderabad", dataProvider = "HyderabadVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Hyderabad")
    public void test03_VerifySelectVirtualOfficeInHyderabad(String city , String location, String buildingName, String building ) throws InterruptedException
    {
    
        WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		click(webLoading.VirtualOfficeOptn);
		click(webLoading.bookNowBtn);
        Thread.sleep(4000);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select(building));
        scrollToElement(webLoading.select(building));
        Thread.sleep(5000);
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select(building));
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test04 - Verify User is able to Select virtual office in Delhi", dataProvider = "DelhiNCRVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Delhi")
    public void test04_VerifySelectVirtualOfficeInDelhi(String city , String location, String buildingName, String building ) throws InterruptedException
    {
    
        WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		click(webLoading.VirtualOfficeOptn);
		click(webLoading.bookNowBtn);
        Thread.sleep(4000);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select(building));
        scrollToElement(webLoading.select(building));
        Thread.sleep(5000);
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select(building));
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test05 - Verify User is able to Select virtual office in Bengaluru", dataProvider = "BengaluruVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Bengaluru")
    public void test05_VerifySelectVirtualOfficeInBengaluru(String city , String location, String buildingName, String building ) throws InterruptedException
    {
    
        WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		click(webLoading.VirtualOfficeOptn);
		click(webLoading.bookNowBtn);
        Thread.sleep(4000);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select(building));
        scrollToElement(webLoading.select(building));
        Thread.sleep(5000);
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select(building));
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test06 - Verify User is able to Select virtual office in Mumbai", dataProvider = "MumbaiVirtualOfficeWorkspaces")
    @Description("This test verifies that User is able to Select virtual office in Mumbai")
    public void test06_VerifySelectVirtualOfficeInMumbai(String city , String location, String buildingName, String building ) throws InterruptedException
    {
    
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
		String currentWindow = getWindowHandel();
		click(webLoading.VirtualOfficeOptn);
		click(webLoading.bookNowBtn);
        Thread.sleep(4000);
        String VirtualOfficeWindow = getWindowHandels();
        switchToParentWindow(VirtualOfficeWindow);
        
        click(webLoading.select("Select Building"));
        Verifications.elementIsVisible(webLoading.select(buildingName));
        scrollToElement(webLoading.select(buildingName));
        Thread.sleep(8000);
        if(virtualOffice.nextBtn.isEnabled()) //next btn
        {
      			mouseHover(virtualOffice.nextBtn);
        }
        else
        {
        	click(webLoading.select(building));
        	mouseHover(virtualOffice.nextBtn);
        }
        Thread.sleep(8000);
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
        WebFlows.proceedWithPayment();
        Thread.sleep(2000);
        UIActions.closeCurrentWindow();
        switchToParentWindow(VirtualOfficeWindow);
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	
	@DataProvider(name="PuneVirtualOfficeWorkspaces")
	public Object[][] puneVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			//{"Pune","Kharadi","World Trade Center"}, //Virtula office not available
			{"Pune","Magarpatta","Panchshil Futura","Futura, Magarpatta Road"}
			};
		
	}
	
	@DataProvider(name="HyderabadVirtualOfficeWorkspaces")
	public Object[][] hyderabadVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Financial District","Rajapushpa Summit","Rajapushpa Summit, Financial District"},
			{"Hyderabad","Hitec City","Krishe Emerald","Krishe Emerald, Hitec City"}
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
			{"Bengaluru","Koramangala","Prestige Atlanta"},
			{"Bengaluru","Koramangala","Prestige Cube"},
			{"Bengaluru","MG Road","The Pavilion"},
			{"Bengaluru","MG Road","Galaxy"},
			{"Bengaluru","MG Road","Embassy Quest"},
			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
			{"Bengaluru","Infantry Road","Prestige Central"},
			//{"Bengaluru","Domlur","Sunriver, EGL"}, //Virtual office not avilable
			//{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //virtual office not avilable
			{"Bengaluru","Bellandur","Embassy TechVillage"},
			{"Bengaluru","Bellandur","Vaishnavi Signature"},
			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
			{"Bengaluru","Hebbal","Manyata NXT"},
			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}
	
	@DataProvider(name="MumbaiVirtualOfficeWorkspaces")
	public Object[][] mumbaiVirtualOfficeWorkspaces()
	{
		return new Object[][] { 
			//{"Mumbai","Nariman Point","Express Towers"},//not available
			{"Mumbai","Goregaon East","Oberoi Commerz II","Oberoi Commerz II, Goregaon East"},
			{"Mumbai","Goregaon East","NESCO IT Park","NESCO IT Park, Goregaon East"},
			{"Mumbai","Vikhroli West","247 Park","247 Park, Vikhroli West"},
			{"Mumbai","Thane","Zenia","Zenia, Thane"},
			//{"Mumbai","Andheri East","Vijay Diamond"},//not available
			{"Mumbai","Andheri East","Raheja Platinum","K. Raheja Platinum, Andheri East"},
			{"Mumbai","Powai","Chromium","Chromium, Powai"},
			{"Mumbai","Navi Mumbai","Seawoods Grand Central","Seawoods Grand Central, Navi Mumbai"},
			{"Mumbai","Malad","Spectrum Tower","Spectrum Tower, Malad"},
			{"Mumbai","Worli","Vaswani Chambers","Vaswani Chambers, Worli"},
			{"Mumbai","BKC","Enam Sambhav","Enam Sambhav, BKC"}
			};
		
	}
}
