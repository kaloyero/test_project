package api_tests;

import apibase.utilities.ApiBase;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ConfigReader.getProperty;

public class getCheckItemsPIM extends ApiBase {
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
        String URI = domain +"stock/checkitemsinpim";

        // passing the param value
        GlamitEnv = "104";

        //hitting the api to get the response
        Response response = given().header(new Header("Authorization","Bearer "+IDTknResp)).
                header("Glamit-Env",GlamitEnv).
                when().get(URI).then().extract().response();
        log.info(response.asString());

    }

}
