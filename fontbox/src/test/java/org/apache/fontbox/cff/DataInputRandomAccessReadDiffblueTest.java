package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class DataInputRandomAccessReadDiffblueTest {
  /**
   * Method under test: {@link DataInputRandomAccessRead#hasRemaining()}
   */
  @Test
  void testHasRemaining() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).hasRemaining());
    assertFalse((new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
        .hasRemaining());
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getPosition());
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#setPosition(int)}
   */
  @Test
  void testSetPosition() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).setPosition(-1));
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .setPosition(1));
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#readByte()}
   */
  @Test
  void testReadByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals('A', (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readByte());
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .readByte());
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#readUnsignedByte()}
   */
  @Test
  void testReadUnsignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readUnsignedByte());
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .readUnsignedByte());
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#peekUnsignedByte(int)}
   */
  @Test
  void testPeekUnsignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(2));
    assertEquals(65, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(0));
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).peekUnsignedByte(-1));
    assertThrows(IOException.class,
        () -> (new DataInputRandomAccessRead(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{}))))
            .peekUnsignedByte(2));
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  void testReadBytes() throws IOException {
    // Arrange and Act
    byte[] actualReadBytesResult = (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualReadBytesResult);
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  void testReadBytes2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(-1));
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#readBytes(int)}
   */
  @Test
  void testReadBytes3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readBytes(9));
  }

  /**
   * Method under test: {@link DataInputRandomAccessRead#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8, (new DataInputRandomAccessRead(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).length());
  }
}
