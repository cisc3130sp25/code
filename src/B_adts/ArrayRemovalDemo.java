package B_adts;

import java.util.Arrays;

// This program demonstrates how to remove elements from a partially-filled array, while preserving the order of the elements.
// This is not directly related to the topic of ADTs, but is relevant to the last part of HW 2.
public class ArrayRemovalDemo {
    public static void main(String[] args) {
        String[] arr = new String[10];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";
        arr[3] = "d";
        int size = 4;

        size = remove(arr, 1, size);
        System.out.println(toString(arr, size));
        System.out.println(Arrays.toString(arr));
        // note that there's an extra "d" in the array, but we don't care,
        // since we only consider the elements until index size.
    }

    public static String toString(String[] arr, int size) {
        String result = "";

        for (int i = 0; i < size; i++) {
            result += arr[i] + " ";
        }

        return result;
    }

    public static int remove(String[] arr, int index, int size) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return size - 1;
    }
}