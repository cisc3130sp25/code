package G_complexity;

import java.util.Arrays;

/**
 * Demonstrates two algorithms for testing element uniqueness.
 */
public class Uniqueness {
    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean allUniqueSlow(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;              // found duplicate pair
                }
            }
        }

        return true;                           // if we reach this, elements are unique
    }
    // running time of allUniqueSlow: O(n^2)

    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean allUniqueFaster(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length); // make a copy of arr
        Arrays.sort(copy);                           // and sort the copy
                                                     // (client would not appreciate their array being modified)

        for (int i = 0; i < copy.length - 1; i++) {
            if (copy[i] == copy[i + 1]) {           // check neighboring entries
                return false;                       // found duplicate pair
            }
        }

        return true;                                // if we reach this, elements are unique
    }
    // running time of allUniqueFaster: O(n log n)

    // In a few weeks, we will see how to do this in O(n) time.
}