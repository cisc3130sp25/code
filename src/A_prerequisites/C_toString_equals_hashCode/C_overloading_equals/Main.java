package A_prerequisites.C_toString_equals_hashCode.C_overloading_equals;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Jane Doe", 1234);
        Student s2 = new Student("Jane Doe", 1234);
        Object  s3 = new Student("Jane Doe", 1234);

        // The following correctly calls the equals method of Student:
        System.out.println(s1.equals(s2)); // true

        // The following calls the equals method of Object,
        // not the one we wrote in Student.
        // That's because s3 is a variable of type Object and
        // cannot be automatically cast down to Student.
        System.out.println(s1.equals(s3)); // false, but we want true!

        // We will fix this by overRIDING the equals method
    }
}
