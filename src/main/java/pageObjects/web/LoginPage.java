package pageObjects.web;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
//    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
//    public WebElement txt_create;
//
//    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90")
//    public List<WebElement> list_tasks;
//
//    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
//    public WebElement btn_x;
//
//    @FindBy(how = How.CLASS_NAME, using = "css-5j8aew")
//    public WebElement close_btn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div/div[1]/div")
    public WebElement weWorkLoginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1-email\"]")
    public WebElement emailTestField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1-password\"]")
    public WebElement passwordTestField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1-submit\"]/span")
    public WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/p")
    public WebElement userName;
}
