package tests.day14_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookTest {

    @Test(groups = "regression")
    public void test01(){

        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // 2- Cookies cikiyorsa kabul edin

        // 3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        FacebookPage facebookPage = new FacebookPage();


        // 4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        String fakeSifre = faker.internet().password();
        String fakeMail = faker.internet().emailAddress();

        facebookPage.mailKutusu.sendKeys(fakeMail);
        facebookPage.sifreKutusu.sendKeys(fakeSifre);

        facebookPage.loginButonu.click();

        // 5- Basarili giris yapilamadigini test edin

        // giris yapamadigimizi, hala email kutusunun gorundugu ile test edebiliriz
        Assert.assertTrue(facebookPage.mailKutusu.isDisplayed());

        Driver.quitDriver();
    }

}
