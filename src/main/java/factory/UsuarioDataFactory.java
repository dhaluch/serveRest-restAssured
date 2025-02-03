package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import pojo.Usuario;

import java.io.FileInputStream;
import java.io.IOException;

public class UsuarioDataFactory {

    public static Usuario criarUsuario() throws IOException {

        Faker faker = new Faker();
        Usuario usuario = new Usuario();
        usuario.setNome(faker.name().fullName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword("1234");
        usuario.setAdministrador("true");
        CreateJSON createUsuarioJson = new CreateJSON();
        createUsuarioJson.criaUsuarioJson(usuario);
        return usuario;


    }


    public static Usuario criarUsuarioEmailInvalido() throws IOException {

        String postUsuario = "src/test/resources/requestBody/postUsuarios.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.readValue(new FileInputStream(postUsuario), Usuario.class);
        usuario.setEmail(" ");
        return  usuario;
    }

    public static Usuario criarUsuarioAdminstradorVazio() throws IOException {
        String postUsuario = "src/test/resources/requestBody/postUsuarios.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.readValue(new FileInputStream(postUsuario), Usuario.class);
        usuario.setAdministrador(" ");
        return  usuario;
    }

    public static void  idUsuario(String id){


    }

}
