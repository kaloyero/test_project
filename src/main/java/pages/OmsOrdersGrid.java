package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class OmsOrdersGrid extends Driver {
    // Locators
    private final By filtros = By.xpath("//div[contains(@class, 'ant-collapse-header')]");
    private final By ordenes = By.xpath("//tr[contains(@class, 'ant-table-row')]");
    private final By ASSIGNED = By.xpath("//input[@value='ASSIGNED']");
    private final By CANCELLED = By.xpath("//input[@value='CANCELLED']");
    private final By DELIVERED = By.xpath("//input[@value='DELIVERED']");
    private final By DISPATCHED = By.xpath("//input[@value='DISPATCHED']");
    private final By PAYMENT_REJECTED = By.xpath("//input[@value='PAYMENT_REJECTED']");
    private final By PENDING = By.xpath("//input[@value='PENDING']");
    private final By PICKED = By.xpath("//input[@value='PICKED']");
    private final By PREPARED = By.xpath("//input[@value='PREPARED']");
    private final By REFUNDED = By.xpath("//input[@value='REFUNDED']");
    private final By SEARCHING = By.xpath("//input[@value='SEARCHING']");
    private final By orderCheckbox = By.xpath("//td[contains(@class,'ant-table-cell')][1]"); // Grid orders column → Checkbox
    private final By orderNumberAndCreatedDate = By.xpath("//td[contains(@class,'ant-table-cell')][2]"); // Grid orders column → Order number and created date
    private final By orderCustomerFullNameAndOrigin = By.xpath("//td[contains(@class,'ant-table-cell')][3]"); // Grid orders column → Customer full name and origin
    private final By orderTotalMountAndProductQuantity = By.xpath("//td[contains(@class,'ant-table-cell')][4]"); // Grid orders column → Total mount and products quantity
    private final By orderPaymentMethodAndCreatedDate = By.xpath("//td[contains(@class,'ant-table-cell')][5]"); // Grid orders column → Payment method and created date
    private final By orderShippingMethodAddressAndPrintButton = By.xpath("//td[contains(@class,'ant-table-cell')][6]"); // Grid orders column → Shipping method, address, print button and see link
    private final By orderStatus = By.xpath("//td[contains(@class,'ant-table-cell')][7]"); // Grid orders column → Status
    private final By nextButton = By.xpath("//button[@tabindex='-1']//span[@aria-label='right']");
    Logger log = LogManager.getLogger(OmsOrdersGrid.class);

    // Methods
    public void clickOnFilter(String value) {
        for (int i = 0; i < driver.findElements(filtros).size(); i++) {
            WebElement element = driver.findElements(filtros).get(i);
            String filterName = element.getText();
            if (filterName.contains(value)) {
                waitForElementDisplayed(ordenes);
                log.info("Click en el filtro " + value);
                Assert.assertEquals(filterName, value);
                element.click();
                break;
            }
        }
    }

    public void clickFilterStatus() {
        clickOnFilter("Estados");
    }

    public void clickFilterPaymentMethods() {
        clickOnFilter("Método de pago");
    }

    public void clickFilterShippingMethods() {
        clickOnFilter("Método de envío");
    }

    public void clickFilterPaymentDate() {
        clickOnFilter("Fecha de pago");
    }

    public void clickFilterCreatedDate() {
        clickOnFilter("Fecha de creación");
    }

    public void clickFilterMount() {
        clickOnFilter("Monto");
    }

    public void verifyOrdersStatus(String expectedStatus) {
        wait(1);
        List<WebElement> orderNumber = driver.findElements(this.orderNumberAndCreatedDate);
        List<WebElement> orderStatus = driver.findElements(this.orderStatus);
        for (int i = 0; i < orderStatus.size(); i++) {
            String[] parts = orderNumber.get(i).getText().split(" |\\n");
            log.info("Validando que la orden " + parts[1] + " tenga el estado " + expectedStatus);
            Assert.assertEquals(orderStatus.get(i).getText(), expectedStatus);
        }
    }

    public void verifyThatOrdersHaveTheAssignedStatus() {
        verifyOrdersStatus("Asignado");
    }

    public void verifyThatOrdersHaveTheCancelledStatus() {
        verifyOrdersStatus("Cancelado");
    }

    public void verifyThatOrdersHaveTheDeliveredStatus() {
        verifyOrdersStatus("Entregado");
    }

    public void verifyThatOrdersHaveTheDispatchedStatus() {
        verifyOrdersStatus("Despachado");
    }

    public void verifyThatOrdersHaveThePaymentRejectedStatus() {
        verifyOrdersStatus("Pago Rechazado");
    }

    public void verifyThatOrdersHaveThePendingStatus() {
        verifyOrdersStatus("Pendiente");
    }

    public void verifyThatOrdersHaveThePickedStatus() {
        verifyOrdersStatus("Pickeado");
    }

    public void verifyThatOrdersHaveThePreparedStatus() {
        verifyOrdersStatus("Preparado");
    }

    public void verifyThatOrdersHaveTheRefundedStatus() {
        verifyOrdersStatus("Cambio/Reintegro");
    }

    public void verifyThatOrdersHaveTheSearchingStatus() {
        verifyOrdersStatus("En Busqueda");
    }

    public void selectAssignedState() {
        click(ASSIGNED);
    }

    public void selectCancelledState() {
        click(CANCELLED);
    }

    public void selectDeliveredState() {
        click(DELIVERED);
    }

    public void selectDispatchedState() {
        click(DISPATCHED);
    }

    public void selectPaymentRejectedState() {
        click(PAYMENT_REJECTED);
    }

    public void selectPendingState() {
        click(PENDING);
    }

    public void selectPickedState() {
        click(PICKED);
    }

    public void selectPreparedState() {
        click(PREPARED);
    }

    public void selectRefundedState() {
        click(REFUNDED);
    }

    public void selectSearchingState() {
        click(SEARCHING);
    }

    public void clickNextButton() {
        click(nextButton);
    }
}
