package C_generics.A_generic_classes.C_current_style;

/*
Pair is a generic class.

T is a type parameter. It is a placeholder for an actual type,
which will be specified by the client when they create an object of this class.

Within the Pair class, T can be used as the type of instance fields,
and can be used in constructors and instance methods.
 */
public class Pair<T> {
    private T first, second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        // String is the type argument here. For this Pair object, T = String
        Pair<String> stringPair = new Pair<>("a", "b");
        System.out.println(stringPair);

        // this will not compile, which is good
        // stringPair.setFirst(34);

        // no cast needed, since the compiler knows that
        // getFirst must return a String for this particular Pair
        String firstString = stringPair.getFirst();

        // Integer is the type argument here. For this Pair object, T = Integer
        Pair<Integer> integerPair = new Pair<>(89, -90); // autoboxing
        System.out.println(integerPair); // (89, -90)
        int first = integerPair.getFirst();  // auto-unboxing
        integerPair.setFirst(34);

        // won't compile --
        // we cannot use a primitive as a type argument
        // Pair<int> intPair = new Pair<>(56, 78);

        Pair<PositiveInteger> positiveIntegerPair = new Pair<>(
                new PositiveInteger(5), new PositiveInteger(9));
        System.out.println(positiveIntegerPair);

        PositiveInteger firstPositiveInteger = positiveIntegerPair.getFirst();

        // a Pair<Number> can contain objects of all classes that inherit from Number
        Pair<Number> numberPair = new Pair<>(34.7845, new PositiveInteger(23));
        System.out.println(numberPair);

        // it is possible to say this, but it's usually not a good idea
        // Pair pair = new Pair(4, 34);
    }
}
