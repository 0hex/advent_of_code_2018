package zero.hex.adventofcode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @Test
  void should_accept_file() throws URISyntaxException {
    URL url = Thread.currentThread().getContextClassLoader().getResource("input.txt");
    String path = new URI(url.toString()).getPath();
    assertDoesNotThrow(() ->
        Application.main(new String[]{path})
    );
  }

  @Test
  void should_fail_if_no_args() {
    assertThrows(IllegalArgumentException.class, () -> Application.main(new String[]{}));
  }
}