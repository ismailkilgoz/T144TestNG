package tests.day17_CrossbrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_CrossbrowserAramaTesti extends TestBaseCross {

    /* .xml dosyasindan parametre olarak gonderilen
     calisacakBrowser'i buradan yakalayacagimiz bir sistem kurduk

     1- .xml calisacakBrowser'i parametre olarak yollar
     2- her class'da ugrasmamak icin
        olusturdugumuz TestBaseCross calisacakBrowser parametresini yakalar
        ve calisacakBrowser'a uygun WebDriver objesi olusturmasi icin
        DriverCross'u calistirir
     3- DriverCross kendisine parametre olarak gonderilen calisacakBrowser'a
        uygun WebDriver'i olusturup TestBaseCross'a dondurur
     4- TestBaseCross DriverCross'dan gelen WebDriver'i
        "driver" objesine atama yapar
     5- Test class'inda "driver" objesini kullanarak testlerimizi yazacagiz

     ONEMLI NOT  :  Page class'larinda Driver.getDriver() tanimli oldugundan
                    crossBrowser testler icin varolan Page class'larini kullanamayiz
     */



    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // belirlenen aranacakKelime icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime"),Keys.ENTER);
        ReusableMethods.bekle(1);

        // arama sonucunda urun bulunabildigini test edin
        String unExpectedSonucYazisi = "0 Products Found";

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

        // sayfayi kapatin
        // TestBaseCross'da @AfterMethod sayfayi kapatiyor.

    }

}
