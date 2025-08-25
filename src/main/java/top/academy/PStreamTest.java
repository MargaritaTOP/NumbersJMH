package top.academy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PStreamTest {
    public static List<Integer> pStream3or5(List<Integer> collection) {
        return collection.parallelStream()
                .filter(CommonMethods::isDivisibleBy3Or5) // (x) -> CommonMethods.isDivisibleBy3Or5(x)
                .collect(Collectors.toList());
    }
    public static List<Integer> pStreamPrime(List<Integer> collection) {
        return collection.parallelStream()
                .filter(CommonMethods::isPrime)
                .collect(Collectors.toList());
    }
    public static double pStreamAverage(List<Integer> collection) {
        return collection.parallelStream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }
    public static long pStreamSame(List<Integer> collection) {
        Map<Integer, Long> frequencyMap = collection.parallelStream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        return frequencyMap.values().parallelStream()
                .max(Long::compare)
                .orElse(0L);
    }
}