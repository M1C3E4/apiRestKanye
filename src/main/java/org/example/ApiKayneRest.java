package org.example;

import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiKayneRest {

    private final HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        PrintWriter saveDB = new PrintWriter("DataBase.txt");
        ApiKayneRest apiKayneRest = new ApiKayneRest();
        Scanner scanner = new Scanner(System.in);
        System.out.println("*Pierwsza perełka mądrości Kanye Westa: ");
        apiKayneRest.sendGet();
        while (true) {
            System.out.println("*Jeżeli chcesz poznać kolejną perełkę mądrości Kanye Westa wpisz next w przeciwnym razie wpisz end:");
            String next = scanner.next();
            if (next.equals("next")) {
                apiKayneRest.sendGet();
            } else {
                break;
            }
        }
    }

    private final String url = "https://api.kanye.rest";

    private String sendGet() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseVar = response.body();
        System.out.println(responseVar);
        return responseVar;
    }
}