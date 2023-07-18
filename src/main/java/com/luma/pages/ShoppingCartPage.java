package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//input[@class='input-text qty'])[1]")
    WebElement quantity;
    //By quantity = By.xpath("(//input[@class='input-text qty'])[1]");
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Update Shopping Cart']")
    WebElement update;
    //By update = By.xpath("//span[normalize-space()='Update Shopping Cart']");

    public void changeQuantity(String text) {
        Reporter.log("Change Quantity "+text);
        quantity.clear();
        sendTextToElement(quantity, text);
        CustomListeners.test.log(Status.PASS,"Change Quantity "+text);
    }

    public void clickOnUpdate() {
        Reporter.log("Click on Update");
        clickOnElement(update);
        CustomListeners.test.log(Status.PASS,"Click on Update");
    }
}
