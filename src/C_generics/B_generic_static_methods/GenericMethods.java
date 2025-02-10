package C_generics.B_generic_static_methods;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println(middle(arr));

        Integer[] integers = {1, 2, 3, 4};
        System.out.println(middle(integers));

        int[] ints = {1, 2, 3};
        // System.out.println(middle(ints)); // doesn't compile

        List<String> stringList = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        System.out.println("original String list: " + stringList);

        swap(stringList, 0, 2);
        System.out.println("list after swapping the elements at indexes 0 and 2: "
                           + stringList);

        List<String> strings = List.of("bus", "train", "car", "boat");
        System.out.println(max(strings)); // train
    }

    /**
     * Returns the element at the midpoint of arr (if arr.length is odd)
     * or the element right after the midpoint (if arr.length is even).
     */
    // we can pass to this method a String[] or an Integer[], for example
    // but not an int[] or double[]
    public static <E> E middle(E[] arr) {
        return arr[arr.length / 2];
    }

    /**
     * Swaps the element at index1 with the element at index2.
     */
    // we can pass an ArrayList<String> to this method, for example
    public static <E> void swap(List<E> list,
                                int index1, int index2) {
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <E extends Comparable<E>> E max(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        E maxSoFar = list.get(0);

        for (E e : list) {
            if (e.compareTo(maxSoFar) > 0) {
                maxSoFar = e;
            }
        }

        return maxSoFar;
    }
}