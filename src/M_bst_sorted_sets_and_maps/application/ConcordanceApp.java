package M_bst_sorted_sets_and_maps.application;

import java.io.FileNotFoundException;
import java.util.Comparator;

public class ConcordanceApp {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.err.println("usage: ConcordanceApp <filename>");
            System.exit(1);
        }

        System.out.println("=== Natural order:");
        System.out.println(new Concordance(args[0]));

        System.out.println("=== Case-insensitive order:");
        System.out.println(new Concordance(args[0], String.CASE_INSENSITIVE_ORDER.thenComparing(Comparator.naturalOrder())));
    }
}
