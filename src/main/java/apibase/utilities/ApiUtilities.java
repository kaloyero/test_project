package apibase.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.Driver;

import static io.restassured.RestAssured.given;

public class ApiUtilities extends ApiBase {
    public static Logger log = LogManager.getLogger(Driver.class.getName());

//    @Test
//    public void getList() {
//
//
//        specLevisRMA.queryParam("sku", "levis_2249132720-1316-M");
//        Response response = given().contentType(ContentType.JSON)
//                .spec(specLevisRMA).
//                auth().oauth2(refreshToken()).
//                when().get();
//
//        response.prettyPrint();
//        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
//
//    }
}
