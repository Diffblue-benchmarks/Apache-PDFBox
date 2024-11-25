package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAccessStreamCacheImplDiffblueTest {
  /**
   * Test {@link RandomAccessStreamCacheImpl#createBuffer()}.
   * <p>
   * Method under test: {@link RandomAccessStreamCacheImpl#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer()")
  void testCreateBuffer() throws IOException {
    // Arrange and Act
    RandomAccess actualCreateBufferResult = (new RandomAccessStreamCacheImpl()).createBuffer();

    // Assert
    assertTrue(actualCreateBufferResult instanceof RandomAccessReadWriteBuffer);
    ByteBuffer byteBuffer = ((RandomAccessReadWriteBuffer) actualCreateBufferResult).currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualCreateBufferResult.available());
    assertEquals(0, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).currentBufferPointer);
    assertEquals(0L, actualCreateBufferResult.getPosition());
    assertEquals(0L, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).pointer);
    assertEquals(0L, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).size);
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
    assertFalse(actualCreateBufferResult.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((RandomAccessReadWriteBuffer) actualCreateBufferResult).chunkSize);
  }
}
