package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberFormatUtilDiffblueTest {
  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '0.5'; then return three")
  void testFormatFloatFast_when05_thenReturnThree() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, NumberFormatUtil.formatFloatFast(0.5f, 3, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('.', asciiBuffer[1]);
    assertEquals('0', asciiBuffer[0]);
    assertEquals('5', asciiBuffer[2]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When {@code -1.0E-5}.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '-1.0E-5'; then return eight")
  void testFormatFloatFast_when10e5_thenReturnEight() {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(8, NumberFormatUtil.formatFloatFast(-1.0E-5f, 5, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('-', asciiBuffer[0]);
    assertEquals('.', asciiBuffer[2]);
    assertEquals('0', asciiBuffer[3]);
    assertEquals('0', asciiBuffer[4]);
    assertEquals('0', asciiBuffer[5]);
    assertEquals('0', asciiBuffer[6]);
    assertEquals('1', asciiBuffer[7]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '-9.223372E18'; then return minus one")
  void testFormatFloatFast_when9223372e18_thenReturnMinusOne() {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(-9.223372E18f, 5, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('A', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
    assertEquals('X', asciiBuffer[1]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When {@code 9.223373E18}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when '9.223373E18'; then return minus one")
  void testFormatFloatFast_when9223373e18_thenReturnMinusOne() {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223373E18f, 5, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('A', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
    assertEquals('X', asciiBuffer[1]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when NaN; then return minus one")
  void testFormatFloatFast_whenNaN_thenReturnMinusOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(Float.NaN, 3, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('A', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
    assertEquals('X', asciiBuffer[1]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when six; then return minus one")
  void testFormatFloatFast_whenSix_thenReturnMinusOne() {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223372E18f, 6, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('A', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
    assertEquals('X', asciiBuffer[1]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when ten; then return two")
  void testFormatFloatFast_whenTen_thenReturnTwo() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(2, NumberFormatUtil.formatFloatFast(10.0f, 3, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('0', asciiBuffer[1]);
    assertEquals('1', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
  }

  /**
   * Test {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  @DisplayName("Test formatFloatFast(float, int, byte[]); when zero; then return one")
  void testFormatFloatFast_whenZero_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, NumberFormatUtil.formatFloatFast(0.5f, 0, asciiBuffer));
    assertEquals(8, asciiBuffer.length);
    assertEquals('1', asciiBuffer[0]);
    assertEquals('A', asciiBuffer[2]);
    assertEquals('X', asciiBuffer[1]);
  }
}
