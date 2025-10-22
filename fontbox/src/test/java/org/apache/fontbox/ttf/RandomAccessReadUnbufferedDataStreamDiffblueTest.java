package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadUnbufferedDataStreamDiffblueTest {
  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#getCurrentPosition()}.
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.getCurrentPosition()"})
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getCurrentPosition());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read()}.
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read()"})
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).read());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream = new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnThree() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream = new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#readLong()}.
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.readLong()"})
  void testReadLong() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readLong());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#getOriginalDataSize()}.
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.getOriginalDataSize()"})
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L, (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).getOriginalDataSize());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#createSubView(long)}.
   * <p>
   * Method under test: {@link RandomAccessReadUnbufferedDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessRead RandomAccessReadUnbufferedDataStream.createSubView(long)"})
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadUnbufferedDataStream(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
