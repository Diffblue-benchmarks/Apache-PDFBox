package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CodespaceRangeDiffblueTest {
  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test new CodespaceRange(byte[], byte[]); when array of byte with 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenArrayOfByteWithA_thenThrowIllegalArgumentException() {
    // Arrange
    byte[] startBytes = new byte[] {'A'};

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CodespaceRange(startBytes, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return CodeLength is eight.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test new CodespaceRange(byte[], byte[]); when array of byte with zero; then return CodeLength is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenArrayOfByteWithZero_thenReturnCodeLengthIsEight() {
    // Arrange
    byte[] startBytes = new byte[] {0};

    // Act
    CodespaceRange actualCodespaceRange =
        new CodespaceRange(startBytes, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(8, actualCodespaceRange.getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return CodeLength is eight.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test new CodespaceRange(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return CodeLength is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenAxaxaxaxBytesIsUtf8_thenReturnCodeLengthIsEight()
      throws UnsupportedEncodingException {
    // Arrange and Act
    CodespaceRange actualCodespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, actualCodespaceRange.getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#CodespaceRange(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test new CodespaceRange(byte[], byte[]); when empty array of byte; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodespaceRange.<init>(byte[], byte[])"})
  void testNewCodespaceRange_whenEmptyArrayOfByte_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CodespaceRange(new byte[] {}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CodespaceRange#getCodeLength()}.
   *
   * <p>Method under test: {@link CodespaceRange#getCodeLength()}
   */
  @Test
  @DisplayName("Test getCodeLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodespaceRange.getCodeLength()"})
  void testGetCodeLength() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(8, codespaceRange.getCodeLength());
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   *
   * <p>Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "\bXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatchesResult = codespaceRange.matches("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName(
      "Test matches(byte[]); given 'A'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_givenA_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange(
            new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatchesResult = codespaceRange.matches("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[]); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatchesResult = codespaceRange.matches("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualMatchesResult);
  }

  /**
   * Test {@link CodespaceRange#matches(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  @DisplayName("Test matches(byte[]); when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.matches(byte[])"})
  void testMatches_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatchesResult = codespaceRange.matches(new byte[] {});

    // Assert
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   *
   * <p>Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int); when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_whenA_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(
        codespaceRange.isFullMatch(
            new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}, 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test isFullMatch(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test {@link CodespaceRange#isFullMatch(byte[], int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  @DisplayName("Test isFullMatch(byte[], int); when three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodespaceRange.isFullMatch(byte[], int)"})
  void testIsFullMatch_whenThree_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange =
        new CodespaceRange("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 3));
  }
}
