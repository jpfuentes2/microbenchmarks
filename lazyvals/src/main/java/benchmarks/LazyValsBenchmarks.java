package benchmarks;

import benchmarks.lazyvals.*;
import org.openjdk.jmh.annotations.Benchmark;

public class LazyValsBenchmarks {

    @Benchmark
    public long baseline(ValCounterProvider eagerProvider) {
        return eagerProvider.counter().incrementAndGet();
    }

    @Benchmark
    public long lazyValCounter(LazyValCounterProvider lazyProvider) {
        return lazyProvider.counter().incrementAndGet();
    }
}

