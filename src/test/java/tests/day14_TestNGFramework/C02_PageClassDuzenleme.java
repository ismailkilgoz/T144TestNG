package tests.day14_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C02_PageClassDuzenleme {

    @Test(groups = "smoke")
    public void aramaTesti(){

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone", Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        int actualSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualSonucSayisi>0);

        // sayfayi kapatin
        Driver.quitDriver();
    }
}
