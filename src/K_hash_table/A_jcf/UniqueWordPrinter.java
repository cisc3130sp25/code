package K_hash_table.A_jcf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.SequencedSet;

// prints the unique words from the file,
// ordered by the order in which they were first seen in the file
public class UniqueWordPrinter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("filename? ");
        String filename = keyboardScanner.next();

        Scanner scanner = new Scanner(new File(filename));
        SequencedSet<String> words = new LinkedHashSet<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}