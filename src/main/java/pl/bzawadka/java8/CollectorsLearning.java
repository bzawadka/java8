package pl.bzawadka.java8;

import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsLearning {

    public List<String> accumulateNames(List<Person> persons) {
        return persons
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public String joinNames(List<Person> persons) {
        return persons
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public Integer sumSalaries(List<Person> persons) {
        return persons
                .stream()
                .collect(Collectors.summingInt(Person::getSalary));
    }

    public Map<Department, List<Person>> groupByDepartment(List<Person> persons) {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getDepartment));
    }

    public Map<Department, Integer> sumSalariesInDepartment(List<Person> persons) {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingInt(Person::getSalary)));
    }

    public Map<Boolean, List<Person>> partitionBySalaryAboveThreshold(int salaryThreshold, List<Person> persons) {
        return persons
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getSalary() > salaryThreshold));
    }
}
