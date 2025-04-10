package Movies;

import Model.Title;
import Model.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Omdb {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            List<Title> movies = new ArrayList<>();
            boolean running = true;

            while (running) {
                System.out.println("Enter your favorite movie (or type 'exit' to quit): ");
                String movie = scanner.nextLine();

                if (movie.equalsIgnoreCase("exit")) {
                    running = false;
                    continue;
                }

                try {
                    String url = "http://www.omdbapi.com/?t=" + movie.replace(" ", "+") + "&apikey=6a5c2ac3";
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();
                    System.out.println("API Response:\n" + json);

                    TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
                    Title myTitle = new Title(titleOmdb);
                    movies.add(myTitle);

                } catch (IOException | InterruptedException e) {
                    System.out.println("Error fetching movie data: " + e.getMessage());
                }
            }

            try (FileWriter fileWriter = new FileWriter("TopMovies.json")) {
                fileWriter.write(gson.toJson(movies));
                fileWriter.close();
                System.out.println("Movies saved successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }

        System.out.println("See ya, space cowboy!");
    }
}
