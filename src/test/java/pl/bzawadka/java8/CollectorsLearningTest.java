package pl.bzawadka.java8;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
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
        List<Person> persons = asList(
                new Person("Joe"),
                new Person("Bill"),
                new Person("Bob"));
        assertThat(underTest.accumulateNames(persons), is(asList("Joe", "Bill", "Bob")));
    }

    @Test
    public void testJoining() {
        List<Person> persons = asList(
                new Person("Joe"),
                new Person("Bill"),
                new Person("Bob"));
        assertThat(underTest.joinNames(persons), is("Joe, Bill, Bob"));
    }

    @Test
    public void testSumming() {
        List<Person> persons = asList(
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

        assertThat(underTest.groupByDepartment(asList(joe, bill, bob, fred, jack)), is(expectedGrouping));
    }

    @Test
    public void testGroupingWithSumming() {
        Person joe = new Person("Joe", 50000, Department.HR);
        Person bill = new Person("Bill", 50000, Department.HR);
        Person bob = new Person("Bob", 100000, Department.IT);
        Person fred = new Person("Fred", 100000, Department.IT);
        Person jack = new Person("Jack", 150000, Department.SALES);

        Map<Department, Integer> expectedGrouping = ImmutableMap.of(
                Department.HR, 100000,
                Department.IT, 200000,
                Department.SALES, 150000
        );

        assertThat(underTest.sumSalariesInDepartment(asList(joe, bill, bob, fred, jack)), is(expectedGrouping));
    }

    @Test
    public void testPartitioning() {
        Person joe = new Person("Joe", 50000);
        Person bill = new Person("Bill", 110000);
        Person bob = new Person("Bob", 99000);
        Person fred = new Person("Fred", 150000);

        Map<Boolean, List<Person>> expectedPartitioning = ImmutableMap.of(
                Boolean.TRUE, ImmutableList.of(bill, fred),
                Boolean.FALSE, ImmutableList.of(joe, bob)
        );

        assertThat(underTest.partitionBySalaryAboveThreshold(100000, asList(joe, bill, bob, fred)), is(expectedPartitioning));
    }

    @Test
    public void testFilteringRich() {
        Person joe = new Person("Joe", 50000);
        Person bill = new Person("Bill", 110000);
        Person bob = new Person("Bob", 99000);
        Person fred = new Person("Fred", 150000);

        int richnessThreshold = 100000;
        List<Person> expectedRich = ImmutableList.of(bill, fred);

        assertThat(underTest.filterBySalaryAboveThreshold(richnessThreshold, asList(joe, bill, bob, fred)), is(expectedRich));
    }
}