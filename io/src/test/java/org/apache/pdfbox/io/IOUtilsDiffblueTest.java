package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessageFactory;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IOUtilsDiffblueTest {
  /**
   * Test {@link IOUtils#toByteArray(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  @DisplayName("Test toByteArray(InputStream); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] IOUtils.toByteArray(InputStream)"})
  void testToByteArray_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtils.toByteArray(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link IOUtils#toByteArray(InputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  @DisplayName(
      "Test toByteArray(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] IOUtils.toByteArray(InputStream)"})
  void testToByteArray_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = IOUtils.toByteArray(in);

    // Assert
    int actualReadResult = in.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Test {@link IOUtils#copy(InputStream, OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copy(InputStream, OutputStream); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IOUtils.copy(InputStream, OutputStream)"})
  void testCopy_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtils.copy(input, new ByteArrayOutputStream()));
    verify(input).transferTo(isA(OutputStream.class));
  }

  /**
   * Test {@link IOUtils#copy(InputStream, OutputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test copy(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IOUtils.copy(InputStream, OutputStream)"})
  void testCopy_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    long actualCopyResult = IOUtils.copy(input, output);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8L, actualCopyResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link IOUtils#populateBuffer(InputStream, byte[])}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  @DisplayName(
      "Test populateBuffer(InputStream, byte[]); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IOUtils.populateBuffer(InputStream, byte[])"})
  void testPopulateBuffer_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readNBytes(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtils.populateBuffer(in, "AXAXAXAX".getBytes("UTF-8")));
    verify(in).readNBytes(isA(byte[].class), eq(0), eq(8));
  }

  /**
   * Test {@link IOUtils#populateBuffer(InputStream, byte[])}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  @DisplayName(
      "Test populateBuffer(InputStream, byte[]); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IOUtils.populateBuffer(InputStream, byte[])"})
  void testPopulateBuffer_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualPopulateBufferResult = IOUtils.populateBuffer(in, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    int actualReadResult = in.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8L, actualPopulateBufferResult);
  }

  /**
   * Test {@link IOUtils#closeQuietly(Closeable)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link Closeable} {@link Closeable#close()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  @DisplayName(
      "Test closeQuietly(Closeable); given IOException(); when Closeable close() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IOUtils.closeQuietly(Closeable)"})
  void testCloseQuietly_givenIOException_whenCloseableCloseThrowIOException() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException()).when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert
    verify(closeable).close();
  }

  /**
   * Test {@link IOUtils#closeQuietly(Closeable)}.
   *
   * <ul>
   *   <li>When {@link Closeable} {@link Closeable#close()} does nothing.
   *   <li>Then calls {@link Closeable#close()}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  @DisplayName(
      "Test closeQuietly(Closeable); when Closeable close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String,
   * IOException)}
   */
  @Test
  @DisplayName(
      "Test closeAndLogException(Closeable, Logger, String, IOException); given IOException(); then return LocalizedMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"
  })
  void testCloseAndLogException_givenIOException_thenReturnLocalizedMessageIsNull()
      throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException()).when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();
    ExtendedLoggerWrapper logger2 =
        new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult =
        IOUtils.closeAndLogException(closeable, logger2, "Resource Name", new IOException());

    // Assert
    verify(closeable).close();
    assertNull(actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertNull(actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   *
   * <ul>
   *   <li>When {@link Closeable} {@link Closeable#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String,
   * IOException)}
   */
  @Test
  @DisplayName(
      "Test closeAndLogException(Closeable, Logger, String, IOException); when Closeable close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"
  })
  void testCloseAndLogException_whenCloseableCloseDoesNothing() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();
    ExtendedLoggerWrapper logger2 =
        new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult =
        IOUtils.closeAndLogException(closeable, logger2, "Resource Name", new IOException());

    // Assert
    verify(closeable).close();
    assertNull(actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertNull(actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String,
   * IOException)}
   */
  @Test
  @DisplayName(
      "Test closeAndLogException(Closeable, Logger, String, IOException); when 'null'; then return LocalizedMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"
  })
  void testCloseAndLogException_whenNull_thenReturnLocalizedMessageIsNull() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException()).when(closeable).close();
    StatusLogger logger = StatusLogger.getLogger();
    ExtendedLoggerWrapper logger2 =
        new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult =
        IOUtils.closeAndLogException(closeable, logger2, "Resource Name", null);

    // Assert
    verify(closeable).close();
    assertNull(actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertNull(actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#closeAndLogException(Closeable, Logger, String, IOException)}.
   *
   * <ul>
   *   <li>When {@link PropertiesUtil#PropertiesUtil(String)} with propertiesFileName is {@code
   *       foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtils#closeAndLogException(Closeable, Logger, String,
   * IOException)}
   */
  @Test
  @DisplayName(
      "Test closeAndLogException(Closeable, Logger, String, IOException); when PropertiesUtil(String) with propertiesFileName is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IOException IOUtils.closeAndLogException(Closeable, Logger, String, IOException)"
  })
  void testCloseAndLogException_whenPropertiesUtilWithPropertiesFileNameIsFooTxt()
      throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException()).when(closeable).close();
    Level defaultLevel = Level.forName("Error closing {}", 42);
    FormattedMessageFactory messageFactory = new FormattedMessageFactory();
    PropertiesUtil props = new PropertiesUtil("foo.txt");

    SimpleLogger logger =
        new SimpleLogger(
            "Error closing {}",
            defaultLevel,
            true,
            true,
            true,
            true,
            "2020-03-01",
            messageFactory,
            props,
            new PrintStream(new ByteArrayOutputStream()));
    ExtendedLoggerWrapper logger2 =
        new ExtendedLoggerWrapper(logger, "Name", new FormattedMessageFactory());

    // Act
    IOException actualCloseAndLogExceptionResult =
        IOUtils.closeAndLogException(closeable, logger2, "Resource Name", new IOException());

    // Assert
    verify(closeable).close();
    assertNull(actualCloseAndLogExceptionResult.getLocalizedMessage());
    assertNull(actualCloseAndLogExceptionResult.getMessage());
    assertNull(actualCloseAndLogExceptionResult.getCause());
    assertEquals(0, actualCloseAndLogExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link IOUtils#createMemoryOnlyStreamCache()}.
   *
   * <p>Method under test: {@link IOUtils#createMemoryOnlyStreamCache()}
   */
  @Test
  @DisplayName("Test createMemoryOnlyStreamCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RandomAccessStreamCache.StreamCacheCreateFunction IOUtils.createMemoryOnlyStreamCache()"
  })
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
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((RandomAccessReadWriteBuffer) createBufferResult).chunkSize);
  }

  /**
   * Test {@link IOUtils#createTempFileOnlyStreamCache()}.
   *
   * <p>Method under test: {@link IOUtils#createTempFileOnlyStreamCache()}
   */
  @Test
  @DisplayName("Test createTempFileOnlyStreamCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RandomAccessStreamCache.StreamCacheCreateFunction IOUtils.createTempFileOnlyStreamCache()"
  })
  void testCreateTempFileOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createTempFileOnlyStreamCache().create();

    // Assert
    assertTrue(actualCreateResult instanceof ScratchFile);
    assertEquals(0, ((ScratchFile) actualCreateResult).getNewPage());
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB,
        ((ScratchFile) actualCreateResult).getPageSize());
  }
}
