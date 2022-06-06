package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pojo.Usd;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;


public class CbrTest {
    private final static String URL = "https://www.cbr-xml-daily.ru/daily_json.js";
    private final double usdExpectedValue = 61.96590042114258;

    @Tag("rest")
    @Test
    @DisplayName("Проверка курса доллара")
    public void checkUsdValueTest() {
/*        List<Usd> usd = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL)
                .then().log().all()
                .extract().body().jsonPath().getList("Valute", Usd.class);
*/

        //get response
        Response res = given()
                .filter(new AllureRestAssured())
                .when()
                .contentType(ContentType.JSON)
                .get(URL);

        //Response body
        ResponseBody b = res.getBody();

        //convert response body to string
        String responseBody = b.asString();

        //JSON Representation from Response Body
        JsonPath jsnPath = res.jsonPath();

        LinkedHashMap valute = jsnPath.get("Valute");

        //check that valutes.size == valutes
        Assertions.assertEquals(34, valute.keySet().size());
        //Assert.assertEquals(valute.keySet().size(), 34);

        LinkedHashMap usdMap = jsnPath.get("Valute.USD");

        String usdId = (String) usdMap.get("ID");
        String usdNumCode = (String) usdMap.get("NumCode");
        String usdCharCode = (String) usdMap.get("CharCode");
        int usdNominal = (int) usdMap.get("Nominal");
        String usdName = (String) usdMap.get("Name");
        double usdValue = (float) usdMap.get("Value");
        double usdPrevious = (float) usdMap.get("Previous");

        new Usd(usdId,usdNumCode,usdCharCode,usdNominal,usdName,usdValue,usdPrevious);
        Usd pojoUsd = new Usd();

        // Check that Value equals +- 0.01rub
        Assertions.assertEquals(usdExpectedValue, pojoUsd.getValue(), 0.01);
        //Assert.assertEquals(pojoUsd.getValue(), 83.40969848632812, 0.01);
        System.out.println("Тест пройден");



        int i =0;
    }
}
