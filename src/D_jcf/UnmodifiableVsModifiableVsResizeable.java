package D_jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class UnmodifiableVsModifiableVsResizeable {
    public static void main(String[] args) {
        List<Integer> unmodifiable = List.of(1, 2, 3);
        unmodifiable.add(4); // exception
        unmodifiable.set(1, 10); // exception
 
        List<Integer> modifiable = Arrays.asList(1, 2, 3);
        modifiable.set(1, 10); // works
        modifiable.add(4); // exception, since not resizeable
 
        List<Integer> resizeable = new ArrayList<>(List.of(1, 2, 3));
        resizeable.set(1, 10); // works
        resizeable.add(4); // works
    }
}