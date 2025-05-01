package O_lambdas;

public record Employee(Name name, String id, int salary) {
    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s $%,-10d", name.first(), name.last(), id, salary);
    }
}