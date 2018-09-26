# 01-two-modules

## Step 1
Create a module called `firstmodule` in the `src` folder.
You can put the sources for this first module in a `firstmodule` directory.
Remember, a module is created by adding a module descriptor (`module-info.java`) to the root of the source tree for the module.

## Step 2
Then, create a class with a `main` method.
This class must be in a package (modules cannot contain code outside packages).
Try compiling the module.
On https://docs.oracle.com/javase/10/tools/javac.htm you can find all the new flags that have been added for handling modules during compilation.
Compiling a single module can be done without any special new flags, but try using the `--module-source-path` flag instead, because we will add a second module next.
You'll see that when using this flag, you need to define a destination/output directory as well using `-d`.
Also look at the `--module` (or `-m`) flag of `javac`, since it allows you to define just a module name for compilation, rather than having to list all source files as input to the compiler.

## Step 3
Now, run the module.
The syntax for running a compiled module is as follows:

```
java --module-path <destdir> -m <modulename>/<mainclass>
```

Note that the the main class should be fully qualified (including the package name).
Also, `--module-path` can be shortened to `-mp`.

## Step 4
Next, add another module called `secondmodule`.
Create a class `Helper` in this module (again, class must be inside of a package), with a method that returns a string.
Instantiate this `Helper` class in your previously created main class in `firstmodule` and print the string to the console.
This creates a dependency between the modules, so ensure the module descriptors reflect this.
What else needs to happen for the code to compile? (Think of strong encapsulation!)

## Step 5
Try running the application with the same command you used before to run the single module.
Note that the module descriptor is used at runtime to check all dependencies before starting the application.
If you remove `secondmodule` from the destination directory, and try to run the app using the same command, you will get an explanation of why the app cannot be started.
