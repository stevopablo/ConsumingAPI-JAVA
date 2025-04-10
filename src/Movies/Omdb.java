package Movies;

import Model.Title;
import Model.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.SequencedCollection;

public class Omdb {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur favorite movie: ");
        String movie = scanner.nextLine();
        final String URL = "http://www.omdbapi.com/?t=" + movie + "&apikey=6a5c2ac3";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(URL))
                            .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("response = " + response.body());

        String json = (String) response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
//        Title myMovie = gson.fromJson(json,Title.class);
//        System.out.println(myMovie);

        TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.println("titleOmdb = " + titleOmdb);

        Title myTitle = new Title(titleOmdb);

    }
}
