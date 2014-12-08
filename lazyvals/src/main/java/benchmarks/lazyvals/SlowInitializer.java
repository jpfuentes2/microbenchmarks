package benchmarks.lazyvals;

public class SlowInitializer {

    private SlowInitializer() { }

    public static class Counter {

        private int value = 0;

        private Counter() { }

        public int incrementAndGet() {
            return ++value;
        }
    }

    public static Counter createCounter() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Counter();
    }
}
