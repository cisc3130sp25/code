package O_lambdas;

/*
Functional interface: an interface with exactly one method that
needs to be overridden by implementors.

Static and default methods don't have to be overridden by implementors.
Additionally, methods found in the Object class (such as toString and equals)
also don't need to be overridden by implementors.

The single abstract method that must be overridden is known as the
functional method of the functional interface.

A functional interface can be implemented by a class, as usual. But it can
also be implemented by a lambda expression or a method reference, as will
be demonstrated in the LambdaDemo file.

The @FunctionalInterface annotation is optional. It makes the compiler check
whether this interface is truly a functional interface.
 */

@FunctionalInterface
public interface IntBinaryOperator {
    int apply(int a, int b); // functional method

    String toString();

    static void staticPrint(String s) {
        System.out.println(s);
    }

    default void instancePrint(String s) {
        System.out.println(s);
    }
}

class Addition implements IntBinaryOperator {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

class Multiplication implements IntBinaryOperator {
    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}

class Main {
    public static void main(String[] args) {
        IntBinaryOperator op = new Addition();
        IntBinaryOperator.staticPrint("hello");
        op.instancePrint("hello");
        int result = op.apply(4, 7);
        System.out.println(result); // 11
    }
}