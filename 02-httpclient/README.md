# HttpClient

In Java 9, the new [HttpClient API](https://docs.oracle.com/javase/10/docs/api/jdk/incubator/http/HttpClient.html) was introduced as a so-called incubator module.
This meant that you could use the API, but it was still subject to change.
In Java 11, the HttpClient was finalized and made part of the Java standard library.
This means we now have a modern HTTP client by default in Java, which supports HTTP/2 and WebSockets as well.

Because we're using Java 10, when compiling/running code that uses `HttpClient` we still need to tell `javac` and `java` that we want to use the incubator module containing the `HttpClient` API with the following flag:

```
--add-modules jdk.incubator.httpclient
```

If you're using an IDE you should configure this flag for the Java compiler and execution environment from within the IDE.

## 01. sync-http


## 02. async-http