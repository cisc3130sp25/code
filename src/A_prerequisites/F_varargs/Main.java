package A_prerequisites.F_varargs;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum(1.5, 2, 2.5)); // 6.0
        System.out.println(sum(1.5));         // 1.5
        System.out.println(sum());            // 0.0

        // can also pass an explicit array:
        double[] arr = {1.5, 2, 2.5};
        System.out.println(sum(arr));         // 6.0
    }

    // This is a method with a vararg parameter.
    // A vararg parameter is treated by the method as an array.
    // The caller can pass as many arguments as they wish,
    // even without creating an array explicitly;
    // instead, Java creates an array behind the scenes.
    public static double sum(double... nums) {
        double sum = 0;

        for (double num : nums) {
            sum += num;
        }

        return sum;
    }
}

// examples of JDK methods with vararg parameters:
// - Objects.hash(Object... itemsToHash)
// - System.out.printf(String formatString, Object... args)