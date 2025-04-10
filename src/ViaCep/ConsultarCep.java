package ViaCep;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;

public class ConsultarCep {

    public Endereco buscarPorCep(String cep) throws IOException, InterruptedException {
        String URL = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("response.body() = " + response.body());
            return new Gson().fromJson(response.body(), Endereco.class);

        }catch (IOException | InterruptedException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            throw new RuntimeException("Falha ao buscar cep");
        }
    }
}
