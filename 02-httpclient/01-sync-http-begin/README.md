# HttpClient - synchronous calls

In this exercise we're going to perform a GET call using the least amount of configuration, using default settings of the `HttpClient`.

You can either use the `compilerun.sh` script to run the application from the command-line, or use Maven to compile (`mvn compile`) and run (`mvn exec:java`) the example.

You can also import the project into an IDE.
Since it is a Maven project, most IDEs should automatically set the right configuration.
Alternatively, you can configure your favorite IDE for this project manually.
In that case, remember to select JDK 11 as the runtime platform, and set the language level for your project to Java 11.

Tip: try to use `var` wherever it makes sense.

## Step 1
Create a `HttpClient` instance (use the simplest possible way) and an `HttpRequest` that points to `https://www.google.com` (as a GET request).

## Step 2
Perform the request using the `HttpClient` instance.
Look at the various pre-defined `BodyHandler`s as provided by the `HttpRequest.BodyHandlers` class.

## Step 3
Print the headers of the response *if it is succesful*.
You can determine this by inspecting the `statusCode` of the response.
Otherwise, print the unsuccessful status code and the body of the response (it may contain an error).

Tip: you can trigger the failure path by performing a request to `http://httpstat.us/400` instead.    

## Bonus step
Change the request URL to `http://google.com` (drop the `www`) and run the code again.
You'll see that a 301 (redirect) status code is returned.
Try to configure the `HttpClient` so that it transparently follows redirects, and delivers a 200 OK response again.
You'll need the `HttpClient.Builder` for this to create a correctly configured `HttpClient`.
