package pl.bzawadka.java8;

import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionLearningTest {

    @Test
    public void testFunctionInHashMapWorks() {
        Function<Department, Set<Person>> noPersonsForDepartment = d -> new HashSet<>();

        Map<Department, Set<Person>> personsByDepartments = new HashMap<>();
        assertThat(personsByDepartments.size(), is(0));

        personsByDepartments.computeIfAbsent(Department.HR, noPersonsForDepartment);
        assertThat(personsByDepartments.size(), is(1));
        assertThat(personsByDepartments.get(Department.HR).isEmpty(), is(true));
    }

    @Test
    public void testBiFunctionInHashMapWorks() {
        Map<String, String> map = new HashMap<>();
        map.put("foo", null);
        map.put("bar", "BAR");

        map.compute("foo", (k, v) -> v == null ? "FRESH" : v.concat(" STALE")); // BiFunction<String, String, String>
        map.compute("bar", (k, v) -> v == null ? "FRESH" : v.concat(" STALE"));

        assertThat(map.get("foo"), is("FRESH"));
        assertThat(map.get("bar"), is("BAR STALE"));
    }

}
