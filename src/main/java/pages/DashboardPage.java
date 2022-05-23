package pages;

import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import org.openqa.selenium.By;

import static utilities.ConfigReader.getProperty;


public class DashboardPage extends Driver{

    //Locators
    private final By emailInputGoogle = By.cssSelector("#identifierId");
    private final By passwordInputGoogle = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private final By googleButtonContinueWithGoogle = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/button");
    private final By nextGoogleButtonAfterWriteEmail = By.cssSelector("#identifierNext > div > button");
    private final By nextGoogleButtonAfterWritePass = By.cssSelector("#passwordNext > div > button");
    private final By VitaminaButton = By.cssSelector("#root > div > ul > li:nth-child(6) > a");

    // Methods
    public void enterGoogleEmail() { sendValue(emailInputGoogle, getProperty("testQa"));}

    public void enterGooglePassword() {
        sendValue(passwordInputGoogle, getProperty("testPassQa"));
    }

    public void clickGoogleButtonContinueWithGoogle() { click(googleButtonContinueWithGoogle);}

    public void clickNextGoogleButtonAfterEnterEmail() {
        click(nextGoogleButtonAfterWriteEmail);
    }

    public void clickNextGoogleButtonAfterWritePass() { click(nextGoogleButtonAfterWritePass);}

    public void clickButtonVitamina() { click(VitaminaButton);}

    public void loginGoogleWithTestUser() {
        /*driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/button")).click();*/
        clickGoogleButtonContinueWithGoogle();
        enterGoogleEmail();
        clickNextGoogleButtonAfterEnterEmail();
        enterGooglePassword();
        clickNextGoogleButtonAfterWritePass();
    }

    public void navigateToDashVitamina() {
        clickButtonVitamina();
    }

    public void navigateToContinueWithGoogle() {
        //mouseHoverElementAndClickInternalElement(linkVentas, linkListadoDeOrdenes);
        Actions builder = new Actions(driver);
        /*builder.moveToElement(driver.findElement(ContinueWithGoogle)).perform();
        click(linkListadoDeOrdenes);*/
    }


}




