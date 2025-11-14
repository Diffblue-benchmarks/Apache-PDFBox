package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TTCDataStreamDiffblueTest {
  /**
   * Test {@link TTCDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is AA backspace AAXAX Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'off', 'len'; then 'AXAXAXAX' Bytes is 'UTF-8' is AA backspace AAXAX Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTCDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenAxaxaxaxBytesIsUtf8IsAaBackspaceAaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")));
    TTCDataStream stream2 = new TTCDataStream(stream);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, new TTCDataStream(stream2).read(b, 1, 3));
    assertArrayEquals("AA\bAAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link TTCDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AAXAAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'off', 'len'; then 'AXAXAXAX' Bytes is 'UTF-8' is 'AAXAAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTCDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenAxaxaxaxBytesIsUtf8IsAaxaaxaxBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, new TTCDataStream(stream).read(b, 1, 3));
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link TTCDataStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with A backspace A
   *       backspace A backspace A Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with A backspace A backspace A backspace A Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTCDataStream.read()"})
  void testRead_givenByteArrayInputStreamWithABackspaceABackspaceABackspaceABytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")));
    TTCDataStream stream2 = new TTCDataStream(stream);

    // Act and Assert
    assertEquals(65, new TTCDataStream(stream2).read());
  }

  /**
   * Test {@link TTCDataStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTCDataStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(65, new TTCDataStream(stream).read());
  }

  /**
   * Test {@link TTCDataStream#readLong()}.
   *
   * <ul>
   *   <li>Then return {@code 4686066915985604872}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '4686066915985604872'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.readLong()"})
  void testReadLong_thenReturn4686066915985604872() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")));
    TTCDataStream stream2 = new TTCDataStream(stream);

    // Act and Assert
    assertEquals(4686066915985604872L, new TTCDataStream(stream2).readLong());
  }

  /**
   * Test {@link TTCDataStream#readLong()}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '4708585257725083992'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.readLong()"})
  void testReadLong_thenReturn4708585257725083992() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(4708585257725083992L, new TTCDataStream(stream).readLong());
  }

  /**
   * Test {@link TTCDataStream#getCurrentPosition()}.
   *
   * <ul>
   *   <li>Given {@link TTCDataStream#TTCDataStream(TTFDataStream)} with stream is {@link
   *       TTCDataStream#TTCDataStream(TTFDataStream)}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName(
      "Test getCurrentPosition(); given TTCDataStream(TTFDataStream) with stream is TTCDataStream(TTFDataStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.getCurrentPosition()"})
  void testGetCurrentPosition_givenTTCDataStreamWithStreamIsTTCDataStream() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TTCDataStream stream2 = new TTCDataStream(stream);

    // Act and Assert
    assertEquals(0L, new TTCDataStream(stream2).getCurrentPosition());
  }

  /**
   * Test {@link TTCDataStream#getCurrentPosition()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.getCurrentPosition()"})
  void testGetCurrentPosition_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0L, new TTCDataStream(stream).getCurrentPosition());
  }

  /**
   * Test {@link TTCDataStream#getOriginalDataSize()}.
   *
   * <ul>
   *   <li>Given {@link TTCDataStream#TTCDataStream(TTFDataStream)} with stream is {@link
   *       TTCDataStream#TTCDataStream(TTFDataStream)}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName(
      "Test getOriginalDataSize(); given TTCDataStream(TTFDataStream) with stream is TTCDataStream(TTFDataStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.getOriginalDataSize()"})
  void testGetOriginalDataSize_givenTTCDataStreamWithStreamIsTTCDataStream() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    TTCDataStream stream2 = new TTCDataStream(stream);

    // Act and Assert
    assertEquals(8L, new TTCDataStream(stream2).getOriginalDataSize());
  }

  /**
   * Test {@link TTCDataStream#getOriginalDataSize()}.
   *
   * <ul>
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize(); then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTCDataStream.getOriginalDataSize()"})
  void testGetOriginalDataSize_thenReturnEight() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(8L, new TTCDataStream(stream).getOriginalDataSize());
  }

  /**
   * Test {@link TTCDataStream#createSubView(long)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@link RandomAccessReadView}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long); given 'A'; then return RandomAccessReadView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead TTCDataStream.createSubView(long)"})
  void testCreateSubView_givenA_thenReturnRandomAccessReadView() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(
            new byte[] {
              'A',
              GlyfDescript.ON_CURVE,
              'A',
              GlyfDescript.ON_CURVE,
              'A',
              GlyfDescript.ON_CURVE,
              'A',
              GlyfDescript.ON_CURVE
            });
    RandomAccessReadDataStream stream = new RandomAccessReadDataStream(inputStream);
    TTCDataStream stream2 = new TTCDataStream(stream);

    // Act
    RandomAccessRead actualCreateSubViewResult = new TTCDataStream(stream2).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Test {@link TTCDataStream#createSubView(long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  @DisplayName(
      "Test createSubView(long); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead TTCDataStream.createSubView(long)"})
  void testCreateSubView_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    RandomAccessReadDataStream stream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    RandomAccessRead actualCreateSubViewResult = new TTCDataStream(stream).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
