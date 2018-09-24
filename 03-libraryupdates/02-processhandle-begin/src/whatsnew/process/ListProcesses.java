package whatsnew.process;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

public class ListProcesses {
    public static void main(String... args) {
        // List all processes, order them by start time and print them using printInfo

    }

    private static void printInfo(ProcessHandle.Info info) {
        if(info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get() +
                               ", Command: " + info.command().get());
        }

    }
}
