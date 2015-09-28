package pl.bzawadka.java8;

import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PredicateLearningTest {

    private PredicateLearning underTest;

    private ArrayList<Person> persons;

    @Before
    public void setUp() {
        underTest = new PredicateLearning();
        persons = new ArrayList<>();
        persons.add(new Person("Joe", 50000, Department.IT));
        persons.add(new Person("Bill", 100000, Department.IT));
        persons.add(new Person("Bob", 150000, Department.SALES));
    }

    @Test
    public void testRemoveByDepartment() {
        assertThat(persons.size(), is(3));

        underTest.removeByDepartment(persons, Department.IT);

        assertThat(persons.size(), is(1));
        assertThat(persons.get(0).getDepartment(), is(not(Department.IT)));
    }

    @Test
    public void testRemoveByDepartmentHighEarners() {
        assertThat(persons.size(), is(3));
        int salaryThreshold = 90000;

        underTest.removeByDepartmentWithSalaryAbove(persons, Department.IT, salaryThreshold);

        assertThat(persons.size(), is(2));
        assertThat(persons, hasItem(new Person("Joe", 50000, Department.IT)));
    }
}