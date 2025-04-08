package K_hash_table.A_jcf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Running time is O(n), where n is the number of words in the file.
public class UniqueWords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("filename? ");
        String filename = keyboardScanner.next();

        Scanner fileScanner = new Scanner(new File(filename));
        Set<String> uniqueWords = new HashSet<>();

        while (fileScanner.hasNext()) {
            String word = fileScanner.next();
            uniqueWords.add(word);
        }

        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}