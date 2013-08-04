package io.github.ianfairman.example.prime;

public class PrimeGenerator {

    private IntegerConsumer consumer;

    public PrimeGenerator(IntegerConsumer consumer) {
        this.consumer = consumer;
    }
    
    public void generate(int max) {
        Sieve sieve = new OptimalSimpleSieve(max);
        if (2 <= max) {
            consumer.consume(2);
        }
        double maxAsDouble = Integer.valueOf(max).doubleValue();
        int maxToSieve = Double.valueOf(Math.sqrt(maxAsDouble)).intValue() + 1;
        int current = 3;
        while (current <= max) {
            if (sieve.isPrime(current)) {
                consumer.consume(current);
                if (current < maxToSieve) {
                    int compoundNumberToExclude = current * current;
                    while (compoundNumberToExclude <= max) {
                        sieve.markAsCompoundNumber(compoundNumberToExclude);
                        compoundNumberToExclude += 2 * current;
                    }
                }
            }
            current = current + 2;
        }
    }
}
