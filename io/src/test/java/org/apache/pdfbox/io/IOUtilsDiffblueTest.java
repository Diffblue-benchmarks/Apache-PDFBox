package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IOUtilsDiffblueTest {
  /**
   * Test {@link IOUtils#toByteArray(InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  @DisplayName("Test toByteArray(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  void testToByteArray_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = IOUtils.toByteArray(in);

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Test {@link IOUtils#copy(InputStream, OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copy(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  void testCopy_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    long actualCopyResult = IOUtils.copy(input, output);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(8L, actualCopyResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link IOUtils#populateBuffer(InputStream, byte[])}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  @DisplayName("Test populateBuffer(InputStream, byte[]); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  void testPopulateBuffer_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualPopulateBufferResult = IOUtils.populateBuffer(in, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(8L, actualPopulateBufferResult);
  }

  /**
   * Test {@link IOUtils#closeQuietly(Closeable)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  @DisplayName("Test closeQuietly(Closeable); given IOException(String) with 'foo'")
  void testCloseQuietly_givenIOExceptionWithFoo() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Test {@link IOUtils#closeQuietly(Closeable)}.
   * <ul>
   *   <li>When {@link Closeable} {@link Closeable#close()} does nothing.</li>
   *   <li>Then calls {@link Closeable#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  @DisplayName("Test closeQuietly(Closeable); when Closeable close() does nothing; then calls close()")
  void testCloseQuietly_whenCloseableCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Test {@link IOUtils#createMemoryOnlyStreamCache()}.
   * <p>
   * Method under test: {@link IOUtils#createMemoryOnlyStreamCache()}
   */
  @Test
  @DisplayName("Test createMemoryOnlyStreamCache()")
  void testCreateMemoryOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createMemoryOnlyStreamCache().create();

    // Assert
    RandomAccess createBufferResult = actualCreateResult.createBuffer();
    assertTrue(createBufferResult instanceof RandomAccessReadWriteBuffer);
    assertTrue(actualCreateResult instanceof RandomAccessStreamCacheImpl);
    ByteBuffer byteBuffer = ((RandomAccessReadWriteBuffer) createBufferResult).currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, createBufferResult.available());
    assertEquals(0, ((RandomAccessReadWriteBuffer) createBufferResult).currentBufferPointer);
    assertEquals(0L, createBufferResult.getPosition());
    assertEquals(0L, ((RandomAccessReadWriteBuffer) createBufferResult).pointer);
    assertEquals(0L, ((RandomAccessReadWriteBuffer) createBufferResult).size);
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
    assertFalse(createBufferResult.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((RandomAccessReadWriteBuffer) createBufferResult).chunkSize);
  }

  /**
   * Test {@link IOUtils#createTempFileOnlyStreamCache()}.
   * <p>
   * Method under test: {@link IOUtils#createTempFileOnlyStreamCache()}
   */
  @Test
  @DisplayName("Test createTempFileOnlyStreamCache()")
  void testCreateTempFileOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createTempFileOnlyStreamCache().create();

    // Assert
    assertTrue(actualCreateResult instanceof ScratchFile);
    assertEquals(0, ((ScratchFile) actualCreateResult).getNewPage());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, ((ScratchFile) actualCreateResult).getPageSize());
  }
}
