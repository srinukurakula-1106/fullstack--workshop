package oop_advanced.generics;

import java.util.*;

public class GenericsTest {
    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>("Age",25);
        System.out.println(pair);

        Box<String> box = new Box<>();
        box.set("Hello");
        System.out.println(box.get());

        List<Integer> nums = List.of(1,5,3,9,2);
        System.out.println(CollectionUtils.findMax(nums));

        List<String> names = List.of("Alice","Bob","Anna");
        System.out.println(CollectionUtils.filter(names, s -> s.startsWith("A")));
    }
}
