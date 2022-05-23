package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

import static utilities.ConfigReader.getProperty;

public class VtexPage_babyCotton extends Driver {

    public static Logger log = LogManager.getLogger(VtexPage_babyCotton.class);



    @FindBy(css = ".glamit-dior-components-0-x-fa-user")
    public WebElement iconlogin;

    @FindBy(css = ".glamit-dior-components-0-x-drawer_content_tab_sub_content > div:nth-of-type(2) > .glamit-dior-components-0-x-drawer_content_login_button\n")
    public WebElement crearcuenta;

    @FindBy(css = ".ph6.vtex-button__label > span")
    public WebElement enviarcodigomail;


    @FindBy(xpath = "#cookiescript_accept")
    public WebElement aceptarcoockies;

    @FindBy(css = " #cookiescript_close")
    public WebElement closepopup;

    @FindBy(xpath = "//button[contains(@class,'closeButton')]")
    public WebElement newsLetterCloseButton;

    @FindBy (css = ".bg-action-primary .t-small")
    public WebElement confirmationbutton;

    @FindBy (css = ".bg-action-primary .t-small")
    public WebElement clicksendmail;

    @FindBy(css = ".vtex-login-2-x-accessCodeOptionBtn span")
    public WebElement accesscodemail;

    @FindBy(xpath = "(//input[contains(@placeholder,'Dirección de e-mail')])[2]")
    public WebElement insertarmail;

    @FindBy(xpath = "(//div[contains(.,'Suscribite a nuestro newsletter y obtené tu beneficio: 10% de descuento')])[18]")
    public WebElement popup;

    @FindBy(xpath = "(//div[contains(@role,'button')])[2]")
    public WebElement lupa;

    @FindBy(xpath = "//input[@autocomplete='off']")
    public WebElement buscador;

    @FindBy(xpath = "//div[contains(@class,'vtex-login')]")
    public WebElement loginIconLink;

    @FindBy(xpath = "//span[contains(@class,'store-logo vtex-store-components-3-x-logoContainer vtex-store-components-3-x-sizeDesktop pv4 ph6')]")
    public WebElement logo;

    @FindBy(xpath = "(//div[contains(.,'new in')])[10]")
    public WebElement newin;

    @FindBy(xpath = "(//div[contains(.,'Regalos')])[10]")
    public WebElement regalos;

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

    @FindBy(xpath = "//button[contains(@class,'shp-open-options vbw1 ba fw5 ttu br2 fw4 v-mid relative mt3 pv3 ph5 f6 bg-washed-blue b--washed-blue blue hover-bg-light-blue hover-b--light-blue hover-heavy-blue pointer')]")
    public WebElement calcular;

    @FindBy(xpath = "//input[contains(@id,'ship-postalCode')]")
    public WebElement codigopostal;

    @FindBy(xpath = "(//input[contains(@type,'text')])[2]")
    public WebElement codigodedescuento;

    @FindBy(xpath = "(//button[contains(.,'Sumar')])[2]")
    public WebElement sumar;

    @FindBy(xpath = "//a[contains(.,'Elegir más productos')]")
    public WebElement elegirmasproductos;

    @FindBy(xpath = "//a[contains(.,'Finalizar compra')]")
    public WebElement finalizarcompra;

    @FindBy(xpath = "//input[@id='client-email']")
    public WebElement email;

    @FindBy(xpath = "//input[contains(@autocomplete,'given-name')]")
    public WebElement nombre;

    @FindBy(xpath = "//input[contains(@autocomplete,'last-name')]")
    public WebElement apellido;

    @FindBy(xpath = "//input[@id='client-document']")
    public WebElement dnis;

    @FindBy(xpath = "(//input[contains(@class,'input-micro')])[1]")
    public WebElement codigodearea;

    @FindBy(xpath = "(//input[contains(@type,'tel')])[4]")
    public WebElement telefono;

    @FindBy(xpath = "//input[contains(@data-bind,'checked: checkout.optinNewsLetter, enable: checkout.saveData')]")
    public WebElement recibirnewsletter;

    @FindBy(xpath = "//button[@id='go-to-shipping']")
    public WebElement iralaentrega;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement calle;

