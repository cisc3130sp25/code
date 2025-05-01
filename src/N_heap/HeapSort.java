package N_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// we didn't cover this in class

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {0, 65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    // O(n log n)
    public static void heapSort(int[] a) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int n : a) {
            pq.add(n);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = pq.remove();
        }
    }
}
