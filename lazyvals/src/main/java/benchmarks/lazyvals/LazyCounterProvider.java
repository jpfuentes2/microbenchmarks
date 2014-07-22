package benchmarks.lazyvals;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import benchmarks.lazyvals.SlowInitializer.Counter;

@State(Scope.Benchmark)
public class LazyCounterProvider {

    private Counter counter;
    private volatile boolean initialized;

    public Counter getCounter() {
        if(this.initialized) {
            return this.counter;
        } else {
            return init();
        }
    }

    private Counter init() {
        synchronized(this) {
            if(!this.initialized) {
                this.counter = SlowInitializer.createCounter();
                this.initialized = true;
            }
            return this.counter;
        }
    }
}
