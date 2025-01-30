package A_prerequisites.C_toString_equals_hashCode.D_overriding_equals;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Jane Doe", 1234);
        Student s2 = new Student("Jane Doe", 1234);
        Object  s3 = new Student("Jane Doe", 1234);

        // Both of the following call the version of the equals method that is written in the Student class.
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        // Note that s1, s2, and s3 each have a different hash code.
        // This violates the specification/contract of the hashCode method,
        // which states that equal objects must have equal has codes.
        // We will fix this next.
    }
}
