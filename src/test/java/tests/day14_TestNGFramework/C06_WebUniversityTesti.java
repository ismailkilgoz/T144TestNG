package tests.day14_TestNGFramework;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_WebUniversityTesti {

    @Test
    public void test01(){

        // 1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        // 2."Login Portal" a kadar asagi inin
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", webUniversityPage.loginPortalButonu);
        ReusableMethods.bekle(1);

        // 3."Login Portal" a tiklayin
        webUniversityPage.loginPortalButonu.click();


        // 4.Diger window'a gecin
        ReusableMethods.switchWindowByTitle(Driver.getDriver(),"WebDriver | Login Portal");

        // 5."username" ve "password" kutularina fake deger yazdirin
        Faker faker = new Faker();
        String fakeUsername = faker.name().username();
        String fakePassword = faker.internet().password();

     // webUniversityPage.usernameKutusu.

        // 6."login" butonuna basin
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        // 8.Ok diyerek Popup'i kapatin
        // 9.Ilk sayfaya geri donun
        // 10.Ilk sayfaya donuldugunu test edin

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
