package D_jcf;

import java.util.*;

/*
The enhanced for loop (aka the for-each loop)

The enhanced for loop, which you should already be familiar with,
can be used with two kinds of objects:
1. arrays
2. any type that implements the Iterable interface.

Example with an array:
Suppose arr is a String[]. Then the following enhanced for loop:
    for (String s : arr) {
        // do something with s
    }
gets translated into something like the following "under the hood":
    for (int i = 0; i < arr.length; i++) {
        String s = arr[i];
        // do something with s
    }

Example with a type that implements the Iterable interface:
Suppose coll is a variable of some type that implements the
Iterable<String> interface. For example, suppose coll is a
Collection<String>. Then the following enhanced for loop:
    for (String s : coll) {
        // do something with s
    }
gets translated into something like the following "under the hood":
    Iterator<String> it = coll.iterator();
    while (it.hasNext()) {
        String s = it.next();
        // do something with s
    }
This works because the Iterable interface guarantees the existence
of a method named iterator() that returns an Iterator. And the
Iterator interface guarantees that every iterator has methods
hasNext() and next().
 */

public class IteratorDemos {
    public static void main(String[] args) {
        Collection<String> collection1 = List.of("hello", "world", "good", "morning");
        printCollection(collection1);

        Collection<Integer> collection2 = Set.of(11, 22, 33, 44);
        printCollection(collection2);

        List<String> list1 = new LinkedList<>(List.of("hello", "world", "good", "morning"));
        printList(list1);
        printListBackwards(list1);

        List<Integer> list2 = new ArrayList<>(List.of(11, 22, 33, 44, 56));
        printList(list2);
        printListBackwards(list2);

        removeEvenElements(list2);
        System.out.println(list2);

        List<Integer> list = new ArrayList<>(List.of(5, 2, 4, 1, 7));
        momentum(list);
        System.out.println(list);
    }

    public static <E> void printCollection(Collection<E> collection) {
        // cannot use an old-fashioned for loop, since a Collection
        // doesn't know about indexes!
        // for (int i = 0; i < collection.size(); i++) {
        //     ???????
        // }

        // using an enhanced for loop
        for (E element : collection) {
            System.out.print(element + " ");
        }
        System.out.println();

        // using an iterator: one style - using a for loop
        for (Iterator<E> it = collection.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // using an iterator: another style - using a while loop
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void removeEvenElements(Collection<Integer> collection) {
        // for (Integer element : collection) {
        //     if (element % 2 == 0) {
        //         collection.remove(element);
        //     }
        // }
        // Does not work - we get a ConcurrentModificationException,
        // which occurs when we use a collection's method to modify the size of
        // the collection while we are iterating over that collection.
        // Even though we don't see the iterator here, it exists under the hood.


        for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext(); ) {
            int element = iterator.next();
            if (element % 2 == 0) {
                iterator.remove(); // calling Iterator's remove method, not Collection's, so no ConcurrentModificationException
            }
        }

        // near the end of the course, we will see that we can simply say:
        // collection.removeIf(element -> element % 2 == 0);
    }

    public static <E> void removeEveryOtherElement(SequencedCollection<E> collection) {
        Iterator<E> iterator = collection.iterator();

        while (iterator.hasNext()) {
            iterator.next();          // Retrieve an element.
            iterator.remove();        // Remove the most recently retrieved element.

            if (iterator.hasNext()) { // If there is at least one additional element,
                iterator.next();      // retrieve an element but don't remove it.
            }
        }
    }

    /* The rest of this file is optional. */

    /*
    - The List interface has two primary implementations: ArrayList and LinkedList.
      These two classes differ considerably in their internal details.
    - The running time of the get(int index) method is very fast for an ArrayList:
      the number of steps performed internally is a small constant -- it doesn't
      depend on the size of the list.
    - By contrast, the running time of the get(int index) method is slow for a LinkedList:
      the number of steps performed internally is based on the size of the list.
      (This will be discussed further in a few weeks hence.)
    - Thus we want to avoid calling the get method repeatedly in a loop when dealing
      with a LinkedList or with an unknown kind of List that might be a LinkedList.
    - An Iterator, or a ListIterator, allows for the efficient retrieval of successive
      elements of a List, whether an ArrayList or a LinkedList.
    */

    public static <E> void printList(List<E> list) {
        // this works, and runs efficiently for an ArrayList,
        // but slowly for a LinkedList.
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // using an enhanced for loop: efficient for both ArrayList and LinkedList
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();

        // using an Iterator: efficient for both ArrayList and LinkedList
        for (Iterator<E> it = list.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // using a ListIterator: efficient for both ArrayList and LinkedList
        for (ListIterator<E> iterator = list.listIterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Using an iterator with an ArrayList is technically a bit slower than
        // using a for loop with indexes. But when you have a List and don't know
        // what kind of list it is, it's best to use an iterator.
    }

    public static <E> void printListBackwards(List<E> list) {
        // this works, and runs efficiently for an ArrayList,
        // but slowly for a LinkedList.
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // we cannot use an enhanced for loop here, since it only goes forward

        // we cannot use a plain Iterator here, since it only goes forward

        // the following runs efficiently for both ArrayList and LinkedList.
        // We obtain a ListIterator that starts at the end of the list.
        // listIterator is a method of the List interface; the method returns a
        // ListIterator.
        ListIterator<E> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        // In Java 21+, we can use the reversed() method and an enhanced for loop:
        for (E element : list.reversed()) {
            System.out.print(element + " ");
        }
    }

    public static void momentum(List<Integer> list) {
        int sum = 0;

        // works, and runs efficiently for an ArrayList.
        // but runs slowly for a LinkedList.
        // for (int i = 0; i < list.size(); i++) {
        //     sum += list.get(i);
        //     list.set(i, sum);
        // }

        // cannot use a plain Iterator, since it doesn't provide a way to
        // set an element

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            sum += it.next();
            it.set(sum);
        }
        // efficient for both ArrayList and LinkedList
    }

    // insert toInsert before every occurrence of target in list
    public static <E> void insertBeforeEveryTarget(List<E> list,
                                                   E target,
                                                   E toInsert) {
        // works, but slow for both ArrayList and LinkedList
        // for (int i = 0; i < list.size(); i++) {
        //     if (list.get(i).equals(target)) {
        //         list.add(i, toInsert);
        //     }
        // }

        // an enhanced for loop isn't appropriate here, since we need
        // to know the index

        // a standard Iterator wouldn't work here, since it doesn't provide
        // a method for adding to the list.

        // using a ListIterator:
        // ListIterator<E> iterator = list.listIterator(); // start from beginning
        // while (iterator.hasNext()) {
        //     if (iterator.next().equals(target)) {
        //         iterator.previous(); // move backwards one step
        //         iterator.add(toInsert);
        //         iterator.next();
        //     }
        // }

        // another approach: start from the end of the list
        ListIterator<E> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (iterator.previous().equals(target)) {
                iterator.add(toInsert);
                iterator.previous();
            }
        }
        // efficient for LinkedList,but still slow for ArrayList (but that can't be helped)
    }
}