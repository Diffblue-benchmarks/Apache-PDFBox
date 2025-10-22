package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CodespaceRangeDiffblueTest {
  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName("Test new CodespaceRange(byte[], byte[]); when array of byte with 'A'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenArrayOfByteWithA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new CodespaceRange(new byte[]{'A'}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return CodeLength is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName("Test new CodespaceRange(byte[], byte[]); when array of byte with zero; then return CodeLength is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenArrayOfByteWithZero_thenReturnCodeLengthIsEight() {
    // Arrange, Act and Assert
    assertEquals(8,
        (new CodespaceRange(new byte[]{0}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return CodeLength is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName("Test new CodespaceRange(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return CodeLength is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenAxaxaxaxBytesIsUtf8_thenReturnCodeLengthIsEight() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, (new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName("Test new CodespaceRange(byte[], byte[]); when empty array of byte; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenEmptyArrayOfByte_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CodespaceRange(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Test {@link CodespaceRange#getCodeLength()}.
   * <p>
   * Method under test: {@link CodespaceRange#getCodeLength()}
   */
  @Test
  @DisplayName("Test getCodeLength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CodespaceRange.getCodeLength()"})
  void testGetCodeLength() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, (new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   * <p>
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[]); given 'A'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_givenA_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange = new CodespaceRange(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[]); when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).matches(new byte[]{}));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   * <p>
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int); given 'A'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_givenA_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange = new CodespaceRange(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int); when three; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_whenThree_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 3));
  }
}
