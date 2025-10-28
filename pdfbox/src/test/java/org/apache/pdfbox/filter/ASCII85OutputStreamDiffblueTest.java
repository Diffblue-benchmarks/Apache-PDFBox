package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class ASCII85OutputStreamDiffblueTest {
  /**
   * Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  void testSetTerminator() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ASCII85OutputStream(new ByteArrayOutputStream(1))).setTerminator('A'));
    assertThrows(IllegalArgumentException.class,
        () -> (new ASCII85OutputStream(new ByteArrayOutputStream(1))).setTerminator(''));
    assertThrows(IllegalArgumentException.class,
        () -> (new ASCII85OutputStream(new ByteArrayOutputStream(1))).setTerminator('z'));
  }

  /**
   * Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  void testSetTerminator2() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream(1));

    // Act
    ascii85OutputStream.setTerminator('v');

    // Assert
    assertEquals('v', ascii85OutputStream.getTerminator());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ASCII85OutputStream#getLineLength()}
   *   <li>{@link ASCII85OutputStream#getTerminator()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream(1));

    // Act
    int actualLineLength = ascii85OutputStream.getLineLength();

    // Assert
    assertEquals('~', ascii85OutputStream.getTerminator());
    assertEquals(72, actualLineLength);
  }

  /**
   * Method under test: {@link ASCII85OutputStream#setLineLength(int)}
   */
  @Test
  void testSetLineLength() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream(1));

    // Act
    ascii85OutputStream.setLineLength(1);

    // Assert
    assertEquals(1, ascii85OutputStream.getLineLength());
  }

  /**
   * Method under test: {@link ASCII85OutputStream#setLineLength(int)}
   */
  @Test
  void testSetLineLength2() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream(1));

    // Act
    ascii85OutputStream.setLineLength(72);

    // Assert
    assertEquals(72, ascii85OutputStream.getLineLength());
  }

  /**
   * Method under test:
   * {@link ASCII85OutputStream#ASCII85OutputStream(OutputStream)}
   */
  @Test
  void testNewASCII85OutputStream() {
    // Arrange and Act
    ASCII85OutputStream actualAscii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream(1));

    // Assert
    assertEquals('~', actualAscii85OutputStream.getTerminator());
    assertEquals(72, actualAscii85OutputStream.getLineLength());
  }
}
