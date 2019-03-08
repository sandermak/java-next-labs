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
                  groupingBy(Book::getAuthors,
                             filtering(b -> b.getPrice() > 10,
                                       toSet())
                  )
          );
        System.out.println(booksByAuthors);

        books = Book.getBooks();
        // Collect all authors that sell books at a given price
        // Hint: take a look at Collectors::groupingBy and Collectors::flatMapping
        Map<Double, Set<String>> authorsSellingForPrice =
          books.collect(
                  groupingBy(Book::getPrice,
                             flatMapping(b -> b.getAuthors().stream(),
                                         toSet())
                  )
          );
        System.out.println(authorsSellingForPrice);
    }
}
