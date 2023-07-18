package com.luma.testsuite;

import com.luma.customlisteners.CustomListeners;
import com.luma.pages.DufflePage;
import com.luma.pages.HomePage;
import com.luma.pages.MenPantsPage;
import com.luma.pages.ShoppingCartPage;
import com.luma.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {
    HomePage homePage;
    MenPantsPage menPantsPage;
    DufflePage dufflePage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        menPantsPage = new MenPantsPage();
        dufflePage = new DufflePage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"Sanity","Regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(3000);
        homePage.mouseHoverOnGearAndClick();
        verifyTwoStrings("Overnight Duffle", By.xpath("//span[@class='base']"));
        dufflePage.changeQuantity("3");
        dufflePage.clickOnAddToCart();
        Thread.sleep(2000);
        verifyTwoStrings("You added Overnight Duffle to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        menPantsPage.clickOnShoppingCart();
        verifyTwoStrings("Overnight Duffle", By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        String actual = driver.findElement(By.xpath("//input[@title='Qty']")).getAttribute("value");
        Assert.assertEquals(actual, "3");
        verifyTwoStrings("$135.00", By.xpath("(//span[@class='cart-price']//span)[2]"));
        shoppingCartPage.changeQuantity("5");
        shoppingCartPage.clickOnUpdate();
        Thread.sleep(1000);
        verifyTwoStrings("$225.00",By.xpath("(//span[@class='cart-price']//span)[2]"));

    }
}
