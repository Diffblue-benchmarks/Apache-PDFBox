package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadUnbufferedDataStreamDiffblueTest {
  /**
   * Test {@link
   * RandomAccessReadUnbufferedDataStream#RandomAccessReadUnbufferedDataStream(RandomAccessRead)}.
   *
   * <ul>
   *   <li>Then return OriginalData read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RandomAccessReadUnbufferedDataStream#RandomAccessReadUnbufferedDataStream(RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new RandomAccessReadUnbufferedDataStream(RandomAccessRead); then return OriginalData read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RandomAccessReadUnbufferedDataStream.<init>(RandomAccessRead)"})
  void testNewRandomAccessReadUnbufferedDataStream_thenReturnOriginalDataReadIsMinusOne()
      throws IOException {
    // Arrange and Act
    RandomAccessReadUnbufferedDataStream actualRandomAccessReadUnbufferedDataStream =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));

    // Assert
    int actualReadResult =
        actualRandomAccessReadUnbufferedDataStream.getOriginalData().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(-1L, actualRandomAccessReadUnbufferedDataStream.readLong());
    assertEquals(0L, actualRandomAccessReadUnbufferedDataStream.getCurrentPosition());
    assertEquals(0L, actualRandomAccessReadUnbufferedDataStream.getOriginalDataSize());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#getCurrentPosition()}.
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.getCurrentPosition()"})
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3))
            .getCurrentPosition());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)} with {@code b}, {@code
   * off}, {@code len}.
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertEquals(0L, randomAccessReadUnbufferedDataStream.getCurrentPosition());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)} with {@code b}, {@code
   * off}, {@code len}.
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen2() throws IOException {
    // Arrange
    RandomAccessReadUnbufferedDataStream randomAccessReadUnbufferedDataStream =
        new RandomAccessReadUnbufferedDataStream(
            new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), 3L, 3L));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadUnbufferedDataStream.read(b, 1, 3));
    assertEquals(-1L, randomAccessReadUnbufferedDataStream.getCurrentPosition());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#read()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomAccessReadUnbufferedDataStream.read()"})
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        -1, new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3)).read());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#readLong()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.readLong()"})
  void testReadLong_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        -1L,
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3)).readLong());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#getOriginalData()}.
   *
   * <ul>
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream RandomAccessReadUnbufferedDataStream.getOriginalData()"})
  void testGetOriginalData_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    int actualReadResult =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3))
            .getOriginalData()
            .read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#getOriginalDataSize()}.
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RandomAccessReadUnbufferedDataStream.getOriginalDataSize()"})
  void testGetOriginalDataSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3))
            .getOriginalDataSize());
  }

  /**
   * Test {@link RandomAccessReadUnbufferedDataStream#createSubView(long)}.
   *
   * <p>Method under test: {@link RandomAccessReadUnbufferedDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead RandomAccessReadUnbufferedDataStream.createSubView(long)"})
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult =
        new RandomAccessReadUnbufferedDataStream(new RandomAccessReadWriteBuffer(3))
            .createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
