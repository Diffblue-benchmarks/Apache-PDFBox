package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomAccessReadBufferDiffblueTest {
  /**
   * Method under test: {@link RandomAccessReadBuffer#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();

    // Act
    randomAccessReadBuffer.close();

    // Assert
    assertNull(randomAccessReadBuffer.currentBuffer);
    assertTrue(randomAccessReadBuffer.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#close()}
   */
  @Test
  void testClose2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act
    createBufferFromStreamResult.close();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertNull(createBufferFromStreamResult.currentBuffer);
    assertTrue(createBufferFromStreamResult.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act
    createBufferFromStreamResult.seek(1L);

    // Assert
    assertEquals(1, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(1, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(1L, createBufferFromStreamResult.getPosition());
    assertEquals(1L, createBufferFromStreamResult.pointer);
    assertEquals(7, createBufferFromStreamResult.available());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  void testSeek2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadBuffer()).seek(-1L));
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  void testSeek3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act
    createBufferFromStreamResult.seek(1L);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(1, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(1, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(1L, createBufferFromStreamResult.getPosition());
    assertEquals(1L, createBufferFromStreamResult.pointer);
    assertEquals(4095, createBufferFromStreamResult.available());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadBuffer()).getPosition());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#getPosition()}
   */
  @Test
  void testGetPosition2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    long actualPosition = RandomAccessReadBuffer.createBufferFromStream(inputStream).getPosition();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0L, actualPosition);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}
   */
  @Test
  void testNewRandomAccessReadBuffer() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer();

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.available());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadBuffer.size);
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
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.chunkSize);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  void testNewRandomAccessReadBuffer3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(input);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[10]);
    assertEquals((byte) 0, arrayResult[11]);
    assertEquals((byte) 0, arrayResult[12]);
    assertEquals((byte) 0, arrayResult[13]);
    assertEquals((byte) 0, arrayResult[14]);
    assertEquals((byte) 0, arrayResult[15]);
    assertEquals((byte) 0, arrayResult[17]);
    assertEquals((byte) 0, arrayResult[18]);
    assertEquals((byte) 0, arrayResult[19]);
    assertEquals((byte) 0, arrayResult[20]);
    assertEquals((byte) 0, arrayResult[21]);
    assertEquals((byte) 0, arrayResult[22]);
    assertEquals((byte) 0, arrayResult[23]);
    assertEquals((byte) 0, arrayResult[24]);
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
    assertEquals((byte) 0, arrayResult[8]);
    assertEquals((byte) 0, arrayResult[9]);
    assertEquals((byte) 0, arrayResult[Short.SIZE]);
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualRandomAccessReadBuffer.available());
    assertEquals(8L, actualRandomAccessReadBuffer.size);
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.chunkSize);
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
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  void testNewRandomAccessReadBuffer4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(input);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.available());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadBuffer.size);
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
    assertFalse(byteBuffer.hasRemaining());
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.chunkSize);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  void testNewRandomAccessReadBuffer5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> new RandomAccessReadBuffer(input));
    verify(input).read(isA(byte[].class));
    verify(input, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  void testNewRandomAccessReadBuffer6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(input);

    // Assert
    verify(input).read(isA(byte[].class));
    verify(input, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
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
    assertEquals(4096L, actualRandomAccessReadBuffer.size);
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.available());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.chunkSize);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessReadBuffer()).read());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read()}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));

    // Act
    int actualReadResult = createBufferFromStreamResult.read();

    // Assert
    assertEquals(1, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(1L, createBufferFromStreamResult.getPosition());
    assertEquals(1L, createBufferFromStreamResult.pointer);
    assertEquals(65, actualReadResult);
    assertEquals(7, createBufferFromStreamResult.available());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read()}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act
    int actualReadResult = createBufferFromStreamResult.read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0, actualReadResult);
    assertEquals(1, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(1L, createBufferFromStreamResult.getPosition());
    assertEquals(1L, createBufferFromStreamResult.pointer);
    assertEquals(4095, createBufferFromStreamResult.available());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read(byte[], int, int)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadBuffer.read(b, 2, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
    assertEquals('X', b[3]);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read(byte[], int, int)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b, 2, 3);

    // Assert
    assertEquals((byte) -1, b[3]);
    assertEquals(3, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(3, actualReadResult);
    assertEquals(3, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(3L, createBufferFromStreamResult.getPosition());
    assertEquals(3L, createBufferFromStreamResult.pointer);
    assertEquals(5, createBufferFromStreamResult.available());
    assertEquals(8, b.length);
    assertEquals('A', b[2]);
    assertEquals('A', b[4]);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#read(byte[], int, int)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b, 2, 3);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals((byte) 0, b[2]);
    assertEquals((byte) 0, b[3]);
    assertEquals((byte) 0, b[4]);
    assertEquals(3, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(3, actualReadResult);
    assertEquals(3, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(3L, createBufferFromStreamResult.getPosition());
    assertEquals(3L, createBufferFromStreamResult.pointer);
    assertEquals(4093, createBufferFromStreamResult.available());
    assertEquals(8, b.length);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadBuffer()).length());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#length()}
   */
  @Test
  void testLength2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    long actualLengthResult = RandomAccessReadBuffer.createBufferFromStream(inputStream).length();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(4096L, actualLengthResult);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#expandBuffer()}
   */
  @Test
  void testExpandBuffer() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    RandomAccessReadBuffer.createBufferFromStream(inputStream).expandBuffer();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#checkClosed()}
   */
  @Test
  void testCheckClosed() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    RandomAccessReadBuffer.createBufferFromStream(inputStream).checkClosed();

    // Assert that nothing has changed
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#isClosed()}
   */
  @Test
  void testIsClosed() {
    // Arrange, Act and Assert
    assertFalse((new RandomAccessReadBuffer()).isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#isClosed()}
   */
  @Test
  void testIsClosed2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    boolean actualIsClosedResult = RandomAccessReadBuffer.createBufferFromStream(inputStream).isClosed();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertFalse(actualIsClosedResult);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#isEOF()}
   */
  @Test
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new RandomAccessReadBuffer()).isEOF());
    assertFalse(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .isEOF());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#isEOF()}
   */
  @Test
  void testIsEOF2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    boolean actualIsEOFResult = RandomAccessReadBuffer.createBufferFromStream(inputStream).isEOF();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertFalse(actualIsEOFResult);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#createView(long, long)}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateViewResult = (new RandomAccessReadBuffer()).createView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateViewResult.getPosition());
    assertEquals(3, actualCreateViewResult.available());
    assertFalse(actualCreateViewResult.isClosed());
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#createView(long, long)}
   */
  @Test
  void testCreateView2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    RandomAccessReadView actualCreateViewResult = RandomAccessReadBuffer.createBufferFromStream(inputStream)
        .createView(1L, 3L);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0L, actualCreateViewResult.getPosition());
    assertEquals(3, actualCreateViewResult.available());
    assertFalse(actualCreateViewResult.isClosed());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  void testCreateBufferFromStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessReadBuffer actualCreateBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(inputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[]{}));
    ByteBuffer byteBuffer = actualCreateBufferFromStreamResult.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualCreateBufferFromStreamResult.currentBufferPointer);
    assertEquals(0L, actualCreateBufferFromStreamResult.getPosition());
    assertEquals(0L, actualCreateBufferFromStreamResult.pointer);
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[10]);
    assertEquals((byte) 0, arrayResult[11]);
    assertEquals((byte) 0, arrayResult[12]);
    assertEquals((byte) 0, arrayResult[13]);
    assertEquals((byte) 0, arrayResult[14]);
    assertEquals((byte) 0, arrayResult[15]);
    assertEquals((byte) 0, arrayResult[17]);
    assertEquals((byte) 0, arrayResult[18]);
    assertEquals((byte) 0, arrayResult[19]);
    assertEquals((byte) 0, arrayResult[20]);
    assertEquals((byte) 0, arrayResult[21]);
    assertEquals((byte) 0, arrayResult[22]);
    assertEquals((byte) 0, arrayResult[23]);
    assertEquals((byte) 0, arrayResult[24]);
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
    assertEquals((byte) 0, arrayResult[8]);
    assertEquals((byte) 0, arrayResult[9]);
    assertEquals((byte) 0, arrayResult[Short.SIZE]);
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualCreateBufferFromStreamResult.available());
    assertEquals(8L, actualCreateBufferFromStreamResult.size);
    assertFalse(actualCreateBufferFromStreamResult.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualCreateBufferFromStreamResult.chunkSize);
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
   * Method under test:
   * {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  void testCreateBufferFromStream2() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{});

    // Act
    RandomAccessReadBuffer actualCreateBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(inputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[]{}));
    ByteBuffer byteBuffer = actualCreateBufferFromStreamResult.currentBuffer;
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualCreateBufferFromStreamResult.available());
    assertEquals(0, actualCreateBufferFromStreamResult.currentBufferPointer);
    assertEquals(0L, actualCreateBufferFromStreamResult.getPosition());
    assertEquals(0L, actualCreateBufferFromStreamResult.pointer);
    assertEquals(0L, actualCreateBufferFromStreamResult.size);
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
    assertFalse(byteBuffer.hasRemaining());
    assertFalse(actualCreateBufferFromStreamResult.isClosed());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualCreateBufferFromStreamResult.chunkSize);
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  void testCreateBufferFromStream3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException("foo"));
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act and Assert
    assertThrows(IOException.class, () -> RandomAccessReadBuffer.createBufferFromStream(inputStream));
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  void testCreateBufferFromStream4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act
    RandomAccessReadBuffer actualCreateBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(inputStream);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    ByteBuffer byteBuffer = actualCreateBufferFromStreamResult.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualCreateBufferFromStreamResult.currentBufferPointer);
    assertEquals(0L, actualCreateBufferFromStreamResult.getPosition());
    assertEquals(0L, actualCreateBufferFromStreamResult.pointer);
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
    assertEquals(4096L, actualCreateBufferFromStreamResult.size);
    assertFalse(actualCreateBufferFromStreamResult.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualCreateBufferFromStreamResult.available());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualCreateBufferFromStreamResult.chunkSize);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#resetBuffers()}
   */
  @Test
  void testResetBuffers() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer.createBufferFromStream(inputStream);

    // Act
    createBufferFromStreamResult.resetBuffers();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
    assertEquals(0, createBufferFromStreamResult.available());
    assertEquals(0L, createBufferFromStreamResult.size);
  }

  /**
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(int)}
   */
  @Test
  void testNewRandomAccessReadBuffer2() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(3);

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.available());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadBuffer.size);
    assertEquals(3, byteBuffer.capacity());
    assertEquals(3, byteBuffer.limit());
    assertEquals(3, actualRandomAccessReadBuffer.chunkSize);
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertArrayEquals(new byte[]{0, 0, 0}, byteBuffer.array());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(ByteBuffer)}
   */
  @Test
  void testNewRandomAccessReadBuffer7() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(
        ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    assertEquals(8, byteBuffer.capacity());
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualRandomAccessReadBuffer.available());
    assertEquals(8, actualRandomAccessReadBuffer.chunkSize);
    assertEquals(8L, actualRandomAccessReadBuffer.size);
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    byte[] expectedArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedArrayResult, byteBuffer.array());
  }

  /**
   * Method under test:
   * {@link RandomAccessReadBuffer#RandomAccessReadBuffer(byte[])}
   */
  @Test
  void testNewRandomAccessReadBuffer8() throws IOException {
    // Arrange
    byte[] input = "AXAXAXAX".getBytes("UTF-8");

    // Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(input);

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadBuffer.getPosition());
    assertEquals(0L, actualRandomAccessReadBuffer.pointer);
    assertEquals(8, byteBuffer.capacity());
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualRandomAccessReadBuffer.available());
    assertEquals(8, actualRandomAccessReadBuffer.chunkSize);
    assertEquals(8L, actualRandomAccessReadBuffer.size);
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertSame(input, byteBuffer.array());
  }
}
