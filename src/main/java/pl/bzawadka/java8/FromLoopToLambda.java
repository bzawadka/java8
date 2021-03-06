package pl.bzawadka.java8;

import java.util.*;

/**
 * from for loop to lambda
 * inspired by http://blog.takipi.com/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/
 */
public class FromLoopToLambda {
    private static final int TEST_DATA_SET_SIZE = 100;
    private static final int TEST_DATA_BOUND = 10000;
    private List<Integer> dataSet;

    public FromLoopToLambda() {
        dataSet = new ArrayList<>(TEST_DATA_SET_SIZE);
        populateDataSet(dataSet);
    }

    private List<Integer> populateDataSet(List<Integer> dataSet) {
        Random random = new Random();
        for (int i = 0; i < TEST_DATA_SET_SIZE; i++) {
            dataSet.add(random.nextInt(TEST_DATA_BOUND));
        }
        return dataSet;
    }

    public int forMinInteger() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dataSet.size(); i++) {
            min = Integer.min(min, dataSet.get(i));
        }
        return min;
    }

    public int forEachMinInteger() {
        int min = Integer.MAX_VALUE;
        for (Integer i : dataSet) {
            min = Integer.min(min, i);
        }
        return min;
    }

    public int iteratorMinInteger() {
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = dataSet.iterator();
        while (iterator.hasNext()) {
            min = Integer.min(min, iterator.next());
        }
        return min;
    }

    public int parallelStreamMinInteger() {
        return dataSet.parallelStream().reduce(Integer::min).get();
    }

    public int streamMinInteger() {
        return dataSet.stream().reduce(Integer::min).get();
    }

    public int lambdaMinInteger() {
        return dataSet.stream().reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b));
    }

    /**
     * be careful with forEach: http://stackoverflow.com/questions/16635398/java-8-iterable-foreach-vs-foreach-loop/20177092#20177092
     */
    public int forEachLambdaMinInteger() {
        final Wrapper minWrapper = new Wrapper();
        minWrapper.value = Integer.MAX_VALUE;
        dataSet.forEach(i -> minHelper(i, minWrapper));
        return minWrapper.value;
    }

    private int minHelper(Integer a, Wrapper b) {
        b.value = Integer.min(a, b.value);
        return b.value;
    }

    public static class Wrapper {
        public Integer value;
    }
}
