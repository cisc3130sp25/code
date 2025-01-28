package A_prerequisites.C_toString_equals_hashCode.C_overloading_equals;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }

    /*
    This method does not override the equals method of the Object class,
    since the equals method of the Object class has a parameter of type Object,
    not of type Student.
    In fact, we are overLOADING the equals method -- we're
    writing another method with the same name but different
    parameter type.
    Important: you should generally NOT write an equals method in this style.
    */
    public boolean equals(Student other) {
        return this.name.equals(other.name) && this.id == other.id;

        // "this.name.equals(other.name)" calls the equals method of the
        // String class, since this.name is a String.
    }
}
