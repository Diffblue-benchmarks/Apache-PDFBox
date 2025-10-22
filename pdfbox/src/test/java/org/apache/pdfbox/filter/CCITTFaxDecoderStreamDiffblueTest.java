package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CCITTFaxDecoderStreamDiffblueTest {
  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  @DisplayName("Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] byteArray = new byte[1];
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 3, 1L, true)).read(byteArray);
    assertEquals(-1, stream.read(new byte[]{}));
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{0}, byteArray);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  @DisplayName("Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_thenThrowIllegalArgumentException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 1, 1L, true));

  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   * <ul>
   *   <li>When eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  @DisplayName("Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenEight() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] byteArray = new byte[1];
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 3, 8L, true)).read(byteArray);
    assertEquals(-1, stream.read(new byte[]{}));
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{0}, byteArray);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  @DisplayName("Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] byteArray = new byte[1];
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 3, -1L, true)).read(byteArray);
    assertEquals(-1, stream.read(new byte[]{}));
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{0}, byteArray);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}
   */
  @Test
  @DisplayName("Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when two; then array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenTwo_thenArrayOfByteWithZeroAndZero() throws UnsupportedEncodingException {
    // Arrange and Act
    new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, new byte[8]);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true)).read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true)).read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead3() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> (new CCITTFaxDecoderStream(stream, -1, 2, 1L, true)).read());
    verify(stream, atLeast(1)).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead4() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 2, 2, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead5() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, false)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead6() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 128, 4, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead7() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, false)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(128, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt2() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, -1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(stream, atLeast(1)).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt3() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 2, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt4() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, false);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithOneAndX() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0}, new byte[6]);
    assertArrayEquals(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenArrayOfByteWithZeroAndZero() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0}, new byte[7]);
    assertArrayEquals(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndMin_value() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = ccittFaxDecoderStream.read(b, 1, 3);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1, actualReadResult);
    assertArrayEquals(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenReturnThree() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithOneAndX() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1, 2, 1L,
            true)).read());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0}, new byte[6]);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CCITTFaxDecoderStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1,
            2, 1L, true)).read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#read()} throw {@link EOFException#EOFException(String)} with {@code foo}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given DataInputStream read() throw EOFException(String) with 'foo'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_givenDataInputStreamReadThrowEOFExceptionWithFoo_thenReturnZero() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new EOFException("foo"));

    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    ccittFaxDecoderStream.skip(1L);

    // Act
    int actualReadResult = ccittFaxDecoderStream.read();

    // Assert
    verify(stream).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Then array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenArrayOfByteWithZeroAndZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true)).read());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0}, new byte[7]);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Then return one hundred twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenReturnOneHundredTwentyEight() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(128, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   * <ul>
   *   <li>Then return {@link Double#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenReturnSize() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new CCITTFaxDecoderStream(stream, 2, 4, 1L, true)).read();

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(Double.SIZE, actualReadResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1L,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true)).skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true)).skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip3() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> (new CCITTFaxDecoderStream(stream, -1, 2, 1L, true)).skip(1L));
    verify(stream, atLeast(1)).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip4() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 2, 2, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip5() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip6() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 2, 1L, false)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip7() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 2, 4, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip8() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 128, 4, 1L, true)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip9() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenReturn(1);

    // Act
    long actualSkipResult = (new CCITTFaxDecoderStream(stream, 1, 4, 1L, false)).skip(1L);

    // Assert
    verify(stream, atLeast(1)).read();
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); given ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithArrayOfByteWithOneAndX() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1, 2, 1L,
            true)).skip(1L));
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0}, new byte[6]);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CCITTFaxDecoderStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1,
            2, 1L, true)).skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#read()} throw {@link EOFException#EOFException(String)} with {@code foo}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); given DataInputStream read() throw EOFException(String) with 'foo'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenDataInputStreamReadThrowEOFExceptionWithFoo_thenReturnMinusOne() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new EOFException("foo"));

    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Act
    long actualSkipResult = ccittFaxDecoderStream.skip(1L);

    // Assert
    verify(stream).read();
    assertEquals(-1L, actualSkipResult);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   * <ul>
   *   <li>Then array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); then array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_thenArrayOfByteWithZeroAndZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1L,
        (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true)).skip(1L));
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0}, new byte[7]);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#markSupported()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CCITTFaxDecoderStream.markSupported()"})
  void testMarkSupported_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true))
        .markSupported());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#reset()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CCITTFaxDecoderStream#reset()}
   */
  @Test
  @DisplayName("Test reset(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CCITTFaxDecoderStream.reset()"})
  void testReset_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new CCITTFaxDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true))
            .reset());
  }
}
