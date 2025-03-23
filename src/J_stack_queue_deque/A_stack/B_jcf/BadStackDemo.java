package J_stack_queue_deque.A_stack.B_jcf;
 
import java.util.Stack;
 
public class BadStackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack); // [a, b, c]
        // prints bottom to top
 
        // the fact that this is allowed is bad
        System.out.println(stack.get(1));
 
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}