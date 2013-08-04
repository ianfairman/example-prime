package io.github.ianfairman.example.prime;

public class SimpleSieve implements Sieve {

    private final boolean[] array;
    
    public SimpleSieve(long size) {
        array = new boolean[(int)size + 1];
    }
    
    public boolean isPrime(long index) {
        return !array[(int)index];
    }

    public void markAsCompoundNumber(long index) {
        array[(int)index] = true;
    }
}
