package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DufflePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='qty']")
    WebElement quantity;
    //By quantity = By.xpath("//input[@id='qty']");
    @CacheLookup
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    WebElement addToCart;
    //By addToCart = By.xpath("//button[@id='product-addtocart-button']");

    public void changeQuantity(String text) {
        Reporter.log("Change Quantity "+text);
        quantity.clear();
        sendTextToElement(quantity, text);
        CustomListeners.test.log(Status.PASS, "Change Quantity "+text);
    }

    public void clickOnAddToCart() {
        Reporter.log("Click on Add to Cart ");
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on Add to Cart ");
    }
}
