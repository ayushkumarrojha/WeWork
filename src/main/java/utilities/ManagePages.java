package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.AddNewUserPage;
import pageObjects.grafana.ServerAdminMainPage;
import pageObjects.grafana.ServerAdminMenuPage;
import pageObjects.grafana.UserInformationPage;
import pageObjects.web.webLoading;
import pageObjects.web.ConferenceroomPage;
import pageObjects.web.EventsPage;
import pageObjects.web.HomePage;
import pageObjects.web.LoginPage;
import pageObjects.web.PaymentPage;
import pageObjects.web.VirtualOfficePage;
// Class Name: ManagePages
// Class Description: This class init the elements/objects of all tested applications, in all the required pages
public class ManagePages extends Base {

    public static void initGrafana() {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdmin = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaUserInformation = PageFactory.initElements(driver, UserInformationPage.class);
        webLogin = PageFactory.initElements(driver, LoginPage.class);
        webLoading = PageFactory.initElements(driver, webLoading.class);
        webhome = PageFactory.initElements(driver, HomePage.class);
        virtualOffice = PageFactory.initElements(driver, VirtualOfficePage.class);
        payment = PageFactory.initElements(driver, PaymentPage.class);
        conferenceRoom = PageFactory.initElements(driver, ConferenceroomPage.class);
        events = PageFactory.initElements(driver, EventsPage.class);
    }

    public static void initWallet() {
        walletMain = new pageObjects.createWallet.MainPage(mobileDriver);
    }

    public static void initToDo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}