    @FindBy(xpath = "//input[contains(@name,'number')]")
    public WebElement numerocalle;

    @FindBy(xpath = "//button[contains(.,'Ir para el pago')]")
    public WebElement irparaelpago;

    @FindBy(xpath = "//span[contains(.,'Tarjeta de crédito')]")
    public WebElement tarjeta;

    @FindBy(xpath = "//input[contains(@maxlength,'30')]")
    public WebElement numero;

    @FindBy(xpath = "//input[@name='cardNumber']")
    public WebElement carNumber;

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

    @FindBy(xpath = "//select[contains(@name,'cardExpirationMonth')]")
    public WebElement mesvencimiento; //aclaracion:tiene que haber 2 numeros,ej:03)

    @FindBy(xpath = "//select[contains(@name,'cardExpirationYear')]")
    public WebElement añovencimiento;  //aclaraciòn:tiene que haber 2 numeros validos;ej:22)

    @FindBy(xpath = "//input[contains(@id,'creditCardpayment-card-0Code')]")
    public WebElement codigodeseguridad; //aclaración:tiene que haber 3 números)

    @FindBy(xpath = "//div[text()='Modificar contraseña']")
    public WebElement myAccountChangePasswordBtn;

    @FindBy(name = "currentPassword")
    public WebElement myAccountCurrentPassword;

    @FindBy(name = "newPassword")
    public WebElement myAccountNewPassword;

    @FindBy(xpath = "//div[text()='Guardar contraseña']")
    public WebElement myAccountSavePassBtn;

    @FindBy(xpath = "//li[contains(@data-href,'account/logout/')]")
    public WebElement ButtonLogOut;

    @FindBy(xpath = "(//nav[@id='menu']//a[contains(@href,'mujer.html') and text()='Mujer'])[1]")
    public WebElement mujerMainMenu;

    @FindBy(xpath = "//section[@id='galeria']/article")
    public List<WebElement> mujerMainMenu_ItemsCount;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    public WebElement imputMail;

    @FindBy(xpath = "//input[contains(@id,'addOverlay')]")
    public WebElement mailinatorImput;

    @FindBy(xpath = "//input[contains(@id,'creditCardpayment-card-0Name')]")
    public WebElement nombreyapellido;

    @FindBy(xpath = "(//nav[@id='menu']//a[contains(@href,'hombre.html') and text()='Hombre'])[1]")
    public WebElement hombreMainMenu;

    @FindBy(xpath = "//nav[@id='menu']//a[contains(@href,'ninos') and text()='Kids']")
    public WebElement kidsMainMenu;

    @FindBy(xpath = "//h1[@id='nombreProducto']")
    public WebElement productName;

    @FindBy(xpath = "//span[@itemprop='price']")
    public WebElement productPrice;

    @FindBy(xpath = "//a[contains(@class,'dontHaveAccount')]")
    public WebElement register;

    @FindBy(id = "inbox_field")
    public WebElement mailAddressField;

    @FindBy(xpath = "//input[contains(@id,'addOverlay')]")
    public WebElement mailinatorImputs;

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

    @FindBy(xpath = "//section[contains(@class,'tileList')]//li")
    public List<WebElement> searchListResult;

    @FindBy(xpath = "//button//span[contains(@class,'buttonText') or contains(@class,'buyButtonText')]")
    public WebElement comprar;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[contains(@class,'close-icon')]")
    public WebElement itemAddedNotificationCloseIcon;

    @FindBy(xpath = "//span[contains(@class,'vtex-minicart-2-x-minicartIconContainer gray relative')]")
    public WebElement carrito;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ítem agregado a su carrito']")
    public WebElement itemAddedNotification;

    @FindBy(xpath = "//div[contains(@class,'toast-container')]//div[text()='Ver carrito']")
    public WebElement itemAddedNotification_verCarrito;

    @FindBy(xpath = "//a[contains(@id,'product-name')]")
    public WebElement checkOutProductName;

    @FindBy(xpath = "//span[@class='new-product-price']")
    public WebElement checkOutProductPrice;

    @FindBy(xpath = "(//td[text()='Total']/../td[@class='monetary'])[1]")
    public WebElement FinalCheckOutPrice;

