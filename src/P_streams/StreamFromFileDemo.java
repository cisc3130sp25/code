package P_streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;

public class StreamFromFileDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("input.txt");

        System.out.println("all lines:");
        Files.lines(path).forEach(System.out::println);
        System.out.println();

        System.out.print("longest line containing \"the\": ");
        Files.lines(path)
                .filter(line -> line.contains("the"))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        System.out.print("longest token: ");
        Scanner scanner = new Scanner(new File("input.txt"));
//        String longestSoFar = "";
//        while (scanner.hasNext()) {
//            String current = scanner.next();
//            if (current.length() > longestSoFar.length()) {
//                longestSoFar = current;
//            }
//        }
//        System.out.println(longestSoFar);
        scanner.tokens()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }
}