package whatsnew.httpclient;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;
import java.util.concurrent.CompletableFuture;


public class AsyncHttpBuilderExample {

    public static void main(String... args) throws Exception {
        HttpClient.Builder builder = HttpClient.newBuilder();

        builder.version(HttpClient.Version.HTTP_2)
               .followRedirects(HttpClient.Redirect.ALWAYS);

        HttpClient client = builder.build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .header("User-Agent", "Java")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response =
          client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .whenComplete((res, exception) -> {
                    System.out.println("Version: " + res.version());
                    System.out.println("Error  : " + exception);
                });

        response.join();
    }
}
