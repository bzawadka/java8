package pl.bzawadka.java8.functionalinterface;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void testConvert() throws Exception {
        Converter<String, Integer> integerConverter = (from) -> Integer.valueOf(from);
        assertThat(integerConverter.convert("123"), equalTo(123));

        //static method reference
        Converter<String, Integer> anotherIntegerConverter = Integer::valueOf;
        assertThat(anotherIntegerConverter.convert("234"), equalTo(234));

        // variables used in lambda expressions must be effectively final
        String prefix = "CHF";
        Converter<Integer, String> prefixingConverter = (from) -> prefix.concat(" ").concat(from.toString());
        assertThat(prefixingConverter.convert(100), equalTo("CHF 100"));
    }
}