package Z_hw1;

public class ArrayUtils2Test {
    public static void main(String[] args) {
        testCopyOf();
        testCopyOfWithLength();
        testCopyOfRange();
    }

    private static void testCopyOf() {
        System.out.println("Testing copyOf");

        int[] arr1 = {1, 2, 3};
        int[] copy1 = ArrayUtils2.copyOf(arr1);
        System.out.println(copy1[0] == arr1[0] && copy1[1] == arr1[1] && copy1[2] == arr1[2]); // true

        copy1[0] = 10;
        System.out.println(arr1[0] == 1); // true
        System.out.println(copy1[0] == 10); // true

        int[] arr2 = {};
        int[] copy2 = ArrayUtils2.copyOf(arr2);
        System.out.println(copy2.length == 0); // true

        int[] arr3 = {1, 2, 0, 4};
        int[] copy3 = ArrayUtils2.copyOf(arr3);
        System.out.println(copy3[0] == arr3[0] && copy3[1] == arr3[1] && copy3[2] == arr3[2] && copy3[3] == arr3[3]); // true

        copy3[2] = 99;
        System.out.println(arr3[2] == 0); // true
        System.out.println(copy3[2] == 99); // true

        int[] arr4 = {42};
        int[] copy4 = ArrayUtils2.copyOf(arr4);
        System.out.println(copy4[0] == arr4[0]); // true

        System.out.println();
    }

    private static void testCopyOfWithLength() {
        System.out.println("Testing copyOf with length");

        int[] arr1 = {1, 2, 3};
        int[] copy1 = ArrayUtils2.copyOf(arr1, 3);
        System.out.println(copy1[0] == arr1[0] && copy1[1] == arr1[1] && copy1[2] == arr1[2]); // true
        copy1[0] = 10;
        System.out.println(arr1[0] == 1); // true
        System.out.println(copy1[0] == 10); // true

        int[] arr2 = {1, 2, 3};
        int[] copy2 = ArrayUtils2.copyOf(arr2, 5);
        System.out.println(copy2[0] == arr2[0] && copy2[1] == arr2[1] && copy2[2] == arr2[2] && copy2[3] == 0 && copy2[4] == 0); // true
        copy2[0] = 10;
        System.out.println(arr2[0] == 1); // true
        System.out.println(copy2[0] == 10); // true

        int[] arr3 = {1, 2, 3};
        int[] copy3 = ArrayUtils2.copyOf(arr3, 2);
        System.out.println(copy3[0] == arr3[0] && copy3[1] == arr3[1]); // true
        copy3[0] = 10;
        System.out.println(arr3[0] == 1); // true
        System.out.println(copy3[0] == 10); // true

        int[] arr4 = {};
        int[] copy4 = ArrayUtils2.copyOf(arr4, 3);
        System.out.println(copy4.length == 3 && copy4[0] == 0 && copy4[1] == 0 && copy4[2] == 0); // true
        copy4[0] = 10;
        System.out.println(arr4.length == 0); // true
        System.out.println(copy4[0] == 10); // true

        int[] arr5 = {1, 2, 3};
        int[] copy5 = ArrayUtils2.copyOf(arr5, 0);
        System.out.println(copy5.length == 0); // true

        System.out.println();
    }

    private static void testCopyOfRange() {
        System.out.println("Testing copyOfRange");

        int[] arr1 = {5, 10, 15, 20, 25};
        int[] copy1 = ArrayUtils2.copyOfRange(arr1, 1, 3);
        System.out.println(copy1[0] == 10 && copy1[1] == 15); // true
        copy1[0] = 100;
        System.out.println(arr1[0] == 5); // true
        System.out.println(copy1[0] == 100); // true

        int[] arr2 = {5, 10, 15, 20, 25};
        int[] copy2 = ArrayUtils2.copyOfRange(arr2, 0, 2);
        System.out.println(copy2[0] == 5 && copy2[1] == 10); // true
        copy2[1] = 200;
        System.out.println(arr2[1] == 10); // true
        System.out.println(copy2[1] == 200); // true

        int[] arr3 = {5, 10, 15, 20, 25};
        int[] copy3 = ArrayUtils2.copyOfRange(arr3, 2, 5);
        System.out.println(copy3[0] == 15 && copy3[1] == 20 && copy3[2] == 25); // true
        copy3[2] = 300;
        System.out.println(arr3[2] == 15); // true
        System.out.println(copy3[2] == 300); // true

        int[] arr4 = {5, 10, 15, 20, 25};
        int[] copy4 = ArrayUtils2.copyOfRange(arr4, 0, 0);
        System.out.println(copy4.length == 0); // true

        int[] arr5 = {5, 10, 15, 20, 25};
        int[] copy5 = ArrayUtils2.copyOfRange(arr5, 1, 1);
        System.out.println(copy5.length == 0); // true

        System.out.println();
    }
}
