package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.Test;

class TTFDataStreamDiffblueTest {
  /**
   * Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  void testRead32Fixed() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728.256f,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read32Fixed());
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).read32Fixed());
  }

  /**
   * Method under test: {@link TTFDataStream#read32Fixed()}
   */
  @Test
  void testRead32Fixed2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    float actualRead32FixedResult = (new RandomAccessReadDataStream(inputStream)).read32Fixed();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(16728.256f, actualRead32FixedResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  void testReadString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("AXA",
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readString(3));
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readString(3));
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readString(3, null));
  }

  /**
   * Method under test: {@link TTFDataStream#readString(int)}
   */
  @Test
  void testReadString2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualReadStringResult = (new RandomAccessReadDataStream(inputStream)).readString(3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals("AXA", actualReadStringResult);
  }

  /**
   * Method under test: {@link TTFDataStream#read(int)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .read(CmapTable.ENCODING_WIN_UNICODE_FULL));
    assertEquals(0,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(0).length);
  }

  /**
   * Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  void testReadSignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readSignedByte());
    assertEquals(-1,
        (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})))
            .readSignedByte());
  }

  /**
   * Method under test: {@link TTFDataStream#readSignedByte()}
   */
  @Test
  void testReadSignedByte2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadSignedByteResult = (new RandomAccessReadDataStream(inputStream)).readSignedByte();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(65, actualReadSignedByteResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  void testReadUnsignedByte() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedByte());
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedByte());
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedByte()}
   */
  @Test
  void testReadUnsignedByte2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadUnsignedByteResult = (new RandomAccessReadDataStream(inputStream)).readUnsignedByte();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(65, actualReadUnsignedByteResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  void testReadUnsignedInt() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1096302936L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedInt());
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedInt());
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedInt()}
   */
  @Test
  void testReadUnsignedInt2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    long actualReadUnsignedIntResult = (new RandomAccessReadDataStream(inputStream)).readUnsignedInt();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(1096302936L, actualReadUnsignedIntResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  void testReadUnsignedShort() throws IOException {
    // Arrange, Act and Assert
    assertEquals(16728,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readUnsignedShort());
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readUnsignedShort());
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedShort()}
   */
  @Test
  void testReadUnsignedShort2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadUnsignedShortResult = (new RandomAccessReadDataStream(inputStream)).readUnsignedShort();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(16728, actualReadUnsignedShortResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedByteArray(int)}
   */
  @Test
  void testReadUnsignedByteArray() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{65, 88, 65},
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedByteArray(3));
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedByteArray(int)}
   */
  @Test
  void testReadUnsignedByteArray2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int[] actualReadUnsignedByteArrayResult = (new RandomAccessReadDataStream(inputStream)).readUnsignedByteArray(3);

    // Assert
    verify(inputStream).readAllBytes();
    assertArrayEquals(new int[]{65, 88, 65}, actualReadUnsignedByteArrayResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readUnsignedShortArray(int)}
   */
  @Test
  void testReadUnsignedShortArray() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{16728, 16728, 16728},
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedShortArray(3));
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .readUnsignedShortArray(5));
  }

  /**
   * Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  void testReadSignedShort() throws IOException {
    // Arrange, Act and Assert
    assertEquals((short) 16728,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readSignedShort());
    assertThrows(EOFException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readSignedShort());
  }

  /**
   * Method under test: {@link TTFDataStream#readSignedShort()}
   */
  @Test
  void testReadSignedShort2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    short actualReadSignedShortResult = (new RandomAccessReadDataStream(inputStream)).readSignedShort();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((short) 16728, actualReadSignedShortResult);
  }

  /**
   * Method under test: {@link TTFDataStream#readInternationalDate()}
   */
  @Test
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
    assertEquals(1, actualReadInternationalDateResult.getFirstDayOfWeek());
    assertEquals(1, actualReadInternationalDateResult.getMinimalDaysInFirstWeek());
    assertEquals(147846313, actualReadInternationalDateResult.getWeekYear());
    assertEquals(4665516846303529920L, actualReadInternationalDateResult.getTimeInMillis());
    assertEquals(52, actualReadInternationalDateResult.getWeeksInWeekYear());
    assertTrue(actualReadInternationalDateResult.isLenient());
    assertTrue(actualReadInternationalDateResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link TTFDataStream#readInternationalDate()}
   */
  @Test
  void testReadInternationalDate2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Calendar actualReadInternationalDateResult = (new RandomAccessReadDataStream(inputStream)).readInternationalDate();

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualReadInternationalDateResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("147846313-05-05", simpleDateFormat.format(actualReadInternationalDateResult.getTime()));
    TimeZone timeZone = actualReadInternationalDateResult.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("UTC", timeZone.getID());
    assertEquals("gregory", actualReadInternationalDateResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualReadInternationalDateResult.getFirstDayOfWeek());
    assertEquals(1, actualReadInternationalDateResult.getMinimalDaysInFirstWeek());
    assertEquals(147846313, actualReadInternationalDateResult.getWeekYear());
    assertEquals(4665516846303529920L, actualReadInternationalDateResult.getTimeInMillis());
    assertEquals(52, actualReadInternationalDateResult.getWeeksInWeekYear());
    assertTrue(actualReadInternationalDateResult.isLenient());
    assertTrue(actualReadInternationalDateResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  void testReadTag() throws IOException {
    // Arrange, Act and Assert
    assertEquals("AXAX",
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readTag());
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readTag());
  }

  /**
   * Method under test: {@link TTFDataStream#readTag()}
   */
  @Test
  void testReadTag2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualReadTagResult = (new RandomAccessReadDataStream(inputStream)).readTag();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals("AXAX", actualReadTagResult);
  }

  /**
   * Method under test: {@link TTFDataStream#createSubView(long)}
   */
  @Test
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

  /**
   * Method under test: {@link TTFDataStream#createSubView(long)}
   */
  @Test
  void testCreateSubView2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadDataStream(inputStream)).createSubView(3L);

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }
}
