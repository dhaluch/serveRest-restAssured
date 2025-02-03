import config.Configuracoes;
import factory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.restassured.AllureRestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import pojo.Usuario;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Usuarios {
    @BeforeAll
    public static void setUp(){
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        String teste = configuracoes.baseURI();
        baseURI = configuracoes.baseURI();

    }



    public void createUser() throws IOException {
       // baseURI = "https://serverest.dev";

        Usuario usuario = UsuarioDataFactory.criarUsuario();

        given()
            .contentType(ContentType.JSON)
            .body(usuario)
        .when()
            .post("/usuarios")

        .then()
            .log().all();
            //.extract()
            //.path("authorization");
    }




    //teste de contrato
    @Test
    public void createUserValidaContrato() throws IOException {
      //  baseURI = "https://serverest.dev";

        Usuario usuario = UsuarioDataFactory.criarUsuario();

        given()
            .filter(new AllureRestAssured())
            .contentType(ContentType.JSON)
            .body(usuario)
        .when()
            .post("/usuarios")

        .then()
                .assertThat()
                .statusCode(400)
               // .body(matchesJsonSchemaInClasspath("schemas/postUsuariovalido.json"))
                .log().all();


    }
}
