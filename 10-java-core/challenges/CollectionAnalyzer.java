package challenges;

import java.util.*;
import java.util.stream.*;

public class CollectionAnalyzer {

    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static Map<Character, Long> charFrequency(List<String> words) {
        return words.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
    }

    // Test
    public static void main(String[] args) {
        System.out.println(groupByLength(Arrays.asList("hi", "bye", "hello", "ok")));
        // {2=[hi, ok], 3=[bye], 5=[hello]}

        System.out.println(charFrequency(Arrays.asList("aab", "bc")));
        // {a=2, b=2, c=1}
    }
}
