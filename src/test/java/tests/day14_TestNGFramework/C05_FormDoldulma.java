package tests.day14_TestNGFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_FormDoldulma {

    @Test(groups = {"smoke","E2E 1"})
    public void test01(){

        // 1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        // 2- Sirt Agrisi ve Carpinti checkbox’larini secin
        ToFormPage toFormPage = new ToFormPage();
        toFormPage.sirtAgrisiYaziElementi.click();
        toFormPage.carpintiCheckboxElementi.click();

        // 3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(toFormPage.sirtAgrisiCheckboxElementi.isSelected());
        Assert.assertTrue(toFormPage.carpintiCheckboxElementi.isSelected());


        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(("window.scrollBy(0, 500)"));

        // 4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        Assert.assertFalse(toFormPage.sekerCheckboxElementi.isSelected());
        Assert.assertFalse(toFormPage.epilepsiCheckboxElementi.isSelected());

        // 5- sayfayi kapatin
        Driver.quitDriver();
    }
}
