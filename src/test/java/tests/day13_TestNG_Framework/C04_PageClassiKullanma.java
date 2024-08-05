package tests.day13_TestNG_Framework;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C04_PageClassiKullanma {


    @Test(groups = {"smoke,E2E 1"})
    public void test01() {
    Driver.getDriver().get("https://www.testotomasyonu.com/");

    // TestNG POM'de pages class'lari altindaki locate edilmis
        // WebElement'leri kullanmak icin ilgili class'tan obje olustururuz
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        testOtomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

        String expectedIsimIcerik = "phone";
        String actualIsim = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                .getText()
                .toLowerCase();


        Driver.quitDriver();
    }
}
