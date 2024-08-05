package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // 1 - https://www.facebook.com/ adresine gidin
    //2- Cookies cikiyorsa kabul edin
    //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    //4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    //5- Basarili giris yapilamadigini test edin



    @FindBy(id = "email")
    public WebElement mailKutusu;

    @FindBy(id = "pass")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginButonu;
}
