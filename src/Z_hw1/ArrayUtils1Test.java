package Z_hw1;

public class ArrayUtils1Test {
    public static void main(String[] args) {
        testIndexOf();
        testAllEqualTo();
        testSomeEqualTo();
        testNoneEqualTo();
        testEquals();
    }

    private static void testIndexOf() {
        System.out.println("Testing indexOf");

        System.out.println(ArrayUtils1.indexOf(new String[]{"a", "b", "c"}, "a")); // 0
        System.out.println(ArrayUtils1.indexOf(new String[]{"a", "b", "c"}, "b")); // 1
        System.out.println(ArrayUtils1.indexOf(new String[]{"a", "b", "c"}, "c")); // 2
        System.out.println(ArrayUtils1.indexOf(new String[]{"a", "b", "c"}, "d")); // -1
        System.out.println(ArrayUtils1.indexOf(new String[]{"a", "b", "a", "c"}, "a")); // 0
        System.out.println(ArrayUtils1.indexOf(new String[]{null, "b", "c"}, null)); // 0
        System.out.println(ArrayUtils1.indexOf(new String[]{"a", null, "c"}, null)); // 1
        System.out.println(ArrayUtils1.indexOf(new String[]{}, "a")); // -1
        System.out.println(ArrayUtils1.indexOf(new String[]{new String("a")}, new String("a"))); // 0

        System.out.println();
    }

    private static void testAllEqualTo() {
        System.out.println("Testing allEqualTo");

        System.out.println(ArrayUtils1.allEqualTo(new String[]{"a", "a", "a"}, "a")); // true
        System.out.println(ArrayUtils1.allEqualTo(new String[]{"a", "b", "a"}, "a")); // false
        System.out.println(ArrayUtils1.allEqualTo(new String[]{"b", "b", "b"}, "b")); // true
        System.out.println(ArrayUtils1.allEqualTo(new String[]{"b", "b", "c"}, "b")); // false
        System.out.println(ArrayUtils1.allEqualTo(new String[]{}, "a")); // true
        System.out.println(ArrayUtils1.allEqualTo(new String[]{null, null, null}, null)); // true
        System.out.println(ArrayUtils1.allEqualTo(new String[]{null, "a", null}, null)); // false
        System.out.println(ArrayUtils1.allEqualTo(new String[]{"a", "a", "a"}, "b")); // false
        System.out.println(ArrayUtils1.allEqualTo(new String[]{new String("a"), new String("a"), "a"}, new String("a"))); // true

        System.out.println();
    }

    private static void testSomeEqualTo() {
        System.out.println("Testing someEqualTo");

        System.out.println(ArrayUtils1.someEqualTo(new String[]{"a", "b", "c"}, "a")); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"a", "b", "c"}, "b")); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"a", "b", "c"}, "d")); // false
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"a", "a", "a"}, "a")); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"b", "b", "c"}, "b")); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"b", "b", "c"}, "c")); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"b", "b", "c"}, "d")); // false
        System.out.println(ArrayUtils1.someEqualTo(new String[]{}, "a")); // false
        System.out.println(ArrayUtils1.someEqualTo(new String[]{null, null, null}, null)); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{null, "a", null}, null)); // true
        System.out.println(ArrayUtils1.someEqualTo(new String[]{"a", "a", "a"}, "b")); // false

        System.out.println();
    }

    private static void testNoneEqualTo() {
        System.out.println("Testing noneEqualTo");

        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"a", "b", "c"}, "d")); // true
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"a", "b", "c"}, "a")); // false
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"a", "b", "c"}, "b")); // false
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"a", "a", "a"}, "b")); // true
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"b", "b", "b"}, "a")); // true
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"b", "b", "c"}, "d")); // true
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"b", "b", "c"}, "c")); // false
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{}, "a")); // true
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{null, null, null}, null)); // false
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{null, "a", null}, null)); // false
        System.out.println(ArrayUtils1.noneEqualTo(new String[]{"a", "a", "a"}, "b")); // true

        System.out.println();
    }

    private static void testEquals() {
        System.out.println("Testing equals");

        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", null}, new String[]{"a", "b"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", null}, new String[]{"a", "b", null})); // true
        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", "c"}, new String[]{"a", "b", "c"})); // true
        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", "c"}, new String[]{"a", "c", "b"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", "c"}, new String[]{"a", "b", "c", "d"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{"a", "b", "c"}, new String[]{"a", "b"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{null, "b", "c"}, new String[]{null, "b", "c"})); // true
        System.out.println(ArrayUtils1.equals(new String[]{null, "b", "c"}, new String[]{"a", "b", "c"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{null, null, null}, new String[]{null, null, null})); // true
        System.out.println(ArrayUtils1.equals(new String[]{null, "x", null}, new String[]{null, "x", "y"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{}, new String[]{})); // true
        System.out.println(ArrayUtils1.equals(new String[]{}, new String[]{"a"})); // false
        System.out.println(ArrayUtils1.equals(new String[]{"a"}, new String[]{})); // false
        System.out.println(ArrayUtils1.equals(new String[]{new String("a")}, new String[]{new String("a")})); // true

        System.out.println();
    }
}
