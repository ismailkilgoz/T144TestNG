package tests.day13_TestNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_DependsOnMethods {

      /*
        EGER test method'lari birbirine bagli ise
        yani ilk method'da yapilan islem basarili olmadiginda
        sonraki method'larin calismasina gerek kalmiyorsa

        Bu durumda siralamadan bagimsiz olarak
        bir method calismadan once baska bir method'un calistigini
        ve PASSED oldugunu kontrol etmek istiyorsak
        dependsOnMethod = "... " kull;anabiliriz

        dependsOnMethods() siralamaya karismaz
        ANCAK sira bir method'a geldiginde
        once bagimli oldugu method'un calisip PASSED oldugunu kontrol eder
        eger calismamissa onceligi bagimli oldugu method'a verir

        Biz bir method'u tek basina calistirmak istedigimizde
        bagimli oldugu method varsa
        biz demesek bile once bagimli oldugu test method'unu calistirir
        sonra kendisi calisir
        ANCAK bu durum 2'den fazla test method'u icin calismaz

     */


    // 3 farkli test methodu olusturup asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, acilan urun sayfasindaki isimde case sensitive olmadan phone bulundugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void urunAramaTesti(){
        // 2- phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = driver.findElement(By.className("product-count-text"))
                .getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

    }
    @Test(dependsOnMethods = "urunAramaTesti")
    public void ilkUrunIsimTesti(){
        driver.findElement(By.xpath("(//*[@class='mx-2 mb-3 mt-4'])[1]")).click();
        ReusableMethods.bekle(3);
        String expectedIsimIcerik = "phone";
        String urunBilgiDetayi = driver.findElement(By.className("prod-detail")).getText().toLowerCase();

        Assert.assertTrue(urunBilgiDetayi.contains(expectedIsimIcerik));
    }

}
