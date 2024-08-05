package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversityPage {

    public WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginPortalButonu;

    @FindBy(id = "text")
    public WebDriver usernameKutusu;

    @FindBy(id = "password")
    public WebDriver passwordKutusu;

    @FindBy(id = "login-button")
    public WebDriver loginButonu;

}
