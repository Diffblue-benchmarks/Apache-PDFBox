package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Type1ParserDiffblueTest {
  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse2() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse3() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse4() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> type1Parser.parse(new byte[]{0, '!', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse5() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!%XAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse6() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "A!(XAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse7() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "[!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse8() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();
    byte[] segment1 = "\t!AXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> type1Parser.parse(segment1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Parser#parse(byte[], byte[])}
   */
  @Test
  void testParse9() throws IOException {
    // Arrange
    Type1Parser type1Parser = new Type1Parser();

    // Act and Assert
    assertThrows(IOException.class,
        () -> type1Parser.parse(new byte[]{0, '!', '[', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
