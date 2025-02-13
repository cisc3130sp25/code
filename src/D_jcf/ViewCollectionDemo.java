package D_jcf;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ViewCollectionDemo {
    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> reverse = original.reversed();
 
        System.out.println(original); // [1, 2, 3]
        System.out.println(reverse);  // [3, 2, 1]
 
        original.add(4);
        System.out.println(original); // [1, 2, 3, 4]
        System.out.println(reverse);  // [4, 3, 2, 1]
 
        reverse.add(5);
        System.out.println(reverse);  // [4, 3, 2, 1, 5]
        System.out.println(original); // [5, 1, 2, 3, 4]
 
        System.out.println(original.get(1)); // 1
        System.out.println(reverse.get(1));  // 3
 
 
        List<Integer> sub = original.subList(1, 3);
        System.out.println(sub.size()); // 2
        sub.clear();
        System.out.println(original); // [5, 3, 4]
 
 
        String[] stringArray = {"a", "b", "c"};
        List<String> stringList = Arrays.asList(stringArray);
        stringList.set(0, "z");
        System.out.println(Arrays.toString(stringArray)); // [z, b, c]
        stringArray[1] = "g";
        System.out.println(stringList); // [z, g, c]
    }
}
 