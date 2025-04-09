package Meal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TheMealDB {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search for a meal: ");
        String meal = scanner.nextLine().trim();
        final String API = "https://www.themealdb.com/api/json/v1/1/search.php?s="+ meal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(API))
                            .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
    }
}
