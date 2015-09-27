package pl.bzawadka.java8;

import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.List;
import java.util.function.Consumer;

public class DefaultMethods {

    public void setDepartmentWithLambda(List<Person> persons, final Department department) {
        persons.forEach(e -> e.setDepartment(department));
    }

    public void setDepartmentWithExplicitConsumer(List<Person> persons, final Department department) {
        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                person.setDepartment(department);
            }
        });
    }
}
