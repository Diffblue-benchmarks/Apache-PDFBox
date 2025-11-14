package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessStreamCacheImplDiffblueTest {
  /**
   * Test {@link RandomAccessStreamCacheImpl#createBuffer()}.
   *
   * <p>Method under test: {@link RandomAccessStreamCacheImpl#createBuffer()}
   */
  @Test
  @DisplayName("Test createBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccess RandomAccessStreamCacheImpl.createBuffer()"})
  void testCreateBuffer() throws IOException {
    // Arrange and Act
    RandomAccess actualCreateBufferResult = new RandomAccessStreamCacheImpl().createBuffer();

    // Assert
    assertTrue(actualCreateBufferResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((RandomAccessReadWriteBuffer) actualCreateBufferResult).chunkSize);
    ByteBuffer byteBuffer = ((RandomAccessReadWriteBuffer) actualCreateBufferResult).currentBuffer;
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.array().length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    ByteBuffer expectedFlipResult =
        ((RandomAccessReadBuffer) actualCreateBufferResult).currentBuffer;
    assertSame(expectedFlipResult, byteBuffer.flip());
    assertTrue(byteBuffer.hasArray());
    assertFalse(byteBuffer.hasRemaining());
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, byteBuffer.position());
    assertEquals(0, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).currentBufferPointer);
    assertEquals(0L, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).pointer);
    assertEquals(0L, ((RandomAccessReadWriteBuffer) actualCreateBufferResult).size);
    assertEquals(0, actualCreateBufferResult.available());
    assertEquals(0L, actualCreateBufferResult.getPosition());
    assertFalse(actualCreateBufferResult.isClosed());
  }
}
