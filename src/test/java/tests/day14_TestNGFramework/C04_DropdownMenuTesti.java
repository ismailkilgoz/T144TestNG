package tests.day14_TestNGFramework;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DropdownMenuTesti {

    @Test
    public void test01(){

        // 1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        // 2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        ToFormPage toFormPage = new ToFormPage();
        Select selectGun = new Select(toFormPage.gunDropdownElementi);
        selectGun.selectByIndex(5);

        // 3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(toFormPage.ayDropdownElementi);
        selectAy.selectByValue("nisan");

        // 4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(toFormPage.yilDropdownElementi);
        selectYil.selectByVisibleText("1990");

        // 5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        // 6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ReusableMethods.getStringList(selectAy.getOptions()));

        // 7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int ayDropdownmenuSize = selectAy.getOptions().size();
        int expectedSize = 13;

        Assert.assertEquals(ayDropdownmenuSize,expectedSize);

        Driver.quitDriver();
    }
}
