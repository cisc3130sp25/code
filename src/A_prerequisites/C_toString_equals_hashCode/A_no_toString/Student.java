package A_prerequisites.C_toString_equals_hashCode.A_no_toString;

/*
Every class in Java inherits from the class named Object 
either directly or indirectly. (The only exception is the 
Object class itself -- it does not inherit from anything.) 
If a class does not explicitly extend another class, then
it implicitly extends the Object class. For example, the
Student class, below, directly inherits from the Object 
class. If Student had a subclass C, then C would directly
extend Student and indirectly extend Object.

The documentation of the Object class is here: 
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html
You are not expected to understand most of this documentation. 
We will focus on the toString(), equals(), and hashCode() methods 
in the Object class. 
*/

public class Student { // equivalent to: public class Student extends Object {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}