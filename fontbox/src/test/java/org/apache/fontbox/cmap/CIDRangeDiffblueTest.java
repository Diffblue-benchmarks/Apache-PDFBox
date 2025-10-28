package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class CIDRangeDiffblueTest {
  /**
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  void testMap() {
    // Arrange, Act and Assert
    assertEquals(3, (new CIDRange(3, 3, 3, 3)).map(3, 3));
    assertEquals(-1, (new CIDRange(3, 1, 3, 3)).map(3, 3));
    assertEquals(-1, (new CIDRange(3, 3, 3, 1)).map(3, 3));
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(1, 3));
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(0, 3));
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(-1, 3));
    assertEquals(-1, (new CIDRange(1, 1, 1, 8)).map(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
    assertEquals(2136490329,
        (new CIDRange(Integer.MIN_VALUE, 1, 1, 8)).map(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  void testMap2() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  void testMap3() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 8);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  void testMap4() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(8, 1, 1, 8);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  void testUnmap() {
    // Arrange, Act and Assert
    assertEquals(1, (new CIDRange(1, 1, 1, 3)).unmap(1));
    assertEquals(-1, (new CIDRange(Integer.MIN_VALUE, 1, 1, 3)).unmap(1));
    assertEquals(-1, (new CIDRange(1, 1, 1, 3)).unmap(0));
  }

  /**
   * Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  void testExtend() {
    // Arrange, Act and Assert
    assertFalse((new CIDRange(1, 1, 1, 3)).extend(1, 1, 1, 3));
    assertTrue((new CIDRange(1, 0, 1, 3)).extend(1, 1, 1, 3));
    assertFalse((new CIDRange(1, 1, 1, 1)).extend(1, 1, 1, 3));
    assertFalse((new CIDRange(1, 1, 1, 3)).extend(2, 1, 1, 3));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CIDRange#CIDRange(int, int, int, int)}
   *   <li>{@link CIDRange#getCodeLength()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(3, (new CIDRange(1, 1, 1, 3)).getCodeLength());
  }
}
