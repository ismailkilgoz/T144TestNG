package tests.day13_TestNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

    /*
        TestNG test method'larinin oncelik belirtmez isek Harf Sirasina uygun olarak calistirir
        Eger test method'larinin calismasini isim sirasi disindaki bir siralama yapmak istersek
        methodlara kucukten buyuge dogru priority degeri verebiliriz
        priority degeri belirtmezsek, default olarak 0 degerini alir

     */

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

    // 3 farkli test methodu olusturup asagidaki testleri yapin
    // 1- testotomasyonu anasayfaya gidip, logo gorundugunu test edin
    // 2- wisequarter.com anasayfaya gidip title'in Wise icerdigini test edin
    // 3- youtube anasayfaya gidip url'in youtube icerdigini test edin

    @Test(priority = 2)
    public void testotomasyonuTesti(){
        // 1- testotomasyonu anasayfaya gidip, logo gorundugunu test edin
        driver.get("https://www.testotomasyonu.com/");

        WebElement logoElementi = driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test(priority = 1)
    public void wisequarterTest(){
        // 2- wisequarter.com anasayfaya gidip title'in Wise icerdigini test edin
        driver.get("https://www.wisequarter.com/");

        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
    }

    @Test(priority = 0)
    public void youtubeTesti(){
        // 3- youtube anasayfaya gidip url'in youtube icerdigini test edin
        driver.get("https://www.youtube.com/");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
