package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessStreamCacheImplDiffblueTest {
  /**
   * Test {@link RandomAccessStreamCacheImpl#createBuffer()}.
   * <p>
   * Method under test: {@link RandomAccessStreamCacheImpl#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccess RandomAccessStreamCacheImpl.createBuffer()"})
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
    assertFalse(actualCreateBufferResult.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.array().length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((RandomAccessReadWriteBuffer) actualCreateBufferResult).chunkSize);
  }
}
