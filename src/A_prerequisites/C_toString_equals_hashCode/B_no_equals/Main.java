package A_prerequisites.C_toString_equals_hashCode.B_no_equals;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 1234);
        Student s2 = new Student("John Doe", 1234);

        System.out.println(s1.toString());
        System.out.println(s1);

        Object o = s1;
        System.out.println(o);

        // In each of the above println statements,
        // the toString() method of Student is called.


        // The == operator, when comparing references,
        // determines whether they refer to the same object.
        // It does not examine the contents of two objects
        // to see if they are equal.
        System.out.println(s1 == s2); // false
        Student s3 = s1;
        System.out.println(s1 == s3); // true

        // The equals method that is inherited from the Object
        // class behaves like the == operator.
        System.out.println(s1.equals(s2)); // false
        System.out.println(s1.equals(s3)); // true
    }
}
