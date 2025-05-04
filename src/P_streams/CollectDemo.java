package P_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectDemo {
    public static void main(String[] args) {
        String[] arr = {"aa", "b", "ccc", "aaa", "baa", "aa"};

        // classify the elements by their first character
        Map<Character, List<String>> map1 = Arrays.stream(arr)
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map1);

        Set<String> set = Arrays.stream(arr)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(set);

        String s1 = Arrays.stream(arr)
                .map(String::toUpperCase)
                .collect(Collectors.joining());
        System.out.println(s1);

        String s2 = Arrays.stream(arr)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println(s2);
    }
}