package D_jcf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// an example of a class with a custom iterator
public class ArraySet<E> implements MySet<E> {
    private final E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (isFull() || contains(e)) {
            return false;
        } else {
            elements[size] = e;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index < 0) {
            return false;
        } else {
            elements[index] = elements[size - 1];
            size--;
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArraySetIterator();
    }

    // A non-static inner class.
    // It can access all fields and methods of the outer class.
    private class ArraySetIterator implements Iterator<E> {
        private int index;

        public ArraySetIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E element = elements[index];
            index++;
            return element;
            // the above three lines can be combined to: return elements[index++];
        }
    }
}

