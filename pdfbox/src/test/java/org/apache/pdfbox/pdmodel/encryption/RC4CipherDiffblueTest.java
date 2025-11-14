package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RC4CipherDiffblueTest {
  /**
   * Test {@link RC4Cipher#setKey(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RC4Cipher#setKey(byte[])}
   */
  @Test
  @DisplayName("Test setKey(byte[]); when array of byte with minus one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.setKey(byte[])"})
  void testSetKey_whenArrayOfByteWithMinusOne_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new RC4Cipher().setKey(new byte[] {-1}));
  }

  /**
   * Test {@link RC4Cipher#setKey(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RC4Cipher#setKey(byte[])}
   */
  @Test
  @DisplayName("Test setKey(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.setKey(byte[])"})
  void testSetKey_whenAxaxaxaxBytesIsUtf8_thenDoesNotThrow() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new RC4Cipher().setKey("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RC4Cipher#setKey(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RC4Cipher#setKey(byte[])}
   */
  @Test
  @DisplayName("Test setKey(byte[]); when empty array of byte; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.setKey(byte[])"})
  void testSetKey_whenEmptyArrayOfByte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RC4Cipher().setKey(new byte[] {}));
  }

  /**
   * Test {@link RC4Cipher#write(byte[], int, int, OutputStream)} with {@code byte[]}, {@code int},
   * {@code int}, {@code OutputStream}.
   *
   * <p>Method under test: {@link RC4Cipher#write(byte[], int, int, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int, int, OutputStream) with 'byte[]', 'int', 'int', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.write(byte[], int, int, OutputStream)"})
  void testWriteWithByteIntIntOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    rc4Cipher.write(data, 2, 3, output);

    // Assert
    byte[] expectedToByteArrayResult = "AXA".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(byte, OutputStream)} with {@code byte}, {@code OutputStream}.
   *
   * <p>Method under test: {@link RC4Cipher#write(byte, OutputStream)}
   */
  @Test
  @DisplayName("Test write(byte, OutputStream) with 'byte', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.write(byte, OutputStream)"})
  void testWriteWithByteOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    rc4Cipher.write((byte) 'A', output);

    // Assert
    assertArrayEquals(new byte[] {'A'}, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(byte[], OutputStream)} with {@code byte[]}, {@code OutputStream}.
   *
   * <p>Method under test: {@link RC4Cipher#write(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test write(byte[], OutputStream) with 'byte[]', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.write(byte[], OutputStream)"})
  void testWriteWithByteOutputStream2() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    rc4Cipher.write(data, output);

    // Assert
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(InputStream, OutputStream)} with {@code InputStream}, {@code
   * OutputStream}.
   *
   * <p>Method under test: {@link RC4Cipher#write(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test write(InputStream, OutputStream) with 'InputStream', 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.write(InputStream, OutputStream)"})
  void testWriteWithInputStreamOutputStream() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();
    ByteArrayInputStream data = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    rc4Cipher.write(data, output);

    // Assert
    int actualReadResult = data.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link RC4Cipher#write(InputStream, OutputStream)} with {@code InputStream}, {@code
   * OutputStream}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RC4Cipher#write(InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test write(InputStream, OutputStream) with 'InputStream', 'OutputStream'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RC4Cipher.write(InputStream, OutputStream)"})
  void testWriteWithInputStreamOutputStream_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    RC4Cipher rc4Cipher = new RC4Cipher();

    DataInputStream data = mock(DataInputStream.class);
    when(data.read(Mockito.<byte[]>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> rc4Cipher.write(data, new ByteArrayOutputStream()));
    verify(data).read(isA(byte[].class));
  }
}
