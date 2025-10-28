package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class DataInputByteArrayDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataInputByteArray#DataInputByteArray(byte[])}
   *   <li>{@link DataInputByteArray#getPosition()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).getPosition());
  }

  /**
   * Method under test: {@link DataInputByteArray#hasRemaining()}
   */
  @Test
  void testHasRemaining() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).hasRemaining());
    assertFalse((new DataInputByteArray(new byte[]{})).hasRemaining());
  }

  /**
   * Method under test: {@link DataInputByteArray#setPosition(int)}
   */
  @Test
  void testSetPosition() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).setPosition(-1));
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).setPosition(1));
  }

  /**
   * Method under test: {@link DataInputByteArray#readByte()}
   */
  @Test
  void testReadByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals('A', (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readByte());
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readByte());
  }

  /**
   * Method under test: {@link DataInputByteArray#readUnsignedByte()}
   */
  @Test
  void testReadUnsignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readUnsignedByte());
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readUnsignedByte());
  }

  /**
   * Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  void testPeekUnsignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).peekUnsignedByte(2));
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).peekUnsignedByte(-1));
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).peekUnsignedByte(2));
  }

  /**
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  void testReadBytes() throws IOException {
    // Arrange and Act
    byte[] actualReadBytesResult = (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readBytes(3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualReadBytesResult);
  }

  /**
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  void testReadBytes2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).readBytes(-1));
  }

  /**
   * Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  void testReadBytes3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DataInputByteArray(new byte[]{})).readBytes(3));
  }

  /**
   * Method under test: {@link DataInputByteArray#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8, (new DataInputByteArray("AXAXAXAX".getBytes("UTF-8"))).length());
  }
}
