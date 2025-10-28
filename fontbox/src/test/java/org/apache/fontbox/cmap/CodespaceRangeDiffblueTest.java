package org.apache.fontbox.cmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class CodespaceRangeDiffblueTest {
  /**
   * Method under test: {@link CodespaceRange#getCodeLength()}
   */
  @Test
  void testGetCodeLength() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, (new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).getCodeLength());
  }

  /**
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  void testMatches() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  void testMatches2() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange = new CodespaceRange(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  void testMatches3() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.matches("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CodespaceRange#matches(byte[])}
   */
  @Test
  void testMatches4() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).matches(new byte[]{}));
  }

  /**
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  void testIsFullMatch() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  void testIsFullMatch2() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  void testIsFullMatch3() throws UnsupportedEncodingException {
    // Arrange
    CodespaceRange codespaceRange = new CodespaceRange(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Method under test: {@link CodespaceRange#isFullMatch(byte[], int)}
   */
  @Test
  void testIsFullMatch4() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");
    CodespaceRange codespaceRange = new CodespaceRange(startBytes, "\bXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(codespaceRange.isFullMatch("AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  void testNewCodespaceRange() throws UnsupportedEncodingException {
    // Arrange
    byte[] startBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, (new CodespaceRange(startBytes, "AXAXAXAX".getBytes("UTF-8"))).getCodeLength());
  }

  /**
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  void testNewCodespaceRange2() {
    // Arrange, Act and Assert
    assertEquals(8,
        (new CodespaceRange(new byte[]{0}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getCodeLength());
  }

  /**
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  void testNewCodespaceRange3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CodespaceRange(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Method under test: {@link CodespaceRange#CodespaceRange(byte[], byte[])}
   */
  @Test
  void testNewCodespaceRange4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new CodespaceRange(new byte[]{'A'}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

  }
}
