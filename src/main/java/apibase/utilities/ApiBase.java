package apibase.utilities;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import utilities.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static utilities.ConfigReader.getProperty;

public class ApiBase extends Driver {
    public static Logger log = LogManager.getLogger(ApiBase.class);
//    protected RequestSpecification authToken;
//    protected RequestSpecification specLevisRMA;
//    protected RequestSpecification specMimo;
    public String newToken, newIdToken;
    public static String ApiEnv,IDTknResp,domain,dateFrom,dateTo,page,perPage,GlamitEnv,desasignar;
//    @Before
//    public void setUpLevisRma() {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("page", "1");
//        parameters.put("size", "50");
//        specLevisRMA = new RequestSpecBuilder().
//                setBaseUri("https://api.oms.glamit.com.ar/v1/rma/rmas")
//                .addHeader("Glamit-Env", "179").addQueryParams(parameters)
//                .build();
//
//    }
//
//    @Before
//    public void setUpToken() {
//
//        authToken = new RequestSpecBuilder().
//                setBaseUri("https://api.auth.glamit.com.ar/auth/refresh")
//                .build();
//    }
//
//    public String refreshToken() {
//        String refresh_token = "refresh_token";
//        //String refreshTokenKey="eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.RUWinRrzXRrS4owgVtf6CztSYuo0s2Hl2u7itBdogOsB6sx3SOMhmbGwi_Lk-jZ_y0Dz6DtuLfo_T_rWom4cF1dkP9--Ti7vhTqEcrTt3FXiuYB99u9fFRufEVs50d0oLMQER2Se4l7qk-UHwB1u0gKQc1Rv0aoONHCuPlzgD5FZRrKcVSoEVcXIqPj6Ppk8t5Ie66JpyoWnJNnEAau9hBmIDSbJ1QoHomNP34DFdFFBl8nyuiVsYQBoUzArZ_ufDdOLxaQNRR255nai1PBAvMN1S2oFe9adE3MfVARwuDy55Gq0yJY4PhNESadp6EO8HYQE2eQqkGCjPlcR1ZKqIA.ANmEsNIEUVvoYH1F.w-RICpIyKDuCPXHIrcVJQhw4w-A4w4vcxjiJnmzuNejhZE28sU2VFCSuo_x3wspmarQFYxaX59klhsC_ZJdnegtVcu8uooKCHn9LAqzvrDUgTL1FN2qFZMLTAVFRHWwua5ffZ-QoTG_dTz4kdinmwdbN4R1-TJiIkNvC8NoUlDnGXZM0GRen2DF6qyktcDxiZ3ORzv5PQS2pIUM27pcwBBel-7GY42Pnhk_ZJ-WuhX9p54QSp5eLHD1aBF6KMwuwM83o4QWiF9FryXqnRsVjkoBEUB8YPbgfLg8Z0_d06CV09aYJuQ2UAwDldwy4c5Z3dFNtHb7nqigovL3co3FMGBoVtvPXkfS-1L5ZAQeB8jORcIka1X8uHnX3hNmAUu91hakIXuHhntqSOeITmWFuxrtYqFjSz3tyAeK-ammS0VY0u6pxm6__P7Xkl7XQ9VmWc2n4klHGAirabcL9W8AqOBF98EWJznnays2bi9FVpOaP4wtYuMGGESl3fUnuyTO08w95IgLnYTNncFu99GhumxiJIMcQ-e0b7gtHUyzEE111hzRLr2fX2XJhxR03z1GjYjHZMLL3nwoqCsv_wsQgrn2A7a7Nwy_mp5pMmJId9LsbCf-94wBtcZl-kTzJE4Suqakhrkji8-7dKtyDa00CKUFMpdkeVAV8AEZjc3oezoVAgvCcsHU01NzgrDsbUcfqjH03tFSFEl9KwT7VUZdNEd09iY3yR-DIsiWI3lH6VGgjh14oU51MSGq-1FZCVzuppcqIyXD5zB0OHypV4V6pWkH21T1XelxphBWSQo5cnP-X4zLRyGcs29eLZnmVtbU3XHODEQ0SEdq1qZRdlQkG5c4Y1N9BGbyVeb-UOQnfSkiNBd8WskhXK-QT0v8FGVEG57EeMLyh-FDuH4YB-DCfqsU_iaRAyS8JKyP_DIOK6E6fE2wdMXxq7E_wlrZ17yVHQ5Qz_s1n2eF_WTaLr27by8Hp4U7PBZdVHQ5lXZu77CIJY6lXh6E_b-rEa1zucoEuxGQVNG0SMTLmk1qMVXvNjHf_yqzTSpHGxdJ4VWNBoNWl0NMJjatxWUxrgtG4P4JgJroyno10Yrkcp5JX6SGXkVPCYXsBNwKnwS1weNxOA2snHeZtjaIhFqAnLfpSxt5f6XXY4UzFDP_Js9Me2jdEFkmbS4lsFXdPdAjWjMAwcv709ezYQNZspAVjsRAy8nUhEWG_FdM2vJ8wqPeBeQp62kby._tHy40Yqx4jHglGD5DCh6w";
//        authToken.queryParam(refresh_token, "eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiUlNBLU9BRVAifQ.RUWinRrzXRrS4owgVtf6CztSYuo0s2Hl2u7itBdogOsB6sx3SOMhmbGwi_Lk-jZ_y0Dz6DtuLfo_T_rWom4cF1dkP9--Ti7vhTqEcrTt3FXiuYB99u9fFRufEVs50d0oLMQER2Se4l7qk-UHwB1u0gKQc1Rv0aoONHCuPlzgD5FZRrKcVSoEVcXIqPj6Ppk8t5Ie66JpyoWnJNnEAau9hBmIDSbJ1QoHomNP34DFdFFBl8nyuiVsYQBoUzArZ_ufDdOLxaQNRR255nai1PBAvMN1S2oFe9adE3MfVARwuDy55Gq0yJY4PhNESadp6EO8HYQE2eQqkGCjPlcR1ZKqIA.ANmEsNIEUVvoYH1F.w-RICpIyKDuCPXHIrcVJQhw4w-A4w4vcxjiJnmzuNejhZE28sU2VFCSuo_x3wspmarQFYxaX59klhsC_ZJdnegtVcu8uooKCHn9LAqzvrDUgTL1FN2qFZMLTAVFRHWwua5ffZ-QoTG_dTz4kdinmwdbN4R1-TJiIkNvC8NoUlDnGXZM0GRen2DF6qyktcDxiZ3ORzv5PQS2pIUM27pcwBBel-7GY42Pnhk_ZJ-WuhX9p54QSp5eLHD1aBF6KMwuwM83o4QWiF9FryXqnRsVjkoBEUB8YPbgfLg8Z0_d06CV09aYJuQ2UAwDldwy4c5Z3dFNtHb7nqigovL3co3FMGBoVtvPXkfS-1L5ZAQeB8jORcIka1X8uHnX3hNmAUu91hakIXuHhntqSOeITmWFuxrtYqFjSz3tyAeK-ammS0VY0u6pxm6__P7Xkl7XQ9VmWc2n4klHGAirabcL9W8AqOBF98EWJznnays2bi9FVpOaP4wtYuMGGESl3fUnuyTO08w95IgLnYTNncFu99GhumxiJIMcQ-e0b7gtHUyzEE111hzRLr2fX2XJhxR03z1GjYjHZMLL3nwoqCsv_wsQgrn2A7a7Nwy_mp5pMmJId9LsbCf-94wBtcZl-kTzJE4Suqakhrkji8-7dKtyDa00CKUFMpdkeVAV8AEZjc3oezoVAgvCcsHU01NzgrDsbUcfqjH03tFSFEl9KwT7VUZdNEd09iY3yR-DIsiWI3lH6VGgjh14oU51MSGq-1FZCVzuppcqIyXD5zB0OHypV4V6pWkH21T1XelxphBWSQo5cnP-X4zLRyGcs29eLZnmVtbU3XHODEQ0SEdq1qZRdlQkG5c4Y1N9BGbyVeb-UOQnfSkiNBd8WskhXK-QT0v8FGVEG57EeMLyh-FDuH4YB-DCfqsU_iaRAyS8JKyP_DIOK6E6fE2wdMXxq7E_wlrZ17yVHQ5Qz_s1n2eF_WTaLr27by8Hp4U7PBZdVHQ5lXZu77CIJY6lXh6E_b-rEa1zucoEuxGQVNG0SMTLmk1qMVXvNjHf_yqzTSpHGxdJ4VWNBoNWl0NMJjatxWUxrgtG4P4JgJroyno10Yrkcp5JX6SGXkVPCYXsBNwKnwS1weNxOA2snHeZtjaIhFqAnLfpSxt5f6XXY4UzFDP_Js9Me2jdEFkmbS4lsFXdPdAjWjMAwcv709ezYQNZspAVjsRAy8nUhEWG_FdM2vJ8wqPeBeQp62kby._tHy40Yqx4jHglGD5DCh6w");
//        Response response2 = given().spec(authToken).given().post();
//        //response2.prettyPrint();
//        Map<String, String> getToken = response2.as(HashMap.class);
//        // System.out.println(getToken.get("id_token"));
//        return newToken = getToken.get("id_token");
//
//    }


    public String IdToken() {
        //getting the env from properties file
        ApiEnv = getProperty("API_ENV");
        log.info("the environment is ..."+ApiEnv);

        // getting the url to generate base URI
        String URI = getProperty("refreshTokenUri") ;
        log.info("The base URI is .." + URI);
        Response response = given().contentType(ContentType.JSON).queryParam("refresh_token" , getProperty("refreshToken")).when().post(URI).then().extract().response();
        log.info(response.asString());
        //asserting the status code and getting ID token
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("id_token"));
        newIdToken = response.jsonPath().getString("id_token");
        return newIdToken;
    }

    public String getDateFormat(Date fDate, String formatDt) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDt);

        String date = sdf.format(fDate);
        return date;
    }

    /**
     * This method is used to read json file
     * @param filename - pass the file name of json
     * @return - will return the value of json file
     */
    public JSONObject readJSONFromFile (String filename){
        JSONObject jsonObject = null;
        try {
            InputStream is = new FileInputStream(new File("src/test/resources/"+filename));
            if (is == null){
                throw  new NullPointerException("cannot find resource file" +filename);
            }
            JSONTokener tokener = new JSONTokener(is);
            jsonObject= new JSONObject(tokener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }




}
