package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Usuario;

import java.io.FileInputStream;
import java.io.IOException;

public class UsuarioDataFactory {

    public static Usuario criarUsuario() throws IOException {
        String postUsuario = "src/test/resources/requestBody/postUsuarios.json";
        
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.readValue(new FileInputStream(postUsuario), Usuario.class);
        return usuario;
    }
    /*
    public static Usuario criarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("Alex fontana");
        usuario.setEmail("alex.fontana@qa.com.br");
        usuario.setPassword("12345");
        usuario.setAdminstrador("true");
        return  usuario;
    }

     */
}
