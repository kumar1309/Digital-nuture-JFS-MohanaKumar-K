import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Ravi", 25),
            new Person("Sneha", 17),
            new Person("Karan", 30)
        );

        System.out.println("All People:");
        people.forEach(System.out::println);

        System.out.println("\nAdults:");
        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}
