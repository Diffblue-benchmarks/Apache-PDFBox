package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class NumberFormatUtilDiffblueTest {
  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(2, NumberFormatUtil.formatFloatFast(10.0f, 3, asciiBuffer));
    assertArrayEquals("10AXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast2() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223372E18f, 6, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast3() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(9.223373E18f, 5, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast4() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(-9.223372E18f, 5, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast5() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(8, NumberFormatUtil.formatFloatFast(-1.0E-5f, 5, asciiBuffer));
    assertArrayEquals("-0.00001".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast6() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, NumberFormatUtil.formatFloatFast(0.5f, 3, asciiBuffer));
    assertArrayEquals("0.5XAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast7() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, NumberFormatUtil.formatFloatFast(Float.NaN, 3, asciiBuffer));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }

  /**
   * Method under test:
   * {@link NumberFormatUtil#formatFloatFast(float, int, byte[])}
   */
  @Test
  void testFormatFloatFast8() throws UnsupportedEncodingException {
    // Arrange
    byte[] asciiBuffer = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, NumberFormatUtil.formatFloatFast(0.5f, 0, asciiBuffer));
    assertArrayEquals("1XAXAXAX".getBytes("UTF-8"), asciiBuffer);
  }
}
