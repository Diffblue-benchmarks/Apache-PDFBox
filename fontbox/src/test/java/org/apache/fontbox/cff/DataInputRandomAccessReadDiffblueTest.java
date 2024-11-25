package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataInputRandomAccessReadDiffblueTest {
  /**
   * Test {@link DataInputRandomAccessRead#hasRemaining()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  void testHasRemaining_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).hasRemaining());
  }

  /**
   * Test {@link DataInputRandomAccessRead#hasRemaining()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); given ByteArrayInputStream(byte[]) with empty array of byte; then return 'false'")
  void testHasRemaining_givenByteArrayInputStreamWithEmptyArrayOfByte_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
        .hasRemaining());
  }

  /**
   * Test {@link DataInputRandomAccessRead#getPosition()}.
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition()")
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getPosition());
  }

  /**
   * Test {@link DataInputRandomAccessRead#setPosition(int)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); given ByteArrayInputStream(byte[]) with empty array of byte")
  void testSetPosition_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .setPosition(1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#setPosition(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); when minus one; then throw IOException")
  void testSetPosition_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).setPosition(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readByte()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'A'")
  void testReadByte_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnA() throws IOException {
    // Arrange, Act and Assert
    assertEquals('A', (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readByte()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  void testReadByte_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .readByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readUnsignedByte()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then return sixty-five")
  void testReadUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readUnsignedByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readUnsignedByte()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw IOException")
  void testReadUnsignedByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .readUnsignedByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); given ByteArrayInputStream(byte[]) with empty array of byte")
  void testPeekUnsignedByte_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); then return sixty-five")
  void testPeekUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); when minus one; then throw IOException")
  void testPeekUnsignedByte_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); when zero; then return sixty-five")
  void testPeekUnsignedByte_whenZero_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(0));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when minus one; then throw IOException")
  void testReadBytes_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when nine; then throw IOException")
  void testReadBytes_whenNine_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(9));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when three; then return 'AXA' Bytes is 'UTF-8'")
  void testReadBytes_whenThree_thenReturnAxaBytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualReadBytesResult = (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualReadBytesResult);
  }

  /**
   * Test {@link DataInputRandomAccessRead#length()}.
   * <p>
   * Method under test: {@link DataInputRandomAccessRead#length()}
   */
  @Test
  @DisplayName("Test length()")
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).length());
  }
}
