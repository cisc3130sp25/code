package D_jcf;
 
import java.util.*;
 
public class CollectionDemos {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        printElements(list);
 
        Deque<String> deque = new ArrayDeque<>(List.of("a", "b"));
        printElements(deque);
 
        System.out.println(list.containsAll(deque)); // true
        System.out.println(deque.containsAll(list)); // false
 
        deque.addAll(list);
        System.out.println(deque.size()); // 5
 
        Queue<String> queue = new PriorityQueue<>(List.of("a", "b", "c"));
 
        printFirstAndLast(list);
        printFirstAndLast(deque);
        // printFirstAndLast(queue); // doesn't compile, since Queue isn't a SequencedCollection
    }
 
    public static <E> void printElements(Collection<E> collection) {
        for (E element : collection) {
            System.out.println(element);
        }
    }
 
    public static <E> void printFirstAndLast(SequencedCollection<E> collection) {
        System.out.println(collection.getFirst());
        System.out.println(collection.getLast());
    }
}