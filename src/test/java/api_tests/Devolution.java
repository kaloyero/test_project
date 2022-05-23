//package api_tests;
//
//
//import apibase.pojos.Entities;
//import apibase.pojos.Products;
//import apibase.utilities.ApiBase;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
//public class Devolution extends ApiBase {
//    Response response;
//
//    @Test
//    public void verifyData() {
//        Map<String, Object> expectedData = new HashMap<>();
//        Map<String, Object> products = new HashMap<>();
//        products.put("qty", 1);
//        products.put("sku", "levis_2249132720-1316-M");
//        expectedData.put("id", 6);
//        expectedData.put("ref", "17900122226-1");
//        expectedData.put("status", "complete");
//        expectedData.put("total", 2618.5600);
//        expectedData.put("type", "DEVOLUCION");
//        expectedData.put("reason", "Cliente");
//        expectedData.put("carrier", "andreaniestandar_andreaniestandar");
//        expectedData.put("external_id", 8889);
//        expectedData.put("tracking_number", "");
//        expectedData.put("customer_full_name", "Micaela Gonzalez");
//        expectedData.put("created_at", "2021-02-01T20:49:17.000+00:00");
//        expectedData.put("updated_at", "2021-02-01T20:50:21.000+00:00");
//        expectedData.put("qty", products.get("qty"));
//        expectedData.put("sku", products.get("sku"));
//
//
//        // System.out.println(expectedData);
//
//
//        specLevisRMA.queryParam("sku", "levis_2249132720-1316-M");
//        response = given().contentType(ContentType.JSON)
//                .spec(specLevisRMA).
//                auth().oauth2(refreshToken()).
//                when().get();
//
//        response.prettyPrint();
//        Map<String, Object> actualData = response.as(HashMap.class);
//        JsonPath actualData2 = response.jsonPath();
//        String path = "entities";
//
//        System.out.println(actualData2.get("entities[0].products[0].sku").toString());
//
//        //System.out.println(actualData.get("entities[0]"));
//
//        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
//        Assert.assertEquals(expectedData.get("sku"), actualData2.get("entities[0].products[0].sku"));
//
//
//    }
//
//    @Test
//    public void pojoTry() throws JsonProcessingException {
//        Products products = new Products(6, "levis_2249132720-1316-M");
//        products.setQty(5);
//        System.out.println(products.getQty());
//        Entities expectedDataNoConstructor = new Entities();
//        expectedDataNoConstructor.setCarrier("argentino");
//        System.out.println(expectedDataNoConstructor.getCarrier());
//        Entities expectedData = new Entities(6, "17900122226-1", 2618.5600, "DEVOLUCION", "Cliente", "andreaniestandar_andreaniestandar", products);
//        // System.out.println(expectedData.getCarrier());
//        expectedData.setCarrier("oca");
//        System.out.println(expectedData.getCarrier());
//
//        specLevisRMA.queryParam("sku", "levis_2249132720-1316-M");
//        response = given().contentType(ContentType.JSON)
//                .spec(specLevisRMA).
//                auth().oauth2(refreshToken()).
//                when().get();
//        // response.prettyPrint();
//        JsonPath actualDataJson = response.jsonPath();
//        Map<String, Object> actualDataMap = response.as(HashMap.class);
//        //actualData.prettyPrint();
//        System.out.println(actualDataMap.get("entities"));
//        Assert.assertEquals(products.getSku(), actualDataJson.get("entities[0].products[0].sku").toString());
//        /*ObjectMapper objectMapper=new ObjectMapper();
//        Entities[] entities2=objectMapper.readValue(response.asString(),Entities[].class);
//        System.out.println(entities2[0].getCarrier());*/
//
//
//    }
//
//    @Test
//    public void pojoTry2() {
//        Products products = new Products();
//        Entities entities = new Entities();
//        entities.setCarrier("andreaniestandar_andreaniestandar");
//        products.setSku("levis_2249132720-1316-M");
//        products.setQty(1);
//        specLevisRMA.queryParam("sku", "levis_2249132720-1316-M");
//        response = given().contentType(ContentType.JSON)
//                .spec(specLevisRMA).
//                auth().oauth2(refreshToken()).
//                when().get();
//        response.prettyPrint();
//
//        Assert.assertEquals(entities.getCarrier(), response.jsonPath().get("entities[0].carrier").toString());
//
//
//    }
//
//}
