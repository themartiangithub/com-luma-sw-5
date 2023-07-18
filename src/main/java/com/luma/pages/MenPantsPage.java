package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MenPantsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Cronus Yoga Pant']")
    WebElement cronusPant;
    //By cronusPant = By.xpath("//a[normalize-space()='Cronus Yoga Pant']");
    @CacheLookup
    @FindBy(xpath = "(//div[@class='swatch-option text'])[1]")
    WebElement size32;
    //By size32 = By.xpath("(//div[@class='swatch-option text'])[1]");
    @CacheLookup
    @FindBy(xpath = "(//div[@class='swatch-option color'])[1]")
    WebElement color;
    //By color = By.xpath("(//div[@class='swatch-option color'])[1]");
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")
    WebElement addToCart;
    //By addToCart = By.xpath("(//span[contains(text(),'Add to Cart')])[1]");
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCart;
    //By shoppingCart = By.xpath("//a[normalize-space()='shopping cart']");

    public void mouseHoverOnPantAndClick() throws InterruptedException {
        Reporter.log("Mouse hover on Cronus Pant");
        mouseHoverToElement(cronusPant);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Cronus Pant ");
        Thread.sleep(1000);
        Reporter.log("Mouse hover on Size and click ");
        mouseHoverToElementAndClick(size32);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Size and click ");
        Thread.sleep(1000);
        Reporter.log("Mouse hover on Color and click ");
        mouseHoverToElementAndClick(color);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Color and click ");
    }

    public void clickOnAddToCart() throws InterruptedException {
        Reporter.log("Mouse hover on Cronus Pant ");
        mouseHoverToElement(cronusPant);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Cronus Pant ");
        Thread.sleep(1000);
        Reporter.log("Mouse hover on Add to Cart and click ");
        mouseHoverToElementAndClick(addToCart);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Add to Cart and click ");
        Thread.sleep(1000);
    }

    public void clickOnShoppingCart() throws InterruptedException {
        Reporter.log("Click on Shopping Cart ");
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on Shopping Cart ");
        Thread.sleep(1000);
    }

}
