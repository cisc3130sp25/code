package A_prerequisites.C_toString_equals_hashCode.D_overriding_equals;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "student with name " + name + " and id " + id;
    }

    @Override
    public boolean equals(Object o) {
        // First attempt:
        // return this.name.equals(o.name) && this.id == o.id;

        // Our first attempt doesn't compile, since the Object 
        // class doesn't have fields called name and id.

        // Second attempt, version 1:
        // return this.name.equals(((Student) o).name)
        //     && this.id == ((Student) o).id;

        // Second attempt, version 2 (more readable):
        // Student other = (Student) o;
        // return this.name.equals(other.name) && this.id == other.id;

        // Our second attempt will compile, and run well in many cases,
        // but will generate a ClassCastException if o doesn't refer to an instance of Student.
        // We don't know what type of object o refers to -- it might potentially
        // be any type of object, due to polymorphism. It can 
        // refer to a String object, for example.

        // Solution: first use the instanceof operator, and then cast.
        // This is one of the few places in Java where casting is desirable.
        // (We will see another in the context of generics.)
        // This is how you should write the equals method from now on.
        if (o instanceof Student) {
            Student other = (Student) o;
            return this.name.equals(other.name) && this.id == other.id;
        } else {
            return false;
        }

        /*
        // In recent versions of Java, the above can be simplified to:
        if (o instanceof Student other) {
           return this.name.equals(other.name) && this.id == other.id;
        } else {
          return false;
        }

        // or even more simply:
        return o instanceof Student other && this.name.equals(other.name) && this.id == other.id;
        */
    }
}
