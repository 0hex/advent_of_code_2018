package zero.hex.adventofcode.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FrequencyAnalyzerTest {

  @Test
  void should_return_initial_frequency_on_empty_input() {
    final long initialFrequency = 0L;
    Stream<String> input = Stream.of();
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);
    sut.analyze(input);

    assertEquals(initialFrequency, sut.getFrequency().longValue());
  }

  @Test
  void should_return_initial_frequency_on_balanced_input() {
    final long initialFrequency = 0L;
    Stream<String> input = Stream.of("1", "-1");
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);
    sut.analyze(input);

    assertEquals(initialFrequency, sut.getFrequency().longValue());
  }

  @Test
  void should_fail_if_no_analysis_was_run() {
    final long initialFrequency = 0L;
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);

    assertNull(sut.getFirstRepeatedFrequency());
    assertEquals(initialFrequency, sut.getFrequency().longValue());
  }

  @Test
  void should_find_the_first_repeated_frequency() {
    final long initialFrequency = 0L;
    Stream<String> input = Stream.of("1", "2", "3", "4", "-7");
    FrequencyAnalyzer sut = new FrequencyAnalyzer(initialFrequency);
    sut.analyze(input);

    assertNotNull(sut.getFirstRepeatedFrequency());
    assertEquals(3L, sut.getFirstRepeatedFrequency().longValue());
  }

}