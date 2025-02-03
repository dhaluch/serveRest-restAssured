package factory;

import org.json.simple.JSONObject;
import pojo.Usuario;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJSON {

    Usuario user;
    JSONObject userJson;
    JSONObject idUsuario;

    public CreateJSON() throws IOException {


    }

    public void criaUsuarioJson(Usuario usuarioJon) throws IOException {
        userJson = new JSONObject();
        userJson.put("Nome",usuarioJon.getNome());
        userJson.put("email",usuarioJon.getEmail());
        userJson.put("password",usuarioJon.getPassword());
        userJson.put("administrador", usuarioJon.getAdministrador());

        FileWriter file = new FileWriter("src/test/resources/requestBody/jsonExemplo.json");
        file.write(userJson.toJSONString());
        file.flush();
        file.close();
    }

    public void salvaIdusuarioCriado(String id) throws IOException {
        idUsuario = new JSONObject();
        userJson.put("_id",id);
        FileWriter file = new FileWriter("src/test/resources/requestBody/jsonExemplo.json");
        file.write(userJson.toJSONString());
        file.flush();
        file.close();
    }



}
