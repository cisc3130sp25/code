package K_hash_table.A_jcf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("filename? ");
        String filename = keyboardScanner.next();

        Scanner fileScanner = new Scanner(new File(filename));
        Map<String, Integer> map = new HashMap<>();

        while (fileScanner.hasNext()) {
            String word = fileScanner.next();

            map.put(word, map.getOrDefault(word, 0) + 1);
            // equivalent to:
            // if (map.containsKey(word)) {
            //     map.put(word, map.get(word) + 1);
            // } else {
            //     map.put(word, 1);
            // }
        }

        for (String word : map.keySet()) {
            System.out.println(word + ": " + map.get(word));
        }

        // or:
        // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
    }
}