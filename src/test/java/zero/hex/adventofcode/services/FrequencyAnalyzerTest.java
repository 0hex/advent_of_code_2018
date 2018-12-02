package zero.hex.adventofcode.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FrequencyAnalyzerTest {

  @Test
  void should_return_initial_frequency_on_empty_input() {
    final long initialFrequency = 0L;
    Stream<String> input = Stream.of();
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);

    assertEquals(initialFrequency, sut.getResult(input));
  }

  @Test
  void should_return_initial_frequency_on_balanced_input() {
    final long initialFrequency = 0L;
    Stream<String> input = Stream.of("1", "-1");
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);

    assertEquals(initialFrequency, sut.getResult(input));
  }
}