package api_tests;

import apibase.utilities.ApiBase;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static utilities.ConfigReader.getProperty;
import static utilities.Driver.faker;

public class getOrders extends ApiBase {
    public static Logger log = LogManager.getLogger(ApiBase.class);


    @Test
    public void get_orders(){
        // getting the id token
        IDTknResp = IdToken();

        //getting the env and respective URL
        if (ApiEnv.equalsIgnoreCase("uat")){

            domain = getProperty("baseURI_UAT");
        }
        // final end point
        String URI = domain +"orders";



        // passing value using fake class
        Date dtfrom = faker.date().past(30, TimeUnit.DAYS);
        dateFrom = getDateFormat(dtfrom,"yyyy-MM-dd");

        Date dtto = faker.date().future(3, TimeUnit.DAYS);
        dateTo = getDateFormat(dtto,"yyyy-MM-dd");
        page = "1";
        perPage = "500";
        GlamitEnv = "104";

        //hitting the api to get the response
        Response response = given().queryParam("dateFrom",dateFrom).
                queryParam("dateTo",dateTo).queryParam("page",page).queryParam("perPage",perPage).header(new Header("Authorization","Bearer "+IDTknResp)).
                header("Glamit-Env",GlamitEnv).
                when().get(URI).then().extract().response();
        log.info(response.asString());

    }

}
