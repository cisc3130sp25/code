package F_search_sort;

import java.util.Comparator;

public class GenericSelectionSort {
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

    // for example, if E = Integer, we can use a Comparator<Integer>,
    // or a Comparator<Number>, or a Comparator<Object>
    public static <E> void selectionSort(E[] a, Comparator<? super E> comp) {
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