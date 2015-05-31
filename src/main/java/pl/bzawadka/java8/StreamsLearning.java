package pl.bzawadka.java8;

import java.util.List;

public class StreamsLearning {

    public Integer sum(List<Integer> list) {
        return list
                .stream()
                .reduce(Integer::sum).get();
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
}
