package io.github.ianfairman.example.prime;

public class OptimalSimpleSieve implements Sieve {
    private final boolean[] array;
    
    public OptimalSimpleSieve(long size) {
        array = new boolean[convertToInternalIndex(size) + 1];
    }
    
    public boolean isPrime(long index) {
        return !array[convertToInternalIndex(index)];
    }

    public void markAsCompoundNumber(long index) {
        array[convertToInternalIndex(index)] = true;
    }
    
    private int convertToInternalIndex(long index) {
        return (int) (index - 1L)/2;
    }
}
