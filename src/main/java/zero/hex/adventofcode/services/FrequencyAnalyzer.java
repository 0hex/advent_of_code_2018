package zero.hex.adventofcode.services;

import java.util.stream.Stream;

/**
 * A frequency analyzer.
 */
public class FrequencyAnalyzer {

  private final long initialFrequency;

  public FrequencyAnalyzer(long initialFrequency) {
    this.initialFrequency = initialFrequency;
  }

  /**
   * Calculate the resulting frequency after applying the deltas in the input.
   *
   * @param frequencyDeltas the frequency variations
   * @return the final frequency
   */
  public long getResult(Stream<String> frequencyDeltas) {
    // Convert strings to longs and add them to the initial frequency.
    return initialFrequency + frequencyDeltas.mapToLong(Long::parseLong).sum();
  }
}
