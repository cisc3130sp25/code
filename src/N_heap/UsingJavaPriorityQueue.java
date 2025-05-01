package N_heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Java's priority queue is a MIN priority queue, built upon a min heap; the head is the min.
public class UsingJavaPriorityQueue {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>();
        pq.add("Oklahoma");
        pq.add("Texas");
        pq.add("New York");
        pq.add("California");
        pq.add("Georgia");
        System.out.println(pq); // note: not sorted! all we know is that head is always the min

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();

        Queue<Patient> patients = new PriorityQueue<>(Comparator.reverseOrder());
        patients.add(new Patient("Jim", 3));
        patients.add(new Patient("Jane", 2));
        patients.add(new Patient("Mark", 4));
        patients.add(new Patient("Nancy", 2));
        System.out.println(patients);

        while (!patients.isEmpty()) {
            System.out.println(patients.remove());
        }
    }
}