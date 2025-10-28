package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;

class RandomAccessReadWriteBufferDiffblueTest {
  /**
   * Method under test:
   * {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}
   */
  @Test
  void testNewRandomAccessReadWriteBuffer() throws IOException {
    // Arrange and Act
    RandomAccessReadWriteBuffer actualRandomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadWriteBuffer.available());
    assertEquals(0, actualRandomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadWriteBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[0]);
    assertEquals((byte) 0, arrayResult[1]);
    assertEquals((byte) 0, arrayResult[10]);
    assertEquals((byte) 0, arrayResult[11]);
    assertEquals((byte) 0, arrayResult[12]);
    assertEquals((byte) 0, arrayResult[13]);
    assertEquals((byte) 0, arrayResult[14]);
    assertEquals((byte) 0, arrayResult[15]);
    assertEquals((byte) 0, arrayResult[17]);
    assertEquals((byte) 0, arrayResult[18]);
    assertEquals((byte) 0, arrayResult[19]);
    assertEquals((byte) 0, arrayResult[2]);
    assertEquals((byte) 0, arrayResult[20]);
    assertEquals((byte) 0, arrayResult[21]);
    assertEquals((byte) 0, arrayResult[22]);
    assertEquals((byte) 0, arrayResult[23]);
    assertEquals((byte) 0, arrayResult[24]);
    assertEquals((byte) 0, arrayResult[3]);
    assertEquals((byte) 0, arrayResult[4]);
    assertEquals((byte) 0, arrayResult[4071]);
    assertEquals((byte) 0, arrayResult[4072]);
    assertEquals((byte) 0, arrayResult[4073]);
    assertEquals((byte) 0, arrayResult[4074]);
    assertEquals((byte) 0, arrayResult[4075]);
    assertEquals((byte) 0, arrayResult[4076]);
    assertEquals((byte) 0, arrayResult[4077]);
    assertEquals((byte) 0, arrayResult[4078]);
    assertEquals((byte) 0, arrayResult[4079]);
    assertEquals((byte) 0, arrayResult[4080]);
    assertEquals((byte) 0, arrayResult[4081]);
    assertEquals((byte) 0, arrayResult[4082]);
    assertEquals((byte) 0, arrayResult[4083]);
    assertEquals((byte) 0, arrayResult[4084]);
    assertEquals((byte) 0, arrayResult[4085]);
    assertEquals((byte) 0, arrayResult[4086]);
    assertEquals((byte) 0, arrayResult[4087]);
    assertEquals((byte) 0, arrayResult[4088]);
    assertEquals((byte) 0, arrayResult[4089]);
    assertEquals((byte) 0, arrayResult[4090]);
    assertEquals((byte) 0, arrayResult[4091]);
    assertEquals((byte) 0, arrayResult[4092]);
    assertEquals((byte) 0, arrayResult[4093]);
    assertEquals((byte) 0, arrayResult[4094]);
    assertEquals((byte) 0, arrayResult[4095]);
    assertEquals((byte) 0, arrayResult[5]);
    assertEquals((byte) 0, arrayResult[6]);
    assertEquals((byte) 0, arrayResult[7]);
    assertEquals((byte) 0, arrayResult[8]);
    assertEquals((byte) 0, arrayResult[9]);
    assertEquals((byte) 0, arrayResult[Short.SIZE]);
    assertFalse(actualRandomAccessReadWriteBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadWriteBuffer.chunkSize);
  }

  /**
   * Method under test: {@link RandomAccessReadWriteBuffer#write(int)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(19088743);

    // Assert
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(1, byteBuffer.position());
    assertEquals(1, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(1L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(1L, randomAccessReadWriteBuffer.pointer);
    assertEquals(1L, randomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals('g', arrayResult[0]);
  }

  /**
   * Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  void testWrite2() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(8, byteBuffer.position());
    assertEquals(8, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(8L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(8L, randomAccessReadWriteBuffer.pointer);
    assertEquals(8L, randomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals('A', arrayResult[0]);
    assertEquals('A', arrayResult[2]);
    assertEquals('A', arrayResult[4]);
    assertEquals('A', arrayResult[6]);
    assertEquals('X', arrayResult[1]);
    assertEquals('X', arrayResult[3]);
    assertEquals('X', arrayResult[5]);
    assertEquals('X', arrayResult[7]);
  }

  /**
   * Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  void testWrite3() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer(3);

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(2, byteBuffer.position());
    assertEquals(2, randomAccessReadWriteBuffer.currentBufferPointer);
    byte[] arrayResult = byteBuffer.array();
    assertEquals(3, arrayResult.length);
    assertEquals(8L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(8L, randomAccessReadWriteBuffer.pointer);
    assertEquals(8L, randomAccessReadWriteBuffer.size);
    assertEquals('A', arrayResult[0]);
    assertEquals('X', arrayResult[1]);
  }

  /**
   * Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  void testWrite4() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(new byte[]{});

    // Assert that nothing has changed
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, randomAccessReadWriteBuffer.pointer);
    assertEquals(0L, randomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[0]);
    assertEquals((byte) 0, arrayResult[1]);
    assertEquals((byte) 0, arrayResult[2]);
    assertEquals((byte) 0, arrayResult[3]);
    assertEquals((byte) 0, arrayResult[4]);
    assertEquals((byte) 0, arrayResult[5]);
    assertEquals((byte) 0, arrayResult[6]);
    assertEquals((byte) 0, arrayResult[7]);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadWriteBuffer#write(byte[], int, int)}
   */
  @Test
  void testWrite5() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 19088743, 0);

    // Assert that nothing has changed
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, randomAccessReadWriteBuffer.pointer);
    assertEquals(0L, randomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[0]);
    assertEquals((byte) 0, arrayResult[1]);
    assertEquals((byte) 0, arrayResult[2]);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadWriteBuffer#write(byte[], int, int)}
   */
  @Test
  void testWrite6() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Assert
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(3, byteBuffer.position());
    assertEquals(3, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(3L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(3L, randomAccessReadWriteBuffer.pointer);
    assertEquals(3L, randomAccessReadWriteBuffer.size);
    byte[] arrayResult = byteBuffer.array();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals('A', arrayResult[1]);
    assertEquals('X', arrayResult[0]);
    assertEquals('X', arrayResult[2]);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)}
   */
  @Test
  void testNewRandomAccessReadWriteBuffer2() throws IOException {
    // Arrange and Act
    RandomAccessReadWriteBuffer actualRandomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer(3);

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadWriteBuffer.available());
    assertEquals(0, actualRandomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadWriteBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.size);
    assertEquals(3, byteBuffer.capacity());
    assertEquals(3, byteBuffer.limit());
    assertEquals(3, actualRandomAccessReadWriteBuffer.chunkSize);
    assertFalse(actualRandomAccessReadWriteBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertArrayEquals(new byte[]{0, 0, 0}, byteBuffer.array());
  }
}
