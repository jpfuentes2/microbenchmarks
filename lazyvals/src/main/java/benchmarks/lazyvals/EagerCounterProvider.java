package benchmarks.lazyvals;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import benchmarks.lazyvals.SlowInitializer.Counter;

@State(Scope.Benchmark)
public class EagerCounterProvider {

    private final Counter counter = SlowInitializer.createCounter();

    public Counter getCounter() {
        return counter;
    }
}
