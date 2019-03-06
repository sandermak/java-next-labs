# The Java Module System: Services

We have four pre-defined modules in this exercise.
All module descriptors are currently empty, it's up to you to define them correctly.

The goal is to have a module `client` that we can run, that uses the `Logging` interface as defined in the `logger.api` module.
There are two service provider modules that must provide `Logging` implementations through the [services](https://openjdk.java.net/projects/jigsaw/quick-start#services) mechanism.

Use `./compilerun.sh` to compile and run the code. During the steps you'll need to expand this script with new modules to compile. On Windows you can use Cygwin or the Linux Subsystem for Windows, or alternatively just copy the individual commands from the script to the command line, the scripts are fairly small so it's not too bad.

## Step 1
Ensure that the `logger.client` module compiles, it currently has a compile error because of the import of `Logging`.
You can fix this by defining the `logger.client` and `logger.api` module descriptors correctly.
If you did this correctly, compiling and running the `logger.client` will succeed (even though it doesn't do anything yet).

## Step 2
Add an appropriate `ServiceLoader` invocation to the `main` method, that obtains all services that implement `Logging`.
For each instance returned by the `ServiceLoader`, invoke the `log` method with a message.
Use the [ServiceLoader JavaDoc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ServiceLoader.html) if necessary.
Also take care to update the module descriptor of the `logger.client` module so it reflects the service use.
The `logging.client` module should still compile and run, but it still doesn't do anything, because there are no service providers yet.
Let's fix that.

## Step 3
Look at the `logger.plain` module. It implements the `Logging` interface in a straightforward manner.
Expose this implementation as service by setting up the module descriptor for the `logger.plain` module.
Then, compile the `logger.client` and `logger.plain` modules together.
Update the `compilerun.sh` script to also compile this additional module.
The `-m` flag takes a comma-separated list of modules to compile.
You have to specify the `logger.plain` module for compilation explicitly because the compiler only picks up additional modules through `requires` relations, not because of service relations.

Compilation now succeeds.
If you still see a `ServiceConfigurationError` error at runtime, take care to update the `logger.client` module descriptor to reflect the service use.
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

Compiling and running the application (don't forget to add `logger.jdk` to the `compilerun.sh` script) now shows the output of both `Logging` implementations.

## Bonus Step
Look at the `stream` method on `ServiceLoader`.
You can use this to inspect service provider implementations before instantiating and using them.
Put a `@Deprecated` annotation on the `PlainLogging` implementation.
Now modify the service loader invocation in `main` so that it only instantiates and uses `Logging` implementations that are not deprecated.
