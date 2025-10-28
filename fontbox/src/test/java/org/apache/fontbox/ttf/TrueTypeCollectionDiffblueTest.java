package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class TrueTypeCollectionDiffblueTest {
  /**
   * Method under test: {@link TrueTypeCollection#TrueTypeCollection(InputStream)}
   */
  @Test
  void testNewTrueTypeCollection() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> new TrueTypeCollection(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }
}
