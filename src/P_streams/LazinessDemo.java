package P_streams;

import java.util.stream.Stream;

public class LazinessDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");

        stream = stream.filter(s -> {
            System.out.println("filtering " + s);
            return s.length() == 5;
        });

        // nothing gets printed yet

        System.out.println("About to invoke the terminal operation");

        stream.findAny().ifPresent(System.out::println);
        // filtering one
        // filtering two
        // filtering three
        // three

        // note that four was never filtered, because it didn't need to be
    }
}
