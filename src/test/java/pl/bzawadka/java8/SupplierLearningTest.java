package pl.bzawadka.java8;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SupplierLearningTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSupplierInObjectsIsUsed() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("supplier says: not null object is required");

        Supplier<String> notNullMessageSupplier = () -> "supplier says: not null object is required";
        Objects.requireNonNull(null, notNullMessageSupplier);
    }

    @Test
    public void testSupplierInOptionalIsUsed() {
        Optional<String> emptyBase = Optional.empty();
        Supplier<String> otherStringSupplier = () -> "other supplied string";
        assertThat(emptyBase.orElseGet(otherStringSupplier), is("other supplied string"));
    }


}