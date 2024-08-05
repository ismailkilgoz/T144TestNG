package tests.day15_TestNG_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_SoftAssertion {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("wasUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        WebAppSecurityPage webAppSecurity = new WebAppSecurityPage();


        softAssert.assertTrue(webAppSecurity.zeroBankLogo.isDisplayed(),
                "Zerobank logosu gorunmuyor");


        // 3. Sign in butonuna basin
        webAppSecurity.anasayfadakiSigninButonu.click();

        // 4. Login kutusuna “username” yazin
        webAppSecurity.loginKutusu.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        webAppSecurity.passwordKutusu.sendKeys("password");

        // 6. Sign in tusuna basin
        webAppSecurity.loginSinginButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(webAppSecurity.girisYapilanKullanici.isDisplayed(),
                "Sayfaya giris yapilamadi, kullanici bilgilerini kontrol edin");

        // 9. Online banking menusunu tiklayin
        webAppSecurity.onlineBankingButonu.click();

        //10. Pay Bills sayfasina gidin
        webAppSecurity.payBillsLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        webAppSecurity.foreignCurrencySekmesi.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(webAppSecurity.pcCurrencyDropdown.isEnabled(),
                "PC Currency dropdown erisilemiyor");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(webAppSecurity.pcCurrencyDropdown);

        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption);

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,
                "Dropdown menude option sayisi expected'dan farkli");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        String expectedOptionsIcerik = "Canada (dollar)";

        List < WebElement> optionsElementList = select.getOptions();
        List <String> optionsYaziList = ReusableMethods.getStringList(optionsElementList);

        softAssert.assertTrue(optionsYaziList.contains(expectedOptionsIcerik));

        //17. Sayfayi kapatin

        softAssert.assertAll();
        Driver.quitDriver();
    }
}
