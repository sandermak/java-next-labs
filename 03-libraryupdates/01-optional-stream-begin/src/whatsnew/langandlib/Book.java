package whatsnew.langandlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Book {

    public final String title;
    public final Set<String> authors;
    public final double price;

    public Book(String title, Set<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public static Stream<Book> getBooks() {
        return Stream.of(new Book("Java 9 Modularity", Set.of("Sander Mak", "Paul Bakker"), 33.99),
                         new Book("Designing Data-Intensive Applications", Set.of("Martin Klepmann"), 38.99),
                         new Book("Java 8 Lambdas", Set.of("Richard Warburton"), 33.99),
                         new Book("Too cheap", Set.of("Richard Warburton"), 9.99));
    }

    public static Book getBook() {
        return getBooks().findFirst().get();
    }
}
