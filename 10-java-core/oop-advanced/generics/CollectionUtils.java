package oop_advanced.generics;

import java.util.*;
import java.util.function.Predicate;

public class CollectionUtils {

    public static <T> T findFirst(List<T> list, Predicate<T> predicate) {
        for(T t : list)
            if(predicate.test(t)) return t;
        return null;
    }

    public static <T extends Comparable<T>> T findMax(List<T> list) {
        return Collections.max(list);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for(T t : list)
            if(predicate.test(t)) result.add(t);
        return result;
    }
}
