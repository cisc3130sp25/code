package N_heap;

public class MaxPriorityQueueDemo {
    public static void main(String[] args) {
        Patient patient1 = new Patient("John", 2);
        Patient patient2 = new Patient("Cindy", 7);
        Patient patient3 = new Patient("Tim", 5);
        Patient patient4 = new Patient("Jim", 1);

        MaxPriorityQueue<Patient> priorityQueue = new MaxPriorityQueue<>();
        priorityQueue.add(patient1);
        priorityQueue.add(patient2);
        priorityQueue.add(patient3);
        priorityQueue.add(patient4);

        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove() + " ");
        }
    }
}