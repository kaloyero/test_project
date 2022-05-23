package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class OmsLoginPage extends Driver {

    // Locators
    private final By storeIdInput = By.cssSelector("#storeId");
    private final By loginButton = By.cssSelector(".ant-btn-lg");
    private final By emailInputGoogle = By.cssSelector("#identifierId");
    private final By nextGoogleButtonAfterWriteEmail = By.cssSelector("#identifierNext > div > button");
    private final By passwordInputGoogle = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
    private final By nextGoogleButtonAfterWritePass = By.xpath("//*[@id='passwordNext']/div/button/span");
    private final By linkVentas = By.xpath("//span[contains(text(), 'Ventas')]");
    private final By linkListadoDeOrdenes = By.xpath("//a[contains(text(), 'Listado de ordenes')]");

    // Methods
    public void clickStoreIdInput() {
        click(storeIdInput);
    }

    public void enterIdStoreInIdTiendaInput(String value) {
        sendValue(storeIdInput, value);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void loginByParams(String value) {
        try {
            clickStoreIdInput();
            enterIdStoreInIdTiendaInput(value);
            Thread.sleep(1000);
            clickLoginButton();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginWithMimoStoreId() {
        loginByParams("55");
    }

    public void loginWithFilaStoreId() {
        loginByParams("74");
    }

    public void enterGoogleEmail() {
        sendValue(emailInputGoogle, getProperty("testUser"));
    }

    public void clickNextGoogleButtonAfterEnterEmail() {
        click(nextGoogleButtonAfterWriteEmail);
    }

    public void enterGooglePassword() {
        sendValue(passwordInputGoogle, getProperty("testPass"));
    }

    public void clickNextGoogleButtonAfterEnterPassword() {
        click(nextGoogleButtonAfterWritePass);
    }

    public void loginGoogleWithTestUser() {
        enterGoogleEmail();
        clickNextGoogleButtonAfterEnterEmail();
        enterGooglePassword();
        clickNextGoogleButtonAfterEnterPassword();
    }

    public void navigateToListadoDeOrdenes() {
        //mouseHoverElementAndClickInternalElement(linkVentas, linkListadoDeOrdenes);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(linkVentas)).perform();
        click(linkListadoDeOrdenes);
    }
}
