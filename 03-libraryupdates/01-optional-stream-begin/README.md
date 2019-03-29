# Library additions on Optional/Stream

## 01. Optional::ifPresentOrElse

Open `src/whatsnew/langandlib/optional/OptionalIfPresentOrElse.java` and look at the code.
Use `Optional::ifPresentOrElse` (introduced in Java 9) to achieve the same effect as in the preceding `if-else` statement.

## 02. Optional::or

Open `src/whatsnew/langandlib/optional/OptionalOr.java` and look at the code.
Use `Optional::or` (introduced in Java 9) to implement the cascading alternatives that are implemented in the existing code, but now in a nicer way.
Notice you'll end up with an `Optional<Book>` in `bestBook`, whereas the original solution (`bestBookBefore`) will blow up with an exception should the `localFallback` also be empty!

## 03. Optional::stream and Stream::flatMap

Open `src/whatsnew/langandlib/optional/OptionalStream.java` and look at the code.
The introduction of `Optional::stream` in Java 9 allows us to turn optionals in to empty or single-valued streams.
Combining this with `Stream::flatMap`, which takes multiple streams and flattens them into a single `Stream`, allows us to extract the values of full and empty optionals into a single `Stream`.

This exercise can be implemented using `Optional::stream` combined with `Stream::flatMap` and some other `Stream` methods.
The goal is to turn the stream of `Book`s into a set of author names.
For every book, find the first author (use `Stream::findFirst`), and collect all these first authors into a single `Set`.


## 04. Stream::takeWhile/dropWhile

Open `src/whatsnew/langandlib/stream/FindGitConflict.java` and look at the code.
In `resources/index.html` you'll find a file that contains a Git conflict, where the start and the end of the conflict are clearly delineated.
Use `Stream::takeWhile` and `dropWhile` to extract the code within the conflict and print it to the console.
You should omit the begin/end markers of the conflict (it's okay to print the middle separator).

Will this approach work with multiple conflicts in the same file? Why (not)? Try it!

## 05. New Collectors for streams

Open `src/whatsnew/langandlib/stream/NewCollectors.java` and look at the code.
There are two problems described, try to solve them by adding the appropriate `Collector` at the location indicated.
Use the hints, and look at the pre-defined collectors in the `Collectors` class that have been added since Java 9.