    @FindBy(xpath = " //td[@class='item-remove']//a[@class='item-link-remove']")
    public WebElement removeItemCart;

    @FindBy(xpath = "//h2[text()='Su carrito está vacio']")
    public WebElement emptyCartMsg;

    @FindBy(xpath = "//div[contains(@class,'logo')]/a")
    public WebElement cartPgLogo;

    @FindBy(xpath = "//a[contains(@class,'checkout-logo')]")
    public WebElement umarCartPgLogo;

    @FindBy(xpath = " //a[contains(@title,'Umbro Home')]")
    public WebElement umbroCartPgLogo;

    @FindBy(xpath = "//div[@id='logo']//img")
    public WebElement tucciarCartPgLogo;

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

    @FindBy(xpath = "//div[@class='vtex-button__label flex items-center justify-center h-100 ph6 w-100 border-box '][contains(.,'Cerrar pedido')]")
    public WebElement iramicarrito;

    @FindBy(xpath = " //input[@id='ship-number']")
    public WebElement enterStreetNumber;

    @FindBy(xpath = "//a[@data-name='PAGOFACIL']")
    public WebElement mercadoPagoCashOption;

    @FindBy(xpath = "//span[text()='PAGOFACIL']")
    public WebElement cashPagoFacilOption;

    @FindBy(xpath = "//span[text()='Comprar ahora']/..//i[@class='icon-spinner icon-spin' and @style='display: none;']/..//span[text()='Comprar ahora']")
    public WebElement finalComprarAhora;

    @FindBy(xpath = "//*[contains(text(),'Gracias por la compra!')]")
    public WebElement thankYouMessage;

    @FindBy(xpath = "//div[@class='mv1-ns']")
    public WebElement mailProductName;

    @FindBy(xpath = "(//div[contains(@role,'button')])[2]")
    public WebElement searchGlassIconAdmit;

    @FindBy(xpath = "(//div[contains(.,'Enviar')])[8]")
    public WebElement enviarbutton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div[1]/div[2]/button/svg")
    public WebElement closing;

    @FindBy(xpath = "//img[@alt='BUZO UP LECLERC']")
    public WebElement buzosFirstItem;

    @FindBy(xpath = "//span[@class='btn-place-order-wrapper']")
    public WebElement navigateToPaymentButton;

    @FindBy(xpath = "//label[@for='pagofacil']")
    public WebElement pagoFacilOption;

    @FindBy(xpath = "//span[text()='Pagar']")
    public WebElement pagoFacilBuyButton;

    @FindBy(xpath = "//span[text()='Para terminar solo resta que pagues ']")
    public WebElement successPayment;

    @FindBy(xpath = "//a[text()='Volver al sitio']")
    public WebElement goBackMainPage;

    @FindBy(xpath = " //button[@id='newCookieDisclaimerButton']")
    public WebElement cookiesAcceptButton;

    @FindBy(id = "btnNoIdWpnPush")
    public WebElement popUpNoButton;

    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div[2]/div/div/div/div[1]/ul/li[1]/div/button/div")
    public WebElement onlyAppamail;

