package whatsnew.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;


public class SimpleHttpClientExample {

    public static void main(String... args) throws Exception {
        var client = HttpClient.newHttpClient();

        var request =
                HttpRequest.newBuilder(URI.create("https://www.ns.nl"))
                .GET()
                .build();

        HttpResponse<String> response =
          client.send(request, HttpResponse.BodyHandler.asString());

        if(response.statusCode() == 200)
            System.out.println(response.headers().map());
        else
            System.out.println(response.statusCode() + ": " + response.body());
    }
}
