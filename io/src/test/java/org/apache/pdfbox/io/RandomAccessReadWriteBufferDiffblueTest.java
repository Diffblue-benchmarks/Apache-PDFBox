package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

class RandomAccessReadWriteBufferDiffblueTest {
  /**
   * Test {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}
   */
  @Test
  @DisplayName("Test new RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.<init>()"})
  void testNewRandomAccessReadWriteBuffer() throws IOException {
    // Arrange and Act
    RandomAccessReadWriteBuffer actualRandomAccessReadWriteBuffer =
        new RandomAccessReadWriteBuffer();

    // Assert
    assertEquals(
        RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, actualRandomAccessReadWriteBuffer.chunkSize);
    ByteBuffer byteBuffer = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.array().length);
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, byteBuffer.capacity());
    ByteBuffer expectedFlipResult = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertSame(expectedFlipResult, byteBuffer.flip());
    assertTrue(byteBuffer.hasArray());
    assertFalse(byteBuffer.hasRemaining());
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.size);
    assertEquals(0, actualRandomAccessReadWriteBuffer.available());
    assertEquals(0L, actualRandomAccessReadWriteBuffer.getPosition());
    assertFalse(actualRandomAccessReadWriteBuffer.isClosed());
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link RandomAccessReadBuffer#chunkSize} is three.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)}
   */
  @Test
  @DisplayName(
      "Test new RandomAccessReadWriteBuffer(int); when three; then return chunkSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.<init>(int)"})
  void testNewRandomAccessReadWriteBuffer_whenThree_thenReturnChunkSizeIsThree()
      throws IOException {
    // Arrange and Act
    RandomAccessReadWriteBuffer actualRandomAccessReadWriteBuffer =
        new RandomAccessReadWriteBuffer(3);

    // Assert
    assertEquals(3, actualRandomAccessReadWriteBuffer.chunkSize);
    ByteBuffer byteBuffer = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertArrayEquals(new byte[] {0, 0, 0}, byteBuffer.array());
    assertEquals(3, byteBuffer.capacity());
    ByteBuffer expectedFlipResult = actualRandomAccessReadWriteBuffer.currentBuffer;
    assertSame(expectedFlipResult, byteBuffer.flip());
    assertTrue(byteBuffer.hasArray());
    assertFalse(byteBuffer.hasRemaining());
    assertEquals(0, byteBuffer.limit());
    assertEquals(0, byteBuffer.position());
    assertEquals(0, actualRandomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.pointer);
    assertEquals(0L, actualRandomAccessReadWriteBuffer.size);
    assertEquals(0, actualRandomAccessReadWriteBuffer.available());
    assertEquals(0L, actualRandomAccessReadWriteBuffer.getPosition());
    assertFalse(actualRandomAccessReadWriteBuffer.isClosed());
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[])"})
  void testWriteWithByte() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer(3);

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(2, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(8L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(8L, randomAccessReadWriteBuffer.pointer);
    assertEquals(8L, randomAccessReadWriteBuffer.size);
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertTrue(byteBuffer.hasRemaining());
    assertArrayEquals(new byte[] {'A', 'X', 0}, byteBuffer.array());
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(byte[], int, int)} with {@code byte[]}, {@code
   * int}, {@code int}.
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 19088743, 0);

    // Assert that nothing has changed
    assertEquals(0, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, randomAccessReadWriteBuffer.pointer);
    assertEquals(0L, randomAccessReadWriteBuffer.size);
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(byte[], int, int)} with {@code byte[]}, {@code
   * int}, {@code int}.
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt2() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Assert
    assertEquals(3, randomAccessReadWriteBuffer.currentBufferPointer);
    byte[] arrayResult = randomAccessReadWriteBuffer.currentBuffer.array();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals('A', arrayResult[1]);
    assertEquals('X', arrayResult[0]);
    assertEquals('X', arrayResult[2]);
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(byte[], int, int)} with {@code byte[]}, {@code
   * int}, {@code int}.
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt3() throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer(1);

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Assert
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertEquals(1, byteBuffer.limit());
    assertEquals(1, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(3L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(3L, randomAccessReadWriteBuffer.pointer);
    assertEquals(3L, randomAccessReadWriteBuffer.size);
    assertArrayEquals(new byte[] {'X'}, byteBuffer.array());
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()} {@link
   *       RandomAccessReadBuffer#currentBufferPointer} is eight.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  @DisplayName(
      "Test write(byte[]) with 'byte[]'; then RandomAccessReadWriteBuffer() currentBufferPointer is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[])"})
  void testWriteWithByte_thenRandomAccessReadWriteBufferCurrentBufferPointerIsEight()
      throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, randomAccessReadWriteBuffer.currentBufferPointer);
    byte[] arrayResult = randomAccessReadWriteBuffer.currentBuffer.array();
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
   * Test {@link RandomAccessReadWriteBuffer#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()} {@link
   *       RandomAccessReadBuffer#currentBufferPointer} is zero.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(byte[])}
   */
  @Test
  @DisplayName(
      "Test write(byte[]) with 'byte[]'; then RandomAccessReadWriteBuffer() currentBufferPointer is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(byte[])"})
  void testWriteWithByte_thenRandomAccessReadWriteBufferCurrentBufferPointerIsZero()
      throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(new byte[] {});

    // Assert that nothing has changed
    assertEquals(0, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(0L, randomAccessReadWriteBuffer.pointer);
    assertEquals(0L, randomAccessReadWriteBuffer.size);
  }

  /**
   * Test {@link RandomAccessReadWriteBuffer#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()} {@link
   *       RandomAccessReadBuffer#currentBufferPointer} is one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadWriteBuffer#write(int)}
   */
  @Test
  @DisplayName(
      "Test write(int) with 'int'; then RandomAccessReadWriteBuffer() currentBufferPointer is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadWriteBuffer.write(int)"})
  void testWriteWithInt_thenRandomAccessReadWriteBufferCurrentBufferPointerIsOne()
      throws IOException {
    // Arrange
    RandomAccessReadWriteBuffer randomAccessReadWriteBuffer = new RandomAccessReadWriteBuffer();

    // Act
    randomAccessReadWriteBuffer.write(19088743);

    // Assert
    assertEquals(1, randomAccessReadWriteBuffer.currentBufferPointer);
    assertEquals(1L, randomAccessReadWriteBuffer.getPosition());
    assertEquals(1L, randomAccessReadWriteBuffer.pointer);
    assertEquals(1L, randomAccessReadWriteBuffer.size);
    ByteBuffer byteBuffer = randomAccessReadWriteBuffer.currentBuffer;
    assertTrue(byteBuffer.hasRemaining());
    byte[] arrayResult = byteBuffer.array();
    assertEquals(RandomAccessReadBuffer.DEFAULT_CHUNK_SIZE_4KB, arrayResult.length);
    assertEquals('g', arrayResult[0]);
  }
}
