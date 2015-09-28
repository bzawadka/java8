package pl.bzawadka.java8;

import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateLearning {

    public void removeByDepartment(ArrayList<Person> persons, Department department) {
        persons.removeIf(p -> p.getDepartment().equals(department));
    }

    public void removeByDepartmentWithSalaryAbove(ArrayList<Person> persons, Department department, int salaryThreshold) {
        Predicate<Person> departmentPredicate = p -> p.getDepartment().equals(department);
        Predicate<Person> salaryPredicate = p -> p.getSalary() >= salaryThreshold;
        persons.removeIf(departmentPredicate.and(salaryPredicate));
    }
}
