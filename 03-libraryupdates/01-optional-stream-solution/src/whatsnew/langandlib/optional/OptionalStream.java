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

        Set<String> firstAuthors = books
                .map(book -> book.authors.stream().findFirst())
                .flatMap(optAuthor -> optAuthor.stream())
                .collect(Collectors.toSet());

        System.out.println(firstAuthors);
    }
}
