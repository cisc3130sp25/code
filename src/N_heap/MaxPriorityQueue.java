package N_heap;

import java.util.Comparator;

public class MaxPriorityQueue<E> {
    private MaxHeap<E> heap;

    public MaxPriorityQueue() {
        heap = new MaxHeap<>(); // uses natural order
    }

    public MaxPriorityQueue(Comparator<E> comparator) {
        heap = new MaxHeap<>(comparator);
    }

    // O(log n)
    public void add(E element) {
        heap.add(element);
    }

    // removes and returns the max element
    // O(log n)
    public E remove() {
        return heap.remove();
    }

    // returns the max element
    // O(1)
    public E peek() {
        return heap.peek();
    }

    // O(1)
    public int size() {
        return heap.size();
    }

    // O(1)
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public String toString() {
        return heap.toString();
    }
}