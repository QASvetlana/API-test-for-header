import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class headerTest {
    @Test
    public void testHeader() {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response response = RestAssured
                .given()
                .body(authData)
                .when()
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        System.out.println("/nHeaders:");
        Headers responseHeaders = response.getHeaders();

        System.out.println(responseHeaders);

        assertTrue(responseHeaders.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' name");
    }
}

