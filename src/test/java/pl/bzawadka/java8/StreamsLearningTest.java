package pl.bzawadka.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamsLearningTest {

    private StreamsLearning underTest;

    @Before
    public void setUp() {
        underTest = new StreamsLearning();
    }

    @Test
    public void testSum() {
        assertThat(underTest.sum(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)), is(36));
    }

    @Test
    public void testMax() {
        assertThat(underTest.max(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)), is(8));
    }

    @Test
    public void testMin() {
        assertThat(underTest.min(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)), is(1));
    }
}