package J_stack_queue_deque.A_stack.A_our;

public class OurStackDemo {
    public static void main(String[] args) {
                                                    // contents     output
        Stack<Integer> stack = new ArrayStack<>();  // []
        stack.push(5);                              // [5]
        stack.push(3);                              // [5, 3]
        System.out.println(stack);                  // [5, 3]       top [3, 5] bottom
        System.out.println(stack.size());           // [5, 3]       2
        System.out.println(stack.pop());            // [5]          3
        System.out.println(stack.isEmpty());        // [5]          false
        System.out.println(stack.pop());            // []           5
        System.out.println(stack.isEmpty());        // []           true
        stack.push(7);                              // [7]
        stack.push(3);                              // [7, 3]
        System.out.println(stack.peek());           // [7, 3]       3
        stack.push(4);                              // [7, 3, 4]
        System.out.println(stack.size());           // [7, 3, 4]    3
        System.out.println(stack.pop());            // [7, 3]       4
        stack.push(6);                              // [7, 3, 6]
        stack.push(8);                              // [7, 3, 6, 8]
        System.out.println(stack.pop());            // [7, 3, 6]    8
        System.out.println(stack);                  // [7, 3, 6]    top [6, 3, 7] bottom
    }
}