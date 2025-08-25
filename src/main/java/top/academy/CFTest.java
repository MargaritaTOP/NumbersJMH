package top.academy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CFTest {
    public static List<Integer> cf3or5(List<Integer> collection) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() ->
                        collection.stream()
                                .filter(CommonMethods::isDivisibleBy3Or5)
                                .collect(Collectors.toList()),
                executor);
        List<Integer> result = future.get();
        executor.shutdown();
        return result;
    }
    public static List<Integer> cfPrime(List<Integer> collection) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() ->
                        collection.stream()
                                .filter(CommonMethods::isPrime)
                                .collect(Collectors.toList()),
                executor);
        List<Integer> result = future.get();
        executor.shutdown();
        return result;
    }
    public static double cfAverage(List<Integer> collection) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() ->
                        collection.stream()
                                .mapToDouble(Integer::doubleValue)
                                .average()
                                .orElse(0.0),
                executor);
        double result = future.get();
        executor.shutdown();
        return result;
    }
    public static long cfSame(List<Integer> collection) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            Map<Integer, Long> frequencyMap = collection.stream()
                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
            return frequencyMap.values().stream()
                    .max(Long::compare)
                    .orElse(0L);
        }, executor);
        long result = future.get();
        executor.shutdown();
        return result;
    }
}