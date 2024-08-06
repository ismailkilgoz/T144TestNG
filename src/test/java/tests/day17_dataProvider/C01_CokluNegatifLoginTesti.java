package tests.day17_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_CokluNegatifLoginTesti {
    @DataProvider
    public static Object[][] testDatalariGonder() {

        String[][] kullaniciDatalariArr = {

                {"banu@gmail.com","898989"},
                {"sedat@yahoo.com","989887"},
                {"orkong@tmail.com","122334"},
                {"fatih@hotmail.com","454545"},
                {"arzu@senmail.com","676767"},
                {"mehmet@mynet.com","878987"}

        };

        return kullaniciDatalariArr;
    }

    // 1. testotomasyonu anasayfaya gidin
    // 2. Account linkine tiklayin
    // 3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
    // 4.   banu@gmail.com     898989
    //      sedat@yahoo.com    989887
    //      orkong@tmail.com   122334
    //      fatih@hotmail.com  454545
    //      arzu@senmail.com   676767
    //      mehmet@mynet.com   878987



    @Test(dataProvider = "testDatalariGonder")
    public void cokluNegatifLoginTesti(String email, String password){

        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2. Account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki
                .click();
        // 3. Asagida verilen kullanici adi ve sifreleri ile
        testOtomasyonuPage.loginEmailKutusu
                .sendKeys(email);

        testOtomasyonuPage.loginPasswordKutusu
                .sendKeys(password);

        // giris yapilamadigini test edin
        // email kutusunun hala gorunur oldugunu test edelim

        Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());

    }
}