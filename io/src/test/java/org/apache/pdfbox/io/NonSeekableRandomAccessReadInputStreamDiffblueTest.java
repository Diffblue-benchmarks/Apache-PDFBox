package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NonSeekableRandomAccessReadInputStreamDiffblueTest {
  /**
   * Test {@link
   * NonSeekableRandomAccessReadInputStream#NonSeekableRandomAccessReadInputStream(InputStream)}.
   *
   * <p>Method under test: {@link
   * NonSeekableRandomAccessReadInputStream#NonSeekableRandomAccessReadInputStream(InputStream)}
   */
  @Test
  @DisplayName("Test new NonSeekableRandomAccessReadInputStream(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.<init>(InputStream)"})
  void testNewNonSeekableRandomAccessReadInputStream() throws IOException {
    // Arrange and Act
    NonSeekableRandomAccessReadInputStream actualNonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, actualNonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, actualNonSeekableRandomAccessReadInputStream.size);
    assertFalse(actualNonSeekableRandomAccessReadInputStream.isClosed());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#close()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.close()"})
  void testClose() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.close();

    // Assert
    assertTrue(nonSeekableRandomAccessReadInputStream.isClosed());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#seek(long)}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.seek(long)"})
  void testSeek() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new NonSeekableRandomAccessReadInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
                .seek(1L));
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#skip(int)}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  @DisplayName("Test skip(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.skip(int)"})
  void testSkip() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.skip(3);

    // Assert
    assertEquals(3, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(5, nonSeekableRandomAccessReadInputStream.available());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#skip(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>When three.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  @DisplayName(
      "Test skip(int); given DataInputStream read(byte[]) throw IOException(); when three; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.skip(int)"})
  void testSkip_givenDataInputStreamReadThrowIOException_whenThree_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class, () -> new NonSeekableRandomAccessReadInputStream(inputStream).skip(3));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#skip(int)}.
   *
   * <ul>
   *   <li>When nine.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  @DisplayName("Test skip(int); when nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.skip(int)"})
  void testSkip_whenNine() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.skip(9);

    // Assert
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.position);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#skip(int)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#skip(int)}
   */
  @Test
  @DisplayName("Test skip(int); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.skip(int)"})
  void testSkip_whenTen() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.skip(10);

    // Assert
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.position);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#getPosition()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NonSeekableRandomAccessReadInputStream.getPosition()"})
  void testGetPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new NonSeekableRandomAccessReadInputStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .getPosition());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read()"})
  void testRead() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    int actualReadResult = nonSeekableRandomAccessReadInputStream.read();

    // Assert
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(65, actualReadResult);
    assertEquals(7, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} return minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'offset', 'length'; given DataInputStream read(byte[]) return minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read(byte[], int, int)"})
  void testReadWithBOffsetLength_givenDataInputStreamReadReturnMinusOne_thenReturnZero()
      throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    int actualReadResult =
        nonSeekableRandomAccessReadInputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    verify(inputStream).read(isA(byte[].class));
    assertEquals(0, actualReadResult);
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read(byte[], int, int)"})
  void testReadWithBOffsetLength_thenReturnThree() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(
        3, nonSeekableRandomAccessReadInputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertEquals(3, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(3L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(5, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(8L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)} with {@code b},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'offset', 'length'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read(byte[], int, int)"})
  void testReadWithBOffsetLength_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new NonSeekableRandomAccessReadInputStream(inputStream)
                .read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} return minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream read(byte[]) return minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read()"})
  void testRead_givenDataInputStreamReadReturnMinusOne_thenReturnMinusOne() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenReturn(-1);
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(inputStream);

    // Act
    int actualReadResult = nonSeekableRandomAccessReadInputStream.read();

    // Assert
    verify(inputStream).read(isA(byte[].class));
    assertEquals(-1, actualReadResult);
    assertEquals(0, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(0, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.position);
    assertEquals(0L, nonSeekableRandomAccessReadInputStream.size);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream read(byte[]) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NonSeekableRandomAccessReadInputStream.read()"})
  void testRead_givenDataInputStreamReadThrowIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class, () -> new NonSeekableRandomAccessReadInputStream(inputStream).read());
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#length()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NonSeekableRandomAccessReadInputStream.length()"})
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new NonSeekableRandomAccessReadInputStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .length());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#rewind(int)}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.rewind(int)"})
  void testRewind() throws IOException {
    // Arrange
    NonSeekableRandomAccessReadInputStream nonSeekableRandomAccessReadInputStream =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    nonSeekableRandomAccessReadInputStream.rewind(-1);

    // Assert
    assertEquals(-1, nonSeekableRandomAccessReadInputStream.available());
    assertEquals(1, nonSeekableRandomAccessReadInputStream.currentBufferPointer);
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.getPosition());
    assertEquals(1L, nonSeekableRandomAccessReadInputStream.position);
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#rewind(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#rewind(int)}
   */
  @Test
  @DisplayName("Test rewind(int); when one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NonSeekableRandomAccessReadInputStream.rewind(int)"})
  void testRewind_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new NonSeekableRandomAccessReadInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
                .rewind(1));
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#isClosed()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NonSeekableRandomAccessReadInputStream.isClosed()"})
  void testIsClosed() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        new NonSeekableRandomAccessReadInputStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .isClosed());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#isEOF()}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NonSeekableRandomAccessReadInputStream.isEOF()"})
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new NonSeekableRandomAccessReadInputStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .isEOF());
  }

  /**
   * Test {@link NonSeekableRandomAccessReadInputStream#createView(long, long)}.
   *
   * <p>Method under test: {@link NonSeekableRandomAccessReadInputStream#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.io.RandomAccessReadView NonSeekableRandomAccessReadInputStream.createView(long, long)"
  })
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new NonSeekableRandomAccessReadInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
                .createView(1L, 3L));
  }
}
