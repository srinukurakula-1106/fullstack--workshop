package collections_streams;

import java.util.*;

public class LambdaRefactor {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Alice","Bob","Anna"));

        // Sort by length
        names.sort((a,b) -> Integer.compare(a.length(), b.length()));

        // Filter even numbers
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        // Print
        names.forEach(System.out::println);

        // Thread
        new Thread(() -> System.out.println("Running")).start();

        // Uppercase
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upper);
    }
}
