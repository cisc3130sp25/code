package F_search_sort;

/*
insertion sort: insert each element into a
sorted sub-array at the front of the array.

original:     {1, | 9, 4, 6, 5, -4}
after pass 1: {1, 9, | 4, 6, 5, -4}
after pass 2: {1, 4, 9, | 6, 5, -4}
after pass 3: {1, 4, 6, 9, | 5, -4}
after pass 4: {1, 4, 5, 6, 9, | -4}
after pass 5: {-4, 1, 4, 5, 6, 9 |}

(The elements to the left of the bar constitute the sorted subarray.)

In insertion sort, we always make n - 1 passes.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 6, 5, -4};
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }
}