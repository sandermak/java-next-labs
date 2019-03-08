package whatsnew.langandlib.stream;

import whatsnew.langandlib.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class NewCollectors {
    public static void main(String... args) {
        Stream<Book> books = Book.getBooks();

        // Group books by author(s), with for each entry in the resulting Map a collection of the authors' books costing more than 10
        // Hint: take a look at Collectors::groupingBy and Collectors::filtering
        Map<Set<String>, Set<Book>> booksByAuthors =
          books.collect(

              null // replace with appropriate collector

          );

        // Expected output: {[Richard Warburton]=[Book{title='Java 8 Lambdas', price=33.99}], [Anonymous]=[], [Paul Bakker, Sander Mak]=[Book{title='Java 9 Modularity', price=33.99}], [Martin Klepmann]=[Book{title='Designing Data-Intensive Applications', price=38.99}]}
        System.out.println(booksByAuthors);

        books = Book.getBooks();
        // Collect all authors that sell books at a given price
        // Hint: take a look at Collectors::groupingBy and Collectors::flatMapping
        Map<Double, Set<String>> authorsSellingForPrice =
          books.collect(

              null // replace with appropriate collector

          );

        // Expected output: {9.99=[Anonymous], 33.99=[Richard Warburton, Paul Bakker, Sander Mak], 38.99=[Martin Klepmann]}
        System.out.println(authorsSellingForPrice);
    }
}
