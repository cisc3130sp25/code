package J_stack_queue_deque.B_queue.A_our;

import I_linked_list.SinglyLinkedList;

/**
 * Implementation of the queue ADT using a singly-linked list.
 * All Queue operations run in O(1) time.
 */
public class LinkedQueue<E> implements Queue<E> {
    private final SinglyLinkedList<E> elements;

    public LinkedQueue() {
        elements = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }
    // O(1)

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    // O(1)

    @Override
    public void enqueue(E e) {
        elements.addLast(e);
    }
    // O(1)

    @Override
    public E peek() {
        return elements.getFirst();
    }
    // O(1)

    @Override
    public E dequeue() {
        return elements.removeFirst();
    }
    // O(1)

    @Override
    public String toString() {
        return elements.toString();
    }
}
