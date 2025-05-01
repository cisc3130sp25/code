package O_lambdas;

/*
Some methods of the Comparator<T> interface:

The functional method:
    int compare(T o1, T o2)

Static methods (headers have been simplified):
    static <T extends Comparable<T>> Comparator<T> naturalOrder()
    static <T extends Comparable<T>> Comparator<T> reverseOrder()
    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor)
    static <T> Comparator<T> comparingInt(ToIntFunction<T> keyExtractor)

Default methods:
    default Comparator<T> reversed()
    default Comparator<T> thenComparing(Comparator<T> other)
    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor)
    default Comparator<T> thenComparingInt(ToIntFunction<T> keyExtractor)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoreComparatorExamples {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(new Name("John", "Adams"), "1234", 50_000),
                new Employee(new Name("John", "Doe"), "2345", 50_000),
                new Employee(new Name("Bob", "Doe"), "6754", 50_000),
                new Employee(new Name("Bob", "Adams"), "5432", 40_000),
                new Employee(new Name("Jane", "Smith"), "7845", 55_000),
                new Employee(new Name("Jane", "Smith"), "7890", 45_000),
                new Employee(new Name("Julia", "Adams"), "8945", 50_000)
        ));

        Collections.shuffle(employees);
        System.out.println("Employees sorted by id:");
        employees.sort(Comparator.comparing(Employee::id));
        employees.forEach(System.out::println);
        System.out.println();

        Collections.shuffle(employees);
        System.out.println("Employees sorted by salary:");
        employees.sort(Comparator.comparing(Employee::salary));
        employees.forEach(System.out::println);
        System.out.println();

        Collections.shuffle(employees);
        System.out.println("Employees sorted by salary and then by id:");
        // employees.sort(((emp1, emp2) -> {
        //   if (emp1.salary() != emp2.salary()) {
        //     return Integer.compare(emp1.salary(), emp2.salary());
        //   } else {
        //     return emp1.id().compareTo(emp2.id());
        //   }
        // }));
        employees.sort(Comparator.comparing(Employee::salary).thenComparing(Employee::id));
        employees.forEach(System.out::println);
        System.out.println();

        Collections.shuffle(employees);
        System.out.println("Employees sorted by salary then by first name and then by last name:");
        Comparator<Employee> bySalaryThenFirstThenLast =
                Comparator.comparing(Employee::salary)
                        .thenComparing(emp -> emp.name().first())
                        .thenComparing(emp -> emp.name().last());
        employees.sort(bySalaryThenFirstThenLast);
        employees.forEach(System.out::println);
    }
}