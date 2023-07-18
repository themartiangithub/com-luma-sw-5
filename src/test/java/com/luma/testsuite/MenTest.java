package com.luma.testsuite;

import com.luma.customlisteners.CustomListeners;
import com.luma.pages.HomePage;
import com.luma.pages.MenPantsPage;
import com.luma.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MenTest extends BaseTest {

    HomePage homePage;
    MenPantsPage menPantsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        menPantsPage = new MenPantsPage();
    }

    @Test(groups = {"Sanity","Regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homePage.mouseHoverOnMenBottomsAndClick();
        menPantsPage.mouseHoverOnPantAndClick();
        menPantsPage.clickOnAddToCart();
        verifyTwoStrings("You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        menPantsPage.clickOnShoppingCart();
        verifyTwoStrings("Shopping Cart",By.xpath("//span[@class='base']"));
        verifyTwoStrings("Cronus Yoga Pant",By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        verifyTwoStrings("32",By.xpath("//dd[contains(text(),'32')]"));
        verifyTwoStrings("Black",By.xpath("//dd[contains(text(),'Black')]"));

    }
}
