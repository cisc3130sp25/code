package J_stack_queue_deque.A_stack.A_our;

import I_linked_list.SinglyLinkedList;

/**
 * Implementation of the Stack ADT by adapting a singly-linked list.
 * O(1) time for all Stack operations.
 */
public class LinkedStack<E> implements Stack<E> {
    private final SinglyLinkedList<E> elements;

    public LinkedStack() {
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
    public void push(E element) {
        elements.addFirst(element);
    }
    // O(1)

    @Override
    public E peek() {
        return elements.getFirst();
    }
    // O(1)

    @Override
    public E pop() {
        return elements.removeFirst();
    }
    // O(1)

    /**
     * Produces a string representation of the stack (ordered from top to bottom)
     */
    @Override
    public String toString() {
        return "top " + elements.toString() + " bottom";
    }
    // O(n)
}
