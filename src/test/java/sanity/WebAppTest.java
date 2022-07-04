package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import static extensions.UIActions.*;

@Listeners(utilities.Listeners.class)
public class WebAppTest extends CommonOps {
    @Test(description = "Test01 - Verify Website Opens on Chrome Browser")
    @Description("This test verifies that the website is opening on the chrome browser")
    public void test01_verifyWebsite() throws InterruptedException {
        WebFlows.loadWebsite();
    }

    @Test(description = "Test02 - Verify User is able to Login")
    @Description("This test verifies that User is able to login")
    public void test02_verifyLogin() throws InterruptedException{
        WebFlows.loadWebsite();
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
    }

    @Test(description = "Test03 - Verify User is able to navigate to terms and services")
    @Description("This test verifies that User is able to navigate to terms and services")
    public void test03_verifyTermsAndConditions() throws InterruptedException {
        WebFlows.loadWebsite();
        scrollToElement(webLonding.termsAndServices);
        Verifications.elementIsVisible(webLonding.termsAndServices);
        click(webLonding.termsAndServices);
        Verifications.verifyUrl(getPageUrl(), getData("TS"));
    }
}
