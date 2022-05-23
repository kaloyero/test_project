package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class VtexPage_kosiukoar extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_kosiukoar.class);

    @FindBy(xpath = " //div[contains(@class,'searchBarContainer')]")
    public WebElement searchBoxIcon;

    @FindBy(xpath = "//div[contains(@class,'autoCompleteOuterContainer')]//input")
    public WebElement searchBox;

    @FindBy(xpath = "//section[contains(@class,'tileList')]//li")
    public List<WebElement> searchListResult;

    @FindBy(xpath = "//button//span[contains(text(),'COMPRAR')]")
    public WebElement comprar;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[contains(@class,'close-icon')]")
    public WebElement itemAddedNotificationCloseIcon;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ítem agregado a su carrito']")
    public WebElement itemAddedNotification;

    @FindBy(xpath = "//a[contains(@href,'www.kosiuko.com')]")
    public WebElement kosiukoLogo;




    public VtexPage_kosiukoar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void SearchProduct(String whatToSearch) {
        WebElement listOfElement;

        try {
            searchBoxIcon.click();
            searchBox.sendKeys(whatToSearch);
            log.info("Entering the Product to search .." + whatToSearch);
            count = searchListResult.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed");
                listOfElement = searchListResult.get(1);
                UiProductName = listOfElement.findElement(By.xpath("//span[contains(@class,'productBrand')]")).getText();
                log.info("The Product name is ..." + UiProductName);
                UiProductPrice = listOfElement.findElement(By.xpath("//div[contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).getText();
                log.info("The Product price is ..." + UiProductPrice);
//                UiProductPrice = amountSplit(UiProductPrice);
//                listOfElement.click();
                js.executeScript("arguments[0].click();", listOfElement.findElement(By.xpath("//span[contains(@class,'currencyContainer')]")));
//                driver.findElement(By.xpath("(//section[contains(@class,'tileList')]//li//span[contains(@class,'currencyContainer')])[3]")).click();
                log.info("Clicking on buy button...");
                wait(3);
                js.executeScript("window.scrollBy(0,500)");
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


}

