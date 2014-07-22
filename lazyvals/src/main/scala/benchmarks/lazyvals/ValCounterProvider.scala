package benchmarks.lazyvals

import org.openjdk.jmh.annotations.{Scope, State}

@State(Scope.Benchmark)
class ValCounterProvider {
  val counter = SlowInitializer.createCounter()
}
