package ui_tests.oms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.OmsLoginPage;
import pages.OmsOrdersGrid;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class OrdersListTests extends Driver {
    Logger log = LogManager.getLogger(OrdersListTests.class);
    OmsLoginPage omsLoginPage = new OmsLoginPage();
    OmsOrdersGrid omsOrdersGrid = new OmsOrdersGrid();

    @BeforeTest
    public void setUp() {
        log.info("Navegando a " + getProperty("url_oms"));
        visit(getProperty("url_oms"));
        log.info("Realizando login con store ID de mimo");
        omsLoginPage.loginWithFilaStoreId();
        log.info("Realizando login en Google Auth");
        omsLoginPage.loginGoogleWithTestUser();
        log.info("Navegando al listado de ordenes");
        omsLoginPage.navigateToListadoDeOrdenes();
        log.info("Desplegando la lista de filtro por estado");
        omsOrdersGrid.clickFilterStatus();
    }

    @Test(priority = 1)
    public void filterOrdersByAssignedStatusTest() {
        log.info("Filtrando por estado 'Asignado'");
        omsOrdersGrid.selectAssignedState();
        omsOrdersGrid.verifyThatOrdersHaveTheAssignedStatus();
    }

    @Test(priority = 2)
    public void filterOrdersByCancelledStatusTest() {
        log.info("Filtrando por estado 'Cancelado'");
        omsOrdersGrid.selectCancelledState();
        omsOrdersGrid.verifyThatOrdersHaveTheCancelledStatus();
    }

    @Test(priority = 3)
    public void filterOrdersByDeliveredStatusTest() {
        log.info("Filtrando por estado 'Entregado'");
        omsOrdersGrid.selectDeliveredState();
        omsOrdersGrid.verifyThatOrdersHaveTheDeliveredStatus();
    }

    @Test(priority = 4)
    public void filterOrdersByDispatchedStatusTest() {
        log.info("Filtrando por estado 'Despachado'");
        omsOrdersGrid.selectDispatchedState();
        omsOrdersGrid.verifyThatOrdersHaveTheDispatchedStatus();
    }

    @Test(priority = 5)
    public void filterOrdersByPaymentRejectedStatusTest() {
        log.info("Filtrando por estado 'Pago Rechazado'");
        omsOrdersGrid.selectPaymentRejectedState();
        omsOrdersGrid.verifyThatOrdersHaveThePaymentRejectedStatus();
    }

    @Test(priority = 6)
    public void filterOrdersByPendingStatusTest() {
        log.info("Filtrando por estado 'Pendiente'");
        omsOrdersGrid.selectPendingState();
        omsOrdersGrid.verifyThatOrdersHaveThePendingStatus();
    }

    @Test(priority = 7)
    public void filterOrdersByPickedStatusTest() {
        log.info("Filtrando por estado 'Pickeado'");
        omsOrdersGrid.selectPickedState();
        omsOrdersGrid.verifyThatOrdersHaveThePickedStatus();
    }

    @Test(priority = 8)
    public void filterOrdersByPreparedStatusTest() {
        log.info("Filtrando por estado 'Preparado'");
        omsOrdersGrid.selectPreparedState();
        omsOrdersGrid.verifyThatOrdersHaveThePreparedStatus();
    }

    @Test(priority = 9)
    public void filterOrdersByRefundedStatusTest() {
        log.info("Filtrando por estado 'Cambio/Reintegro'");
        omsOrdersGrid.selectRefundedState();
        omsOrdersGrid.verifyThatOrdersHaveTheRefundedStatus();
    }

    @Test(priority = 10)
    public void filterOrdersBySearchingStatusTest() {
        log.info("Filtrando por estado 'En Busqueda'");
        omsOrdersGrid.selectSearchingState();
        omsOrdersGrid.verifyThatOrdersHaveTheSearchingStatus();
    }

    @Test(priority = 11)
    public void paginationTest() {
    }

    @Test(priority = 12)
    public void searchEngineTest() {
    }

//    @AfterTest
//    public void tearDown() {
//        closeDriver();
//    }
}
