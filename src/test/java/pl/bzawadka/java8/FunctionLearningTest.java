package pl.bzawadka.java8;

import org.junit.Test;
import pl.bzawadka.java8.data.Department;
import pl.bzawadka.java8.data.Person;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionLearningTest {

    //accept one argument and produce a result
    @Test
    public void testComputeIfAbsentFunctionInMap() {
        Map<Department, Set<Person>> personsByDepartments = new HashMap<>();
        assertThat(personsByDepartments.size(), is(0));

        Function<Department, Set<Person>> emptyDepartmentInitFunction = d -> new HashSet<>();
        personsByDepartments.computeIfAbsent(Department.HR, emptyDepartmentInitFunction);

        assertThat(personsByDepartments.size(), is(1));
        assertThat(personsByDepartments.get(Department.HR).isEmpty(), is(true));
    }

    //accept two arguments and produce a result
    @Test
    public void testComputeRemappingBiFunctionInMap() {
        Map<String, String> fruitWithFreshness = new HashMap<>();
        fruitWithFreshness.put("orange", "yes");
        fruitWithFreshness.put("apple", "no");

        BiFunction<String, String, String> freshnessRemappingFunction =
                (fruit, freshness) -> freshness.equals("yes") ? "FRESH ".concat(fruit) : "ROTTEN ".concat(fruit);
        fruitWithFreshness.compute("orange", freshnessRemappingFunction);
        fruitWithFreshness.compute("apple", freshnessRemappingFunction);

        assertThat(fruitWithFreshness.get("orange"), is("FRESH orange"));
        assertThat(fruitWithFreshness.get("apple"), is("ROTTEN apple"));
    }

    @Test
    public void testMapFunctionInOptional() {
        Optional<Person> person = Optional.of(new Person("bob", Department.IT));
        Optional<Department> departmentMapping = person.map(p -> p.getDepartment());
        assertThat(departmentMapping.get(), is(Department.IT));
    }

    @Test
    public void testSimpleFunction() {
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> replaceZ = s -> s.replaceFirst("z", "x");

        assertThat(toUpperCase.apply("abz"), equalTo("ABZ"));
        assertThat(toUpperCase.andThen(toLowerCase).apply("abz"), equalTo("abz"));
        assertThat(replaceZ.apply("abz"), equalTo("abx"));
    }

}
