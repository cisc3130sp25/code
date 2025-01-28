package A_prerequisites.C_toString_equals_hashCode.B_no_equals;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override // overrides the toString() method of Object
    public String toString() {
        return name + " " + id;
    }
}