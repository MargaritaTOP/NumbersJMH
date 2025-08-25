package top.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class FJTest extends RecursiveTask<Object> {
    private final List<Integer> data;
    private final String method;

    public FJTest(List<Integer> data, String method) {
        this.data = data;
        this.method = method;
    }
    @Override
    protected Object compute() {
        if (data.size() <= 10_000) {
            return switch (method) {
                case "3or5" -> data.stream()
                        .filter(CommonMethods::isDivisibleBy3Or5)
                        .collect(Collectors.toList());
                case "prime" -> data.stream()
                        .filter(CommonMethods::isPrime)
                        .collect(Collectors.toList());
                case "average" -> data.stream()
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .orElse(0.0);
                case "same" -> {
                    Map<Integer, Long> frequencyMap = data.stream()
                            .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
                    yield frequencyMap.values().stream()
                            .max(Long::compare)
                            .orElse(0L);
                }
                default -> throw new IllegalArgumentException("Неизвестный метод: " + method);
            };
        }
        else {
            int mid = data.size() / 2;
            FJTest left = new FJTest(data.subList(0, mid), method);
            FJTest right = new FJTest(data.subList(mid, data.size()), method);
            left.fork();
            right.fork();
            Object leftResult = left.join();
            Object rightResult = right.join();
            switch (method) {
                case "3or5":
                case "prime":
                    @SuppressWarnings("unchecked")
                    List<Integer> leftList = (List<Integer>) leftResult;
                    @SuppressWarnings("unchecked")
                    List<Integer> rightList = (List<Integer>) rightResult;
                    List<Integer> result = new ArrayList<>(leftList);
                    result.addAll(rightList);
                    return result;
                case "average":
                    double leftAvg = (Double) leftResult;
                    double rightAvg = (Double) rightResult;
                    int leftSize = data.subList(0, mid).size();
                    int rightSize = data.subList(mid, data.size()).size();
                    return (leftAvg * leftSize + rightAvg * rightSize) / (leftSize + rightSize);
                case "same":
                    long leftMax = (Long) leftResult;
                    long rightMax = (Long) rightResult;
                    return Math.max(leftMax, rightMax);
                default:
                    throw new IllegalArgumentException("Неизвестный метод: " + method);
            }
        }
    }
    public static List<Integer> fj3or5(List<Integer> data) {
        ForkJoinPool pool = new ForkJoinPool();
        return (List<Integer>) pool.invoke(new FJTest(data, "3or5"));
    }
    public static List<Integer> fjPrime(List<Integer> data) {
        ForkJoinPool pool = new ForkJoinPool();
        return (List<Integer>) pool.invoke(new FJTest(data, "prime"));
    }
    public static double fjAverage(List<Integer> data) {
        ForkJoinPool pool = new ForkJoinPool();
        return (Double) pool.invoke(new FJTest(data, "average"));
    }
    public static long fjSame(List<Integer> data) {
        ForkJoinPool pool = new ForkJoinPool();
        return (Long) pool.invoke(new FJTest(data, "same"));
    }
}