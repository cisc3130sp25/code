package B_adts;

import java.util.Arrays;

// This program demonstrates how to add and remove elements from a partially-filled array.
// This is unrelated to the topic of ADTs, but is relevant to the last part of HW 2.
public class ArrayRemovalDemo {
    public static void main(String[] args) {
        String[] arr = new String[4];
        int size = 0;

        size = add(arr, "a", size);
        size = add(arr, "b", size);
        size = add(arr, "c", size);
        size = add(arr, "d", size);
        System.out.println(toString(arr, size));

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

    public static int add(String[] arr, String s, int size) {
        if (arr.length == size) {
            return size; // cannot add
        } else {
            arr[size] = s;
            return size + 1;
        }
    }

    public static int remove(String[] arr, int index, int size) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return size - 1;
    }
}