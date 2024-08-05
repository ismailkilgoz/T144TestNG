package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_SoftAssertion {

    /*
        TestNG coklu assertion bulunduran method'larda
        failed olan ilk assertion'da kodun calismasini durdurmadan
        testin sonuna kadar calismasini saglayacak bir ALTERNATIF sunar

        Soft assert kullanildiginda
        BIZ RAPORLA diyene kadar
        assertion'larin sonuclarini kaydeder ama calismayi durdurmaz

        biz ne zaman RAPORLA dersek
        failed olan assertion'lari rapor eder
        ve failed olan assertion varsa calismayi durdurur

        SoftAssert'un en buyuk artisi


        SoftAssert'un eksileri
        1- Eger en sonda assertAll() calistirilmazsa
           failed olan assertion olsa bile test PASSED der

        2- hatalari assertAll() ile verdiginden
           hata satiri olarak assertAll() 'un bulundugu satiri verir

        3- hatalari toplu verdigi icin
        hangi hatanin hangi assertion'da verildigini belirten aciklama yazmamiz gerekir
     */

    @Test
    public void aramaTesti() {

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        // SoftAssert kullanmak icin 3 adima ihtiyac var
        // 1. adim softAssert objesi olusturmak

        SoftAssert softAssert = new SoftAssert();

        // 2. yapilacak tum assertion'lari softAssert objesi ile yapmak

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // belirlenmis arama kelimesi icin arama yapin
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime"), Keys.ENTER);
        ReusableMethods.bekle(2);

        // bulunan urun sayisinin 3'ten fazla oldugunu test edin

        int expectedMinUrunSayisi = 3;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(actualBulunanUrunSayisi>expectedMinUrunSayisi);

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // acilan sayfada urun isminde case sensitive olmadan
        // aranacak kelimenin bulundugunu test edin

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText().toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(ConfigReader.getProperty("toAranacakKelime")));

        // 3. adim softAssert objesine yaptigi assertion'lari RAPORLAMASINI soyleyelim

        softAssert.assertAll();

        Driver.quitDriver();
    }
}