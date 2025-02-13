package D_jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableViewCollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));

        List<Integer> unmodifiableView = Collections.unmodifiableList(list);

        // unmodifiableView.add(4); // throws exception
        // unmodifiableView.set(1, 10); // throws exception

        list.add(4);
        list.set(1, 10);
        System.out.println(list); // [1, 10, 3, 4]

        System.out.println(unmodifiableView); // [1, 10, 3, 4]   <--- note!


        SecurityEventLog eventLog = new SecurityEventLog();
        eventLog.log("event 1...");
        eventLog.log("event 2...");
        eventLog.log("event 3...");

        List<String> events = eventLog.getEvents();
        events.remove(1);
        // we should not be able to remove items from a SecurityEventLog!
        // the getEvents() method can prevent this by returning an
        // unmodifiable view of the underlying list.
        System.out.println(eventLog.getEvents());
    }
}

class SecurityEventLog {
    private final List<String> events;
    // we need to ensure that once something gets added to this list,
    // it is impossible to remove it

    public SecurityEventLog() {
        events = new ArrayList<>();
    }

    public void log(String event) {
        events.add(event);
    }

    public List<String> getEvents() {
        // return events;
        // bad; client can remove elements from the list

        // one approach:
        // List<String> copy = new ArrayList<>();
        // for (String element : events) {
        //     copy.add(element);
        // }
        // return copy;

        // return new ArrayList<>(events); // equivalent to the above 5 lines
        // good, but can be costly to copy all the elements to the new list.

        // return List.copyOf(events);
        // also good, but same issue as before.

        return Collections.unmodifiableList(events);
        // this is the best approach: don't copy elements,
        // but return an unmodifiable wrapper that throws
        // an exception if the client tries to modify it.
    }
}