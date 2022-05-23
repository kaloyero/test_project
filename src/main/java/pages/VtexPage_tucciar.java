package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class VtexPage_tucciar extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_tucciar.class);

    @FindBy(name = "token")
    public WebElement enterCode;

    @FindBy(xpath = " //input[normalize-space(@placeholder)='Ingrese su contraseña']")
    public WebElement enterPassword;

    @FindBy(xpath = " //input[normalize-space(@placeholder)='Confirmar contraseña']")
    public WebElement enterConfirmPassword;

    @FindBy(xpath = " //div[contains(@class,'sendButton')]//button")
    public WebElement createButton;

    @FindBy(xpath = "//div[contains(@class,'login')]//button")
    public WebElement loginSuccess;

    @FindBy(xpath = "//a[@id='payment-group-MercadoPagoPaymentGroup']")
    public WebElement mercadoPagoOption;


    public VtexPage_tucciar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void enterTokenAndPassword() {
        fakePass = faker.internet().password(10, 13, true, true, true);


        try {
            log.info("code recived is " + codeReceived);
            enterCode.sendKeys(codeReceived);
            log.info("clicking on login icon");
            enterPassword.sendKeys(fakePass);
            log.info("entering new password.." + fakePass);
            enterConfirmPassword.sendKeys(fakePass);
            log.info("entering new confirm password.." + fakePass);
            createButton.click();
            log.info("clicking on create button..");
            wait(5);
            waitForVisibility(loginSuccess, 10);
            Assert.assertTrue(loginSuccess.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectMercadoPagoOption() {
        try {
            log.info("Selecting mercado pago option");
            waitForVisibility(mercadoPagoOption, 20);
            mercadoPagoOption.click();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


}

