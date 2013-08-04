package io.github.ianfairman.example.prime;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PrimeGeneratorTest {

    private PrimeGenerator generator;
    private IntegerConsumer consumer;
    
    @Before
    public void createGenerator() {
        consumer = mock(IntegerConsumer.class);
        generator = new PrimeGenerator(consumer);
    }
    
    @Test
    public void shouldFind2ForMaxValueOf2() {
        // When
        generator.generate(2);
        // Then
        verify(consumer, times(1)).consume(2);
    }

    @Test
    public void shouldFind2And3ForMaxValueOf3() {
        // When
        generator.generate(3);
        // Then
        verify(consumer, times(1)).consume(2);
        verify(consumer, times(1)).consume(3);
    }
    
    @Test
    public void shouldFind2And3And5ForMaxValueOf6() {
        // When
        generator.generate(6);
        // Then
        verify(consumer, times(1)).consume(2);
        verify(consumer, times(1)).consume(3);
        verify(consumer, never()).consume(4);
        verify(consumer, times(1)).consume(5);
        verify(consumer, never()).consume(6);
    }
    
    @Test
    public void shouldFind2And3And5And7And11And13ForMaxValueOf16() {
        // When
        generator.generate(16);
        // Then
        verify(consumer, never()).consume(1);
        verify(consumer, times(1)).consume(2);
        verify(consumer, times(1)).consume(3);
        verify(consumer, never()).consume(4);
        verify(consumer, times(1)).consume(5);
        verify(consumer, never()).consume(6);
        verify(consumer, times(1)).consume(7);
        verify(consumer, never()).consume(8);
        verify(consumer, never()).consume(9);
        verify(consumer, never()).consume(10);
        verify(consumer, times(1)).consume(11);
        verify(consumer, never()).consume(12);
        verify(consumer, times(1)).consume(13);
        verify(consumer, never()).consume(14);
        verify(consumer, never()).consume(15);
        verify(consumer, never()).consume(16);
    }
    
    @Test
    public void shouldFind168PrimesUnder1000() {
        // When
        generator.generate(1000);
        // Then
        verify(consumer, times(168)).consume(anyInt());
        
    }
}
