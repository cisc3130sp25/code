package A_prerequisites.C_toString_equals_hashCode.E_overriding_hashCode;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Jane Doe", 1234);
        Student s2 = new Student("Jane Doe", 1234);
        Object  s3 = new Student("Jane Doe", 1234);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        // They all have equal hash codes,
        // since they are equal according to the equals method,
        // and we overrode the hashCode method correctly.

        // If we had not overridden the hashCode method in the Student class,
        // in violation of the specification inherited from the Object class,
        // they would almost certainly have had three different hashCode results.
    }
}
