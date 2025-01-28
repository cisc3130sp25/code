package A_prerequisites.E_Comparator;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private int age;

    public Student(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id " + id + " with age " + age;
    }

    /**
     * Compares two students based on their IDs.
     */
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}