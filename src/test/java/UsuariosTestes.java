import config.Configuracoes;
import factory.CreateJSON;
import factory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.restassured.AllureRestAssured;

import pojo.Usuario;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UsuariosTestes {
    @BeforeAll
    public static void setUp(){
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        String teste = configuracoes.baseURI();
        baseURI = configuracoes.baseURI();

    }
    @Test
    public void ValidaCriacaoUsuarioSucesso() throws IOException {
        //  baseURI = "https://serverest.dev";

        Usuario usuario = UsuarioDataFactory.criarUsuario();

        String Id = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("schemas/postUsuariovalido.json"))
                .log().all()
                .extract()
                .path("_id");

    }

    @Test
    public void validaCampoEmailValido() throws IOException {
       // baseURI = "https://serverest.dev";

        Usuario usuario = UsuarioDataFactory.criarUsuarioEmailInvalido();

        given()
            .contentType(ContentType.JSON)
            .body(usuario)
        .when()
            .post("/usuarios")

        .then()
                .assertThat()
                .statusCode(400)
                .body("email", is("email deve ser um email válido"))
                .log().all();
    }

    @Test
    public void validaCampoAdministrador() throws IOException {
        // baseURI = "https://serverest.dev";

        Usuario usuario = UsuarioDataFactory.criarUsuarioAdminstradorVazio();

        given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post("/usuarios")

                .then()
                .assertThat()
                .statusCode(400)
                .body("administrador", is("administrador deve ser 'true' ou 'false'"))
                .log().all();
    }


}
