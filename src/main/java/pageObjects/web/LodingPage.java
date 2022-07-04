package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LodingPage {

//    @FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/div[3]/a")
//    public WebElement enterpriseButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[3]/div/div/div/div[3]/div/a[2]")
    public WebElement termsAndServices;
}
