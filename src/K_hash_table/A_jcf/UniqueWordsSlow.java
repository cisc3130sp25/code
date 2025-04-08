package K_hash_table.A_jcf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Running time is O(n^2), where n is the number of words in the file.
public class UniqueWordsSlow {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("filename? ");
        String filename = keyboardScanner.next();

        Scanner fileScanner = new Scanner(new File(filename));
        List<String> uniqueWords = new ArrayList<>();

        while (fileScanner.hasNext()) {
            String word = fileScanner.next();

            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }

        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
