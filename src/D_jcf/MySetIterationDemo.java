package D_jcf;

import java.util.Iterator;

public class MySetIterationDemo {
    public static void main(String[] args) {
        MySet<String> set = new ArrayMySet<>(10);
        set.add("a");
        set.add("b");
        set.add("c");

        for (String s : set) {
            System.out.println(s);
        }

        Iterator<String> iter = set.iterator();
        System.out.println(iter.next()); // a
        System.out.println(iter.next()); // b
        System.out.println(iter.hasNext()); // true
        System.out.println(iter.next()); // c
        System.out.println(iter.hasNext()); // false
        System.out.println(iter.next()); // throws exception
    }
}
