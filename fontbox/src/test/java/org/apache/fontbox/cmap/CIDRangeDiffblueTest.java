package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CIDRangeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CIDRange#CIDRange(int, int, int, int)}
   *   <li>{@link CIDRange#getCodeLength()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(3, (new CIDRange(1, 1, 1, 3)).getCodeLength());
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  void testMapWithBytes() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  void testMapWithBytes2() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 8);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  void testMapWithBytes3() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(8, 1, 1, 8);

    // Act and Assert
    assertEquals(-1, cidRange.map("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  void testMapWithBytes4() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(1, 1, 1, 8)).map(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then return {@code 2136490329}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'; then return '2136490329'")
  void testMapWithBytes_thenReturn2136490329() {
    // Arrange, Act and Assert
    assertEquals(2136490329,
        (new CIDRange(Integer.MIN_VALUE, 1, 1, 8)).map(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   * <p>
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'")
  void testMapWithCodeLength() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(3, 1, 3, 3)).map(3, 3));
    assertEquals(-1, (new CIDRange(3, 3, 3, 1)).map(3, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; then return three")
  void testMapWithCodeLength_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, (new CIDRange(3, 3, 3, 3)).map(3, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when minus one")
  void testMapWithCodeLength_whenMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(-1, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when one")
  void testMapWithCodeLength_whenOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(1, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when zero")
  void testMapWithCodeLength_whenZero() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(3, 3, 3, 3)).map(0, 3));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   * <p>
   * Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int)")
  void testUnmap() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(Integer.MIN_VALUE, 1, 1, 3)).unmap(1));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int); then return one")
  void testUnmap_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new CIDRange(1, 1, 1, 3)).unmap(1));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int); when zero; then return minus one")
  void testUnmap_whenZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CIDRange(1, 1, 1, 3)).unmap(0));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   * <p>
   * Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int)")
  void testExtend() {
    // Arrange, Act and Assert
    assertFalse((new CIDRange(1, 1, 1, 3)).extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link CIDRange#CIDRange(int, int, int, int)} with from is one and
   * to is one and unicode is one and codeLength is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int); given CIDRange(int, int, int, int) with from is one and to is one and unicode is one and codeLength is one")
  void testExtend_givenCIDRangeWithFromIsOneAndToIsOneAndUnicodeIsOneAndCodeLengthIsOne() {
    // Arrange, Act and Assert
    assertFalse((new CIDRange(1, 1, 1, 1)).extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int); then return 'true'")
  void testExtend_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CIDRange(1, 0, 1, 3)).extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int); when two")
  void testExtend_whenTwo() {
    // Arrange, Act and Assert
    assertFalse((new CIDRange(1, 1, 1, 3)).extend(2, 1, 1, 3));
  }
}
