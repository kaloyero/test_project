package api_tests;

import apibase.utilities.ApiBase;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static utilities.ConfigReader.getProperty;

public class EventBusOrder extends ApiBase {
    public static Logger log = LogManager.getLogger(ApiBase.class);
    public static String StrIncrement_Id, StrOrder_Id, StrExternal_Id, StrCreation_Date, StrPayment_Date,
            StrInvoice_detailsType, StrInvoice_detailsBusiness_Name, StrProducts, StrProductsUnit_Price, StrProductsOriginal_Price, StrProductsDiscount, StrQty, StrProductTotal, StrProduct_Id_Config,
            StrProductWeight, StrProductHeight, StrProductLength, StrProductWidth, StrProductItem_Id, StrProduct_Id, StrProductSku, StrProductName, StrProductImage_Url, StrProductGtin,
            StrCarrier_Id, StrShipping_Cost, StrShipping_Method, StrBillingStreet_Name, StrBillingStreet_Number, StrBillingFloor,
            StrBillingDoor_Number, StrBillingObservation, StrBillingZip_Code, StrBillingCountry, StrBillingProvince, StrBillingProvince_Name,
            StrShippingStreet_Name, StrShippingStreet_Number, StrShippingFloor, StrShippingDoor_Number, StrShippingObservation,
            StrShippingZip_Code, StrShippingCountry, StrShippingProvince, StrShippingProvince_Name, StrShippingLocality,
            StrPickuppoint, StrCarrier_Pickup, StrCustomer_Name, StrCustomerIdentification_Number, StrCustomer_Id, StrCustomerEmail, StrCustomerPhone,
            StrCustomerBirth_Date, StrCustomer_Group,
            StrApplied_rulesName, StrApplied_rulesDescription, StrApplied_rulesCoupon_Code, StrApplied_rulesFrom_Date, StrApplied_rulesTo_Date,
            StrStore_Id, StrStore_Name, StrTotal_Discount, StrTotal_Qty_Ordered, StrRegion, StrPayment_Method, StrSubtotal,
            StrTotal, StrState, StrStatus, StrGlamit_Oms_State, StrCoupon_Code, StrCard_Issuer, StrCard, StrInstallments, StrInterests,
            StrOrigin_Channel,
            StrOrigin, StrType, StrRma_Id, StrEasy_Cart;

    @Test
    public void CreateOrders() {
        // getting the id token
        IDTknResp = IdToken();


        //getting the env and respective URL
        if (ApiEnv.equalsIgnoreCase("uat")) {

            domain = getProperty("baseURI_UAT_New");
        }
        // final end point
        String URI = domain + "/v1/eventbus/order";

        try {
            JSONObject payload = readJSONFromFile("EventBus_Order.json");

            //Generating data using faker class
            StrIncrement_Id = "Automation" + faker.number().digits(10);
            StrOrder_Id = faker.number().digits(6);
            StrExternal_Id = StrIncrement_Id + "-" + faker.number().digits(3);
            Date dtCr = faker.date().future(3, TimeUnit.DAYS);
            StrCreation_Date = getDateFormat(dtCr, "yyyy-MM-dd");
            StrProductsUnit_Price = faker.number().digits(5);
            StrProductsOriginal_Price = StrProductsUnit_Price;
            StrQty = faker.number().digits(1);
            StrProductTotal = StrProductsUnit_Price;
            StrShipping_Cost = faker.number().digits(3);
            StrBillingStreet_Name = faker.address().streetName();
            StrBillingStreet_Number = faker.address().streetAddressNumber();
            StrBillingFloor = faker.number().digits(1);
            StrBillingZip_Code = faker.number().digits(5);
            StrShippingStreet_Name = faker.address().streetName();
            StrShippingStreet_Number = faker.address().streetAddressNumber();
            StrShippingFloor = faker.number().digits(1);
            StrShippingZip_Code = faker.number().digits(5);
            StrCustomer_Name = faker.name().firstName() + faker.name().lastName();
            StrCustomerEmail = StrCustomer_Name + "@mailinator.com";
            StrCustomerPhone = "+54" + faker.number().digits(10);

            //passing data using faker class
            payload.put("increment_id", StrIncrement_Id);
            payload.put("order_id", StrOrder_Id);
            payload.put("external_id", StrExternal_Id);
            payload.put("creation_date", StrCreation_Date);
            payload.getJSONArray("products").getJSONObject(0).put("unit_price", StrProductsUnit_Price);
            payload.getJSONArray("products").getJSONObject(0).put("original_price", StrProductsOriginal_Price);
            payload.getJSONArray("products").getJSONObject(0).put("qty", StrQty);
            payload.getJSONArray("products").getJSONObject(0).put("total", StrProductTotal);
            payload.getJSONObject("shipping").put("shipping_cost", StrShipping_Cost);
            payload.getJSONObject("shipping").getJSONObject("billing_address").put("street_name", StrBillingStreet_Name);
            payload.getJSONObject("shipping").getJSONObject("billing_address").put("street_number", StrBillingStreet_Number);
            payload.getJSONObject("shipping").getJSONObject("billing_address").put("floor", StrBillingFloor);
            payload.getJSONObject("shipping").getJSONObject("billing_address").put("zip_code", StrBillingZip_Code);
            payload.getJSONObject("shipping").getJSONObject("shipping_address").put("street_name", StrShippingStreet_Name);
            payload.getJSONObject("shipping").getJSONObject("shipping_address").put("street_number", StrShippingStreet_Number);
            payload.getJSONObject("shipping").getJSONObject("shipping_address").put("floor", StrShippingFloor);
            payload.getJSONObject("shipping").getJSONObject("shipping_address").put("province_name", StrShippingProvince_Name);
            payload.getJSONObject("customer").put("customer_name", StrCustomer_Name);
            payload.getJSONObject("customer").put("email", StrCustomerEmail);
            payload.getJSONObject("customer").put("phone", StrCustomerPhone);

            //hitting the api to get the response
            Response response = given().header(new Header("Authorization", "Bearer " + IDTknResp)).
                    header("Content-Type", "application/json").
                    when().body(payload.toString()).post(URI).then().log().all().extract().response();
            log.info(response.asString());

            // validating the status code
            Assert.assertEquals(response.statusCode(),200);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

}
