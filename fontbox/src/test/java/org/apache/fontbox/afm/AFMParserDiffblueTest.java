package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class AFMParserDiffblueTest {
  /**
   * Method under test: {@link AFMParser#parse()}
   */
  @Test
  void testParse() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).parse());
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")))).parse());
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8")))).parse());
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).parse(true));
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("\tXAXAXAX".getBytes("UTF-8")))).parse(true));
    assertThrows(IOException.class,
        () -> (new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8")))).parse(true));
  }
}
