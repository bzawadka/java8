package pl.bzawadka.java8;

import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class PredicateLearningTest {

    private PredicateLearning underTest;

    @Before
    public void setUp() {
        underTest = new PredicateLearning();
    }

    @Test
    public void testRemoveByDepartment() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Joe", 50000, Department.IT));
        persons.add(new Person("Bill", 100000, Department.IT));
        persons.add(new Person("Bob", 150000, Department.SALES));

        underTest.removeByDepartment(persons, Department.IT);

        assertThat(persons.size(), is(1));
        assertThat(persons.get(0).getDepartment(), is(not(Department.IT)));
    }
}