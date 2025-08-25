package top.academy;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx4G"})
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class BenchmarkJMH {
    @Param({"10000"})
    private int size;
    private List<Integer> dataList;
    private int[] dataArray;
    @Setup(Level.Iteration)
    public void setup() {
        Random r = new Random();
        int max = 1000;
        dataList = r.ints(size, 1, max).boxed().toList();
        dataArray = r.ints(size, 1, max).toArray();
    }

    @Benchmark
    public int[] testArray3or5() {
        return ArrayTest.array3or5(dataArray);
    }

    @Benchmark
    public int[] testArrayPrime() {
        return ArrayTest.arrayPrime(dataArray);
    }

    @Benchmark
    public double testArrayAverage() {
        return ArrayTest.arrayAverage(dataArray);
    }

    @Benchmark
    public long testArraySame() {
        return ArrayTest.arraySame(dataArray);
    }

    @Benchmark
    public List<Integer> testCollection3or5() {
        return CollectionTest.collection3or5(dataList);
    }

    @Benchmark
    public List<Integer> testCollectionPrime() {
        return CollectionTest.collectionPrime(dataList);
    }

    @Benchmark
    public double testCollectionAverage() {
        return CollectionTest.collectionAverage(dataList);
    }

    @Benchmark
    public long testCollectionSame() {
        return CollectionTest.collectionSame(dataList);
    }

    @Benchmark
    public List<Integer> testPStream3or5() {
        return PStreamTest.pStream3or5(dataList);
    }

    @Benchmark
    public List<Integer> testPStreamPrime() {
        return PStreamTest.pStreamPrime(dataList);
    }

    @Benchmark
    public double testPStreamAverage() {
        return PStreamTest.pStreamAverage(dataList);
    }

    @Benchmark
    public long testPStreamSame() {
        return PStreamTest.pStreamSame(dataList);
    }

    @Benchmark
    public List<Integer> testCF3or5() throws Exception {
        return CFTest.cf3or5(dataList);
    }

    @Benchmark
    public List<Integer> testCFPrime() throws Exception {
        return CFTest.cfPrime(dataList);
    }

    @Benchmark
    public double testCFAverage() throws Exception {
        return CFTest.cfAverage(dataList);
    }

    @Benchmark
    public long testCFSame() throws Exception {
        return CFTest.cfSame(dataList);
    }

    @Benchmark
    public List<Integer> testFJ3or5() {
        return FJTest.fj3or5(dataList);
    }

    @Benchmark
    public List<Integer> testFJPrime() {
        return FJTest.fjPrime(dataList);
    }

    @Benchmark
    public double testFJAverage() {
        return FJTest.fjAverage(dataList);
    }

    @Benchmark
    public long testFJSame() {
        return FJTest.fjSame(dataList);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkJMH.class.getSimpleName())
                .result("benchmark-results.csv")  // Сохраняем в CSV
                .resultFormat(ResultFormatType.CSV)
                .build();
        new Runner(opt).run();
    }
}