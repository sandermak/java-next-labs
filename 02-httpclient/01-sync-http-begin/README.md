# HttpClient - synchronous calls

In this exercise we're going to perform a GET call using the least amount of configuration, using default settings of the `HttpClient`.

You can either use the `compilerun.sh` script to run the application from the command-line, or you can configure your favorite IDE for this project. In that case, remember to add the `--add-modules jdk.incubator.httpclient` to the compiler (only necessary in IntelliJ) and run configuration (in both IntelliJ and Eclipse).

Tip: try to use `var` wherever it makes sense.

## Step 1
Create a `HttpClient` instance (use the simplest possible way) and an `HttpRequest` that points to `https://www.ns.nl` (as a GET request).

## Step 2
Perform the request using the `HttpClient` instance.
Look at the various pre-defined `BodyHandler`s as provided by the `BodyHandler` class.

## Step 3
Print the headers of the response *if it is succesful*.
You can determine this by inspecting the `statusCode` of the response.
Otherwise, print the unsuccessful status code and the body of the response (it may contain an error).

Tip: you can trigger the failure path by performing a request to `http://httpstat.us/400` instead.    

## Bonus step
Change the request URL to `http://ns.nl` (http instead of https) and run the code again.
You'll see that a 301 (redirect) status code is returned.
Try to configure the `HttpClient` so that it transparently follows redirects, and delivers a 200 OK response again.
You'll need the `HttpClient.Builder` for this.
