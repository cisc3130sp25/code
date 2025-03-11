package G_complexity;

// comparing running times of selection sort and merge sort

import F_search_sort.MergeSort;
import F_search_sort.SelectionSort;

import java.util.Random;

public class SortingExperiment {
    public static void main(String[] args) {
        final int START = 1_000, STOP = 2_000_000;

        System.out.println("using merge sort:");
        for (int n = START; n <= STOP; n *= 2) {
            int[] arr = getRandomArray(n);
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort(arr);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            System.out.printf("n: %,12d took %,12d milliseconds%n", n, elapsed);
        }

        System.out.println("using selection sort:");
        for (int n = START; n <= STOP; n *= 2) {
            int[] arr = getRandomArray(n);
            long startTime = System.currentTimeMillis();
            SelectionSort.selectionSort(arr);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            System.out.printf("n: %,12d took %,12d milliseconds%n", n, elapsed);
        }
    }

    public static int[] getRandomArray(int length) {
        Random randomGenerator = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomGenerator.nextInt();
        }

        return arr;
    }
}
