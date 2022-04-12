package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import static extensions.UIActions.click;

@Listeners(utilities.Listeners.class)
public class WebAppTest extends CommonOps {
    @Test(description = "Test01 - Verify Website Opens on Chrome Browser")
    @Description("This test verifies that the website is opening on the chrome browser")
    public void test01_verifyWebsite() {
        WebFlows.loadWebsite();
        Verifications.elementIsVisible(webLogin.close_btn);
        click(webLogin.close_btn);
       // Verifications.verifyTextInElement(grafanaMain.head_Dashboard, "Welcome to Grafana");
    }
}
