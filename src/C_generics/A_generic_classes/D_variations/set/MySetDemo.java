package C_generics.A_generic_classes.D_variations.set;

public class MySetDemo {
    public static void main(String[] args) {
        MySet<String> stringSet = MySet.create(10);
        MySet<Double> doubleSet = MySet.create(5);
    }
}
