package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFDocEncodingDiffblueTest {
  /**
   * Test {@link PDFDocEncoding#toString(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PDFDocEncoding#toString(byte[])}
   */
  @Test
  @DisplayName("Test toString(byte[]) with 'byte[]'")
  void testToStringWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", PDFDocEncoding.toString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PDFDocEncoding#getBytes(String)}.
   * <p>
   * Method under test: {@link PDFDocEncoding#getBytes(String)}
   */
  @Test
  @DisplayName("Test getBytes(String)")
  void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = PDFDocEncoding.getBytes("Text");

    // Assert
    assertArrayEquals("Text".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test {@link PDFDocEncoding#containsChar(char)}.
   * <p>
   * Method under test: {@link PDFDocEncoding#containsChar(char)}
   */
  @Test
  @DisplayName("Test containsChar(char)")
  void testContainsChar() {
    // Arrange, Act and Assert
    assertTrue(PDFDocEncoding.containsChar('A'));
  }
}
