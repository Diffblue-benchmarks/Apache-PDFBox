package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SequenceRandomAccessReadDiffblueTest {
  /**
   * Test {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}.
   * <ul>
   *   <li>Then return Position is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  @DisplayName("Test new SequenceRandomAccessRead(List); then return Position is zero")
  void testNewSequenceRandomAccessRead_thenReturnPositionIsZero() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    SequenceRandomAccessRead actualSequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Assert
    assertEquals(0L, actualSequenceRandomAccessRead.getPosition());
    assertEquals(8, actualSequenceRandomAccessRead.available());
    assertFalse(actualSequenceRandomAccessRead.isClosed());
  }

  /**
   * Test {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  @DisplayName("Test new SequenceRandomAccessRead(List); when ArrayList(); then throw IllegalArgumentException")
  void testNewSequenceRandomAccessRead_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SequenceRandomAccessRead(new ArrayList<>()));
  }

  /**
   * Test {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)}
   */
  @Test
  @DisplayName("Test new SequenceRandomAccessRead(List); when 'null'; then throw IllegalArgumentException")
  void testNewSequenceRandomAccessRead_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SequenceRandomAccessRead(null));
  }

  /**
   * Test {@link SequenceRandomAccessRead#close()}.
   * <ul>
   *   <li>Then {@link SequenceRandomAccessRead#SequenceRandomAccessRead(List)} with
   * randomAccessReadList is {@link ArrayList#ArrayList()} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#close()}
   */
  @Test
  @DisplayName("Test close(); then SequenceRandomAccessRead(List) with randomAccessReadList is ArrayList() Closed")
  void testClose_thenSequenceRandomAccessReadWithRandomAccessReadListIsArrayListClosed() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.close();

    // Assert
    assertTrue(sequenceRandomAccessRead.isClosed());
  }

  /**
   * Test {@link SequenceRandomAccessRead#read()}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#read()}
   */
  @Test
  @DisplayName("Test read()")
  void testRead() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    int actualReadResult = sequenceRandomAccessRead.read();

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(65, actualReadResult);
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'")
  void testReadWithBOffsetLength() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read("AXAXAXAX".getBytes("UTF-8"), 2, 0));
    assertEquals(0L, sequenceRandomAccessRead.getPosition());
    assertEquals(8, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'")
  void testReadWithBOffsetLength2() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read(new byte[]{}, 2, 3));
    assertEquals(-1L, sequenceRandomAccessRead.getPosition());
    assertEquals(4, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'")
  void testReadWithBOffsetLength3() throws IOException {
    // Arrange
    RandomAccessReadView randomAccessReadView = new RandomAccessReadView(new RandomAccessReadBuffer(), 1L, 3L);
    randomAccessReadView.seek(2147483647L);

    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList.add(randomAccessReadView);
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(-1, sequenceRandomAccessRead.read(new byte[]{}, 2, 3));
    assertEquals(-1L, sequenceRandomAccessRead.getPosition());
    assertEquals(4, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'; then return three")
  void testReadWithBOffsetLength_thenReturnThree() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act and Assert
    assertEquals(3, sequenceRandomAccessRead.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertEquals(3L, sequenceRandomAccessRead.getPosition());
    assertEquals(5, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#getPosition()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(0L, (new SequenceRandomAccessRead(randomAccessReadList)).getPosition());
  }

  /**
   * Test {@link SequenceRandomAccessRead#seek(long)}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  void testSeek() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.seek(1L);

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#seek(long)}.
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  void testSeek2() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);

    // Act
    sequenceRandomAccessRead.seek(8L);

    // Assert
    assertEquals(0, sequenceRandomAccessRead.available());
    assertEquals(8L, sequenceRandomAccessRead.getPosition());
  }

  /**
   * Test {@link SequenceRandomAccessRead#seek(long)}.
   * <ul>
   *   <li>Given {@link SequenceRandomAccessRead#read(byte[], int, int)} with b is
   * {@code AXAXAXAX} Bytes is {@code UTF-8} and offset is two and length is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); given read(byte[], int, int) with b is 'AXAXAXAX' Bytes is 'UTF-8' and offset is two and length is three")
  void testSeek_givenReadWithBIsAxaxaxaxBytesIsUtf8AndOffsetIsTwoAndLengthIsThree() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    SequenceRandomAccessRead sequenceRandomAccessRead = new SequenceRandomAccessRead(randomAccessReadList);
    sequenceRandomAccessRead.read("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Act
    sequenceRandomAccessRead.seek(1L);

    // Assert
    assertEquals(1L, sequenceRandomAccessRead.getPosition());
    assertEquals(7, sequenceRandomAccessRead.available());
  }

  /**
   * Test {@link SequenceRandomAccessRead#seek(long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when minus one; then throw IOException")
  void testSeek_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new SequenceRandomAccessRead(randomAccessReadList)).seek(-1L));
  }

  /**
   * Test {@link SequenceRandomAccessRead#length()}.
   * <ul>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#length()}
   */
  @Test
  @DisplayName("Test length(); then return eight")
  void testLength_thenReturnEight() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertEquals(8L, (new SequenceRandomAccessRead(randomAccessReadList)).length());
  }

  /**
   * Test {@link SequenceRandomAccessRead#isEOF()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); then return 'false'")
  void testIsEOF_thenReturnFalse() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertFalse((new SequenceRandomAccessRead(randomAccessReadList)).isEOF());
  }

  /**
   * Test {@link SequenceRandomAccessRead#createView(long, long)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SequenceRandomAccessRead#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long); then throw UnsupportedOperationException")
  void testCreateView_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    ArrayList<RandomAccessRead> randomAccessReadList = new ArrayList<>();
    randomAccessReadList
        .add(RandomAccessReadBuffer.createBufferFromStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SequenceRandomAccessRead(randomAccessReadList)).createView(1L, 3L));
  }
}
