package whatsnew.langandlib.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindGitConflict {

    public static void main(String... args) throws Exception {
       Stream<String> diffLines = Files.lines(Paths.get("resources/index.html"));

       // Use Stream::dropWhile/takeWhile to extract the conflict and print it (excluding begin/end markers of the conflict)
       diffLines
             .dropWhile(l -> !l.contains("<<<<<<<"))
             .skip(1)
             .takeWhile(l -> !l.contains(">>>>>>>"))
             .forEach(System.out::println);

    }



}
