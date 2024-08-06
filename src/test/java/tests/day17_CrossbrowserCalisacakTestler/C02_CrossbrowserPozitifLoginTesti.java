package tests.day17_CrossbrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_CrossbrowserPozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // Account linkine basin
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("(//*[text()='Account'])[1]")).click();

        // email olarak gecerliEmail
        ReusableMethods.bekle(1);
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // password olarak gecerliPassword degerlerini girin
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // signIn butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin")).click();

        // sisteme giris yapabildiginizi test edin
        ReusableMethods.bekle(1);
        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assert.assertTrue(logoutButonu.isDisplayed());

}
}
