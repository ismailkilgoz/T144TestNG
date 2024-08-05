package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverClassDuzenleme {

    @Test(groups = {"regression","E2E 2"})
    public void test01(){

        /*
            Driver class'inda kucuk bir duzeltme yapmamiz gerekiyor
         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // url'nin testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // window'u kapatin
        Driver.quitDriver();
    }
}
