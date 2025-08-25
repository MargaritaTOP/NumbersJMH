package top.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionTest {
    public static List<Integer> collection3or5(List<Integer> collection) {
        List<Integer> result = new ArrayList<>(collection);
        result.removeIf(num -> !CommonMethods.isDivisibleBy3Or5(num));
        return result;
    }
    public static List<Integer> collectionPrime(List<Integer> collection) {
        List<Integer> result = new ArrayList<>(collection);
        result.removeIf(num -> !CommonMethods.isPrime(num));
        return result;
    }
    public static double collectionAverage(List<Integer> collection) {
        int sum = 0;
        for (int num : collection) {
            sum += num;
        }
        return (double) sum / collection.size();
    }
    public static long collectionSame(List<Integer> collection) {
        Map<Integer, Long> frequencyMap = collection.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        return frequencyMap.values().stream()
                .max(Long::compare)
                .orElse(0L);
    }
}