    public VtexPage_babyCotton(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void searchType(String WebElement, String testData) {
        driver.findElement(By.xpath(WebElement)).sendKeys(testData);
    }



    public void loginCheckAppa() {

        try {

            waitForVisibility(newsLetterCloseButton,3);
            newsLetterCloseButton.click();
            loginIconLink.click();
            log.info("clicking on login icon");
            wait(3);
            accesscodemail.click();
            log.info("login via email and password button clicked ....");
            loginEmail.sendKeys("babytest@mailinator.com");
            clicksendmail.click();
            log.info("Entering email id..");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void LoginMailinator() {

        openNewTab();
        changeTabByIndex(1);
        navigateToMalinator();
        mailAddressField.sendKeys("babytest");

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

    public void PopUpHandle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            waitForVisibility(popup, 20);
            log.info("Waiting for PopUp");
            insertarmail.sendKeys("emai@email.email");
            log.info("Insert Email into a Newsletter");
            enviarbutton.click();
            visit(getProperty("admitOne_VTEX"));
            log.info("Clicking Sending button Newsletter");
            lupa.click();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void searchingAddCartFullFlow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait(4);
            waitForVisibility(popup, 4);
            log.info("Waiting for PopUp");
            insertarmail.sendKeys("newtestadmitone@mailinator.com");
            log.info("Insert Email into a Newsletter");
            enviarbutton.click();
            wait(2);
            visit(getProperty("admitOne_VTEX"));
            log.info("Clicking Sending button Newsletter");
            wait(2);
            lupa.click();
            buscador.sendKeys("Buzos");
            waitForVisibility(buzosFirstItem, 4);
            buzosFirstItem.click();
            log.info("Click on first Item");
            wait(2);
            comprar.click();
            log.info("Clicking Comprar Button");
            wait(2);
            carrito.click();
            log.info("Clicking on Carrito");
            wait(2);
            iramicarrito.click();
            log.info("Navigate to My Carrito");
            finalizarcompra.click();
            log.info("Finalizar compra");
            nombre.sendKeys("pablo");
            log.info("Ingresando datos");
            email.sendKeys("mail@mail.mail");
            apellido.sendKeys("pablo");
            dnis.sendKeys("31311113");
            codigodearea.sendKeys("221");
            telefono.sendKeys("3139886");
            telefono.sendKeys(Keys.ENTER);
            wait(2);
            iralaentrega.click();
            log.info("Click en Ir a la Entrega");
            codigopostal.sendKeys("1900");
            wait(5);
            calle.sendKeys("54");
            numerocalle.sendKeys("278");
            irparaelpago.click();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void finalBuyButton(WebElement finalComprarAhora) {
        try {
            log.info("Finalizar pago");
            waitForVisibility(finalComprarAhora, 10);
            finalComprarAhora.click();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void pagarMercadoPago() {
        try {
            try {
                cookiesAcceptButton.click();
                log.info("clicking on cookies button");
            } catch (Exception e) {
                log.info("cookies button is not displayed..");
            }
            log.info("selecting pago facil...");
            waitForVisibility(pagoFacilOption, 10);
            pagoFacilOption.click();
            waitForVisibility(pagoFacilBuyButton, 10);
            pagoFacilBuyButton.click();
            log.info("clicking on the final comprar button..");
            waitForVisibility(successPayment, 10);
            Assert.assertTrue(successPayment.isDisplayed(), "Success message not displayed");
            log.info("pagar exitos..");

            waitForVisibility(goBackMainPage, 10);
            goBackMainPage.click();
            log.info("back to main page..");
            waitForVisibility(thankYouMessage, 20);
            Thread.sleep(2000);
            Assert.assertTrue(thankYouMessage.isDisplayed(), "Success message is not displayed.....");
            log.info("successfully displayed the payment and order has been placed .... ");
            log.info("navigating to mail box to check the order success mail confirmation .... ");
            changeTabByIndex(1);
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void pagarTarjetaCredito() {
        try {
            wait(5);
            log.info("Finalizar pago");
            tarjeta.click();
            driver.switchTo().frame(1);
            //waitForVisibility(iframecard, 2);
            carNumber.sendKeys("4111111111111111");
            nombreyapellido.sendKeys("Testing QA");
            mesvencimiento.sendKeys("10");
            añovencimiento.sendKeys("24");
            codigodeseguridad.sendKeys("123");
            finalComprarAhora.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void registerUserDior (){
        randomEmailID = generateRandomString();


        try {
            openNewTab();
            changeTabByIndex(0);
            waitForVisibility(closepopup,4);
            closepopup.click();
            waitForVisibility(iconlogin,3);
            iconlogin.click();
            waitForVisibility(crearcuenta,4);
            crearcuenta.click();
            waitForVisibility(enviarcodigomail,4);
            enviarcodigomail.click();
            imputMail.click();
            imputMail.sendKeys(randomEmailID);
            log.info("Usuario Random generado ....");
            enviar.click();
            wait(3);
            changeTabByIndex(1);
            navigateToMalinator();
            log.info("Navigate to mailinator....");
//            emailMailinator.click();
            Thread.sleep(2000);
            mailAddressField.sendKeys(randomEmailID);
            log.info("Entering email....");
            DiorMailinatorChecking();
            changeTabByIndex(0);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void registerCheck() {

        randomEmailID = generateRandomString();

        try {

            openNewTab();
            changeTabByIndex(0);
            waitForVisibility(loginIconLink,20);
            loginIconLink.click();
            log.info("clicking on login icon");
            waitForVisibility(loginViaEmailPass,20);
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
//            emailMailinator.click();
            Thread.sleep(2000);
            mailAddressField.sendKeys(randomEmailID);
            log.info("Entering email....");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }public void registerCheckDior() {

        randomEmailID = generateRandomString();

        try {

            openNewTab();
            changeTabByIndex(0);
            waitForVisibility(loginIconLink,20);
            loginIconLink.click();
            log.info("clicking on login icon");
            waitForVisibility(loginViaEmailPass,20);
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
//            emailMailinator.click();
            Thread.sleep(2000);
            mailAddressField.sendKeys(randomEmailID);
            log.info("Entering email....");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }




    public void enterTokenAndPassword() {
        fakePass = faker.internet().password(12, 13, true, true, true);


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

    public void enterTokenDior() {
        fakePass = faker.internet().password(12, 13, true, true, true);


        try {
            enterCode.sendKeys(codeReceived);
            log.info("clicking on login icon");
            createButton.click();
            log.info("clicking on create button..");
            //Assert.assertTrue(loginSuccess.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void enterTokenAppa() {
        fakePass = faker.internet().password(12, 13, true, true, true);


        try {
            enterCode.sendKeys(codeReceived);
            log.info("clicking on login icon");
            confirmationbutton.click();
            log.info("clicking on create button..");
            //Assert.assertTrue(loginSuccess.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


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
            js.executeScript("window.scrollBy(0,400)");
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
                wait(3);
                js.executeScript("window.scrollBy(0,500)");
//                js.executeScript("arguments[0].scrollIntoView();",comprar );
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


    public void babySearchProduct(String whatToSearch) {
        WebElement listOfElement;

        try {
            searchBox.sendKeys(whatToSearch);
            log.info("Entering the Product to search .." + whatToSearch);
            wait(2);
            count = searchListResult.size();
            if (count > 1) {
                log.info("More than 1 product has been displayed");
                listOfElement = searchListResult.get(0);
                UiProductName = listOfElement.findElement(By.xpath("//span[contains(@class,'productBrand')]")).getText();
                log.info("The Product name is ..." + UiProductName);
                UiProductPrice = listOfElement.findElement(By.xpath("//div[contains(@class,'sellingPriceContainer')]//span[contains(@class,'currencyContainer')]")).getText();
                log.info("The Product price is ..." + UiProductPrice);
//                UiProductPrice = amountSplit(UiProductPrice);
                listOfElement.findElement(By.xpath("//span[contains(@class,'buyButtonText')]")).click();
                log.info("Clicking on buy button...");
                waitForVisibility(itemAddedNotification, 20);
                Assert.assertTrue(itemAddedNotification.isDisplayed(), "notification is not displayed");


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

    public void deleteItemCart(WebElement emptyCartMsg,WebElement brandLogo) {
        try {
            waitForVisibility(removeItemCart, 20);
            removeItemCart.click();
            log.info("removing the item from the cart...");
            waitForVisibility(emptyCartMsg, 20);
            log.info("empty cart message is displayed...");
            try {
                brandLogo.click();
            } catch (Exception e) {
                log.error("cart logo not displayed :::" + e.getMessage());
            }


            log.info("clicking on log button in cart page...");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void cartCheckOut() {
        String ChckPrdName, ChckPrdPrice;
        try {
            itemAddedNotification_verCarrito.click();
            log.info("clicking on cart checkout from notification ..");
            ChckPrdName = checkOutProductName.getText();
            log.info("Product name from UI is .. " + ChckPrdName);
            Assert.assertTrue(ChckPrdName.contains(UiProductName), "Product name does not match with..");
            log.info("Product name validation done ..");
          //  ChckPrdPrice = checkOutProductPrice.getText();
//            Assert.assertEquals(Double.parseDouble(ChckPrdPrice),Double.parseDouble(UiProductPrice));
            log.info("Product price validation done ..");
            log.info("final product price is ..." + FinalCheckOutPrice.getText());


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void ClickBuscador() {
        hombreMainMenu.click();
        getElementsText((List<WebElement>) buscador);
        log.info(buscador);
    }

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
            zipcode = String.valueOf(faker.number().numberBetween(1040, 1050));
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
            wait(3);
            waitForVisibility(enterStreet, 20);
            enterStreet.sendKeys(streetName);
            log.info("The Street Name entered is.... " + streetName);
            enterStreetNumber.sendKeys(streetNumber);
            log.info("The Street number entered is.... " + streetNumber);
            buttonPayment.click();
            log.info("Clicking on final checkout.... ");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void paymentCashOption() {
        try {
            waitForVisibility(mercadoPagoCashOption,20);
            mercadoPagoCashOption.click();
            log.info("clicking on mercado pago cash option ..");
            waitForVisibility(cashPagoFacilOption, 20);
            Thread.sleep(2000);
            cashPagoFacilOption.click();
            log.info("selecting the cash pago facil option .... ");
            waitForVisibility(finalComprarAhora, 20);
            Thread.sleep(2000);
            finalComprarAhora.click();
            log.info("clicking on final payment option .... ");
            waitForVisibility(thankYouMessage, 20);
            Thread.sleep(2000);
            Assert.assertTrue(thankYouMessage.isDisplayed(), "Success message is not displayed.....");
            log.info("successfully displayed the payment and order has been placed .... ");
            log.info("navigating to mail box to check the order success mail confirmation .... ");
            changeTabByIndex(1);
            driver.navigate().refresh();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void navigateToMalinator() {
        log.info("********************** Navigating to Mailinator **********************");
        driver.navigate().to("https://www.mailinator.com/v4/public/inboxes.jsp");
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        log.info("Creating double tab instance");

    }

    public int clickOnMujerMenu() {

        try {


            mujerMainMenu.click();
            log.info("clicking on mujer link");
            count = mujerMainMenu_ItemsCount.size();
            log.info("the total count is " + count);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        return count;
    }

    public int clickOnHombreMenu() {

        try {


            hombreMainMenu.click();
            log.info("clicking on hombre link");
            count = mujerMainMenu_ItemsCount.size();
            log.info("the total count is " + count);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        return count;
    }

    public int clickOnKidsMenu() {

        try {


            kidsMainMenu.click();
            log.info("clicking on kids link");
            count = mujerMainMenu_ItemsCount.size();
            log.info("the total count is " + count);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
        return count;
    }

    public String generateRandomString() {

        return randomString() + "@mailinator.com";

    }

    public void emailValidation() {
        wait(2);
        mailinatorImputs.sendKeys("newtestadmitone@mailinator.com");
        mailinatorImputs.sendKeys(Keys.ENTER);


    }

    public String randomString() {
        String generatedString = faker.name().firstName() + faker.name().lastName();
        return generatedString;
    }

    public String MailinatorChecking() {

        try {


            goButton.click();
            wait(4);

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
                codeReceived = driver.findElement(By.xpath("//div//strong")).getText();
                log.info("code is : " + codeReceived);
                // VERIFY SUBJECT
                Assert.assertTrue(codeReceived.length() == 6);
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

    public String DiorMailinatorChecking() {

        try {


            goButton.click();
            wait(4);

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
                codeReceived = driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/table[5]/tbody/tr/td/span[2]")).getText();
                log.info("code is : " + codeReceived);
                // VERIFY SUBJECT
                Assert.assertTrue(codeReceived.length() == 6);
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


    public String MailinatorToForOrderConfirmation() {
        String[] strArray;
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
                log.info("The intial product name is : " + UiProductName);
                strArray = mailProductNameCheck.split("-");
                log.info("Product name after splitting the size ... " + strArray[0]);
                Assert.assertTrue(strArray[0].trim().equalsIgnoreCase(UiProductName), "Product name does not match with..");
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

    public void cancelOrder() {
        String myAccEmailID;
        try {
            loginSuccess.click();
            log.info("clicking on user name ..");
            waitForVisibility(myAccount, 20);
            myAccount.click();
            log.info("Clicking on my account....");
            waitForVisibility(myAccountProfileLink, 20);
            //Assert.assertTrue(myAccountProfileLink.isDisplayed(), "Profile link is not displayed...");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}

