package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAccessReadDiffblueTest {
  /**
   * Test {@link RandomAccessRead#read(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then second element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'byte[]'; given 'A'; then second element is minus one")
  void testReadWithByte_givenA_thenSecondElementIsMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBuffer createBufferFromStreamResult = RandomAccessReadBuffer
        .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = createBufferFromStreamResult.read(b);

    // Assert
    assertEquals((byte) -1, b[1]);
    assertEquals((byte) -1, b[3]);
    assertEquals((byte) -1, b[5]);
    assertEquals((byte) -1, b[7]);
    assertEquals(0, createBufferFromStreamResult.available());
    ByteBuffer byteBuffer = createBufferFromStreamResult.currentBuffer;
    assertEquals(8, byteBuffer.position());
    assertEquals(8, actualReadResult);
    assertEquals(8, b.length);
    assertEquals(8, createBufferFromStreamResult.currentBufferPointer);
    assertEquals(8L, createBufferFromStreamResult.getPosition());
    assertEquals(8L, createBufferFromStreamResult.pointer);
    assertFalse(byteBuffer.hasRemaining());
  }

  /**
   * Test {@link RandomAccessRead#read(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessRead#read(byte[])}
   */
  @Test
  @DisplayName("Test read(byte[]) with 'byte[]'; given RandomAccessReadBuffer(); then return minus one")
  void testReadWithByte_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer();
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadBuffer.read(b));
    ByteBuffer byteBuffer = randomAccessReadBuffer.currentBuffer;
    assertEquals(0, byteBuffer.position());
    assertEquals(0, randomAccessReadBuffer.available());
    assertEquals(0, randomAccessReadBuffer.currentBufferPointer);
    assertEquals(0L, randomAccessReadBuffer.getPosition());
    assertEquals(0L, randomAccessReadBuffer.pointer);
    assertEquals(8, b.length);
    assertTrue(byteBuffer.hasRemaining());
    assertEquals('X', b[1]);
    assertEquals('X', b[3]);
    assertEquals('X', b[5]);
    assertEquals('X', b[7]);
  }

  /**
   * Test {@link RandomAccessRead#peek()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  @DisplayName("Test peek(); given 'A'; then return sixty-five")
  void testPeek_givenA_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        RandomAccessReadBuffer
            .createBufferFromStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}))
            .peek());
  }

  /**
   * Test {@link RandomAccessRead#peek()}.
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessRead#peek()}
   */
  @Test
  @DisplayName("Test peek(); given RandomAccessReadBuffer(); then return minus one")
  void testPeek_givenRandomAccessReadBuffer_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessReadBuffer()).peek());
  }

  /**
   * Test {@link RandomAccessRead#available()}.
   * <p>
   * Method under test: {@link RandomAccessRead#available()}
   */
  @Test
  @DisplayName("Test available()")
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new RandomAccessReadBuffer()).available());
  }
}
