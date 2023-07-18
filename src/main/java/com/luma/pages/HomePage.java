package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Women']")
    WebElement women;
    //By women = By.xpath("//span[normalize-space()='Women']");
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-9']//span[contains(text(),'Tops')]")
    WebElement tops;
    //By tops = By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]");
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
    WebElement womenJackets;
    //By womenJackets = By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]");
    @CacheLookup
    @FindBy(xpath = "(//select[@id='sorter'])[1]")
    WebElement selectSorting;
    //By selectSorting = By.xpath("(//select[@id='sorter'])[1]");
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
    WebElement men;
    //By men = By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']");
    @CacheLookup
    @FindBy(xpath = "//li[@class = 'level1 nav-3-2 category-item last parent ui-menu-item']//span[contains(text(),'Bottoms')]")
    WebElement bottoms;
    //By bottoms = By.xpath("//li[@class = 'level1 nav-3-2 category-item last parent ui-menu-item']//span[contains(text(),'Bottoms')]");
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']//span[contains(text(),'Pants')]")
    WebElement pants;
    //By pants = By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]");
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Gear']")
    WebElement gear;
    //By gear = By.xpath("//span[normalize-space()='Gear']");
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Bags']")
    WebElement bags;
    //By bags = By.xpath("//span[normalize-space()='Bags']");
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Overnight Duffle']")
    WebElement duffle;
    //By duffle = By.xpath("//a[normalize-space()='Overnight Duffle']");

    public void mouseHoverOnWomenTopsAndClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Women']")));
        Reporter.log("Mouse hover on Women ");
        mouseHoverToElement(women);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Women ");
        Thread.sleep(1000);
        Reporter.log("Mouse hover on Tops ");
        mouseHoverToElement(tops);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Tops ");
        Thread.sleep(1000);
        Reporter.log("Mouse hover on Women Jackets and Click ");
        mouseHoverToElementAndClick(womenJackets);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Women Jackets and Click ");
        Thread.sleep(1000);
    }

    public void mouseHoverOnMenBottomsAndClick() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")));
        Reporter.log("Mouse hover on Men ");
        mouseHoverToElement(men);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Men ");
        Thread.sleep(5000);
        Reporter.log("Mouse hover on Bottoms");
        mouseHoverToElement(bottoms);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Bottoms");
        Thread.sleep(5000);
        Reporter.log("Mouse hover on Pants and click ");
        mouseHoverToElementAndClick(pants);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Pants and click ");

    }

    public void selectSortingOption(String text) throws InterruptedException {
        Reporter.log("Select Sorting "+text);
        selectByVisibleTextFromDropDown(selectSorting, text);
        CustomListeners.test.log(Status.PASS, "Select Sorting "+text);
        Thread.sleep(1000);
    }

    public void mouseHoverOnGearAndClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Gear']")));
        Reporter.log("Mouse hover on Gear ");
        mouseHoverToElement(gear);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Gear ");
        Thread.sleep(5000);
        Reporter.log("Mouse hover on Bags and Click ");
        mouseHoverToElementAndClick(bags);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Bags and Click ");
        Thread.sleep(3000);
        Reporter.log("Click on Duffle ");
        clickOnElement(duffle);
        CustomListeners.test.log(Status.PASS, "Click on Duffle ");
    }

}
