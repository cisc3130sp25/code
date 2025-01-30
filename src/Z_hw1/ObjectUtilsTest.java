package Z_hw1;

public class ObjectUtilsTest {
    public static void main(String[] args) {
        System.out.println(ObjectUtils.nullSafeEquals(null, null)); // true

        System.out.println(ObjectUtils.nullSafeEquals(null, "hello")); // false
        System.out.println(ObjectUtils.nullSafeEquals("hello", null)); // false

        System.out.println(ObjectUtils.nullSafeEquals("hello", "hello"));             // true
        System.out.println(ObjectUtils.nullSafeEquals("hello", new String("hello"))); // true

    }
}
