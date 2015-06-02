package pl.bzawadka.java8;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CollectorsLearningTest {

    private CollectorsLearning underTest;

    @Before
    public void setUp() {
        underTest = new CollectorsLearning();
    }

    @Test
    public void testAccumulate() {
        List<Person> persons = Arrays.asList(
                new Person("Joe"),
                new Person("Bill"),
                new Person("Bob"));
        assertThat(underTest.accumulateNames(persons), is(Arrays.asList("Joe", "Bill", "Bob")));
    }

    @Test
    public void testJoining() {
        List<Person> persons = Arrays.asList(
                new Person("Joe"),
                new Person("Bill"),
                new Person("Bob"));
        assertThat(underTest.joinNames(persons), is("Joe, Bill, Bob"));
    }

    @Test
    public void testSumming() {
        List<Person> persons = Arrays.asList(
                new Person("Joe", 50000),
                new Person("Bill", 100000),
                new Person("Bob", 150000));
        assertThat(underTest.sumSalaries(persons), is(300000));
    }

    @Test
    public void testGrouping() {
        Person joe = new Person("Joe", 50000, Department.HR);
        Person bill = new Person("Bill", 50000, Department.HR);
        Person bob = new Person("Bob", 100000, Department.IT);
        Person fred = new Person("Fred", 100000, Department.IT);
        Person jack = new Person("Jack", 150000, Department.SALES);

        Map<Department, List<Person>> expectedGrouping = ImmutableMap.of(
                Department.HR, ImmutableList.of(joe, bill),
                Department.IT, ImmutableList.of(bob, fred),
                Department.SALES, ImmutableList.of(jack)
        );

        assertThat(underTest.groupByDepartment(Arrays.asList(joe, bill, bob, fred, jack)), is(expectedGrouping));
    }
}