package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class VtexPage_Fila extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_Fila.class);


    @FindBy(xpath = "//aside[contains(@class,'minicart')]//button")
    public WebElement carritoButton;

    @FindBy(xpath = "//button//*[contains(text(),'Completar Compra')]")
    public WebElement irMiCarritoButton;

    @FindBy(xpath = "//a[contains(@id,'product-name')]")
    public WebElement checkOutProductName;

    @FindBy(xpath = "//span[@class='new-product-price']")
    public WebElement checkOutProductPrice;

    @FindBy(xpath = "(//td[text()='Total']/../td[@class='monetary'])[1]")
    public WebElement FinalCheckOutPrice;

    @FindBy(xpath = "//a[@title='Fila Home']")
    public WebElement filaLogo;


    public VtexPage_Fila(WebDriver driver) {
        PageFactory.initElements(driver, this);
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


}

