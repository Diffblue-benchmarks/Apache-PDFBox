package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataInputByteArrayDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataInputByteArray#DataInputByteArray(byte[])}
   *   <li>{@link DataInputByteArray#getPosition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).getPosition());
  }

  /**
   * Test {@link DataInputByteArray#hasRemaining()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); then return 'false'")
  void testHasRemaining_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new DataInputByteArray(new byte[]{})).hasRemaining());
  }

  /**
   * Test {@link DataInputByteArray#hasRemaining()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); then return 'true'")
  void testHasRemaining_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).hasRemaining());
  }

  /**
   * Test {@link DataInputByteArray#setPosition(int)}.
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer
   * is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  void testSetPosition_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).setPosition(1));
  }

  /**
   * Test {@link DataInputByteArray#setPosition(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); when minus one; then throw IOException")
  void testSetPosition_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).setPosition(-1));
  }

  /**
   * Test {@link DataInputByteArray#readByte()}.
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer
   * is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); given DataInputByteArray(byte[]) with buffer is 'AXAXAXAX' Bytes is 'UTF-8'; then return 'A'")
  void testReadByte_givenDataInputByteArrayWithBufferIsAxaxaxaxBytesIsUtf8_thenReturnA() throws IOException {
    // Arrange, Act and Assert
    assertEquals('A', (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readByte());
  }

  /**
   * Test {@link DataInputByteArray#readByte()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); then throw IOException")
  void testReadByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readByte());
  }

  /**
   * Test {@link DataInputByteArray#readUnsignedByte()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then return sixty-five")
  void testReadUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readUnsignedByte());
  }

  /**
   * Test {@link DataInputByteArray#readUnsignedByte()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw IOException")
  void testReadUnsignedByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readUnsignedByte());
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer
   * is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  void testPeekUnsignedByte_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); then return sixty-five")
  void testPeekUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); when minus one; then throw IOException")
  void testPeekUnsignedByte_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).peekUnsignedByte(-1));
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer
   * is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  void testReadBytes_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readBytes(3));
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   * <ul>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); then return 'AXA' Bytes is 'UTF-8'")
  void testReadBytes_thenReturnAxaBytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualReadBytesResult = (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readBytes(3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualReadBytesResult);
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when minus one; then throw IOException")
  void testReadBytes_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readBytes(-1));
  }

  /**
   * Test {@link DataInputByteArray#length()}.
   * <p>
   * Method under test: {@link DataInputByteArray#length()}
   */
  @Test
  @DisplayName("Test length()")
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).length());
  }
}
