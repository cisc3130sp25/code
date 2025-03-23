package J_stack_queue_deque.C_deque;

import java.util.Deque;
import java.util.LinkedList;

/*
Java Deque methods:

                        First Element (Head)	            Last Element (Tail)
                Throws exception	Special value	Throws exception	Special value
    Insert	    addFirst(e)	        offerFirst(e)	addLast(e)	        offerLast(e)
    Remove	    removeFirst()	    pollFirst()	    removeLast()	    pollLast()
    Examine	    getFirst()	        peekFirst()	    getLast()	        peekLast()

    Deque also contains methods for using a Deque as a stack:
    - push(e)	[equivalent to addFirst(e)]
    - pop()	    [equivalent to removeFirst()]
    - peek()	[equivalent to getFirst()]

    Deque also inherits all of Queue's methods, such as add(e), remove(), and peek().

    Deque contains many other methods, including size() and isEmpty().

Two primary implementations of Deque in the JCF: LinkedList and ArrayDeque.
For both of these implementations, all the methods listed above run in O(1) time.
 */

public class UsingJavaDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        // or:
        // Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        deque.addLast(3);
        deque.addFirst(7);
        System.out.println(deque.getFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        deque.addFirst(6);
        System.out.println(deque.getLast());
        deque.addFirst(8);
        System.out.println(deque.isEmpty());
        System.out.println(deque.getLast());
    }
}