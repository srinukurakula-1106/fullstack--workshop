package collections_streams;

import java.util.*;
import java.util.stream.*;

public class StreamExercise {

    record Employee(Long id,String name,String department,double salary,int years,List<String> skills){}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1L,"Alice","Engineering",85000,5,List.of("Java","Python")),
            new Employee(2L,"Bob","Engineering",75000,3,List.of("Java","JavaScript")),
            new Employee(3L,"Charlie","Sales",65000,7,List.of("Communication","CRM")),
            new Employee(4L,"Diana","Engineering",95000,8,List.of("Java","Kotlin","Go")),
            new Employee(5L,"Eve","HR",55000,2,List.of("Recruiting","Communication")),
            new Employee(6L,"Frank","Sales",70000,4,List.of("Negotiation","CRM"))
        );

        employees.stream()
                .filter(e -> e.department().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .map(Employee::name)
                .forEach(System.out::println);

        System.out.println(
            employees.stream()
                .flatMap(e -> e.skills().stream())
                .distinct()
                .toList()
        );
    }
}
