package A_prerequisites.D_Comparable;

import java.util.Objects;

public class Student implements Comparable<Student> {
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
        if (o instanceof Student) {
            Student other = (Student) o;
            return this.name.equals(other.name) && this.id == other.id;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    /**
     * Compares two students based on their IDs.
     * A student with a lower ID number is considered to be
     * less than a student with a higher ID number.
     *
     * @param other The Student to compare with this Student
     * @return 
     *   a positive integer if this student has a greater id than the other student,
     *   a negative integer if this student has a lower id than the other student,
     *   0 if they have equal IDs
     */
    @Override
    public int compareTo(Student other) {
        // if (this.id > other.id) {
        //   return 55;
        // } else if (this.id < other.id) {
        //   return -190;
        // } else {
        //   return 0;
        // }

        // another way; hackish:
        // return this.id - other.id;
        // Consider this case: this.id = -2_000_000_000 and other.id = 1_000_000_000  ---
        // we want the method to return a negative int, but it will incorrectly return a positive int.

        // best way:
        return Integer.compare(this.id, other.id);
    }
}