package J_stack_queue_deque.A_stack.B_jcf;
 
import java.util.Deque;
import java.util.LinkedList;
 
class A {
    void m1() {}
}
 
class B extends A {
    @Override void m1() {}
    void m2() {}
}
 
class Demo {
    public static void main(String[] args) {
        A a = new B();
        a.m1(); // calls B's m1
        // a.m2(); // doesn't compile
    }
}
 
public class GoodStackDemo {
    public static void main(String[] args) {
        // one way to create a stack
        // Deque<String> stack = new ArrayDeque<>();
 
        // another way:
        Deque<String> stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.size()); // 3
        System.out.println(stack); // [c, b, a]
        // prints top to bottom
 
        // this line will correctly not compile, even though LinkedList has a get(index) method:
        // System.out.println(stack.get(1));
 
        System.out.println(stack.peek());
        System.out.println(stack.peek());
 
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}