package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class VtexPage_admitOne extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_admitOne.class);


    @FindBy(xpath = "//span[contains(@class,'vtex-login')]")
    public WebElement loginIconLink;

    @FindBy(xpath = "//div[contains(@class,'emailPasswordOptionBtn')]/button")
    public WebElement loginViaEmailPass;

    @FindBy(xpath = "//span[@class='t-small'][contains(.,'Entrar')]")
    public WebElement Enter;

    @FindBy(xpath = "//span[contains(.,'Enviar')]")
    public WebElement enviar;

    @FindBy(xpath = "//div[contains(@class,'inputContainerEmail')]//input")
    public WebElement loginEmail;
    @FindBy(xpath = "//div[contains(@class,'inputContainerPassword')]//input")
    public WebElement loginPassword;
    @FindBy(xpath = " //span[contains(@class,'vtex-login-2-x-profile')]")
    public WebElement loginSuccess;

    @FindBy(xpath = "//span[contains(text(),'Mi Cuenta')]")
    public WebElement myAccount;

    @FindBy(xpath = "//a[contains(@href,'/profile') and text()='Perfil']")
    public WebElement myAccountProfileLink;

    @FindBy(xpath = "//a[contains(@href,'/addresses') and text()='Direcciones']")
    public WebElement myAccountDireccionesLink;

    @FindBy(xpath = "//a[contains(@href,'/orders') and text()='Pedidos']")
    public WebElement myAccountPedidosLink;

    @FindBy(xpath = "//a[contains(@href,'/cards') and text()='Tarjetas de crédito']")
    public WebElement myAccountCreditTarjetaLink;

    @FindBy(xpath = " //div[contains(@class,'emailContainer')]/div")
    public WebElement myAccountEmailID;

    @FindBy(xpath = "//div[text()='Modificar contraseña']")
    public WebElement myAccountChangePasswordBtn;

    @FindBy(name = "currentPassword")
    public WebElement myAccountCurrentPassword;

    @FindBy(name = "newPassword")
    public WebElement myAccountNewPassword;

    @FindBy(xpath = "//div[text()='Guardar contraseña']")
    public WebElement myAccountSavePassBtn;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    public WebElement imputMail;

    @FindBy(xpath = "//h1[@id='nombreProducto']")
    public WebElement productName;

    @FindBy(xpath = "//span[@itemprop='price']")
    public WebElement productPrice;

    @FindBy(xpath = "//a[contains(.,'¿no tenés una cuenta? registrate')]")
    public WebElement register;

    @FindBy(id = "inbox_field")
    public WebElement mailAddressField;

    @FindBy(xpath = "//button[@class='primary-btn']")
    public WebElement goButton;

    @FindBy(xpath = "//a[normalize-space(text())='Back to Inbox']")
    public WebElement backToInbox;

    @FindBy(xpath = "//div[contains(@class,'wrapper-nav-items')]//a[text()='Email']")
    public WebElement emailMailinator;

    @FindBy(xpath = "//*[@id='m8rguy']")
    public WebElement emptyInboxMessage;

    @FindBy(name = "token")
    public WebElement enterCode;

    @FindBy(xpath = " //input[normalize-space(@placeholder)='Ingrese su contraseña']")
    public WebElement enterPassword;

    @FindBy(xpath = " //input[normalize-space(@placeholder)='Confirmar contraseña']")
    public WebElement enterConfirmPassword;

    @FindBy(xpath = " //div[contains(@class,'sendButton')]//button")
    public WebElement createButton;

    @FindBy(xpath = "//div[contains(@class,'autoCompleteOuterContainer')]//input")
    public WebElement searchBox;

    @FindBy(xpath = "//ul[contains(@class,'tileListList')]//li")
    public List<WebElement> searchListResult;

    @FindBy(xpath = "//button//span[contains(@class,'buttonText') or contains(@class,'buyButtonText')]")
    public WebElement comprar;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ítem agregado a su carrito']")
    public WebElement itemAddedNotification;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[contains(@class,'close-icon')]")
    public WebElement itemAddedNotificationCloseIcon;

    @FindBy(xpath = "//div[contains(@class,'minicartContainer')]//button")
    public WebElement carritoButton;

    @FindBy(xpath = "//button[@id='proceed-to-checkout']")
    public WebElement irMiCarritoButton;

    @FindBy(xpath = "//a[contains(@id,'product-name')]")
    public WebElement checkOutProductName;

    @FindBy(xpath = "//span[@class='new-product-price']")
    public WebElement checkOutProductPrice;

    @FindBy(xpath = "(//td[text()='Total']/../td[@class='monetary'])[1]")
    public WebElement FinalCheckOutPrice;

    @FindBy(xpath = "//h2[text()='Su carrito está vacio']")
    public WebElement emptyCartMsg;

    @FindBy(id = "cart-to-orderform")
    public WebElement finalizarComprar;

    @FindBy(xpath = "//input[@id='client-first-name']")
    public WebElement EnterFirstName;

    @FindBy(xpath = "//input[@id='client-last-name']")
    public WebElement EnterSurName;

    @FindBy(xpath = "//input[@id='client-document']")
    public WebElement enterDNI;

    @FindBy(xpath = " //input[@id='client-phone1']")
    public WebElement enterPhSuffix;

    @FindBy(xpath = "//input[@id='client-phone3']")
    public WebElement enterPhoneNumber;

    @FindBy(xpath = "//button[@id='go-to-shipping']")
    public WebElement buttonContinueShipping;

    @FindBy(xpath = "//input[@id='ship-postalCode']")
    public WebElement enterPostalCode;

    @FindBy(xpath = "//input[@id='ship-street']")
    public WebElement enterStreet;

    @FindBy(xpath = " //button[@id='btn-go-to-payment']")
    public WebElement buttonPayment;

    @FindBy(xpath = " //input[@id='ship-number']")
    public WebElement enterStreetNumber;

    @FindBy(xpath = "//span[text()='Comprar ahora']/..//i[@class='icon-spinner icon-spin' and @style='display: none;']/..//span[text()='Comprar ahora']")
    public WebElement finalComprarAhora;

    @FindBy(xpath = "//div[@class='mv1-ns']")
    public WebElement mailProductName;

    @FindBy(xpath = "//button[contains(@class,'closeButton')]")
    public WebElement newsLetterCloseButton;




    @FindBy(xpath = "//button[contains(text(),'NO, GRACIAS')]")
    public WebElement buttonNoGracias;

    @FindBy(xpath = "(//div[contains(@class,'tabs-searchbar')]//div[@role='button'])[2]")
    public WebElement admitOneSearchIcon;

    @FindBy(xpath = "//article[contains(@class,'vtex-search')]//li//a")
    public List<WebElement> searchBoxLink;

    @FindBy(xpath = "//div[@id='gallery-layout-container']")
    public WebElement searchResultUmaar;

    @FindBy(xpath = "//div[@id='gallery-layout-container']/div")
    public List<WebElement> searchResultCountUmaar;

    @FindBy(xpath = "(//div[contains(@class,'search-products')])[2]")
    public WebElement searchResultAdmitOne;

    @FindBy(xpath = "(//div[contains(@class,'search-products')])[2]//div[contains(@class,'items-stretch')]")
    public List<WebElement> searchResultCountAdmitOne;


    public VtexPage_admitOne(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void loginCheck() {

        try {


            loginIconLink.click();
            log.info("clicking on login icon");
            loginViaEmailPass.click();
            log.info("login via email and password button clicked ....");
            loginEmail.sendKeys("babytest@mailinator.com");
            log.info("Entering email id..");
            loginPassword.sendKeys("Test@123");
            log.info("Entering password...");
            Enter.click();
            //  loginSuccess.click();
            log.info("clicking on sign in button...");
            Assert.assertTrue(loginSuccess.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * This method will close the News Letter displayed in the screen
     **/

    public void closeNewsLetter() {
        try {
            waitForVisibility(newsLetterCloseButton, 20);
            newsLetterCloseButton.click();
            log.info("news letter pop up closed...");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("No news letter pop up displayed after waiting for 20 sec ...");
        }
    }

    /**
     * This method will close the pop up displayed in the screen
     * webElement  - pass the xpath of popUPButton
     **/


    public void PopUpGracias(WebElement popupNoButton) {
        try {
            waitForVisibility(popupNoButton, 2);
            popupNoButton.click();
            log.info("Clicked on no Gracias button...");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("no popup displayed after waiting for 20 sec...");
        }
    }

    /**
     * This method is used after payment type selcetd and click on comprar button
     **/

    public void pagarMercadoPago() {
        try {
            log.info("Finalizar pago");
            finalComprarAhora.click();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * This method used to register user by using faker class
     **/
    public void registerCheck() {

        randomEmailID = generateRandomString();

        try {

            openNewTab();
            changeTabByIndex(0);
            loginIconLink.click();
            log.info("clicking on login icon");
            loginViaEmailPass.click();
            log.info("login via email and password button clicked ....");
            register.click();
            log.info("Click on register ....");
            wait(2);
            imputMail.click();
            imputMail.sendKeys(randomEmailID);
            log.info("Usuario Random generado ....");
            enviar.click();
            log.info("Clicking on Enviar button ....");
            wait(3);
            changeTabByIndex(1);
            navigateToMalinator();
            log.info("Navigate to mailinator....");
            emailMailinator.click();
            Thread.sleep(2000);
            mailAddressField.sendKeys(randomEmailID);
            log.info("Entering email....");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * This method used to enter the password and confirm password using faker class
     **/

    public void enterTokenAndPassword() {
        fakePass = faker.internet().password(8, 13, true, true, true);


        try {
            enterCode.sendKeys(codeReceived);
            log.info("clicking on login icon");
            enterPassword.sendKeys(fakePass);
            log.info("entering new password.." + fakePass);
            enterConfirmPassword.sendKeys(fakePass);
            log.info("entering new confirm password.." + fakePass);
            createButton.click();
            log.info("clicking on create button..");
            Assert.assertTrue(loginSuccess.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    /**
     * This method used to check the option displayed inside my account option
     **/
    public void myAccountDetailCheck() {
        String myAccEmailID;


        try {
            loginSuccess.click();
            log.info("clicking on user name ..");
            waitForVisibility(myAccount, 20);
            myAccount.click();
            log.info("Clicking on my account....");
            waitForVisibility(myAccountProfileLink, 20);
            Assert.assertTrue(myAccountProfileLink.isDisplayed(), "Profile link is not displayed...");
            log.info("Profile link is displayed in my account page ....");
            Assert.assertTrue(myAccountDireccionesLink.isDisplayed(), "Dirrecion link is not displayed...");
            log.info("Dirrecion link is displayed in my account page ....");
            Assert.assertTrue(myAccountPedidosLink.isDisplayed(), "pedidos link is not displayed...");
            log.info("pedidos link is displayed in my account page ....");
            Assert.assertTrue(myAccountCreditTarjetaLink.isDisplayed(), "trajeta de credit link is not displayed...");
            log.info("trajeta de credit link is displayed in my account page ....");
            myAccEmailID = myAccountEmailID.getText().trim();
            log.info("Email id is displayed in my account page ...." + myAccEmailID);
            Assert.assertTrue(myAccEmailID.equalsIgnoreCase(randomEmailID), "Email id Doest not match....");
            log.info("Email id is verified ....");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * This method used to enter the password and confirm password using faker class inside  my account page
     **/
    public void myAccountChangePassword() {


        try {

            myAccountChangePasswordBtn.click();
            log.info("change password button clicked ....");
            waitForVisibility(myAccountCurrentPassword, 20);
            myAccountCurrentPassword.sendKeys(fakePass);
            log.info("Entering current password ...." + fakePass);
            fakePass = faker.internet().password(8, 13, true, true, true);
            myAccountNewPassword.sendKeys(fakePass);
            log.info("Entering new password ...." + fakePass);
            myAccountSavePassBtn.click();
            log.info("click on save password button..");
            waitForVisibility(myAccountChangePasswordBtn, 20);
            Assert.assertTrue(myAccountChangePasswordBtn.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    /**
     * This method used to search product and click on it
     * it will record product name and product price
     * parameter - what product need to search
     **/

    public void SearchProduct(String whatToSearch) {
        WebElement listOfElement;

        try {
            waitForVisibility(admitOneSearchIcon, 20);
            admitOneSearchIcon.click();
            searchBox.sendKeys(whatToSearch);
            log.info("Entering the Product to search .." + whatToSearch);
            count = searchListResult.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed");
                listOfElement = searchListResult.get(0);
                UiProductName = listOfElement.findElement(By.xpath("//span[contains(@class,'productBrand')]")).getText();
                log.info("The Product name is ..." + UiProductName);
                UiProductPrice = listOfElement.findElement(By.xpath("//div[contains(@class,'selling-price-home') or contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).getText();
                log.info("The Product name is ..." + UiProductPrice);
//                UiProductPrice = amountSplit(UiProductPrice);
                listOfElement.findElement(By.xpath("//div[contains(@class,'selling-price-home') or contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).click();
                log.info("Clicking on first product...");
                waitForVisibility(comprar, 20);
                comprar.click();
                log.info("Adding item to cart....");
//                waitForVisibility(itemAddedNotification, 20);
//                Assert.assertTrue(itemAddedNotification.isDisplayed(), "notification is not displayed");
//                itemAddedNotificationCloseIcon.click();

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

    /**
     * This method used to to get list or tags displayed when click on search box in home page
     * parameter 1 - the first product displayed for that particular option
     * parameter 2 - get the number of product displayed
     **/

    public void getListInSearchBox(WebElement searchResult, List<WebElement> searchResultCount) {

        String searchLink;
        ArrayList<String> searchBarLink = new ArrayList<>();


        try {
            waitForVisibility(admitOneSearchIcon, 20);
            admitOneSearchIcon.click();
            searchBox.click();
            count = searchBoxLink.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed and total count is " + count);
                for (WebElement listOfElement : searchBoxLink) {
                    searchLink = listOfElement.getAttribute("href");
                    System.out.println(searchLink);
                    searchBarLink.add(searchLink);
                }
                for (String s : searchBarLink) {
                    log.info("launching the url " + s);
                    driver.get(s);
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

    /**
     * This method used to validate product in cart page
     * it will validate product name and product price from search page or adding product page
     **/

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

    /**
     * This method used to fill details shipping information for the first time user by using faker class
     **/
    public void cartPageDetailFill() {


        try {
            finalizarComprar.click();
            log.info("clicking on finalizar comprar button ..");
            waitForVisibility(EnterFirstName, 20);
            Thread.sleep(2000);
            firstName = faker.name().firstName();
            surname = faker.name().lastName();
            dni = String.valueOf(faker.number().randomNumber(6, true));
            phoneNumber = faker.number().digits(8);
            streetName = faker.address().streetName();
            streetNumber = faker.address().streetAddressNumber();
            zipcode = String.valueOf(faker.number().numberBetween(1000, 1100));
            EnterFirstName.sendKeys(firstName);
            log.info("The first name entered is .... " + firstName);
            EnterSurName.sendKeys(surname);
            log.info("The surname entered is .... " + surname);
            enterDNI.sendKeys(dni);
            log.info("The DNI entered is .... " + dni);
            enterPhSuffix.sendKeys("11");
            enterPhoneNumber.sendKeys(phoneNumber);
            log.info("The phone number entered is .... " + phoneNumber);
            buttonContinueShipping.click();
            log.info("Clicking on continue button....");
            waitForVisibility(enterPostalCode, 20);
            enterPostalCode.sendKeys(zipcode);
            log.info("The zipcode entered is.... " + zipcode);
            waitForVisibility(enterStreet, 20);
            enterStreet.sendKeys(streetName);
            log.info("The Street Name entered is.... " + streetName);
            enterStreetNumber.sendKeys(streetNumber);
            log.info("The Street number entered is.... " + streetNumber);
            buttonPayment.click();
            log.info("Clicing on final checkout.... ");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    /**
     * This method navigate to mailinator site
     **/
    public void navigateToMalinator() {
        log.info("********************** Navigating to Mailinator **********************");
        driver.navigate().to("https://www.mailinator.com/");
    }


    /**
     * This method used to open new tab
     **/
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        log.info("Creating double tab instance");

    }

    /**
     * This method used to generate random string
     **/

    public String generateRandomString() {

        return faker.name().firstName() + faker.name().lastName()+ "@mailinator.com";

    }


    /**
     * This method used to check the mail to get the code for the first time user registration
     **/
    public String MailinatorChecking() {

        try {


            goButton.click();
            wait(3);
            if (emptyInboxMessage.isDisplayed()) {
                log.info("Vtex is not sending emails to customers...");
            } else {
                log.info(" Getting code from Vtex...");
                List<WebElement> messages = driver.findElements(By.xpath("//tr[@ng-repeat='email in emails']"));
                wait(3);
//                Assert.assertTrue(messages.size() <= 1, "Email box does NOT contain 2nd message...");
                messages.get(0).click();
                Thread.sleep(4000);
                driver.switchTo().frame("html_msg_body");
                codeReceived = driver.findElement(By.xpath("//p[text()='Regrese a la página y use el siguiente codigo para iniciar sesión:']/..//div//strong")).getText();
                log.info("code is : " + codeReceived);
                // VERIFY SUBJECT
                Assert.assertEquals(codeReceived.length(), 6);
                log.info("validation done on code received via email...");
                driver.switchTo().defaultContent();
                changeTabByIndex(0);

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Method failed due to an exception:::" + e.getMessage());
        }
        return codeReceived;
    }

    /**
     * This method used to check the mail for confirm order successful
     **/

    public String MailinatorToForOrderConfirmation() {

        try {
            waitForVisibility(backToInbox, 20);
            backToInbox.click();
            wait(3);
            if (emptyInboxMessage.isDisplayed()) {
                log.info("Vtex is not sending emails to customers...");
            } else {
                List<WebElement> messages = driver.findElements(By.xpath("//tr[@ng-repeat='email in emails']"));
                wait(3);
//                Assert.assertTrue(messages.size() <= 1, "Email box does NOT contain 2nd message...");
                messages.get(0).click();
                Thread.sleep(2000);
                driver.switchTo().frame("html_msg_body");
                mailProductNameCheck = mailProductName.getText();
                log.info("The product name is : " + mailProductNameCheck);
                Assert.assertTrue(mailProductNameCheck.contains(UiProductName));
                log.info("Product name validation done in the mail box ..");
                driver.switchTo().defaultContent();
                changeTabByIndex(0);

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Method failed due to an exception:::" + e.getMessage());
        }
        return mailProductNameCheck;
    }


}

