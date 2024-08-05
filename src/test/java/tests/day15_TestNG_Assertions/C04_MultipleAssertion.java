package tests.day15_TestNG_Assertions;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_MultipleAssertion {

    /*
        TestNG'deki Assert class'indan kullanilan
        assertion method'lari JUnit'deki Assertions gibi
        ilk failed olan Assertion'da kodun calismasini durdurur
        kodun geriye kalaninda hata olup olmadigini bilemeyiz

        kodun geriye kalanini kontrol etmedigi icin
        Bulunan hata duzeltildikten sonra
        test method'u calistirildiginda
        testin PASSED olacagini garanti edemeyiz
     */

    @Test
    public void aramaTesti(){

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // belirlenmis arama kelimesi icin arama yapin
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime"), Keys.ENTER);
        ReusableMethods.bekle(2);

        // bulunan urun sayisinin 3'ten fazla oldugunu test edin

        int expectedMinUrunSayisi = 3;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi>expectedMinUrunSayisi);

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // acilan sayfada urun isminde case sensitive olmadan
        // aranacak kelimenin bulundugunu test edin

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(ConfigReader.getProperty("toAranacakKelime")));

        Driver.quitDriver();

    }
}
