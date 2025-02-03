import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Login {

    /*
    @Test
    public void login() {
        baseURI = "https://serverest.dev";

        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"daniel.haluch@qa.com.br\",\n" +
                        "  \"password\": \"Senha123\"\n" +
                        "}")
                .log().all()
                .when()
                .post("/login")

                .then()
                .log().all()
                .extract()
                .path("authorization");
    }

     */

}