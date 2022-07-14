package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;
@Listeners(utilities.Listeners.class)
public class SelectEventsAndWorkspacesTest extends CommonOps
{

	@Test(description = "Test21 - Verify User is able to select events and workspaces")
    @Description("This test verifies that User is able to select events and workspaces")
    public void test21_SelectEventsAndWorkspaces() throws InterruptedException
    {
		
		WebFlows.loginToApplication();
        click(webLoading.workspaceDrpdwn);
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
	
}
