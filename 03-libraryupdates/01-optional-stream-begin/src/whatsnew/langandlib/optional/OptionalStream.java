package whatsnew.langandlib.optional;

import whatsnew.langandlib.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalStream {

    public static void main(String[] args) {

        // Find all first authors of the books combining Stream::flatMap and Optional::stream
        Stream<Book> books = Book.getBooks();

        Set<String> firstAuthors = null;

        // Expected output (order in firstAuthors Set is not important): [Richard Warburton, Paul Bakker, Anonymous, Martin Klepmann]
        System.out.println(firstAuthors);
    }
}
