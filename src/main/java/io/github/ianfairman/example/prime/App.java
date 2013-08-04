package io.github.ianfairman.example.prime;

public class App {
    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();
        PrimeGenerator generator = new PrimeGenerator(new ConsoleIntegerConsumer());
        generator.generate(1000000);
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Milliseconds: " + (endTime - startTime));
    }
}
