package benchmarks;

import benchmarks.lazyvals.*;
import org.openjdk.jmh.annotations.Benchmark;

public class LazyValsBenchmarks {

    @Benchmark
    public long baseline(ValCounterProvider eagerProvider1, ValCounterProvider2 eagerProvider2) {
        return eagerProvider1.counter().incrementAndGet();
    }

    @Benchmark
    public long lazyValCounter(LazyValCounterProvider lazyProvider) {
        return lazyProvider.counter().incrementAndGet();
    }
}

