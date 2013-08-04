package io.github.ianfairman.example.prime;

public interface Sieve {

    boolean isPrime(long index);
    
    void markAsCompoundNumber(long index);
}
