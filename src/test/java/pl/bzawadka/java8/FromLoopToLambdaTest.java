package pl.bzawadka.java8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FromLoopToLambdaTest {

    @Test
    public void testThemAll() {
        FromLoopToLambda runner = new FromLoopToLambda();

        int val1 = runner.forMinInteger();
        int val2 = runner.forEachMinInteger();
        int val3 = runner.iteratorMinInteger();
        int val4 = runner.lambdaMinInteger();
        int val5 = runner.forEachLambdaMinInteger();

        assertThat(val1, is(equalTo(val2)));
        assertThat(val2, is(equalTo(val3)));
        assertThat(val3, is(equalTo(val4)));
        assertThat(val4, is(equalTo(val5)));
    }
}