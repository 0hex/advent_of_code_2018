package zero.hex.adventofcode.services;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * A frequency analyzer.
 */
public class FrequencyAnalyzer {

  private final AtomicLong accumulatedFrequency;
  private Long firstRepeatedFrequency;
  private Set<Long> frequencies = new HashSet<>();

  public FrequencyAnalyzer(long initialFrequency) {
    accumulatedFrequency = new AtomicLong(initialFrequency);
  }

  /**
   * Calculate the resulting frequency after applying the deltas in the input.
   *
   * @param frequencyDeltas the frequency variations
   * @return the final frequency
   */
  public void analyze(Stream<String> frequencyDeltas) {
    // Convert strings to longs and add them to the initial frequency. Also, report the first frequency that is reached more than once.

    frequencyDeltas.forEach(frequencyDeltaString -> {
      // Convert the frequency delta to a number.
      Long frequencyDelta = Long.parseLong(frequencyDeltaString);

      // Update the accumulated frequency.
      accumulatedFrequency.addAndGet(frequencyDelta);

      // If a repeated frequency has not yet been found
      if (null == firstRepeatedFrequency) {
        long currentAccumulatedFrequency = accumulatedFrequency.longValue();
        // ... and it cannot be added to the frequencies list...
        if (!frequencies.add(currentAccumulatedFrequency)) {
          // ... it is the first repeated frequency
          firstRepeatedFrequency = accumulatedFrequency.longValue();
        }
      }
    });
  }

  /**
   * @return the accumulated frequency
   */
  public Long getFrequency() {
    return accumulatedFrequency.longValue();
  }

  /**
   * @return the first repeated frequency.
   */
  public Long getFirstRepeatedFrequency() {
    return firstRepeatedFrequency;
  }
}
