package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomAccessReadBufferDiffblueTest {
  /**
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>()"})
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
    assertFalse(actualRandomAccessReadBuffer.isClosed());
    assertTrue(byteBuffer.hasRemaining());
    assertTrue(byteBuffer.hasArray());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.array().length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.chunkSize);
  }

  /**
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(InputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(InputStream)"})
  void testNewRandomAccessReadBuffer2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(input);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualRandomAccessReadBuffer.available());
    assertEquals(8L, actualRandomAccessReadBuffer.size);
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
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(byte[])}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(byte[])}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(byte[])"})
  void testNewRandomAccessReadBuffer3() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer("AXAXAXAX".getBytes("UTF-8"));

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
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(InputStream); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(InputStream)"})
  void testNewRandomAccessReadBuffer_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(InputStream); given minus one; then return first element is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(InputStream)"})
  void testNewRandomAccessReadBuffer_givenMinusOne_thenReturnFirstElementIsZero() throws IOException {
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
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[0]);
    assertEquals((byte) 0, arrayResult[1]);
    assertEquals((byte) 0, arrayResult[2]);
    assertEquals((byte) 0, arrayResult[3]);
    assertEquals((byte) 0, arrayResult[4]);
    assertEquals((byte) 0, arrayResult[5]);
    assertEquals((byte) 0, arrayResult[6]);
    assertEquals((byte) 0, arrayResult[7]);
    assertEquals(4096L, actualRandomAccessReadBuffer.size);
    assertTrue(byteBuffer.hasRemaining());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadBuffer.available());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
  }

  /**
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer#currentBuffer} limit is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(InputStream); then return currentBuffer limit is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(InputStream)"})
  void testNewRandomAccessReadBuffer_thenReturnCurrentBufferLimitIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualRandomAccessReadBuffer = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{}));

    // Assert
    ByteBuffer byteBuffer = actualRandomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, actualRandomAccessReadBuffer.available());
    assertEquals(0L, actualRandomAccessReadBuffer.size);
    assertFalse(byteBuffer.hasRemaining());
  }

  /**
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(ByteBuffer)}.
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer#currentBuffer} position is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(ByteBuffer)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(ByteBuffer); then return currentBuffer position is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(ByteBuffer)"})
  void testNewRandomAccessReadBuffer_thenReturnCurrentBufferPositionIsZero() throws IOException {
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
   * Test {@link RandomAccessReadBuffer#RandomAccessReadBuffer(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link RandomAccessReadBuffer#currentBuffer} position is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#RandomAccessReadBuffer(int)}
   */
  @Test
  @DisplayName("Test new RandomAccessReadBuffer(int); when three; then return currentBuffer position is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.<init>(int)"})
  void testNewRandomAccessReadBuffer_whenThree_thenReturnCurrentBufferPositionIsZero() throws IOException {
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
   * Test {@link RandomAccessReadBuffer#close()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.close()"})
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
   * Test {@link RandomAccessReadBuffer#seek(long)}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.seek(long)"})
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
   * Test {@link RandomAccessReadBuffer#seek(long)}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.seek(long)"})
  void testSeek2() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer(0);

    // Act
    randomAccessReadBuffer.seek(1L);

    // Assert that nothing has changed
    assertEquals(0, randomAccessReadBuffer.currentBuffer.position());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
  }

  /**
   * Test {@link RandomAccessReadBuffer#seek(long)}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); given RandomAccessReadBuffer(); when minus one; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.seek(long)"})
  void testSeek_givenRandomAccessReadBuffer_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new RandomAccessReadBuffer()).seek(-1L));
  }

  /**
   * Test {@link RandomAccessReadBuffer#seek(long)}.
   * <ul>
   *   <li>Then {@link RandomAccessReadBuffer#RandomAccessReadBuffer()} {@link RandomAccessReadBuffer#currentBuffer} position is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); then RandomAccessReadBuffer() currentBuffer position is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadBuffer.seek(long)"})
  void testSeek_thenRandomAccessReadBufferCurrentBufferPositionIsZero() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();

    // Act
    randomAccessReadBuffer.seek(1L);

    // Assert that nothing has changed
    assertEquals(0, randomAccessReadBuffer.currentBuffer.position());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
  }

  /**
   * Test {@link RandomAccessReadBuffer#getPosition()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadBuffer.getPosition()"})
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadBuffer()).getPosition());
  }

  /**
   * Test {@link RandomAccessReadBuffer#read()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadBuffer.read()"})
  void testRead() throws IOException {
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
   * Test {@link RandomAccessReadBuffer#read(byte[], int, int)} with {@code b}, {@code offset}, {@code length}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadBuffer.read(byte[], int, int)"})
  void testReadWithBOffsetLength() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b, 2, 3);

    // Assert
    assertEquals(3, createBufferFromStreamResult.currentBuffer.position());
    assertEquals(3, actualReadResult);
    assertEquals(3, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(3L, createBufferFromStreamResult.getPosition());
    assertEquals(3L, createBufferFromStreamResult.pointer);
    assertEquals(5, createBufferFromStreamResult.available());
    assertArrayEquals(new byte[]{'A', 'X', 'A', -1, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link RandomAccessReadBuffer#read(byte[], int, int)} with {@code b}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'; given RandomAccessReadBuffer(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadBuffer.read(byte[], int, int)"})
  void testReadWithBOffsetLength_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadBuffer.read(b, 2, 3));
    assertEquals(0, randomAccessReadBuffer.currentBuffer.position());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadBuffer#read()}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#read()}
   */
  @Test
  @DisplayName("Test read(); given RandomAccessReadBuffer(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadBuffer.read()"})
  void testRead_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();

    // Act and Assert
    assertEquals(-1, randomAccessReadBuffer.read());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
  }

  /**
   * Test {@link RandomAccessReadBuffer#length()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadBuffer.length()"})
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadBuffer()).length());
  }

  /**
   * Test {@link RandomAccessReadBuffer#isClosed()}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RandomAccessReadBuffer.isClosed()"})
  void testIsClosed() {
    // Arrange, Act and Assert
    assertFalse((new RandomAccessReadBuffer()).isClosed());
  }

  /**
   * Test {@link RandomAccessReadBuffer#isEOF()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); given 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RandomAccessReadBuffer.isEOF()"})
  void testIsEOF_givenA_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))
        .isEOF());
  }

  /**
   * Test {@link RandomAccessReadBuffer#isEOF()}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); given RandomAccessReadBuffer(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RandomAccessReadBuffer.isEOF()"})
  void testIsEOF_givenRandomAccessReadBuffer_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new RandomAccessReadBuffer()).isEOF());
  }

  /**
   * Test {@link RandomAccessReadBuffer#createView(long, long)}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessReadView RandomAccessReadBuffer.createView(long, long)"})
  void testCreateView() throws IOException {
    // Arrange and Act
    RandomAccessReadView actualCreateViewResult = (new RandomAccessReadBuffer()).createView(1L, 3L);

    // Assert
    assertEquals(0L, actualCreateViewResult.getPosition());
    assertEquals(3, actualCreateViewResult.available());
    assertFalse(actualCreateViewResult.isClosed());
  }

  /**
   * Test {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}.
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  @DisplayName("Test createBufferFromStream(InputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessReadBuffer RandomAccessReadBuffer.createBufferFromStream(InputStream)"})
  void testCreateBufferFromStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessReadBuffer actualCreateBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(inputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[]{}));
    ByteBuffer byteBuffer = actualCreateBufferFromStreamResult.currentBuffer;
    assertEquals(8, byteBuffer.limit());
    assertEquals(8, actualCreateBufferFromStreamResult.available());
    assertEquals(8L, actualCreateBufferFromStreamResult.size);
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
   * Test {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  @DisplayName("Test createBufferFromStream(InputStream); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessReadBuffer RandomAccessReadBuffer.createBufferFromStream(InputStream)"})
  void testCreateBufferFromStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return first element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  @DisplayName("Test createBufferFromStream(InputStream); given minus one; then return first element is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessReadBuffer RandomAccessReadBuffer.createBufferFromStream(InputStream)"})
  void testCreateBufferFromStream_givenMinusOne_thenReturnFirstElementIsZero() throws IOException {
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
    byte[] arrayResult = byteBuffer.array();
    assertEquals((byte) 0, arrayResult[0]);
    assertEquals((byte) 0, arrayResult[1]);
    assertEquals((byte) 0, arrayResult[2]);
    assertEquals((byte) 0, arrayResult[3]);
    assertEquals((byte) 0, arrayResult[4]);
    assertEquals((byte) 0, arrayResult[5]);
    assertEquals((byte) 0, arrayResult[6]);
    assertEquals((byte) 0, arrayResult[7]);
    assertEquals(4096L, actualCreateBufferFromStreamResult.size);
    assertTrue(byteBuffer.hasRemaining());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.limit());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualCreateBufferFromStreamResult.available());
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
  }

  /**
   * Test {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}.
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer#currentBuffer} limit is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadBuffer#createBufferFromStream(InputStream)}
   */
  @Test
  @DisplayName("Test createBufferFromStream(InputStream); then return currentBuffer limit is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessReadBuffer RandomAccessReadBuffer.createBufferFromStream(InputStream)"})
  void testCreateBufferFromStream_thenReturnCurrentBufferLimitIsZero() throws IOException {
    // Arrange and Act
    RandomAccessReadBuffer actualCreateBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{}));

    // Assert
    ByteBuffer byteBuffer = actualCreateBufferFromStreamResult.currentBuffer;
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, actualCreateBufferFromStreamResult.available());
    assertEquals(0L, actualCreateBufferFromStreamResult.size);
    assertFalse(byteBuffer.hasRemaining());
  }
}
