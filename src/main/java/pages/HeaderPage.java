package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class HeaderPage extends Driver {

    // locators of Levis por Rahmi
    @FindBy(xpath = "//li[@id='cat-sale']")
    public WebElement btn_sale;
    @FindBy(xpath = "//button[@class='cerrar no-boton']")
    public WebElement levisPopUpNewsletter;
    @FindBy(xpath = "//span[@class='_hj-102w7__styles__openStateToggleIcon _hj-3Iftt__styles__surveyIcons']")
    public WebElement survey;
    @FindBy(xpath = "//a[@title='Volver al inicio']")
    public WebElement levisVolverAPrincipal;
    @FindBy(xpath = "//li[@id='cat-hombre']")
    public WebElement levisHombre;
    @FindBy(xpath = "//li[@id='cat-mujer']")
    public WebElement levisMujer;
    @FindBy(xpath = "//li[@id='cat-kids']")
    public WebElement levisKids;
    @FindBy(xpath = "//li[@id='cat-sale']")
    public WebElement levisSale;
    @FindBy(xpath = "//li[@id='cat-stories']")
    public WebElement levisStories;
    @FindBy(xpath = "//li[@id='lookbooks']")
    public WebElement levisLookBooks;
    @FindBy(xpath = "//i[@class='icono-Shopping-Bag icono-2x']")
    public WebElement levisMiCarrito;
    @FindBy(xpath = "//a[@title='Mi cuenta']")
    public WebElement levismiCuenta;
    //Locators of Mimo by Rahmi Dagci
    @FindBy(xpath = "//button[@id='onesignal-slidedown-cancel-button']")
    public WebElement mimoPopUpNovedades;
    @FindBy(xpath = "//button[@class='cerrar']")
    public WebElement mimoPopUpNewsletter;
    @FindBy(id = "Lo Nuevo")
    public WebElement mimoLoNuevo;
    @FindBy(xpath = "//li[@id='Junior']")
    public WebElement mimoJunior;
    @FindBy(xpath = "//li[@id='Kids']")
    public WebElement mimoKids;
    @FindBy(xpath = "//li[@id='Minimimo']")
    public WebElement mimoMinimimo;
    @FindBy(xpath = "//li[@id='Accesorios']")
    public WebElement mimoAccesorios;
    @FindBy(xpath = "//li[@id='Calzado']")
    public WebElement mimoCalzado;
    @FindBy(xpath = "//li[@id='WOW!']")
    public WebElement mimoWOW;
    @FindBy(xpath = "//li[@id='Verano + Sale']")
    public WebElement mimoVeranoSale;
    @FindBy(xpath = "//li[@id='Verano + Sale']")
    public WebElement mimoBacktoschool;
    @FindBy(xpath = "//li[@class='first']")
    public WebElement mimoIngresar;
    @FindBy(xpath = "//a[@title='Registrarse']")
    public WebElement mimoRegistrarse;
    @FindBy(xpath = "//a[@id='miCarrito']")
    public WebElement mimoMiCarrito;
    @FindBy(xpath = "//a[@id='miCarrito']")
    public WebElement mimoVolverAPrincipal;
    @FindBy(xpath = "//input[contains(@placeholder,'¿Qué estás buscando?')]")
    public WebElement umbroBuscar;
    @FindBy(xpath = "(//img[@crossorigin='anonymous'])[1]")
    public WebElement umbrofirstItem;
    @FindBy(xpath = "(//span[contains(.,'Incluir items en el carrito')])[1]")
    public WebElement umbroAddCarrito;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div/p")
    public WebElement umbropopup;
    @FindBy(xpath = "//button[@tabindex='0'][contains(.,'1')]")
    public WebElement umbroMicarrito;
    String sale = "//li[@id='cat-sale']";
    By loNuevo = By.xpath("//*[@id='Lo Nuevo']");
    By junior = By.xpath("//li[@id='Junior']");
    By kids = By.xpath("//li[@id='Kids']");
    By minimimo = By.xpath("//li[@id='Minimimo']");

    public HeaderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static void navigationValidation() {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        ArrayList<String> valid_links = new ArrayList<>();
        String flag = ""; // A flag is added so that the link is not repeated

        log.info("Total links found → " + links.size());

        for (WebElement link : links) {
            log.info(link.getAttribute("href"));
            if (link.getAttribute("href") != null && link.getAttribute("href").contains("http") && !link.getAttribute("href").equals(flag)) {
                valid_links.add(link.getAttribute("href"));
                flag = link.getAttribute("href");
            }
        }

        log.info("Total of valid links found → " + valid_links.size());

        int i = 0;
        for (String href : valid_links) {
            log.info((++i) + ":: Navigate to URL with href: " + href);
            driver.navigate().to(href);
        }
    }

    public void closePopups() {
        mimoPopUpNewsletter.click();
        mimoPopUpNovedades.click();

    }

    public void umbroPopUp() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mimoVerifyLoNuevoContent() {
        List<String> expected = new ArrayList<>();
        expected.add("Lo NuevoJunior Girls(4 a 14 AÑOS)Junior Boys(4 a 14 AÑOS)Kids Girls(1 a 4 años)Kids Boys(1 a 4 años)Minimima(0 a 18 meses)Minimimo(0 a 18 meses)AccesoriosCalzado");
        try {


            getElementsText(loNuevo);
            Assert.assertEquals(getElementsText(loNuevo), expected);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void mimoVerifyJuniorContent() {
        List<String> expected = new ArrayList<>();
        expected.add("JuniorJunior Girls(4 a 14 AÑOS)Junior Boys(4 A 14 AÑOS)");
        try {

            getElementsText(junior);
            Assert.assertEquals(getElementsText(junior), expected);
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void mimoVerifykidsContent() {
        List<String> expected = new ArrayList<>();
        expected.add("KidsKids Girls(1 a 4 años)Kids Boys(1 a 4 años)");
        try {

            getElementsText(kids);
            Assert.assertEquals(expected, getElementsText(kids));
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void mimoVerifyMinimimoContent() {
        List<String> expected = new ArrayList<>();
        expected.add("MinimimoMinimima(0 a 18 meses)Minimimo(0 a 18 meses)Minimix(0 A 18 meses)Ajuar(primeras prendas)");
        try {

            getElementsText(minimimo);
            Assert.assertEquals(expected, getElementsText(minimimo));
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    public void searchingUmbro() {

        try {
            umbroBuscar.sendKeys("botines");
            log.info("Tipeando botines al buscador");
            waitForVisibility(umbrofirstItem, 3);
            umbrofirstItem.click();
            log.info("Haciendo click en el primer resultado");
            waitForVisibility(umbroAddCarrito, 3);
            umbroAddCarrito.click();
            log.info("Agregando item al carrito");
            waitForVisibility(umbroMicarrito, 3);
            umbroMicarrito.click();
            wait(5);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
