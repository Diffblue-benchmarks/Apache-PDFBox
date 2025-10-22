package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HexDiffblueTest {
  /**
   * Test {@link Hex#getString(byte)} with {@code b}.
   * <p>
   * Method under test: {@link Hex#getString(byte)}
   */
  @Test
  @DisplayName("Test getString(byte) with 'b'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Hex.getString(byte)"})
  void testGetStringWithB() {
    // Arrange, Act and Assert
    assertEquals("41", Hex.getString((byte) 'A'));
  }

  /**
   * Test {@link Hex#getString(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link Hex#getString(byte[])}
   */
  @Test
  @DisplayName("Test getString(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Hex.getString(byte[])"})
  void testGetStringWithBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", Hex.getString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Hex#getBytes(byte)} with {@code b}.
   * <p>
   * Method under test: {@link Hex#getBytes(byte)}
   */
  @Test
  @DisplayName("Test getBytes(byte) with 'b'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Hex.getBytes(byte)"})
  void testGetBytesWithB() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'4', '1'}, Hex.getBytes((byte) 'A'));
  }

  /**
   * Test {@link Hex#getBytes(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link Hex#getBytes(byte[])}
   */
  @Test
  @DisplayName("Test getBytes(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Hex.getBytes(byte[])"})
  void testGetBytesWithBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Hex.getBytes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("4158415841584158".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test {@link Hex#getChars(short)}.
   * <p>
   * Method under test: {@link Hex#getChars(short)}
   */
  @Test
  @DisplayName("Test getChars(short)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char[] Hex.getChars(short)"})
  void testGetChars() {
    // Arrange and Act
    char[] actualChars = Hex.getChars((short) 1);

    // Assert
    assertArrayEquals("0001".toCharArray(), actualChars);
  }

  /**
   * Test {@link Hex#getCharsUTF16BE(String)}.
   * <p>
   * Method under test: {@link Hex#getCharsUTF16BE(String)}
   */
  @Test
  @DisplayName("Test getCharsUTF16BE(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char[] Hex.getCharsUTF16BE(String)"})
  void testGetCharsUTF16BE() {
    // Arrange and Act
    char[] actualCharsUTF16BE = Hex.getCharsUTF16BE("0123456789ABCDEF");

    // Assert
    assertArrayEquals("0030003100320033003400350036003700380039004100420043004400450046".toCharArray(),
        actualCharsUTF16BE);
  }

  /**
   * Test {@link Hex#writeHexByte(byte, OutputStream)}.
   * <p>
   * Method under test: {@link Hex#writeHexByte(byte, OutputStream)}
   */
  @Test
  @DisplayName("Test writeHexByte(byte, OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Hex.writeHexByte(byte, OutputStream)"})
  void testWriteHexByte() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    Hex.writeHexByte((byte) 'A', output);

    // Assert
    assertArrayEquals(new byte[]{'4', '1'}, output.toByteArray());
  }

  /**
   * Test {@link Hex#writeHexBytes(byte[], OutputStream)}.
   * <p>
   * Method under test: {@link Hex#writeHexBytes(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeHexBytes(byte[], OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Hex.writeHexBytes(byte[], OutputStream)"})
  void testWriteHexBytes() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    Hex.writeHexBytes(bytes, output);

    // Assert
    byte[] expectedToByteArrayResult = "4158415841584158".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link Hex#decodeBase64(String)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus forty-five and {@code ]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hex#decodeBase64(String)}
   */
  @Test
  @DisplayName("Test decodeBase64(String); then return array of byte with minus forty-five and ']'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Hex.decodeBase64(String)"})
  void testDecodeBase64_thenReturnArrayOfByteWithMinusFortyFiveAndRightSquareBracket() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-45, ']', -73, -29, -98, -69, -13, -48, 1, '\b', '1', 5},
        Hex.decodeBase64("0123456789ABCDEF"));
  }

  /**
   * Test {@link Hex#decodeHex(String)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return array of {@code byte} with one and {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hex#decodeHex(String)}
   */
  @Test
  @DisplayName("Test decodeHex(String); when '0123456789ABCDEF'; then return array of byte with one and '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Hex.decodeHex(String)"})
  void testDecodeHex_when0123456789abcdef_thenReturnArrayOfByteWithOneAndNumberSign() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, Hex.decodeHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link Hex#decodeHex(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Hex#decodeHex(String)}
   */
  @Test
  @DisplayName("Test decodeHex(String); when 'foo'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Hex.decodeHex(String)"})
  void testDecodeHex_whenFoo_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, Hex.decodeHex("foo"));
  }
}
