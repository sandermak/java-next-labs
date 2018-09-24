package whatsnew.langandlib.optional;

import whatsnew.langandlib.Book;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class OptionalOr {
    public static void main(String... args) {
        Optional<Book> localFallback = Optional.of(Book.getBook());

        // Before Optional.or
        Book bestBookBefore = getBestOffer()
                .orElse(
                    getExternalOffer().orElse(localFallback.get()) // .get() is BAD! But we can't return optional here.
                );


        // With Optional.or
        Optional<Book> bestBook = null;

        System.out.println(bestBook);
    }

    static Optional<Book> getBestOffer() {
        return Optional.empty();
    }

    static Optional<Book> getExternalOffer() {
        return Optional.of(new Book("External Book", Set.of(), 11.99));
    }
}
