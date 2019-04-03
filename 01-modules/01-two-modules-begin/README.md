# The Java Module System: Basics

## Step 1
Create a module directory called `firstmodule` in the `src` folder.
You can put the sources for the first module in this `firstmodule` directory.
Remember, a module is created by adding a module declaration (`module-info.java`) to the root of the source tree for the module.
For now, you can create a simple module declaration with just the `module` keyword, the name of the module (`firstmodule`) and an empty body.

## Step 2
Then, create a class with a `main` method in the first module.
This class must be in a package.
Modules cannot contain code outside packages.
You declare a package at the top of your source file with `package mypackagename;`.
You can choose any package name you want, as long as you also create the corresponding directory (or directories, for a nested package name) and put the source file in there.

Now, try compiling the module.
It's easiest to do this from the `01-two-modules-begin` directory, so ensure you're there in your terminal or console.

On https://docs.oracle.com/en/java/javase/11/tools/javac.html you can find all the new flags that have been added for handling modules during compilation.
Compiling a single module can be done without any special new flags, but try using the `--module-source-path` flag instead, because we will add a second module next.
Point this flag to the `src` folder.
You'll see that when using this flag, you need to define a destination/output directory as well using `-d`.
Now, you need to list all sources that you want to compile.
Since that's a lot of (useless) work, you can also look at the `--module` (or `-m`) flag of `javac`.
It allows you to define just a module name for compilation, rather than having to list all source files as input to the compiler.

## Step 3
Now, run the module.
The syntax for running a compiled module is as follows:

```
java --module-path <destdir> -m <modulename>/<mainclass>
```

Note that the the main class should be a fully qualified classname (including the package name).
An example of a fully qualified classname is `com.javamodularity.module1.Main`.
Also, `--module-path` can be shortened to `-p`.

## Step 4
Next, add another module called `secondmodule`.
Create a class `Helper` in this module (again, class must be inside of a package, but a different package than in `firstmodule`!)
The class should contain a method that returns a string.
Instantiate this `Helper` class in your previously created main class in `firstmodule` and print the string to the console.
This creates a dependency between the modules, so ensure the module declarations reflect this.
What else needs to happen for the code to compile? (Think of strong encapsulation!)

## Step 5
Try running the application with the same command you used before to run the single module.
Note that the module declaration is used at runtime to check all dependencies before starting the application.
If you remove `secondmodule` from the destination directory (that you defined with `-d` compiler flag), and try to run the app using the same command (but without recompiling first), you will get an explanation of why the app cannot be started from the module system.
