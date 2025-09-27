package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CIDRangeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CIDRange#CIDRange(int, int, int, int)}
   *   <li>{@link CIDRange#getCodeLength()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CIDRange.<init>(int, int, int, int)", "int CIDRange.getCodeLength()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CIDRange actualCidRange = new CIDRange(1, 1, 1, 3);

    // Assert
    assertEquals(3, actualCidRange.getCodeLength());
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(byte[])"})
  void testMapWithBytes() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act
    int actualMapResult = cidRange.map("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, actualMapResult);
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(byte[])"})
  void testMapWithBytes2() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 8);

    // Act
    int actualMapResult = cidRange.map("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, actualMapResult);
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(byte[])"})
  void testMapWithBytes3() throws UnsupportedEncodingException {
    // Arrange
    CIDRange cidRange = new CIDRange(8, 1, 1, 8);

    // Act
    int actualMapResult = cidRange.map("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, actualMapResult);
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(byte[])"})
  void testMapWithBytes4() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 8);

    // Act
    int actualMapResult = cidRange.map(new byte[] {'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'});

    // Assert
    assertEquals(-1, actualMapResult);
  }

  /**
   * Test {@link CIDRange#map(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return {@code 2136490329}.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#map(byte[])}
   */
  @Test
  @DisplayName("Test map(byte[]) with 'bytes'; then return '2136490329'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(byte[])"})
  void testMapWithBytes_thenReturn2136490329() {
    // Arrange
    CIDRange cidRange = new CIDRange(Integer.MIN_VALUE, 1, 1, 8);

    // Act
    int actualMapResult = cidRange.map(new byte[] {'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'});

    // Assert
    assertEquals(2136490329, actualMapResult);
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 1, 3, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map(3, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength2() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 3, 3, 1);

    // Act and Assert
    assertEquals(-1, cidRange.map(3, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength_thenReturnThree() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 3, 3, 3);

    // Act and Assert
    assertEquals(3, cidRange.map(3, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength_whenMinusOne() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 3, 3, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map(-1, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength_whenOne() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 3, 3, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map(1, 3));
  }

  /**
   * Test {@link CIDRange#map(int, int)} with {@code code}, {@code length}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#map(int, int)}
   */
  @Test
  @DisplayName("Test map(int, int) with 'code', 'length'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.map(int, int)"})
  void testMapWithCodeLength_whenZero() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 3, 3, 3);

    // Act and Assert
    assertEquals(-1, cidRange.map(0, 3));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   *
   * <p>Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.unmap(int)"})
  void testUnmap() {
    // Arrange
    CIDRange cidRange = new CIDRange(Integer.MIN_VALUE, 1, 1, 3);

    // Act and Assert
    assertEquals(-1, cidRange.unmap(1));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.unmap(int)"})
  void testUnmap_thenReturnOne() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act and Assert
    assertEquals(1, cidRange.unmap(1));
  }

  /**
   * Test {@link CIDRange#unmap(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#unmap(int)}
   */
  @Test
  @DisplayName("Test unmap(int); when zero; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDRange.unmap(int)"})
  void testUnmap_whenZero_thenReturnMinusOne() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act and Assert
    assertEquals(-1, cidRange.unmap(0));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   *
   * <p>Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CIDRange.extend(int, int, int, int)"})
  void testExtend() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 3);

    // Act and Assert
    assertFalse(cidRange.extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   *
   * <p>Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CIDRange.extend(int, int, int, int)"})
  void testExtend2() {
    // Arrange
    CIDRange cidRange = new CIDRange(3, 0, 1, 3);

    // Act and Assert
    assertFalse(cidRange.extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link CIDRange#CIDRange(int, int, int, int)} with from is one and to is one and
   *       unicode is one and codeLength is one.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test extend(int, int, int, int); given CIDRange(int, int, int, int) with from is one and to is one and unicode is one and codeLength is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CIDRange.extend(int, int, int, int)"})
  void testExtend_givenCIDRangeWithFromIsOneAndToIsOneAndUnicodeIsOneAndCodeLengthIsOne() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 1, 1, 1);

    // Act and Assert
    assertFalse(cidRange.extend(1, 1, 1, 3));
  }

  /**
   * Test {@link CIDRange#extend(int, int, int, int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CIDRange#extend(int, int, int, int)}
   */
  @Test
  @DisplayName("Test extend(int, int, int, int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CIDRange.extend(int, int, int, int)"})
  void testExtend_thenReturnTrue() {
    // Arrange
    CIDRange cidRange = new CIDRange(1, 0, 1, 3);

    // Act and Assert
    assertTrue(cidRange.extend(1, 1, 1, 3));
  }
}
