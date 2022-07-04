package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import pageObjects.web.LodingPage;
import utilities.CommonOps;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToLoginWindow;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateText;

import java.util.List;

public class WebFlows extends CommonOps 
{
	
   /* @Step("Business Flow: Login To Grafana")
    public static void newLogin(String user, String pass){
        UIActions.click(grafanaLogin.btn_close);
//        UIActions.updateText(grafanaLogin.txt_username, user);
//        UIActions.updateText(grafanaLogin.txt_password, pass);
//        UIActions.click(grafanaLogin.btn_login);
//        UIActions.click(grafanaLogin.btn_skip);
    }
    @Step("Business Flow: Login To Grafana")
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Login To Grafana Using DB Credentials")
    public static void loginDB(){
        String query = "SELECT name, password FROM Employees WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.txt_username, cred.get(0));
        UIActions.updateText(grafanaLogin.txt_password, cred.get(1));
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Create New User")
    public static void createNewUser (String name, String email, String username, String pass){
        UIActions.refreshPage();
        UIActions.click(grafanaServerAdminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_username, username);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.click(grafanaAddNewUser.btn_create);
    }

    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser() {
        UIActions.refreshPage();
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size() -2));
        UIActions.click(grafanaUserInformation.btn_deleteUser);
        UIActions.click(grafanaUserInformation.btn_ConfirmDeleteUser);
    }

    @Step("Business Flow: Search And Verify User")
    public static void searchAndVerifyUser(String user, String shouldExists) {
        UIActions.updateTextHuman(grafanaServerAdminMain.txt_search, user);
        if (shouldExists.equalsIgnoreCase("exist"))
            Verifications.existenceOfElement(grafanaServerAdminMain.rows);
        else if(shouldExists.equalsIgnoreCase("not-exist"))
            Verifications.nonExistenceOfElement(grafanaServerAdminMain.rows);
        else
            throw new RuntimeException("Invalid Expected Output Option In Data Driven Testing: Should Be 'exists' or 'not-exists'");
        }*/

    @Step("Open Website And Login")
    public static void loadWebsite(){
        UIActions.initBrowser("chrome");
    }
    
    @Step("Login to the application")
    public static void loginToApplication()
    {
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
    
    @Step("Logout of the application")
    public static void logoutOfApplication() throws InterruptedException
    {
    	scrollToElement(LodingPage.logout);
	    Verifications.elementIsVisible(LodingPage.logout);
	    click(LodingPage.logout);
    }
    

}


