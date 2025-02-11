package C_generics.A_generic_classes.A_without_generics;

public class PairDemo {
    public static void main(String[] args) {
        IntegerPair integerPair = new IntegerPair(45, 33); // autoboxing
        System.out.println(integerPair); // (45, 33)
        integerPair.setFirst(76);
        System.out.println(integerPair.getFirst()); // 76

        // doesn't work
        // IntegerPair pair2 = new IntegerPair("a", "b");

        StringPair stringPair = new StringPair("a", "b");
        System.out.println(stringPair); // (a, b)
        stringPair.setFirst("c");
        System.out.println(stringPair.getFirst()); // c
    }
}
