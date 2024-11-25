package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TTFDataStreamDiffblueTest {
  /**
   * Test {@link TTFDataStream#read32Fixed()}.
   * <ul>
   *   <li>Then return {@code 16728.256}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  @DisplayName("Test read32Fixed(); then return '16728.256'")
  void testRead32Fixed_thenReturn16728256() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728.256f,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read32Fixed());
  }

  /**
   * Test {@link TTFDataStream#read32Fixed()}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  @DisplayName("Test read32Fixed(); then throw EOFException")
  void testRead32Fixed_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).read32Fixed());
  }

  /**
   * Test {@link TTFDataStream#readString(int, Charset)} with {@code length},
   * {@code charset}.
   * <ul>
   *   <li>Then return {@code AXA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readString(int, Charset)}
   */
  @Test
  @DisplayName("Test readString(int, Charset) with 'length', 'charset'; then return 'AXA'")
  void testReadStringWithLengthCharset_thenReturnAxa() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals("AXA", randomAccessReadDataStream.readString(3, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link TTFDataStream#readString(int, Charset)} with {@code length},
   * {@code charset}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readString(int, Charset)}
   */
  @Test
  @DisplayName("Test readString(int, Charset) with 'length', 'charset'; then throw IOException")
  void testReadStringWithLengthCharset_thenThrowIOException() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{}));

    // Act and Assert
    assertThrows(IOException.class, () -> randomAccessReadDataStream.readString(3, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link TTFDataStream#readString(int)} with {@code length}.
   * <ul>
   *   <li>Then return {@code AXA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'length'; then return 'AXA'")
  void testReadStringWithLength_thenReturnAxa() throws IOException {
    // Arrange, Act and Assert
    assertEquals("AXA",
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readString(3));
  }

  /**
   * Test {@link TTFDataStream#readString(int)} with {@code length}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'length'; then throw IOException")
  void testReadStringWithLength_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readString(3));
  }

  /**
   * Test {@link TTFDataStream#read(int)} with {@code int}.
   * <ul>
   *   <li>When {@link CmapTable#ENCODING_WIN_UNICODE_FULL}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#read(int)}
   */
  @Test
  @DisplayName("Test read(int) with 'int'; when ENCODING_WIN_UNICODE_FULL; then throw IOException")
  void testReadWithInt_whenEncoding_win_unicode_full_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .read(CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Test {@link TTFDataStream#read(int)} with {@code int}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#read(int)}
   */
  @Test
  @DisplayName("Test read(int) with 'int'; when zero; then return array length is zero")
  void testReadWithInt_whenZero_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(0).length);
  }

  /**
   * Test {@link TTFDataStream#readSignedByte()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  @DisplayName("Test readSignedByte(); given 'A'; then return minus one")
  void testReadSignedByte_givenA_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})))
            .readSignedByte());
  }

  /**
   * Test {@link TTFDataStream#readSignedByte()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  @DisplayName("Test readSignedByte(); then return sixty-five")
  void testReadSignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readSignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByte()}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then return sixty-five")
  void testReadUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByte()}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw EOFException")
  void testReadUnsignedByte_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedInt()}.
   * <ul>
   *   <li>Then return {@code 1096302936}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  @DisplayName("Test readUnsignedInt(); then return '1096302936'")
  void testReadUnsignedInt_thenReturn1096302936() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1096302936L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedInt());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedInt()}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  @DisplayName("Test readUnsignedInt(); then throw EOFException")
  void testReadUnsignedInt_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedInt());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShort()}.
   * <ul>
   *   <li>Then return {@code 16728}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  @DisplayName("Test readUnsignedShort(); then return '16728'")
  void testReadUnsignedShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedShort());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShort()}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  @DisplayName("Test readUnsignedShort(); then throw EOFException")
  void testReadUnsignedShort_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedShort());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByteArray(int)}.
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedByteArray(int)}
   */
  @Test
  @DisplayName("Test readUnsignedByteArray(int)")
  void testReadUnsignedByteArray() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{65, 88, 65},
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedByteArray(3));
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShortArray(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedShortArray(int)}
   */
  @Test
  @DisplayName("Test readUnsignedShortArray(int); when five; then throw EOFException")
  void testReadUnsignedShortArray_whenFive_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedShortArray(5));
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShortArray(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return array of {@code int} with {@code 16728} and
   * {@code 16728}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readUnsignedShortArray(int)}
   */
  @Test
  @DisplayName("Test readUnsignedShortArray(int); when three; then return array of int with '16728' and '16728'")
  void testReadUnsignedShortArray_whenThree_thenReturnArrayOfIntWith16728And16728() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{16728, 16728, 16728},
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedShortArray(3));
  }

  /**
   * Test {@link TTFDataStream#readSignedShort()}.
   * <ul>
   *   <li>Then return {@code 16728}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  @DisplayName("Test readSignedShort(); then return '16728'")
  void testReadSignedShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals((short) 16728,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readSignedShort());
  }

  /**
   * Test {@link TTFDataStream#readSignedShort()}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  @DisplayName("Test readSignedShort(); then throw EOFException")
  void testReadSignedShort_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readSignedShort());
  }

  /**
   * Test {@link TTFDataStream#readInternationalDate()}.
   * <p>
   * Method under test: {@link TTFDataStream#readInternationalDate()}
   */
  @Test
  @DisplayName("Test readInternationalDate()")
  void testReadInternationalDate() throws IOException {
    // Arrange and Act
    Calendar actualReadInternationalDateResult = (new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readInternationalDate();

    // Assert
    assertTrue(actualReadInternationalDateResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("147846313-05-05", simpleDateFormat.format(actualReadInternationalDateResult.getTime()));
    TimeZone timeZone = actualReadInternationalDateResult.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("UTC", timeZone.getID());
    assertEquals("gregory", actualReadInternationalDateResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(147846313, actualReadInternationalDateResult.getWeekYear());
    assertEquals(2, actualReadInternationalDateResult.getFirstDayOfWeek());
    assertEquals(4, actualReadInternationalDateResult.getMinimalDaysInFirstWeek());
    assertEquals(4665516846303529920L, actualReadInternationalDateResult.getTimeInMillis());
    assertEquals(52, actualReadInternationalDateResult.getWeeksInWeekYear());
    assertTrue(actualReadInternationalDateResult.isLenient());
    assertTrue(actualReadInternationalDateResult.isWeekDateSupported());
  }

  /**
   * Test {@link TTFDataStream#readTag()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  @DisplayName("Test readTag(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAX'")
  void testReadTag_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnAxax() throws IOException {
    // Arrange, Act and Assert
    assertEquals("AXAX",
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readTag());
  }

  /**
   * Test {@link TTFDataStream#readTag()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  @DisplayName("Test readTag(); given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  void testReadTag_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readTag());
  }

  /**
   * Test {@link TTFDataStream#createSubView(long)}.
   * <p>
   * Method under test: {@link TTFDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long)")
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
