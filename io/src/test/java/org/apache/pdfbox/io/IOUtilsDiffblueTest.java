package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IOUtilsDiffblueTest {
  /**
   * Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  void testToByteArray() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = IOUtils.toByteArray(in);

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Method under test: {@link IOUtils#toByteArray(InputStream)}
   */
  @Test
  void testToByteArray2() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = IOUtils.toByteArray(in);

    // Assert
    verify(in).readAllBytes();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }

  /**
   * Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  void testCopy() throws IOException {
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
   * Method under test: {@link IOUtils#copy(InputStream, OutputStream)}
   */
  @Test
  void testCopy2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    long actualCopyResult = IOUtils.copy(input, output);

    // Assert
    verify(input).transferTo(isA(OutputStream.class));
    assertEquals(0, output.toByteArray().length);
    assertEquals(1L, actualCopyResult);
  }

  /**
   * Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  void testPopulateBuffer() throws IOException {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualPopulateBufferResult = IOUtils.populateBuffer(in, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, in.read(new byte[]{}));
    assertEquals(8L, actualPopulateBufferResult);
  }

  /**
   * Method under test: {@link IOUtils#populateBuffer(InputStream, byte[])}
   */
  @Test
  void testPopulateBuffer2() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readNBytes(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act
    long actualPopulateBufferResult = IOUtils.populateBuffer(in, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(in).readNBytes(isA(byte[].class), eq(0), eq(8));
    assertEquals(1L, actualPopulateBufferResult);
  }

  /**
   * Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  void testCloseQuietly() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Method under test: {@link IOUtils#closeQuietly(Closeable)}
   */
  @Test
  void testCloseQuietly2() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();

    // Act
    IOUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Method under test: {@link IOUtils#createMemoryOnlyStreamCache()}
   */
  @Test
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
   * Method under test: {@link IOUtils#createTempFileOnlyStreamCache()}
   */
  @Test
  void testCreateTempFileOnlyStreamCache() throws IOException {
    // Arrange and Act
    RandomAccessStreamCache actualCreateResult = IOUtils.createTempFileOnlyStreamCache().create();

    // Assert
    assertTrue(actualCreateResult instanceof ScratchFile);
    assertEquals(0, ((ScratchFile) actualCreateResult).getNewPage());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, ((ScratchFile) actualCreateResult).getPageSize());
  }
}
