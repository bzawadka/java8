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

    @Before
    public void setUp() {
        underTest = new ConsumerLearning();
    }

    @Test
    public void testSetDepartmentWithLambdaWorks() {
        List<Person> persons = asList(
                new Person("Joe", 100000, Department.HR),
                new Person("Bill", 100000, Department.SALES));

        underTest.setDepartmentWithLambda(persons, Department.IT);

        for (Person p : persons) {
            assertThat(p.getDepartment(), is(Department.IT));
        }
    }

    @Test
    public void testSetDepartmentWithExplicitConsumerWorks() {
        List<Person> persons = asList(
                new Person("Joe", 100000, Department.HR),
                new Person("Bill", 100000, Department.SALES));

        underTest.setDepartmentWithExplicitConsumer(persons, Department.IT);

        for (Person p : persons) {
            assertThat(p.getDepartment(), is(Department.IT));
        }
    }
}