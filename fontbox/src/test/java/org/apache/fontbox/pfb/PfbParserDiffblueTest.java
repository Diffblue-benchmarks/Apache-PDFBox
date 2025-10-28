package org.apache.fontbox.pfb;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class PfbParserDiffblueTest {
  /**
   * Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  void testNewPfbParser() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    assertThrows(IOException.class, () -> new PfbParser(new ByteArrayInputStream(
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3})));
    assertThrows(IOException.class, () -> new PfbParser("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(IOException.class, () -> new PfbParser(
        new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
    assertThrows(IOException.class, () -> new PfbParser(new byte[]{Byte.MIN_VALUE, 'A', 'A', 3, 'A', 3, 'A', 3, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
    assertThrows(EOFException.class, () -> new PfbParser(new byte[]{Byte.MIN_VALUE, 1, 'A', 3, 'A', 3, 'A', 3, 'A', 3,
        'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }

  /**
   * Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  void testNewPfbParser2() throws IOException {
    // Arrange and Act
    PfbParser actualPfbParser = new PfbParser(new byte[]{Byte.MIN_VALUE, 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A',
        3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Assert
    assertEquals(-1, actualPfbParser.getInputStream().read(new byte[]{}));
    assertEquals(0, actualPfbParser.size());
    assertEquals(0, actualPfbParser.getPfbdata().length);
    assertEquals(0, actualPfbParser.getSegment1().length);
    assertEquals(0, actualPfbParser.getSegment2().length);
    assertArrayEquals(new int[]{0, 0, 0}, actualPfbParser.getLengths());
  }
}
