package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RC4CipherDiffblueTest {
  /**
   * Test {@link RC4Cipher#setKey(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RC4Cipher#setKey(byte[])}
   */
  @Test
  @DisplayName("Test setKey(byte[]); when empty array of byte; then throw IllegalArgumentException")
  void testSetKey_whenEmptyArrayOfByte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new RC4Cipher()).setKey(new byte[]{}));
  }

  /**
   * Test {@link RC4Cipher#write(byte[], int, int, OutputStream)} with
   * {@code byte[]}, {@code int}, {@code int}, {@code OutputStream}.
   * <p>
   * Method under test: {@link RC4Cipher#write(byte[], int, int, OutputStream)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int, OutputStream) with 'byte[]', 'int', 'int', 'OutputStream'")
  void testWriteWithByteIntIntOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    rc4Cipher.write(data, 2, 3, output);

    // Assert
    byte[] expectedToByteArrayResult = "AXA".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(byte, OutputStream)} with {@code byte},
   * {@code OutputStream}.
   * <p>
   * Method under test: {@link RC4Cipher#write(byte, OutputStream)}
   */
  @Test
  @DisplayName("Test write(byte, OutputStream) with 'byte', 'OutputStream'")
  void testWriteWithByteOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    rc4Cipher.write((byte) 'A', output);

    // Assert
    assertArrayEquals(new byte[]{'A'}, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(byte[], OutputStream)} with {@code byte[]},
   * {@code OutputStream}.
   * <p>
   * Method under test: {@link RC4Cipher#write(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test write(byte[], OutputStream) with 'byte[]', 'OutputStream'")
  void testWriteWithByteOutputStream2() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    rc4Cipher.write(data, output);

    // Assert
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(InputStream, OutputStream)} with
   * {@code InputStream}, {@code OutputStream}.
   * <p>
   * Method under test: {@link RC4Cipher#write(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test write(InputStream, OutputStream) with 'InputStream', 'OutputStream'")
  void testWriteWithInputStreamOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    ByteArrayInputStream data = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    rc4Cipher.write(data, output);

    // Assert
    assertEquals(-1, data.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}
