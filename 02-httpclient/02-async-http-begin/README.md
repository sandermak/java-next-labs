# HttpClient - asynchronous calls

In this exercise we're going to do an asynchronous call to `https://www.google.com` using HTTP/2.

## Step 1
Create an `HttpClient` that is configured to prefer HTTP/2 calls using the builder API. HTTP/2 is the default, but try to configure it explicitly to see how it works.
Also configure the client to always follow redirects (this is not the default).

## Step 2
Create an `HttpRequest` to `https://www.google.com`.
Look at the various builder methods to see what configuration options are available.
Try to set a custom header `User-Agent` with the value `Java`.

## Step 3
Now perform an asynchronous call with the request created in the previous step.
Read the [CompletableFuture JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/util/concurrent/CompletableFuture.html) and [CompletionStage JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/util/concurrent/CompletionStage.html), because that's what the `sendAsync` method returns.

You can configure callbacks on the `CompletableFuture` that trigger when the server sends a response.
Have a look at the methods on `CompletionStage` to select a suitable callback.
Pass in a lambda that prints the version of the HTTP response.
We expect this to be version 2, because Google supports HTTP/2.

Now, run the code.

You probably noticed there's no output!
That's because of the asynchronous nature of the `CompletableFuture`.
The application terminates before the callback on the `CompletableFuture` has run, because the server needs some time to respond.

To fix this, add a call to `join` on the `CompletableFuture` that's returned from the method you used previously to configure a callback on the `CompletableFuture`.
This should be the last line in the `main` method.
Alternatively, you can also keep chaining calls from `sendAsync` and end with `join`.
Join ensures the application thread waits until the `CompletableFuture` is completed.

Run the code again. Now you should see the version of the response printed.

You can also try another URL (for example `https://www.eclipse.org`). Does it support HTTP/2?


## Bonus step
Use the methods `sendAsync` method to perform two HTTP requests, which will execute in parallel.
Then, use the appropriate methods on `CompletableFuture` and/or `CompletionStage` to  combine and print the result when both requests have completed.

Tip: look at methods like `allOf`, `thenCombine` and other compositional operators. The idea is to combine two `CompletableFuture`s that you get back from `sendAsync` into a new one.
