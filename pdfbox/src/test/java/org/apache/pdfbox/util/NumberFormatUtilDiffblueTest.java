package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NumberFormatUtilDiffblueTest {
  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '0.5'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_when05_thenReturnThree() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, NumberFormatUtil.formatFloatFast(0.5f, 3, asciiBuffer));
    assertArrayEquals("0.5XAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code -1.0E-5}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '-1.0E-5'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_when10e5_thenReturnEight() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(8, NumberFormatUtil.formatFloatFast(-1.0E-5f, 5, asciiBuffer));
    assertArrayEquals("-0.00001".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code -9.223372E18}.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName(
      "Test formatFloatFast(float, int, byte[]); when '-9.223372E18'; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_when9223372e18_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(-9.223372E18f, 5, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code 9.223373E18}.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName(
      "Test formatFloatFast(float, int, byte[]); when '9.223373E18'; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_when9223373e18_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223373E18f, 5, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName(
      "Test formatFloatFast(float, int, byte[]); when NaN; then 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_whenNaN_thenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(Float.NaN, 3, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName(
      "Test formatFloatFast(float, int, byte[]); when six; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_whenSix_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223372E18f, 6, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when ten; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_whenTen_thenReturnTwo() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(2, NumberFormatUtil.formatFloatFast(10.0f, 3, asciiBuffer));
    assertArrayEquals("10AXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberFormatUtil.formatFloatFast(float, int, byte[])"})
  void testFormatFloatFast_whenZero_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, NumberFormatUtil.formatFloatFast(0.5f, 0, asciiBuffer));
    assertArrayEquals("1XAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }
}
