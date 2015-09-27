package pl.bzawadka.java8;

import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectorsLearning {

    public List<String> accumulateNames(List<Person> persons) {
        return persons
                .stream()
                .map(Person::getName) // Method reference provide easy-to-read lambda expressions for methods that already have a name
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

    public List<Person> filterBySalaryAboveThreshold(int salaryThreshold, List<Person> persons) {
        return persons
                .stream()
                .filter(p -> p.getSalary() > salaryThreshold)
                .collect(Collectors.toList());
    }

    public List<Person> filterByDepartment(Department department, List<Person> persons) {
        return persons
                .stream()
                .filter(p -> p.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public void fireAllInDepartment(List<Person> persons, Department department) {
        Objects.requireNonNull(department);
        persons.stream()
                .filter(p -> p.getDepartment().equals(department))
                .forEach(Person::fire);
    }
}
