package benchmarks;

import benchmarks.lazyvals.EagerCounterProvider;
import benchmarks.lazyvals.LazyCounterProvider;
import benchmarks.lazyvals.LazyValCounterProvider;
import benchmarks.lazyvals.ValCounterProvider;
import org.openjdk.jmh.annotations.Benchmark;

public class LazyValsBenchmarks {

    @Benchmark
    public long measureJavaLazyCounterPerformance(LazyCounterProvider lazyProvider) {
        return lazyProvider.getCounter().incrementAndGet();
    }

    @Benchmark
    public long measureJavaEagerCounterPerformance(EagerCounterProvider eagerProvider) {
        return eagerProvider.getCounter().incrementAndGet();
    }

    @Benchmark
    public long measureScalaEagerCounterPerformance(ValCounterProvider eagerProvider) {
        return eagerProvider.counter().incrementAndGet();
    }

    @Benchmark
    public long measureScalaLazyCounterPerformance(LazyValCounterProvider lazyProvider) {
        return lazyProvider.counter().incrementAndGet();
    }
}
