package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
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
public class SelectDayPassTest extends CommonOps 
{
	@Test(description = "Test01 - Verify User is able to select day pass.(Navigate to header in home page and select Day Pass option from workspace dropdown)")
    @Description("This test verifies that User is able to select day pass. (Navigate to header in home page and select Day Pass option from workspace dropdown)")
    public void test01_SelectDaypass() throws InterruptedException
    {
		WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	String currentWindow = getWindowHandel();
    	click(webLoading.workspaceDrpdwn);
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
	
	@Test(description = "Test02 - Verify User is able to select day pass in Pune. (In  home page navigate to workspaces and select day pass)",dataProvider = "PuneDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass in Pune. (In  home page navigate to workspaces and select day pass)")
    public void test02_SelectDayPassInPune(String city , String location, String buildingName) throws InterruptedException
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
		String currentWindow = getWindowHandel();
		click(webLoading.dayPassBtn);
		click(webLoading.bookNowBtn);
		click(dayPass.selectDate("29"));
        click(dayPass.continueBtn);
        click(dayPass.skipAndPayBtn);
        click(dayPass.confirmAndPayBtn);
        String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
       
    }
	
	@Test(description = "Test03 - Verify User is able to select day pass in Hyderabad. (In  home page navigate to workspaces and select day pass)",dataProvider = "HyderabadDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass in Hyderabad. (In  home page navigate to workspaces and select day pass)")
    public void test03_SelectDayPassInHyderabad(String city , String location, String buildingName) throws InterruptedException
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
		String currentWindow = getWindowHandel();
		click(webLoading.dayPassBtn);
		click(webLoading.bookNowBtn);
		click(dayPass.selectDate("29"));
        click(dayPass.continueBtn);
        click(dayPass.skipAndPayBtn);
        click(dayPass.confirmAndPayBtn);
        String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
	      
    }
	
	@Test(description = "Test04 - Verify User is able to select day pass in Delhi. (In  home page navigate to workspaces and select day pass)",dataProvider = "DelhiNCRDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass in Delhi. (In  home page navigate to workspaces and select day pass)")
    public void test04_SelectDayPassInDelhi(String city , String location, String buildingName) throws InterruptedException
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
		String currentWindow = getWindowHandel();
		click(webLoading.dayPassBtn);
		click(webLoading.bookNowBtn);
		click(dayPass.selectDate("29"));
        click(dayPass.continueBtn);
        click(dayPass.skipAndPayBtn);
        click(dayPass.confirmAndPayBtn);
        String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
	      
    }
	
	@Test(description = "Test05 - Verify User is able to select day pass in Bengaluru. (In  home page navigate to workspaces and select day pass)",dataProvider = "BengaluruDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass in Bengaluru. (In  home page navigate to workspaces and select day pass)")
    public void test05_SelectDayPassInBengaluru(String city , String location, String buildingName) throws InterruptedException
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
		String currentWindow = getWindowHandel();
		click(webLoading.dayPassBtn);
		click(webLoading.bookNowBtn);
		click(dayPass.selectDate("29"));
        click(dayPass.continueBtn);
        click(dayPass.skipAndPayBtn);
        click(dayPass.confirmAndPayBtn);
        String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
	      
    }
	
	@Test(description = "Test06 - Verify User is able to select day pass in Mumbai. (In  home page navigate to workspaces and select day pass)",dataProvider = "MumbaiDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass in Mumbai. (In  home page navigate to workspaces and select day pass)")
    public void test06_SelectDayPassInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		scrollToElement(webLoading.workspaceBtn);
		click(webLoading.workspaceBtn);
		scrollToElement(webLoading.cityDropdown);
		click(webLoading.cityDropdown);
		click(webLoading.select(city));
		click(webLoading.buildingsDropdown);
		click(webLoading.select(location));
		click(webLoading.select(buildingName));
		click(webLoading.exploreBtn);
		String currentWindow = getWindowHandel();
		click(webLoading.dayPassBtn);
		click(webLoading.bookNowBtn);
		click(dayPass.selectDate("29"));
        click(dayPass.continueBtn);
        click(dayPass.skipAndPayBtn);
        click(dayPass.confirmAndPayBtn);
        String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
	      
    }
	
	@Test(description = "Test07 - Verify User is able to select day pass with budnles for Pune",dataProvider = "PuneDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass with budnles for Pune")
    public void test07_SelectDayPasswithBundlesforPune(String city , String location, String buildingName) throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(webLoading.workspaceDrpdwn);
		Thread.sleep(2000);
		click(webLoading.opt("Day pass"));
		click(webLoading.loctnDropdown2);
		click(webLoading.select(city));
		click(webLoading.buildingDropdown);
		click(webLoading.select(buildingName));
		click(webLoading.select("Book a workspace"));
		String currentWindow = getWindowHandel();
		click(webLoading.buyABundleLink);
		click(webLoading.add10DayPassesBundle);
		scrollToElement(webLoading.fiveDaypassAmount);
		String daypassfor5Days =webLoading.fiveDaypassAmount.getText().split(" ")[1];
		String daypassfor10Days =webLoading.tenDaypassAmount.getText().split(" ")[1];
        
		String value = "";
		for(int i=0;i<daypassfor5Days.length();i++)
		{
				char ch = daypassfor5Days.charAt(i);
				if(ch!=',')
				{
					value = value+ch;
				}		
		}
		int daypassAmountfor5days = Integer.parseInt(value);
		
		String value2 = "";
		for(int i=0;i<daypassfor10Days.length();i++)
		{
				char ch = daypassfor10Days.charAt(i);
				if(ch!=',')
				{
					value2 = value2+ch;
				}
				
		}
		int daypassAmountfor10days = Integer.parseInt(value2);
		
		int totalAmount = daypassAmountfor5days + daypassAmountfor10days;
		//System.out.println("Total amount is "+totalAmount);
		
		String discount  =webLoading.discount.getText().split(" ")[2];
		
		String value3 = "";
		for(int i=0;i<discount.length();i++)
		{
				char ch = discount.charAt(i);
				if(ch!=',')
				{
					value3 = value3+ch;
				}
				
		}
		int discountAmount = Integer.parseInt(value3);
		//System.out.println("Discount amount is "+discountAmount);
		
		int finalAmount= totalAmount -discountAmount;
		//System.out.println("Amount after applying discount is  "+finalAmount);
		
		String total  =webLoading.totalAmount.getText().split(" ")[1];
		String value4 = "";
		for(int i=0;i<total.length();i++)
		{
				char ch = total.charAt(i);
				if(ch!=',')
				{
					value4 = value4+ch;
				}
				
		}
		int totalAmountValue = Integer.parseInt(value4);
		//System.out.println("Final  amount is "+totalAmountValue);
		Assert.assertEquals(finalAmount, totalAmountValue);
		
		click(webLoading.select("Proceed to Pay"));
		Thread.sleep(2000);
		String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
    }
	
	@Test(description = "Test08 - Verify User is able to select day pass with budnles (navigate to user's dashboard and select day pass)")
    @Description("This test verifies that User is able to select day pass with budnles (navigate to user's dashboard and select day pass)")
    public void test08_SelectDayPasswithBundlesfromDashboard() throws InterruptedException
    {
		WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(webLogin.userName);
		Thread.sleep(4000);
		scrollToElement(dashboard.buyNowBtn);
		click(dashboard.buyNowBtn);
		Thread.sleep(4000);
		String currentWindow = getWindowHandel();
		click(dashboard.cityDropdown);
		click(dashboard.opt("Mumbai"));
		click(dashboard.buildingDropdown);
		click(dashboard.opt("Zenia"));
		Thread.sleep(4000);
		click(dashboard.add10DayPassesBundle);
		
		scrollToElement(dashboard.fiveDaypassAmount);
		String daypassfor5Days =dashboard.fiveDaypassAmount.getText().split(" ")[1];
		String daypassfor10Days =dashboard.tenDaypassAmount.getText().split(" ")[1];
        
		String value = "";
		for(int i=0;i<daypassfor5Days.length();i++)
		{
				char ch = daypassfor5Days.charAt(i);
				if(ch!=',')
				{
					value = value+ch;
				}		
		}
		int daypassAmountfor5days = Integer.parseInt(value);
		
		String value2 = "";
		for(int i=0;i<daypassfor10Days.length();i++)
		{
				char ch = daypassfor10Days.charAt(i);
				if(ch!=',')
				{
					value2 = value2+ch;
				}
				
		}
		int daypassAmountfor10days = Integer.parseInt(value2);
		
		int totalAmount = daypassAmountfor5days + daypassAmountfor10days;
		//System.out.println("Total amount is "+totalAmount);
		
		String discount  =dashboard.discount.getText().split(" ")[2];
		
		String value3 = "";
		for(int i=0;i<discount.length();i++)
		{
				char ch = discount.charAt(i);
				if(ch!=',')
				{
					value3 = value3+ch;
				}
				
		}
		int discountAmount = Integer.parseInt(value3);
		//System.out.println("Discount amount is "+discountAmount);
		
		int finalAmount= totalAmount -discountAmount;
		//System.out.println("Amount after applying discount is  "+finalAmount);
		
		String total  =dashboard.totalAmount.getText().split(" ")[1];
		String value4 = "";
		for(int i=0;i<total.length();i++)
		{
				char ch = total.charAt(i);
				if(ch!=',')
				{
					value4 = value4+ch;
				}
				
		}
		int totalAmountValue = Integer.parseInt(value4);
		//System.out.println("Final  amount is "+totalAmountValue);
		Assert.assertEquals(finalAmount, totalAmountValue);
		
		click(dashboard.select("Proceed to Pay"));
		Thread.sleep(2000);
		
		
		String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        Thread.sleep(2000);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(webLoading.closeIcon);
        click(webLoading.closeIcon);
        WebFlows.logoutOfApplication();
        
        
    }
	
	@Test(description = "Test09 - Verify User is able to select day pass with budnles (In  home page navigate to workspaces and select day pass)",dataProvider = "PuneDayPassWorkspaces")
    @Description("This test verifies that User is able to select day pass with budnles (In  home page navigate to workspaces and select day pass)")
    public void test09_SelectDayPasswithBundlesfromWrkspaces(String city , String location, String buildingName) throws InterruptedException
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
	      String currentWindow = getWindowHandel();
	      scrollToElement(webLoading.dayPassBtn);
	      click(webLoading.dayPassBtn);
	      click(webLoading.bookNowBtn);
	      click(webLoading.buyABundleLink);
	      Thread.sleep(4000);
		  click(webLoading.plusBtnToAdd10daypass);
		  
			scrollToElement(dashboard.fiveDaypassAmount);
			String daypassfor5Days =dashboard.fiveDaypassAmount.getText().split(" ")[1];
			String daypassfor10Days =dashboard.tenDaypassAmount.getText().split(" ")[1];
	        
			String value = "";
			for(int i=0;i<daypassfor5Days.length();i++)
			{
					char ch = daypassfor5Days.charAt(i);
					if(ch!=',')
					{
						value = value+ch;
					}		
			}
			int daypassAmountfor5days = Integer.parseInt(value);
			
			String value2 = "";
			for(int i=0;i<daypassfor10Days.length();i++)
			{
					char ch = daypassfor10Days.charAt(i);
					if(ch!=',')
					{
						value2 = value2+ch;
					}
					
			}
			int daypassAmountfor10days = Integer.parseInt(value2);
			
			int totalAmount = daypassAmountfor5days + daypassAmountfor10days;
			//System.out.println("Total amount is "+totalAmount);
			
			String discount  =dashboard.discount.getText().split(" ")[2];
			
			String value3 = "";
			for(int i=0;i<discount.length();i++)
			{
					char ch = discount.charAt(i);
					if(ch!=',')
					{
						value3 = value3+ch;
					}
					
			}
			int discountAmount = Integer.parseInt(value3);
			//System.out.println("Discount amount is "+discountAmount);
			
			int finalAmount= totalAmount -discountAmount;
			//System.out.println("Amount after applying discount is  "+finalAmount);
			
			String total  =dashboard.totalAmount.getText().split(" ")[1];
			String value4 = "";
			for(int i=0;i<total.length();i++)
			{
					char ch = total.charAt(i);
					if(ch!=',')
					{
						value4 = value4+ch;
					}
					
			}
			int totalAmountValue = Integer.parseInt(value4);
			//System.out.println("Final  amount is "+totalAmountValue);
			Assert.assertEquals(finalAmount, totalAmountValue);
			click(dashboard.select("Proceed to Pay"));
			Thread.sleep(2000);
			String paymentWindow = getWindowHandels();
	        switchToParentWindow(paymentWindow);
	        Thread.sleep(2000);
	        WebFlows.proceedWithPayment();
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        Verifications.elementIsVisible(webLoading.closeIcon);
	        click(webLoading.closeIcon);
	        WebFlows.logoutOfApplication();
	        
    }
	
	@DataProvider(name="PuneDayPassWorkspaces")
	public Object[][] puneDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Pune","Kharadi","World Trade Center"},
			//{"Pune","Magarpatta","Panchshil Futura"}
			};
		
	}
	
	@DataProvider(name="HyderabadDayPassWorkspaces")
	public Object[][] hyderabadDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Hyderabad","Financial District","Rajapushpa Summit"},
			{"Hyderabad","Hitec City","Krishe Emerald"}
			};
		
	}
	
	@DataProvider(name="DelhiNCRDayPassWorkspaces")
	public Object[][] delhiNCRDayPassWorkspaces()
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
	
	@DataProvider(name="BengaluruDayPassWorkspaces")
	public Object[][] bengaluruDayPassWorkspaces()
	{
		return new Object[][] { 
			{"Bengaluru","Koramangala","Prestige Atlanta"},
			{"Bengaluru","Koramangala","Prestige Cube"},
			{"Bengaluru","MG Road","The Pavilion"},
			{"Bengaluru","MG Road","Galaxy"},
			{"Bengaluru","MG Road","Embassy Quest"},
			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
			{"Bengaluru","Infantry Road","Prestige Central"},
			//{"Bengaluru","Domlur","Sunriver, EGL"}, Day pass not avilable
			//{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, Day pass not avilable
			{"Bengaluru","Bellandur","Embassy TechVillage"},
			{"Bengaluru","Bellandur","Vaishnavi Signature"},
			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
			{"Bengaluru","Hebbal","Manyata NXT"},
			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}
	
	@DataProvider(name="MumbaiDayPassWorkspaces")
	public Object[][] mumbaiDayPassWorkspaces()
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
