package I_linked_list;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMethods {
    public static void main(String[] args) {
        // one way to build a list
        ListNode<String> head1 = new ListNode<>("A", new ListNode<>("B", new ListNode<>("C")));

        // an empty list
        ListNode<String> head2 = null;

        // another way to build a list
        ListNode<Integer> head3 = new ListNode<>(1);
        head3.next = new ListNode<>(2);
        head3.next.next = new ListNode<>(3);
        head3.next.next.next = new ListNode<>(4);

        printIteratively(head1); // A B C
        printIteratively(head2); //
        printIteratively(head3); // 1 2 3 4

        printReversedRecursively(head1); // C B A

        ListNode<Integer> head4 = null;
        for (int i = 5; i <= 25; i += 5) {
            head4 = addLastIteratively(head4, i);
        }
    }

    // Given the head of a linked list, which may be empty,
    // this method prints the list's elements.
    // time: O(n)
    // space: O(1)
    public static <E> void printIteratively(ListNode<E> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    // time: O(n)
    // space: O(n)
    public static <E> void printRecursively(ListNode<E> head) {
        if (head != null) {
            System.out.print(head.data + " ");
            printRecursively(head.next);
        }
    }

    // Given the head of a linked list, which may be empty,
    // this method returns the number of elements in the list.
    // time: O(n)
    // space: O(1)
    public static <E> int getSizeIteratively(ListNode<E> head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    // time: O(n)
    // space: O(n)
    public static <E> int getSizeRecursively(ListNode<E> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + getSizeRecursively(head.next);
        }
    }

    // Given the head of a linked list, which may be empty,
    // this method prints the list's elements in reverse order.
    // time: O(n)
    // space: O(n)
    public static <E> void printReversedIteratively(ListNode<E> head) {
        List<E> aux = new ArrayList<>();

        while (head != null) {
            aux.add(head.data);
            head = head.next;
        }

        for (int i = aux.size() - 1; i >= 0; i--) {
            System.out.print(aux.get(i) + " ");
        }
    }

    // time: O(n)
    // space: O(n)
    public static <E> void printReversedRecursively(ListNode<E> head) {
        if (head != null) {
            printReversedRecursively(head.next);
            System.out.print(head.data + " ");
        }
    }

    // Given the head of a linked list, which may be empty, and an element,
    // this method adds the element at the front of the list,
    // and returns the head of the updated list.
    // time: O(1)
    // space: O(1)
    public static <E> ListNode<E> addFirst(ListNode<E> head, E element) {
        return new ListNode<>(element, head);
    }

    // Given the head of a linked list, which may be empty, and an element,
    // this method adds the element at the end of the list,
    // and returns the head of the updated list.
    // time: O(n)
    // space: O(1)
    public static <E> ListNode<E> addLastIteratively(ListNode<E> head, E element) {
        if (head == null) {
            return new ListNode<>(element);
        }

        ListNode<E> curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new ListNode<>(element);
        return head;
    }

    // time: O(n)
    // space: O(n)
    public static <E> ListNode<E> addLastRecursively(ListNode<E> head, E element) {
        if (head == null) {
            return new ListNode<>(element);
        } else {
            head.next = addLastRecursively(head.next, element);
            return head;
        }
    }
}