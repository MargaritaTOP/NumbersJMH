package top.academy;

import java.util.Arrays;

public class ArrayTest {
    public static int[] array3or5(int[] array) {
        int[] temp = new int[array.length];
        int count = 0;
        for (int num : array) {
            if (CommonMethods.isDivisibleBy3Or5(num)) {
                temp[count++] = num;
            }
        }
        return Arrays.copyOf(temp, count);
    }
    public static int[] arrayPrime(int[] array) {
        int[] temp = new int[array.length];
        int count = 0;
        for (int num : array) {
            if (CommonMethods.isPrime(num)) {
                temp[count++] = num;
            }
        }
        return Arrays.copyOf(temp, count);
    }
    public static double arrayAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    public static long arraySame(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        long maxCount = 1;
        long currentCount = 1;
        int currentNum = sorted[0];
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == currentNum) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentNum = sorted[i];
                currentCount = 1;
            }
        }
        return maxCount;
    }
}