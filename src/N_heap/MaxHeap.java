package N_heap;

import java.util.*;

public class MaxHeap<E> {
    private class NaturalOrderComparator implements Comparator<E> {
        @Override
        public int compare(E e1, E e2) {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }

    private final List<E> elements = new ArrayList<>();
    private final Comparator<E> comparator;

    // for when the user wants to use natural order
    public MaxHeap() {
        this.comparator = new NaturalOrderComparator();
    }

    public MaxHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // O(log n)
    public void add(E element) {
        elements.add(element); // Add to the end of the heap
        int currentIndex = elements.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            // Swap if the current node is greater than its parent
            if (comparator.compare(elements.get(currentIndex), elements.get(parentIndex)) > 0) {
                Collections.swap(elements, currentIndex, parentIndex); // O(1)
            } else {
                break; // the tree is a heap now
            }

            currentIndex = parentIndex;
        }
    }

    // O(log n)
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Collections.swap(elements, 0, elements.size() - 1); // swap first and last elements
        E removedElement = elements.removeLast(); // O(1)

        int currentIndex = 0;
        while (currentIndex < elements.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= elements.size()) {
                break; // Can't go any further
            }

            // Find the maximum between two children
            int maxIndex = leftChildIndex; // guess that the left child is max
            if (rightChildIndex < elements.size()) { // if there is a right child
                if (comparator.compare(elements.get(maxIndex), elements.get(rightChildIndex)) < 0) {
                    // if the left child is less than the right, then right is max
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than its max child
            if (comparator.compare(elements.get(currentIndex), elements.get(maxIndex)) < 0) {
                Collections.swap(elements, currentIndex, maxIndex);
                currentIndex = maxIndex;
            } else {
                break; // The tree is a heap
            }
        }

        return removedElement;
    }

    // O(1)
    public E peek() {
        return elements.getFirst();
    }

    // O(1)
    public int size() {
        return elements.size();
    }

    // O(1)
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
