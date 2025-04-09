package Crypto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Coingecko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int systemON = 1;

        while (systemON == 1) {
            try {
                System.out.println("""
                        List of top 10 cryptocurrencies currently in the market:
                        Bitcoin (BTC)
                        Ethereum (ETH)
                        Tether (USDT)
                        XRP (XRP)
                        BNB (BNB)
                        Solana (SOL)
                        USD Coin (USDC)
                        Dogecoin (DOGE)
                        Cardano (ADA)
                        TRON (TRX) 
                        """);

                System.out.println("Search for a crypto: ");
                String crypto = scanner.nextLine().trim().toLowerCase();

                final String URL = "https://api.coingecko.com/api/v3/simple/price?ids=" + crypto + "&vs_currencies=usd";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Price data: " + response.body());

                System.out.println("Enter 1 to continue or 0 to exit: ");
                systemON = scanner.nextInt();
                scanner.nextLine();

                if (systemON == 0) {
                    System.out.println("See you later...");
                }
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
