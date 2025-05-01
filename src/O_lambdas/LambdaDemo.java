package O_lambdas;

/*
Syntax of lambda expressions:

A lambda expression must implement the abstract method of a functional interface.

A lambda expression can be assigned to a variable, or can be passed to a method.

Basic:
(type0 param0, type1 param1, etc.) -> {
    method body
}

The parameter types must correspond to the parameter types in the functional interface.

Simplifications:
- parameter types can almost always be omitted
- if exactly one parameter, then parentheses can be omitted
- if the method body consists of a single return statement,
  then the word "return", and the curly braces, can be omitted.
- if the method body consists of a single statement, such as a
  print statement, the curly braces can be omitted.

The body of an ideal lambda expression consists of just a single statement.

When a lambda expression simply calls another method, it can be
written in a shorthand way known as a method reference.
Examples:
    (x, y) -> Math.max(x, y) simplifies to: Math::max
General syntax: method location, two colons, method name.

More details: four kinds of method references:
Name	    Syntax	                    Lambda equivalent
Static	    RefType::staticMethod	    (args) -> RefType.staticMethod(args)
            Math::max                   (x, y) -> Math.max(x, y)
Bound	    expr::instanceMethod	    (args) -> expr.instanceMethod(args)
            "hello"::equals             s -> "hello".equals(s)
            System.out::println         s -> System.out.println(s)
Unbound	    RefType::instanceMethod	    (arg0, rest) -> arg0.instanceMethod(rest)
            String::indexOf             (s, ch) -> s.indexOf(ch)
            String::length              s -> s.length()
Constructor	ClassName::new	            (args) -> new ClassName(args)
            Point::new                  (x, y) -> new Point(x, y)
            ArrayList::new              () -> new ArrayList<>()
 */

public class LambdaDemo {
    public static void main(String[] args) {
        /*
        IntBinaryOperator addition = new IntBinaryOperator() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };
         */

        IntBinaryOperator addition = (x, y) -> x + y;
        System.out.println(addition.apply(6, 8));

        int[] arr = {5, 3, 7, 1};
        int sum = reduce(arr, 0, addition);
        System.out.println("sum = " + sum);

        int product = reduce(arr, 1, (x, y) -> x * y);
        System.out.println("product = " + product);

        // int max = reduce(arr, Integer.MIN_VALUE, (x, y) -> Math.max(x, y));
        int max = reduce(arr, Integer.MIN_VALUE, Math::max);
        System.out.println("max = " + max);

        StringConsumer twicePrinter = s -> System.out.println(s + " " + s);
        twicePrinter.accept("hello");

        // StringConsumer printer = s -> System.out.println(s);
        StringConsumer printer = System.out::println;
        printer.accept("hello again");
    }

    /*
    public static int sum(int[] arr) {
        int result = 0;

        for (int element : arr) {
            result = result + element;
        }

        return result;
    }

    public static int product(int[] arr) {
        int result = 1;

        for (int element : arr) {
            result = result * element;
        }

        return result;
    }

    public static int max(int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int element : arr) {
            result = Math.max(result, element);
        }

        return result;
    }
     */

    public static int reduce(int[] arr,
                             int initial,
                             IntBinaryOperator operator) {
        int result = initial;

        for (int element : arr) {
            result = operator.apply(result, element);
        }

        return result;
    }
}