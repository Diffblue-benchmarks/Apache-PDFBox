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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlateFilterDecoderStreamDiffblueTest {
  /**
   * Test {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#FlateFilterDecoderStream(InputStream)}
   */
  @Test
  @DisplayName("Test new FlateFilterDecoderStream(InputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FlateFilterDecoderStream.<init>(InputStream)"})
  void testNewFlateFilterDecoderStream() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    new FlateFilterDecoderStream(inputStream);

    // Assert
    byte[] byteArray = new byte[6];
    assertEquals(6, inputStream.read(byteArray));
    assertArrayEquals("AXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'X'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenX_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'X'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenX_whenAxaxaxaxBytesIsUtf8_thenReturnZero2() throws IOException {
    // Arrange
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(
        new ByteArrayInputStream(new byte[]{'A', 'X', 4, 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertEquals(0, flateFilterDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link FlateFilterDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then calls {@link FilterInputStream#read()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; when minus one; then calls read()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_whenMinusOne_thenCallsRead() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);
    FlateFilterDecoderStream flateFilterDecoderStream = new FlateFilterDecoderStream(inputStream);

    // Act
    int actualReadResult = flateFilterDecoderStream.read("XXAXAXAX".getBytes("UTF-8"), 2, -1);

    // Assert
    verify(inputStream, atLeast(1)).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with empty array of byte; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithEmptyArrayOfByte_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{}))).read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#read()}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); given 'X'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.read()"})
  void testRead_givenX_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new FlateFilterDecoderStream(new ByteArrayInputStream(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'})))
            .read());
  }

  /**
   * Test {@link FlateFilterDecoderStream#markSupported()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FlateFilterDecoderStream.markSupported()"})
  void testMarkSupported() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Test {@link FlateFilterDecoderStream#skip(long)}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long FlateFilterDecoderStream.skip(long)"})
  void testSkip() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).skip(1L));
  }

  /**
   * Test {@link FlateFilterDecoderStream#available()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int FlateFilterDecoderStream.available()"})
  void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Test {@link FlateFilterDecoderStream#reset()}.
   * <p>
   * Method under test: {@link FlateFilterDecoderStream#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FlateFilterDecoderStream.reset()"})
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new FlateFilterDecoderStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).reset());
  }
}
