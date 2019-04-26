package whatsnew.langandlib;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Book {

    public final String title;
    public final SortedSet<String> authors;
    public final double price;

    public Book(String title, SortedSet<String> authors, double price) {
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
        return Stream.of(new Book("Java 9 Modularity", new TreeSet<>(Set.of("Sander Mak", "Paul Bakker")), 33.99),
                         new Book("Designing Data-Intensive Applications", new TreeSet<>(Set.of("Martin Klepmann")), 38.99),
                         new Book("Java 8 Lambdas", new TreeSet<>(Set.of("Richard Warburton")), 33.99),
                         new Book("Too cheap", new TreeSet<>(Set.of("Anonymous")), 9.99));
    }

    public static Book getBook() {
        return getBooks().findFirst().get();
    }
}
