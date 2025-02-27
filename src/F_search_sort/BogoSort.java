package F_search_sort;

import java.util.Random;

public class BogoSort {
    // a bogus sorting algorithm
    public static void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static void shuffle(int[] arr) {
        Random randomGenerator = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = randomGenerator.nextInt(arr.length);
            swap(arr, i, randomIndex);
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
