package pl.bzawadka.java8;

import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConsumerLearningTest {

    private ConsumerLearning underTest;
    private List<Person> persons;

    @Before
    public void setUp() {
        underTest = new ConsumerLearning();
        persons = asList(
                new Person("Joe", Department.HR),
                new Person("Bill", Department.SALES));
    }

    @Test
    public void testSetDepartmentWithLambdaWorks() {
        underTest.setDepartmentWithLambda(persons, Department.IT);
        for (Person p : persons) {
            assertThat(p.getDepartment(), is(Department.IT));
        }
    }

    @Test
    public void testSetDepartmentWithExplicitConsumerWorks() {
        underTest.setDepartmentWithExplicitConsumer(persons, Department.IT);
        for (Person p : persons) {
            assertThat(p.getDepartment(), is(Department.IT));
        }
    }

    @Test
    public void testFireWorks() {
        persons.forEach(p -> assertThat(p.isEmployed(), is(true)));
        underTest.fireAll(persons);
        persons.forEach(p -> assertThat(p.isEmployed(), is(false)));
    }
}