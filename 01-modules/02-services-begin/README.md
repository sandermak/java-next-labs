# The Java Module System

We have four pre-defined modules in this exercise.
All module descriptors are currently empty, it's up to you to define them correctly.

The goal is to have a module `client` that we can run, that uses the `Logging` interface as defined in the `logger.api` module.
There are two service provider modules that must provide `Logging` implementations through the services mechanism.

## Step 1
Ensure that the `logger.client` module compiles, it currently has a compile error because of the import of `Logging`.
You can fix this by defining the `logger.client` and `logger.api` modules correctly.
If you did this correctly, compiling and running the `logger.client` will succeed (even though it doesn't do anything yet).

## Step 2
Add a appropriate `ServiceLoader` invocation to the `main` method, that obtains all services that implement `Logging`.
For each instance returned by the `ServiceLoader`, invoke the `log` method with a message.
Use the [ServiceLoader JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/util/ServiceLoader.html) if necessary.
The `logging.client` module should still compile and run, but it still doesn't do anything, because there are no service providers yet.
Let's fix that.

## Step 3
Look at the `logger.plain` module. It implements the `Logging` interface in a straightforward manner.
Expose this implementations as service by setting up the module descriptor.
Then, compile the `logger.client` and `logger.plain` modules together.
You have to specify the `logger.plain` module for compilation explicitly because the compiler only picks up additional modules through `requires` relations, not because of service relations.

Compilation now succeeds, but at runtime you will most likely see a `ServiceConfigurationError`.
The `logger.client` module descriptor should express that it wants to use services implementing `Logging`.
When you fix this, the application should compile and run, and you should see your message appear in the output.

## Step 4
Let's add another service provider module, `logger.jdk`.
Look at the implementation.
It uses the JDK logging implementation.
However, this API is not part of the `java.base` module, which is always implicitly required by every module.
Therefore, to setup the module descriptor of this service provider, you will also need to address this.
Remember, you can use the Java 9+ JavaDoc to find out in which (JDK) module an API lives.
Expose the `JdkLogging` implementation just as you did with the `PlainLogging`.

Compiling and running the application now shows the output of both `Logging` implementations.

## Bonus Step
Look at the `stream` method on `ServiceLoader`.
You can use this to inspect service provider implementations before instantiating and using them.
Put a `@Deprecated` annotation on the `PlainLogging` implementation.
Now modify the service loader invocation in `main` so that it only instantiates and uses `Logging` implementations that are not deprecated.