package N_heap;

public record Patient(String name, int importance) implements Comparable<Patient> {
    @Override
    public String toString() {
        return name + " " + importance;
    }

    // compares patients based on importance level
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.importance, other.importance);
    }
}