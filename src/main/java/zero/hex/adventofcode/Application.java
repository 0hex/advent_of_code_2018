package zero.hex.adventofcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import zero.hex.adventofcode.services.FrequencyAnalyzer;

/**
 * A CLI interface to the frequency analyzer service.
 */
public class Application {

  private static final long INITIAL_FREQUENCY = 0;

  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      throw new IllegalArgumentException("An input file is required");
    }

    // Initialise the frequency analyser.
    FrequencyAnalyzer fa = new FrequencyAnalyzer(INITIAL_FREQUENCY);

    try (InputStream is = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Stream<String> frequencyDeltas = reader.lines()) {
      // Emit the result of analysing the frequencies.
      System.out.println(fa.getResult(frequencyDeltas));
    }
  }
}
