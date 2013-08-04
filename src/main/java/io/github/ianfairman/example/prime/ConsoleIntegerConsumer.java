package io.github.ianfairman.example.prime;

public class ConsoleIntegerConsumer implements IntegerConsumer{

    public void consume(int number) {
        System.out.println(number);
    }
}
