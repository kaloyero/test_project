package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.ArrayList;

import static utilities.ConfigReader.getProperty;

public class googleSignIn extends Driver {

    public static Logger log = LogManager.getLogger(googleSignIn.class);

    public static int count;
    @FindBy(xpath = "//button[@id='vtexIdUI-google-plus']")
    public WebElement signInWithGoogle;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement googleEmail;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement googlePassword;
    @FindBy(xpath = "//button//span[text()='Siguiente']")
    public WebElement googleOkButton;
    @FindBy(xpath = " //span[contains(@class,'store-logo')]")
    public WebElement admitOneLogo;
    @FindBy(xpath = " //span[text()='Verifica que eres tÃº']")
    public WebElement googleExtraVerify;
    @FindBy(xpath = "//div[text()='Confirma el correo de recuperaciÃ³n']")
    public WebElement slectingEmailOption;
    @FindBy(xpath = "//span[text()='Entrar Con Google']")
    public WebElement enterViaGoogle;
    String fakePass, codeReceived, randomEmailID, mailProductNameCheck, UiProductName, UiProductPrice, firstName, surname, dni, phoneNumber, streetName, streetNumber, zipcode;


    public googleSignIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginViaGoogle(String gogEmail, String gogPassword) {
        try {
            waitForVisibility(signInWithGoogle, 20);
            signInWithGoogle.click();
            log.info("clicking on sign with google option");
            changeTabByIndex(1);
            driver.switchTo().activeElement();
            log.info("clicking on ok button");
            waitForVisibility(googleEmail, 20);
            googleEmail.sendKeys(gogEmail);
            googleOkButton.click();
            log.info("Entering the email id....." + gogEmail);
            waitForVisibility(googlePassword, 20);
            googlePassword.sendKeys(gogPassword);
            log.info("Entering the password....." + gogPassword);
            googleOkButton.click();
            log.info("clicking on ok button");
            Thread.sleep(3000);
            try {
                if (googleExtraVerify.isDisplayed()) {
                    log.info("Google extra verification has been displayed....");
                    waitForVisibility(slectingEmailOption, 20);
                    slectingEmailOption.click();
                    log.info("Selecting Email option....");
                    waitForVisibility(googleEmail, 20);
                    googleEmail.sendKeys(getProperty("admitoneMalainatorconfirmEmail"));
                    log.info("entering confirm email.... " + getProperty("admitoneMalainatorconfirmEmail"));
                    googleOkButton.click();

                }
            } catch (Exception e) {
                Assert.assertTrue(true);
                log.info("extra verification code is not displayed...");
            }

            changeTabByIndex(0);
            driver.switchTo().activeElement();
            waitForVisibility(admitOneLogo, 30);
            log.info("Admit one log os displayed after sign in via google");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void enterWithGoogle(String gogEmail, String gogPassword) {
        try {
            waitForVisibility(enterViaGoogle, 20);
            enterViaGoogle.click();
            log.info("clicking on sign with google option");
            waitForVisibility(googleEmail, 20);
            googleEmail.sendKeys(gogEmail);
            googleOkButton.click();
            log.info("Entering the email id....." + gogEmail);
            waitForVisibility(googlePassword, 20);
            googlePassword.sendKeys(gogPassword);
            log.info("Entering the password....." + gogPassword);
            googleOkButton.click();
            log.info("clicking on ok button");
            Thread.sleep(3000);
            waitForVisibility(admitOneLogo, 30);
            log.info("store log os displayed after sign in via google");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void changeTabByIndex(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        log.info("Swiching Tabs");
    }
}
