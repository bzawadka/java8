package pl.bzawadka.java8.functionalinterface;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
