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

import java.util.ArrayList;
import java.util.List;

public class VtexPage_Minoar extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_Minoar.class);


    @FindBy(xpath = "//div[contains(@class,'autoCompleteOuterContainer')]//input")
    public WebElement searchBox;

    @FindBy(xpath = "//article[contains(@class,'vtex-search')]//li//a")
    public List<WebElement> searchBoxLink;

    @FindBy(xpath = "(//div[contains(@class,'search-content')])[3]")
    public WebElement searchResultUmbroar;

    @FindBy(xpath = "(//div[contains(@class,'search-content')])[3]//div[contains(@class,'items-stretch')]")
    public List<WebElement> searchResultCountUmbroar;

    @FindBy(xpath = "//div[contains(@class,'searchBarContainer')]//li//img")
    public List<WebElement> searchListResult;

    @FindBy(xpath = "//button//span[contains(@class,'buy-button')]")
    public WebElement comprar;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ítem agregado a su carrito']")
    public WebElement itemAddedNotification;

    @FindBy(xpath = "//aside[contains(@class,'minicart')]//button")
    public WebElement carritoButton;

    @FindBy(id = "proceed-to-checkout")
    public WebElement irMiCarritoButton;

    @FindBy(xpath = "//a[contains(@id,'product-name')]")
    public WebElement checkOutProductName;

    @FindBy(xpath = "//span[@class='new-product-price']")
    public WebElement checkOutProductPrice;

    @FindBy(xpath = "(//td[text()='Total']/../td[@class='monetary'])[1]")
    public WebElement FinalCheckOutPrice;

    @FindBy(xpath = "//div[contains(@class,'skuSelectorContainer--talle')]//span[contains(text(),'Selecciona una opción')]")
    public WebElement ErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'skuSelectorContainer--talle')]//select")
    public WebElement selectTalle;

    @FindBy(xpath = "//p[text()='Todavía no tenés nada en tu carrito']")
    public WebElement emptyCartMessage;

    @FindBy(xpath = "//a[contains(@class,'container-logo-checkout')]")
    public WebElement logoClick;

    @FindBy(xpath = "//span[contains(text(),'Mercado Pago') and contains(@class,'payment-group')]")
    public WebElement mercPagoOpt;

    @FindBy(xpath = "//span[text()='Comprar ahora']/..//i[@class='icon-spinner icon-spin' and @style='display: none;']/..")
    public WebElement finalComprar;

    @FindBy(xpath = "//span[text()='Efectivo']")
    public WebElement merPagpEfectOption;

    @FindBy(id = "mercadopago-checkout")
    public WebElement MpIframe;



    public VtexPage_Minoar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getListInSearchBox(WebElement searchResult, List<WebElement> searchResultCount) {

        String searchLink;
        ArrayList<String> searchBarLink = new ArrayList<String>();


        try {
            searchBox.sendKeys(" ");
            log.info("Entering the Product to search ..");
            count = searchBoxLink.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed and total count is " + count);
                for (WebElement listOfElement : searchBoxLink) {
                    searchLink = listOfElement.getAttribute("href");
                    System.out.println(searchLink);
                    searchBarLink.add(searchLink);
                }
                for (int i = 0; i < searchBarLink.size(); i++) {
                    log.info("launching the url " + searchBarLink.get(i));
                    driver.get(searchBarLink.get(i));
                    waitForVisibility(searchResult, 20);
                    wait(3);
                    count = searchResultCount.size();
                    if (count > 1) {
                        log.info("more than 1 product has been displayed");
                    } else {
                        log.info("no product has been displayed");
                        Assert.fail("no product has been displayed");
                    }


                }
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

    public void SearchProduct(String whatToSearch) {
        WebElement listOfElement;

        try {
            wait(3);
            searchBox.sendKeys(whatToSearch);
            log.info("Entering the Product to search .." + whatToSearch);
            count = searchListResult.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed");
                listOfElement = searchListResult.get(0);
                UiProductName = listOfElement.findElement(By.xpath("..//div")).getText();
                log.info("The Product name is ..." + UiProductName);
                // Mimo marca no tiene precio
                listOfElement.findElement(By.xpath("..//div")).click();
                log.info("Trying Clicking on buy button...");
                wait(3);
                waitForVisibility(comprar, 20);
//                comprar.click();
//                log.info("waiting for error message to select talle...");
//                waitForVisibility(ErrorMessage,20);
                selectRandomTextFromDropdown(selectTalle,2);
                comprar.click();


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
        String[] strArray;

        try {
            waitForVisibility(irMiCarritoButton, 15);
            irMiCarritoButton.click();
            log.info("clicking on ir mi carrito button....");
            waitForVisibility(checkOutProductName, 10);
            ChckPrdName = checkOutProductName.getText();
            log.info("Product name from UI is .. " + ChckPrdName);
            strArray = ChckPrdName.split("-");
            log.info("Product name after splitting the size ... " + strArray[0]);
            Assert.assertTrue(strArray[0].trim().equalsIgnoreCase(UiProductName), "Product name does not match with..");
            log.info("Product name validation done ..");
            ChckPrdPrice = checkOutProductPrice.getText();
            // Assert.assertEquals(Double.parseDouble(ChckPrdPrice),Double.parseDouble(UiProductPrice));
            log.info("Product price validation done ..");
            log.info("final product price is ..." + FinalCheckOutPrice.getText());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectMercodoPagoOpt() {
        try {
            log.info("Trying to select the mercado pago option.");
            waitForVisibility(mercPagoOpt, 10);
            mercPagoOpt.click();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void mercPagoEffectivo() {
        try {
            waitForVisibility(MpIframe, 20);
            log.info("iframe element is now visible....");
            driver.switchTo().frame(MpIframe);
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

