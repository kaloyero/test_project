package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class VtexPage_Vitamin extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_Vitamin.class);


    @FindBy(xpath = "//div[contains(@class,'autoCompleteOuterContainer')]//input")
    public WebElement searchBox;

    @FindBy(xpath = "//article[contains(@class,'vtex-search')]//li//a")
    public List<WebElement> searchBoxLink;

    @FindBy(xpath = "(//div[contains(@class,'search-content')])[3]")
    public WebElement searchResultUmbroar;

    @FindBy(xpath = "(//div[contains(@class,'search-content')])[3]//div[contains(@class,'items-stretch')]")
    public List<WebElement> searchResultCountUmbroar;

    @FindBy(xpath = "//section[contains(@class,'tileList')]//li")
    public List<WebElement> searchListResult;

    @FindBy(xpath = "//button//span[contains(@class,'buttonText') or contains(@class,'buyButtonText')]")
    public WebElement comprar;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ítem agregado a su carrito']")
    public WebElement itemAddedNotification;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[contains(@class,'close-icon')]")
    public WebElement itemAddedNotificationCloseIcon;


    @FindBy(xpath = "//aside[contains(@class,'minicart')]//button")
    public WebElement carritoButton;

    @FindBy(xpath = "//button[@id='proceed-to-checkout']")
    public WebElement irMiCarritoButton;

    @FindBy(xpath = "//a[contains(@id,'product-name')]")
    public WebElement checkOutProductName;

    @FindBy(xpath = "//span[@class='new-product-price']")
    public WebElement checkOutProductPrice;

    @FindBy(xpath = "(//td[text()='Total']/../td[@class='monetary'])[1]")
    public WebElement FinalCheckOutPrice;

    @FindBy(xpath = "//span[text()='Efectivo']")
    public WebElement merPagpEfectOption;


    public VtexPage_Vitamin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void SearchProduct(String whatToSearch) {
        WebElement listOfElement;

        try {
            searchBox.sendKeys(whatToSearch);
            log.info("Entering the Product to search .." + whatToSearch);
            count = searchListResult.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed");
                listOfElement = searchListResult.get(0);
                UiProductName = listOfElement.findElement(By.xpath("//span[contains(@class,'productBrand')]")).getText();
                log.info("The Product name is ..." + UiProductName);
                UiProductPrice = listOfElement.findElement(By.xpath("//div[contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).getText();
                log.info("The Product price is ..." + UiProductPrice);
//                UiProductPrice = amountSplit(UiProductPrice);
                listOfElement.click();
//                listOfElement.findElement(By.xpath("//div[contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).click();
                log.info("Clicking on buy button...");
                js.executeScript("window.scrollBy(0,400)");
                waitForVisibility(comprar, 20);
                wait(2);
                comprar.click();
                waitForVisibility(itemAddedNotification, 20);
                Assert.assertTrue(itemAddedNotification.isDisplayed(), "notification is not displayed");
                itemAddedNotificationCloseIcon.click();

            } else {
                log.info("no product has been displayed");
                Assert.fail("no product has been displayed with that search keyword");
            }


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void cartCheckOut() {
        String ChckPrdName, ChckPrdPrice;

        try {
            wait(2);
            carritoButton.click();
            log.info("clicking on cart checkout icon ..");
            wait(2);
            waitForVisibility(irMiCarritoButton, 15);
            irMiCarritoButton.click();
            log.info("clicking on ir mi carrito button....");
            waitForVisibility(checkOutProductName, 10);
            ChckPrdName = checkOutProductName.getText();
            log.info("Product name from UI is .. " + ChckPrdName);
            Assert.assertTrue(ChckPrdName.contains(UiProductName), "Product name does not match with..");
            log.info("Product name validation done ..");
            ChckPrdPrice = checkOutProductPrice.getText();
//            Assert.assertEquals(Double.parseDouble(ChckPrdPrice),Double.parseDouble(UiProductPrice));
            log.info("Product price validation done ..");
            log.info("final product price is ..." + FinalCheckOutPrice.getText());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void mercPagoEffectivo() {
        try {
            log.info("Clicking on Effectivo Option");
            waitForVisibility(merPagpEfectOption, 20);
            merPagpEfectOption.click();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


}

