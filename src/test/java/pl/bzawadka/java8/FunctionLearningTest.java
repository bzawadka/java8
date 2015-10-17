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
    public void testFunctionInHashSetWorks() {
        Function<Department, Set<Person>> defaultHrPersonsFunction = d -> new HashSet<>();

        Map<Department, Set<Person>> personsByDepartments = new HashMap<>();
        assertThat(personsByDepartments.size(), is(0));

        personsByDepartments.computeIfAbsent(Department.HR, defaultHrPersonsFunction);
        assertThat(personsByDepartments.size(), is(1));
        assertThat(personsByDepartments.get(Department.HR).isEmpty(), is(true));
    }

}
