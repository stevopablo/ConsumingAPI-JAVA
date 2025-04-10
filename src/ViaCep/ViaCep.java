package ViaCep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ViaCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConsultarCep consultarCep = new ConsultarCep();
        System.out.println("Digite um cep: ");
        String cep = scanner.nextLine();

        Endereco endereco1 = consultarCep.buscarPorCep(cep);
        System.out.println(endereco1);

//        Endereco endereco = consultarCep.buscarPorCep("01001000");
//        System.out.println(endereco);



    }
}
