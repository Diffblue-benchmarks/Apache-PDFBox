package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class RC4CipherDiffblueTest {
  /**
   * Method under test: {@link RC4Cipher#setKey(byte[])}
   */
  @Test
  void testSetKey() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new RC4Cipher()).setKey(new byte[]{}));
  }

  /**
   * Method under test: {@link RC4Cipher#write(byte, OutputStream)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    rc4Cipher.write((byte) 'A', output);

    // Assert
    assertArrayEquals(new byte[]{'A'}, output.toByteArray());
  }

  /**
   * Method under test: {@link RC4Cipher#write(InputStream, OutputStream)}
   */
  @Test
  void testWrite2() throws IOException {
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

  /**
   * Method under test: {@link RC4Cipher#write(byte[], int, int, OutputStream)}
   */
  @Test
  void testWrite3() throws IOException {
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
   * Method under test: {@link RC4Cipher#write(byte[], OutputStream)}
   */
  @Test
  void testWrite4() throws IOException {
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
}
