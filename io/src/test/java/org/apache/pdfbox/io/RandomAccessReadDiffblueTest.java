package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadDiffblueTest {
  /**
   * Test {@link RandomAccessRead#read(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessRead.read(byte[])"})
  void testReadWithByte() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer createBufferFromStreamResult =
        RandomAccessReadBuffer.createBufferFromStream(inputStream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b);

    // Assert
    assertEquals(0, createBufferFromStreamResult.available());
    ByteBuffer byteBuffer = createBufferFromStreamResult.currentBuffer;
    assertEquals(8, byteBuffer.position());
    assertEquals(8, actualReadResult);
    assertEquals(8, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(8L, createBufferFromStreamResult.getPosition());
    assertEquals(8L, createBufferFromStreamResult.pointer);
    assertFalse(byteBuffer.hasRemaining());
    assertArrayEquals(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1}, b);
  }

  /**
   * Test {@link RandomAccessRead#read(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  @DisplayName(
      "Test read(byte[]) with 'byte[]'; given RandomAccessReadBuffer(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessRead.read(byte[])"})
  void testReadWithByte_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = randomAccessReadBuffer.read(b);

    // Assert
    assertEquals(-1, actualReadResult);
    ByteBuffer byteBuffer = randomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
    assertTrue(byteBuffer.hasRemaining());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessRead#peek()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  @DisplayName("Test peek(); given 'A'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessRead.peek()"})
  void testPeek_givenA_thenReturnSixtyFive() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertEquals(65, RandomAccessReadBuffer.createBufferFromStream(inputStream).peek());
  }

  /**
   * Test {@link RandomAccessRead#peek()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  @DisplayName("Test peek(); given RandomAccessReadBuffer(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessRead.peek()"})
  void testPeek_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, new RandomAccessReadBuffer().peek());
  }

  /**
   * Test {@link RandomAccessRead#available()}.
   *
   * <p>Method under test: {@link RandomAccessRead#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessRead.available()"})
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, new RandomAccessReadBuffer().available());
  }
}
