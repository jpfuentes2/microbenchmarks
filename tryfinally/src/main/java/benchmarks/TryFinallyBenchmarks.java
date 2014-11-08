package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TryFinallyBenchmarks {

    long counter = 100000000L;

    @Benchmark
    public int baseline() {
        int result = (counter + "").hashCode();
        counter++;
        return result;
    }

    @Benchmark
    public int measureTryFinallyOverhead() {
        try {
            return (counter + "").hashCode();
        } finally {
            counter++;
        }
    }
}
