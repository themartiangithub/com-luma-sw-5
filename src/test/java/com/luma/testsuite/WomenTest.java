package com.luma.testsuite;

import com.luma.customlisteners.CustomListeners;
import com.luma.pages.HomePage;
import com.luma.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest{

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
    }

    @Test(groups = {"Sanity","Regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(3000);
        homePage.mouseHoverOnWomenTopsAndClick();
        Thread.sleep(3000);

        // Storing jackets names in list
        List<WebElement> jacketsElementsList = webElementList(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListBefore.add(value.getText());
        }
        // Select Sort By filter “Product Name”
        homePage.selectSortingOption("Product Name");
        // After Sorting value
        jacketsElementsList = webElementList(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListAfter = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value : jacketsElementsList) {
            jacketsNameListAfter.add(value.getText());
        }
        // Sort the before name list into Ascending Order
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        // Verify the products name display in alphabetical order
        Assert.assertEquals(jacketsNameListBefore, jacketsNameListAfter);
    }

    @Test(groups = {"Smoke","Regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        homePage.mouseHoverOnWomenTopsAndClick();
        Thread.sleep(3000);

        List<WebElement> jacketsPriceElementList = webElementList(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement value : jacketsPriceElementList) {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Select Sort By filter “Price”
        homePage.selectSortingOption("Price");
        // After Sorting Products by Price
        jacketsPriceElementList = webElementList(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListAfter = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value : jacketsPriceElementList) {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(jacketsPriceListBefore);
        // Verify the products price display in Low to High
        Assert.assertEquals(jacketsPriceListBefore, jacketsPriceListAfter);
    }

}
