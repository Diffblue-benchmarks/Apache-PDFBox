package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessageFactory;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import org.apache.logging.log4j.status.StatusLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IOUtilsDiffblueTest {
  /**
   * Test {@link IOUtils#toByteArray(InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  @DisplayName("Test toByteArray(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] IOUtils.toByteArray(InputStream)"})
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
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copy(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long IOUtils.copy(InputStream, OutputStream)"})
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
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  @DisplayName("Test populateBuffer(InputStream, byte[]); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long IOUtils.populateBuffer(InputStream, byte[])"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IOUtils.closeQuietly(Closeable)"})
  void testCloseQuietly_givenIOExceptionWithFoo() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IOUtils.closeQuietly(Closeable)"})
  void testCloseQuietly_whenCloseableCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert
    verify(closeable).close();
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}
   */
  @Test
  @DisplayName("Test closeAndLogException(Closeable, Logger, String, IOException); given IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"})
  void testCloseAndLogException_givenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();
    ExtendedLoggerWrapper logger2 = new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult = IOUtils.closeAndLogException(closeable, logger2, "Resource Name",
        new IOException("foo"));

    // Assert
    verify(closeable).close();
    assertEquals("foo", actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   * <ul>
   *   <li>When {@link Closeable} {@link Closeable#close()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}
   */
  @Test
  @DisplayName("Test closeAndLogException(Closeable, Logger, String, IOException); when Closeable close() does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"})
  void testCloseAndLogException_whenCloseableCloseDoesNothing() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();
    ExtendedLoggerWrapper logger2 = new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult = IOUtils.closeAndLogException(closeable, logger2, "Resource Name",
        new IOException("foo"));

    // Assert
    verify(closeable).close();
    assertEquals("foo", actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}
   */
  @Test
  @DisplayName("Test closeAndLogException(Closeable, Logger, String, IOException); when 'null'; then return LocalizedMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"})
  void testCloseAndLogException_whenNull_thenReturnLocalizedMessageIsFoo() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();

    // Act
    IOException actualCloseAndLogExceptionResult = IOUtils.closeAndLogException(closeable,
        new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory()), "Resource Name", null);

    // Assert
    verify(closeable).close();
    assertEquals("foo", actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#createMemoryOnlyStreamCache()}.
   * <p>
   * Method under test: {@link IOUtils#createMemoryOnlyStreamCache()}
   */
  @Test
  @DisplayName("Test createMemoryOnlyStreamCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessStreamCache.StreamCacheCreateFunction IOUtils.createMemoryOnlyStreamCache()"})
  void testCreateMemoryOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createMemoryOnlyStreamCache().create();

    // Assert
    RandomAccess createBufferResult = actualCreateResult.createBuffer();
    assertTrue(createBufferResult instanceof RandomAccessReadWriteBuffer);
    assertTrue(actualCreateResult instanceof RandomAccessStreamCacheImpl);
    assertEquals(0, createBufferResult.available());
    assertEquals(0, ((RandomAccessReadWriteBuffer) createBufferResult).currentBufferPointer);
    assertEquals(0L, createBufferResult.getPosition());
    assertEquals(0L, ((RandomAccessReadWriteBuffer) createBufferResult).pointer);
    assertEquals(0L, ((RandomAccessReadWriteBuffer) createBufferResult).size);
    assertFalse(createBufferResult.isClosed());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessStreamCache.StreamCacheCreateFunction IOUtils.createTempFileOnlyStreamCache()"})
  void testCreateTempFileOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createTempFileOnlyStreamCache().create();

    // Assert
    assertTrue(actualCreateResult instanceof ScratchFile);
    assertEquals(0, ((ScratchFile) actualCreateResult).getNewPage());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, ((ScratchFile) actualCreateResult).getPageSize());
  }
}
