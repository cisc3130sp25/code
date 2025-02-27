package F_search_sort;

import java.util.Arrays;

/*
Merge sort: Repeatedly divides the array in half, sorts each half,
and combines the sorted halves into a sorted whole. We will
implement it recursively.

The algorithm:
- Divide the list into two roughly equal halves.
    Exactly equal halves if the length is even.
    If length is odd, then left side will be one element shorter than right side.
- Sort the left half.
- Sort the right half.
- Merge the two sorted halves into one sorted list.

An example of a "divide and conquer" algorithm.

original array: {32,  14,  27,  76,  23,  41,  85,  58}
first split:    {32,  14,  27,  76} {23,  41,  85,  58}
second split:   {32,  14} {27,  76} {23,  41} {85,  58}
third split:    {32} {14} {27} {76} {23} {41} {85} {58}
first merge:    {14,  32} {27,  76} {23,  41} {58,  85}
second merge:   {14,  27,  32,  76} {23,  41,  58,  85}
third merge:    {14,  23,  27,  32,  41,  58,  76,  85}
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] list = {32, 14, 27, 76, 23, 41, 85, 58};
        mergeSort(list);
    }

    public static void mergeSort(int[] a) {
        // System.out.println("sorting " + Arrays.toString(a));

        // implicit base case:
        // if a.length <= 1, do nothing (already sorted)

        if (a.length > 1) { // if we are not in the base case
            // split array into roughly two halves
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a
            merge(left, right, a);
        }
    }

    // merge sorted arrays arr1 and arr2 together,
    // putting the elements in the result array in sorted order
    private static void merge(int[] arr1, int[] arr2, int[] result) {
        // System.out.println("merging " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2));

        int index1 = 0;      // current index in arr1
        int index2 = 0;      // current index in arr2
        int resultIndex = 0; // current index in result

        // loop until we reach the end of arr1 or arr2
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[resultIndex++] = arr1[index1++];
            } else {
                result[resultIndex++] = arr2[index2++];
            }
        }

        // at this point, we've reach the end of either arr1 or arr2
        // but we don't know which array has remaining elements

        // get any remaining elements from arr1
        while (index1 < arr1.length) {
            result[resultIndex++] = arr1[index1++];
        }

        // get any remaining elements from arr2
        while (index2 < arr2.length) {
            result[resultIndex++] = arr2[index2++];
        }
    }
}