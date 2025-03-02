package F_search_sort;

import java.util.Arrays;
import java.util.Comparator;

public class GenericSelectionSort {
    public static void main(String[] args) {
        String[] a = {"cc", "aaa", "z"};

        selectionSort(a);
        System.out.println(Arrays.toString(a)); // [aaa, cc, z]

        Comparator<String> byLength = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        selectionSort(a, byLength);
        System.out.println(Arrays.toString(a)); // [z, cc, aaa]
    }

    public static <E extends Comparable<E>> void selectionSort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }

            swap(a, i, indexOfMin);
        }
    }

    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static <E> void selectionSort(E[] a, Comparator<E> comp) {
        for (int i = 0; i < a.length - 1; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (comp.compare(a[j], a[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }

            swap(a, i, indexOfMin);
        }
    }
}