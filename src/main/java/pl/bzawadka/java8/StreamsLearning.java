package pl.bzawadka.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsLearning {

    public Integer sum(List<Integer> list) {
        // Perform a reduction using sum function
        return list
                .stream()
                .reduce(Integer::sum).get(); // Method reference provide easy-to-read lambda expressions for methods that already have a name
    }

    public Integer max(List<Integer> list) {
        return list
                .stream()
                .reduce(Integer::max).get();
    }

    public Integer min(List<Integer> list) {
        return list
                .stream()
                .reduce(Integer::min).get();
    }

    public List<Integer> odd(List<Integer> list) {
        // Filter stream with a predicate
        return list
                .stream()
                .filter(z -> z % 2 != 0) //lambda, yeah!
                .collect(Collectors.toList());
    }

    public List<Integer> even(List<Integer> list) {
        return list
                .stream()
                .filter(new Predicate<Integer>() { //non-lambda, just to see how it would be without lambdas
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .collect(Collectors.toList());
    }
}
