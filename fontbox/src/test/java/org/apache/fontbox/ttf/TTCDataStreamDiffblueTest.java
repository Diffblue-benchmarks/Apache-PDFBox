package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TTCDataStreamDiffblueTest {
  /**
   * Test {@link TTCDataStream#read(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <ul>
   *   <li>Then third element is backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then third element is backspace")
  void testReadWithBOffLen_thenThirdElementIsBackspace() throws IOException {
    // Arrange
    TTCDataStream ttcDataStream = new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8")))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ttcDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('\b', b[2]);
  }

  /**
   * Test {@link TTCDataStream#read(byte[], int, int)} with {@code b},
   * {@code off}, {@code len}.
   * <ul>
   *   <li>Then third element is {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then third element is 'X'")
  void testReadWithBOffLen_thenThirdElementIsX() throws IOException {
    // Arrange
    TTCDataStream ttcDataStream = new TTCDataStream(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ttcDataStream.read(b, 1, 3));
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Test {@link TTCDataStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with A
   * backspace A backspace A backspace A Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with A backspace A backspace A backspace A Bytes is 'UTF-8'")
  void testRead_givenByteArrayInputStreamWithABackspaceABackspaceABackspaceABytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8"))))))
        .read());
  }

  /**
   * Test {@link TTCDataStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .read());
  }

  /**
   * Test {@link TTCDataStream#readLong()}.
   * <ul>
   *   <li>Then return {@code 4686066915985604872}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '4686066915985604872'")
  void testReadLong_thenReturn4686066915985604872() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4686066915985604872L, (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("A\bA\bA\bA\b".getBytes("UTF-8"))))))
        .readLong());
  }

  /**
   * Test {@link TTCDataStream#readLong()}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '4708585257725083992'")
  void testReadLong_thenReturn4708585257725083992() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readLong());
  }

  /**
   * Test {@link TTCDataStream#getCurrentPosition()}.
   * <ul>
   *   <li>Given {@link TTCDataStream#TTCDataStream(TTFDataStream)} with stream is
   * {@link TTCDataStream#TTCDataStream(TTFDataStream)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition(); given TTCDataStream(TTFDataStream) with stream is TTCDataStream(TTFDataStream)")
  void testGetCurrentPosition_givenTTCDataStreamWithStreamIsTTCDataStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getCurrentPosition());
  }

  /**
   * Test {@link TTCDataStream#getCurrentPosition()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition(); then return zero")
  void testGetCurrentPosition_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCurrentPosition());
  }

  /**
   * Test {@link TTCDataStream#getOriginalData()}.
   * <ul>
   *   <li>Given {@link TTCDataStream#TTCDataStream(TTFDataStream)} with stream is
   * {@link TTCDataStream#TTCDataStream(TTFDataStream)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); given TTCDataStream(TTFDataStream) with stream is TTCDataStream(TTFDataStream)")
  void testGetOriginalData_givenTTCDataStreamWithStreamIsTTCDataStream() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TTCDataStream#getOriginalData()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData(); then return read is eight")
  void testGetOriginalData_thenReturnReadIsEight() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TTCDataStream#getOriginalDataSize()}.
   * <ul>
   *   <li>Given {@link TTCDataStream#TTCDataStream(TTFDataStream)} with stream is
   * {@link TTCDataStream#TTCDataStream(TTFDataStream)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize(); given TTCDataStream(TTFDataStream) with stream is TTCDataStream(TTFDataStream)")
  void testGetOriginalDataSize_givenTTCDataStreamWithStreamIsTTCDataStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TTCDataStream(
            new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getOriginalDataSize());
  }

  /**
   * Test {@link TTCDataStream#getOriginalDataSize()}.
   * <ul>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#getOriginalDataSize()}
   */
  @Test
  @DisplayName("Test getOriginalDataSize(); then return eight")
  void testGetOriginalDataSize_thenReturnEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8L,
        (new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getOriginalDataSize());
  }

  /**
   * Test {@link TTCDataStream#createSubView(long)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@link RandomAccessReadView}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long); given 'A'; then return RandomAccessReadView")
  void testCreateSubView_givenA_thenReturnRandomAccessReadView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new TTCDataStream(
        new TTCDataStream(new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', GlyfDescript.ON_CURVE,
            'A', GlyfDescript.ON_CURVE, 'A', GlyfDescript.ON_CURVE, 'A', GlyfDescript.ON_CURVE})))))
        .createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Test {@link TTCDataStream#createSubView(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTCDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testCreateSubView_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new TTCDataStream(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
