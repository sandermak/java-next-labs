package whatsnew.httpclient;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;


public class SimpleHttpClientExample {

    public static void main(String... args) throws Exception {
        var client = HttpClient.newHttpClient();

        var request =
                HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpResponse<String> response =
          client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200)
            System.out.println(response.headers().map());
        else
            System.out.println(response.statusCode() + ": " + response.body());
    }
}
