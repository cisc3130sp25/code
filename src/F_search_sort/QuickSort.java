package F_search_sort;

/*
Idea: pick an element to be the "pivot" and rearrange the other
elements around the pivot: all elements smaller than pivot go to the
left of the pivot, and all elements greater than or equal to the pivot
go to the right of the pivot. Keep doing this recursively for each of the
two subarrays around the pivot. Don't do anything to a subarray of length
0 or 1, since it's already sorted.
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 0, 5, 6, 1, -2, 3, 14, 12};
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        // implicit base case: highIndex <= lowIndex (subarray is of length 0 or 1)

        if (highIndex > lowIndex) {
            int pivotIndex = partition(arr, lowIndex, highIndex);
            quickSort(arr, lowIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, highIndex);
        }
    }

    // Chooses a pivot element and partitions arr (from lowIndex through highIndex)
    // around the pivot: all elements less than the pivot will be placed to the left
    // of the pivot, and all elements greater than (or equal to) the pivot will be
    // placed to the right of the pivot.
    // There are many ways to accomplish this; here we are using a relatively easy
    // approach, though not the most efficient one.
    // The method returns the index of the pivot element.
    public static int partition(int[] arr, int lowIndex, int highIndex) {
        // choose the pivot element (we're choosing the first element here, but
        // other approaches choose the last, the middle, or even a random element)
        int pivot = arr[lowIndex];

        // count how many elements are less than the pivot
        int count = 0;
        for (int i = lowIndex + 1; i <= highIndex; i++) {
            if (arr[i] < pivot) {
                count++;
            }
        }

        // move pivot to its proper place
        int pivotIndex = lowIndex + count;
        swap(arr, pivotIndex, lowIndex);

        // now rearrange elements around the pivot using a two-pointer approach
        int leftPointer = lowIndex, rightPointer = highIndex;
        while (leftPointer < pivotIndex && rightPointer > pivotIndex) {
            if (arr[leftPointer] < pivot) {          // arr[leftPointer] can remain where it is
                leftPointer++;
            } else if (arr[rightPointer] >= pivot) { // arr[rightPointer] can remain where it is
                rightPointer--;
            } else {
                swap(arr, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

        return pivotIndex;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}