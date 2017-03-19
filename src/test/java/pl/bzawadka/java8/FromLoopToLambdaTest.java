package pl.bzawadka.java8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FromLoopToLambdaTest {

    @Test
    public void minIntegerIsCalculatedCorrectlyInSevenDifferentWays() {
        FromLoopToLambda underTest = new FromLoopToLambda();

        int val1 = underTest.forMinInteger();
        int val2 = underTest.forEachMinInteger();
        int val3 = underTest.iteratorMinInteger();
        int val4 = underTest.parallelStreamMinInteger();
        int val5 = underTest.streamMinInteger();
        int val6 = underTest.lambdaMinInteger();
        int val7 = underTest.forEachLambdaMinInteger();

        System.out.println(val1 + " for loop");
        System.out.println(val2 + " for-each loop");
        System.out.println(val3 + " iterator");
        System.out.println(val4 + " parallelStream");
        System.out.println(val5 + " stream");
        System.out.println(val6 + " lambda");
        System.out.println(val7 + " forEach lambda");

        assertThat(val1, is(equalTo(val2)));
        assertThat(val2, is(equalTo(val3)));
        assertThat(val3, is(equalTo(val4)));
        assertThat(val4, is(equalTo(val5)));
        assertThat(val5, is(equalTo(val6)));
        assertThat(val6, is(equalTo(val7)));
    }
}