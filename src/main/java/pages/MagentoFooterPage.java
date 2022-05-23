package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class MagentoFooterPage extends Driver {

    // Locators
    protected By repentanceFilaArgentinaButton = By.cssSelector(".boton-cambio--link");
    protected By themesListContactForm = By.cssSelector("#subject");

    // Methods
    public void clickRepentanceFilaArgentinaButton() {
        click(repentanceFilaArgentinaButton);
    }

    public void validateContactsUrl() {
        String endpointContacts = splitUrl(driver.getCurrentUrl(), "/", 3);
        Assert.assertEquals(splitUrl(driver.getCurrentUrl(), "/", 3), "contacts");
    }

    public void clickThemesList() {
        click(themesListContactForm);
    }
}
