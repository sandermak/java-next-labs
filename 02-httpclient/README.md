# HttpClient

In Java 9, the new [HttpClient API](https://docs.oracle.com/javase/10/docs/api/jdk/incubator/http/HttpClient.html) was introduced as a so-called incubator module.
This meant that you could use the API, but it was still subject to change.
In Java 11, the HttpClient was finalized and made part of the Java standard library.
This means we now have a modern HTTP client by default in Java, which supports HTTP/2 and WebSockets as well.

If you're using Java 9 or 10, when compiling/running code that uses `HttpClient` you still need to tell `javac` and `java` that you want to use the incubator module containing the `HttpClient` API with the following flag:

```
--add-modules jdk.incubator.httpclient
```

If you're using an IDE you should configure this flag for the Java compiler and execution environment from within the IDE.

As of Java 11, this flag is no longer necessary. Note that as part of the finalization of the API, the package containing HttpClient types also changed from `jdk.incubator.http` to `java.net.http`.

## 01. sync-http

Perform a simple, synchronous HTTP GET call with the new HttpClient API.

## 02. async-http

Perform an asynchronous HTTP/2 GET call with the new HttpClient API.
