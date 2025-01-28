package A_prerequisites.C_toString_equals_hashCode.A_no_toString;

public class Main { // application; client of Student class
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 1234);
        Student s2 = new Student("John Doe", 1234);

        /*
        Here, we're using the toString() method of the Object class, which is inherited by the Student class.
        The toString() method of the Object class gives us the class name of the actual object
        (here, A_prerequisites.A_toString_equals_hashCode.A_no_toString.Student), then the '@' character,
        and then a hexadecimal number which is the object's hash code.
        A hash code an int associated with an object; it might be the address of the object, but not necessarily.
        */

        System.out.println(s1.toString());

        // when we use a reference variable in a print/println statement
        // Java calls the toString method for us.
        System.out.println(s2);
        // equivalent to: System.out.println(s2.toString());

        // Additionally, if we concatenate a reference variable with a String,
        // Java also calls the toString() method for us
        String s2info = "s2: " + s2;
        // equivalent to: String s2info = "s2: " + s2.toString();
        System.out.println(s2info);
    }
}
