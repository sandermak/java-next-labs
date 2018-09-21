package whatsnew.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


public class AsyncHttpBuilderExample {

    public static void main(String... args) throws Exception {
        HttpClient.Builder builder = HttpClient.newBuilder();

        builder.version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS);

        HttpClient client = builder.build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .header("User-Agent", "Java 10")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response =
          client.sendAsync(request, HttpResponse.BodyHandler.asString());

        response.thenAccept(r -> {
            System.out.println("Version: " + r.version());
        });

        response.join();
    }
}
