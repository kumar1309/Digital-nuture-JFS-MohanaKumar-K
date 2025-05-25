import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 7, 8, 13, 4, 11, 10);

        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evens);
    }
}
