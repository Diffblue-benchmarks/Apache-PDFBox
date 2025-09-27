package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TTFDataStreamDiffblueTest {
  /**
   * Test {@link TTFDataStream#read32Fixed()}.
   *
   * <ul>
   *   <li>Then return {@code 16728.256}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  @DisplayName("Test read32Fixed(); then return '16728.256'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TTFDataStream.read32Fixed()"})
  void testRead32Fixed_thenReturn16728256() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        16728.256f,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .read32Fixed());
  }

  /**
   * Test {@link TTFDataStream#read32Fixed()}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  @DisplayName("Test read32Fixed(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TTFDataStream.read32Fixed()"})
  void testRead32Fixed_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () -> new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).read32Fixed());
  }

  /**
   * Test {@link TTFDataStream#readString(int, Charset)} with {@code length}, {@code charset}.
   *
   * <ul>
   *   <li>Then return {@code AXA}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readString(int, Charset)}
   */
  @Test
  @DisplayName("Test readString(int, Charset) with 'length', 'charset'; then return 'AXA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readString(int, Charset)"})
  void testReadStringWithLengthCharset_thenReturnAxa() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals("AXA", randomAccessReadDataStream.readString(3, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link TTFDataStream#readString(int, Charset)} with {@code length}, {@code charset}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readString(int, Charset)}
   */
  @Test
  @DisplayName("Test readString(int, Charset) with 'length', 'charset'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readString(int, Charset)"})
  void testReadStringWithLengthCharset_thenThrowIOException() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream =
        new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3));

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> randomAccessReadDataStream.readString(3, Charset.forName("UTF-8")));
  }

  /**
   * Test {@link TTFDataStream#readString(int)} with {@code length}.
   *
   * <ul>
   *   <li>Then return {@code AXA}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'length'; then return 'AXA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readString(int)"})
  void testReadStringWithLength_thenReturnAxa() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "AXA",
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readString(3));
  }

  /**
   * Test {@link TTFDataStream#readString(int)} with {@code length}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'length'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readString(int)"})
  void testReadStringWithLength_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readString(3));
  }

  /**
   * Test {@link TTFDataStream#read(int)} with {@code int}.
   *
   * <ul>
   *   <li>When {@link CmapTable#ENCODING_WIN_UNICODE_FULL}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#read(int)}
   */
  @Test
  @DisplayName("Test read(int) with 'int'; when ENCODING_WIN_UNICODE_FULL; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TTFDataStream.read(int)"})
  void testReadWithInt_whenEncoding_win_unicode_full_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
                .read(CmapTable.ENCODING_WIN_UNICODE_FULL));
  }

  /**
   * Test {@link TTFDataStream#read(int)} with {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#read(int)}
   */
  @Test
  @DisplayName("Test read(int) with 'int'; when zero; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TTFDataStream.read(int)"})
  void testReadWithInt_whenZero_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .read(0));
  }

  /**
   * Test {@link TTFDataStream#readSignedByte()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  @DisplayName("Test readSignedByte(); given 'A'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readSignedByte()"})
  void testReadSignedByte_givenA_thenReturnMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(-1, new RandomAccessReadDataStream(inputStream).readSignedByte());
  }

  /**
   * Test {@link TTFDataStream#readSignedByte()}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  @DisplayName("Test readSignedByte(); then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readSignedByte()"})
  void testReadSignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        65,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readSignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readUnsignedByte()"})
  void testReadUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        65,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readUnsignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readUnsignedByte()"})
  void testReadUnsignedByte_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () ->
            new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readUnsignedByte());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedInt()}.
   *
   * <ul>
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  @DisplayName("Test readUnsignedInt(); then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTFDataStream.readUnsignedInt()"})
  void testReadUnsignedInt_thenReturn1096302936() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        1096302936L,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readUnsignedInt());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedInt()}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  @DisplayName("Test readUnsignedInt(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TTFDataStream.readUnsignedInt()"})
  void testReadUnsignedInt_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () -> new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readUnsignedInt());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShort()}.
   *
   * <ul>
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  @DisplayName("Test readUnsignedShort(); then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readUnsignedShort()"})
  void testReadUnsignedShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        16728,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readUnsignedShort());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShort()}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  @DisplayName("Test readUnsignedShort(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TTFDataStream.readUnsignedShort()"})
  void testReadUnsignedShort_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () ->
            new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readUnsignedShort());
  }

  /**
   * Test {@link TTFDataStream#readUnsignedByteArray(int)}.
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedByteArray(int)}
   */
  @Test
  @DisplayName("Test readUnsignedByteArray(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] TTFDataStream.readUnsignedByteArray(int)"})
  void testReadUnsignedByteArray() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {65, 88, 65},
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readUnsignedByteArray(3));
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShortArray(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedShortArray(int)}
   */
  @Test
  @DisplayName("Test readUnsignedShortArray(int); when five; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] TTFDataStream.readUnsignedShortArray(int)"})
  void testReadUnsignedShortArray_whenFive_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () ->
            new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
                .readUnsignedShortArray(5));
  }

  /**
   * Test {@link TTFDataStream#readUnsignedShortArray(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return array of {@code int} with {@code 16728} and {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readUnsignedShortArray(int)}
   */
  @Test
  @DisplayName(
      "Test readUnsignedShortArray(int); when three; then return array of int with '16728' and '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] TTFDataStream.readUnsignedShortArray(int)"})
  void testReadUnsignedShortArray_whenThree_thenReturnArrayOfIntWith16728And16728()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {16728, 16728, 16728},
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readUnsignedShortArray(3));
  }

  /**
   * Test {@link TTFDataStream#readSignedShort()}.
   *
   * <ul>
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  @DisplayName("Test readSignedShort(); then return '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short TTFDataStream.readSignedShort()"})
  void testReadSignedShort_thenReturn16728() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        (short) 16728,
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readSignedShort());
  }

  /**
   * Test {@link TTFDataStream#readSignedShort()}.
   *
   * <ul>
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  @DisplayName("Test readSignedShort(); then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short TTFDataStream.readSignedShort()"})
  void testReadSignedShort_thenThrowEOFException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () -> new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readSignedShort());
  }

  /**
   * Test {@link TTFDataStream#readInternationalDate()}.
   *
   * <p>Method under test: {@link TTFDataStream#readInternationalDate()}
   */
  @Test
  @DisplayName("Test readInternationalDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar TTFDataStream.readInternationalDate()"})
  void testReadInternationalDate() throws IOException {
    // Arrange and Act
    Calendar actualReadInternationalDateResult =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readInternationalDate();

    // Assert
    assertTrue(actualReadInternationalDateResult instanceof GregorianCalendar);
    String actualFormatResult =
        new SimpleDateFormat("yyyy-MM-dd").format(actualReadInternationalDateResult.getTime());
    assertEquals("147846313-05-05", actualFormatResult);
    assertEquals("gregory", actualReadInternationalDateResult.getCalendarType());
    assertEquals(1, actualReadInternationalDateResult.getFirstDayOfWeek());
    assertEquals(1, actualReadInternationalDateResult.getMinimalDaysInFirstWeek());
    assertEquals(147846313, actualReadInternationalDateResult.getWeekYear());
    assertEquals(4665516846303529920L, actualReadInternationalDateResult.getTimeInMillis());
    assertEquals(52, actualReadInternationalDateResult.getWeeksInWeekYear());
    assertTrue(actualReadInternationalDateResult.isLenient());
    assertTrue(actualReadInternationalDateResult.isWeekDateSupported());
  }

  /**
   * Test {@link TTFDataStream#readTag()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  @DisplayName(
      "Test readTag(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readTag()"})
  void testReadTag_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnAxax()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "AXAX",
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .readTag());
  }

  /**
   * Test {@link TTFDataStream#readTag()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  @DisplayName("Test readTag(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TTFDataStream.readTag()"})
  void testReadTag_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new RandomAccessReadDataStream(new RandomAccessReadWriteBuffer(3)).readTag());
  }

  /**
   * Test {@link TTFDataStream#createSubView(long)}.
   *
   * <p>Method under test: {@link TTFDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead TTFDataStream.createSubView(long)"})
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
