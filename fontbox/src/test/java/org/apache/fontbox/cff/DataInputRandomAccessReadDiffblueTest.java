package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataInputRandomAccessReadDiffblueTest {
  /**
   * Test {@link DataInputRandomAccessRead#DataInputRandomAccessRead(RandomAccessRead)}.
   *
   * <p>Method under test: {@link
   * DataInputRandomAccessRead#DataInputRandomAccessRead(RandomAccessRead)}
   */
  @Test
  @DisplayName("Test new DataInputRandomAccessRead(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataInputRandomAccessRead.<init>(RandomAccessRead)"})
  void testNewDataInputRandomAccessRead() throws IOException {
    // Arrange and Act
    DataInputRandomAccessRead actualDataInputRandomAccessRead =
        new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3));

    // Assert
    assertEquals(0, actualDataInputRandomAccessRead.getPosition());
    assertEquals(0, actualDataInputRandomAccessRead.length());
    assertFalse(actualDataInputRandomAccessRead.hasRemaining());
  }

  /**
   * Test {@link DataInputRandomAccessRead#hasRemaining()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); given 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataInputRandomAccessRead.hasRemaining()"})
  void testHasRemaining_givenA_thenReturnTrue() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertTrue(new DataInputRandomAccessRead(randomAccessRead).hasRemaining());
  }

  /**
   * Test {@link DataInputRandomAccessRead#hasRemaining()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataInputRandomAccessRead.hasRemaining()"})
  void testHasRemaining_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).hasRemaining());
  }

  /**
   * Test {@link DataInputRandomAccessRead#getPosition()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.getPosition()"})
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0, new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).getPosition());
  }

  /**
   * Test {@link DataInputRandomAccessRead#setPosition(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataInputRandomAccessRead.setPosition(int)"})
  void testSetPosition_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).setPosition(1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#setPosition(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataInputRandomAccessRead.setPosition(int)"})
  void testSetPosition_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).setPosition(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readByte()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); given 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte DataInputRandomAccessRead.readByte()"})
  void testReadByte_givenA_thenReturnA() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertEquals('A', new DataInputRandomAccessRead(randomAccessRead).readByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readByte()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte DataInputRandomAccessRead.readByte()"})
  void testReadByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).readByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); given 'A'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.readUnsignedByte()"})
  void testReadUnsignedByte_givenA_thenReturnSixtyFive() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertEquals(65, new DataInputRandomAccessRead(randomAccessRead).readUnsignedByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.readUnsignedByte()"})
  void testReadUnsignedByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).readUnsignedByte());
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName(
      "Test peekUnsignedByte(int); given DataInputStream read(byte[]) throw IOException(); then calls read(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_givenDataInputStreamReadThrowIOException_thenCallsRead()
      throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(randomAccessRead).peekUnsignedByte(0));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_thenReturnMinusOne() throws IOException {
    // Arrange
    DataInputRandomAccessRead dataInputRandomAccessRead =
        new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3));

    // Act and Assert
    assertEquals(-1, dataInputRandomAccessRead.peekUnsignedByte(0));
    assertEquals(0, dataInputRandomAccessRead.getPosition());
    assertEquals(0, dataInputRandomAccessRead.length());
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputRandomAccessRead#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).peekUnsignedByte(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When three.
   *   <li>Then return array of {@code byte} with {@code A} and three.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName(
      "Test readBytes(int); given 'A'; when three; then return array of byte with 'A' and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputRandomAccessRead.readBytes(int)"})
  void testReadBytes_givenA_whenThree_thenReturnArrayOfByteWithAAndThree() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 3, 'A'}, new DataInputRandomAccessRead(randomAccessRead).readBytes(3));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputRandomAccessRead.readBytes(int)"})
  void testReadBytes_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).readBytes(3));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputRandomAccessRead.readBytes(int)"})
  void testReadBytes_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).readBytes(-1));
  }

  /**
   * Test {@link DataInputRandomAccessRead#readBytes(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when zero; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputRandomAccessRead.readBytes(int)"})
  void testReadBytes_whenZero_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).readBytes(0));
  }

  /**
   * Test {@link DataInputRandomAccessRead#length()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataInputRandomAccessRead#length()}
   */
  @Test
  @DisplayName("Test length(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputRandomAccessRead.length()"})
  void testLength_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, new DataInputRandomAccessRead(new RandomAccessReadWriteBuffer(3)).length());
  }
}
