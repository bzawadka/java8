package pl.bzawadka.java8;

import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.ArrayList;

public class PredicateLearning {

    public void removeByDepartment(ArrayList<Person> persons, Department department) {
        persons.removeIf(p -> p.getDepartment().equals(department));
    }
}
