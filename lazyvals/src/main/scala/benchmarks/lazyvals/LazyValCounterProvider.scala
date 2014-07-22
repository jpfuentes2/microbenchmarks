package benchmarks.lazyvals

import org.openjdk.jmh.annotations.{Scope, State}

@State(Scope.Benchmark)
class LazyValCounterProvider {
  lazy val counter = SlowInitializer.createCounter()
}
