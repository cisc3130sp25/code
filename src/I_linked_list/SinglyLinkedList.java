package I_linked_list;

/*
Three cases to consider in most of the below methods:
1. Immediately prior to the method being called, the list is empty.
   size == 0, head == null, tail == null
2. Immediately prior to the method being called, the list contains exactly one element.
   size == 1, head == tail and head != null and tail != null
3. Immediately prior to the method being called, the list contains more than one element.
   size > 1, head != tail and neither are null
   We may have to consider whether we are operating in the middle of the list,
   at the head, or at the tail.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head, tail;
    private int size;

    // O(1)
    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // O(1)
    public void addFirst(E element) {
        head = new Node<>(element, head);
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    // O(1)
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty list");
        }

        return head.data;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public void addLast(E element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            tail = tail.next = new Node<>(element);
            size++;
        }
    }

    // O(1)
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty list");
        }

        return tail.data;
    }

    // O(1)
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return result;
    }

    // O(n) since this is a singly-linked list; would be O(1) if it were a doubly-linked list
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = tail.data;

        Node<E> current = head;

        for (int i = 0; i < size - 2; i++) {
            current = current.next;
        }

        tail = current;
        tail.next = null;
        size--;

        if (size == 0) {
            head = tail = null;
        }

        return result;
    }

    // O(n)
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // O(n)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;

        while (current != null) {
            sb.append(current.data);

            if (current != tail) {
                sb.append(", ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // O(n)
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = new Node<>(element, current.next);
            size++;
        }
    }

    // O(n)
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            E result = current.next.data;
            current.next = current.next.next;
            size--;
            return result;
        }
    }

    // O(1)
    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    private class SinglyLinkedListIterator implements Iterator<E> {
        private Node<E> current;

        public SinglyLinkedListIterator() {
            current = head;
        }

        // O(1)
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // O(1)
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E result = current.data;
            current = current.next;
            return result;
        }
    }
}