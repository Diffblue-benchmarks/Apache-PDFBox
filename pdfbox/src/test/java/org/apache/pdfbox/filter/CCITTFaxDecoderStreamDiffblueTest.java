package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

class CCITTFaxDecoderStreamDiffblueTest {
  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new CCITTFaxDecoderStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 1, 1L, true));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when eight; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenEight_thenDoesNotThrow()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new CCITTFaxDecoderStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 8L, true));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@link CCITTFaxDecoderStream#buffer} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when four; then return buffer is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenFour_thenReturnBufferIsMinusOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    CCITTFaxDecoderStream actualCcittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true);

    // Assert
    assertEquals(-1, actualCcittFaxDecoderStream.buffer);
    assertEquals(-1, actualCcittFaxDecoderStream.bufferPos);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@link CCITTFaxDecoderStream#buffer} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when four; then return buffer is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenFour_thenReturnBufferIsMinusOne2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    CCITTFaxDecoderStream actualCcittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, -1L, true);

    // Assert
    assertEquals(-1, actualCcittFaxDecoderStream.buffer);
    assertEquals(-1, actualCcittFaxDecoderStream.bufferPos);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when minus one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenMinusOne_thenDoesNotThrow()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new CCITTFaxDecoderStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, -1L, true));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when three; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenThree_thenDoesNotThrow()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new CCITTFaxDecoderStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int, long, boolean)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#CCITTFaxDecoderStream(InputStream, int, int,
   * long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new CCITTFaxDecoderStream(InputStream, int, int, long, boolean); when two; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.<init>(InputStream, int, int, long, boolean)"})
  void testNewCCITTFaxDecoderStream_whenTwo_thenDoesNotThrow() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new CCITTFaxDecoderStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead2() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead3() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead4() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 2, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead5() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), -1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead6() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead7() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, false);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead8() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, false);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead9() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead10() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);
    ccittFaxDecoderStream.skip(2L);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead11() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);
    ccittFaxDecoderStream.skip(2L);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt2() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 0, 0, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt3() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt4() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt5() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), -1, 2, 1L, true);

    // Act and Assert
    assertThrows(
        IOException.class, () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt6() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 31, -121, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt7() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, false);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt8() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, false);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 0, 0, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt9() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt10() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);
    ccittFaxDecoderStream.skip(2L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 0, 0, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt11() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    ccittFaxDecoderStream.skip(2L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', -121, -2, 0, 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt12() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);
    ccittFaxDecoderStream.skip(2L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithOneAndX()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code A@AXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then 'AXAXAXAX' Bytes is 'UTF-8' is 'A@AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenAxaxaxaxBytesIsUtf8IsAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 4, 1L, true);
    ccittFaxDecoderStream.skip(2L);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals("A@AXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndMin_value()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ccittFaxDecoderStream.read(b, 1, 3));
    assertArrayEquals(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, b);
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);

    // Act and Assert
    assertThrows(
        IOException.class, () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new IllegalArgumentException());
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ccittFaxDecoderStream.read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(stream).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with one and {@code X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with array of byte with one and 'X'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithOneAndX_thenReturnZero()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with zero and {@code X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX_thenReturnZero()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertEquals(0, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Then return one hundred thirty-five.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred thirty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenReturnOneHundredThirtyFive() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    ccittFaxDecoderStream.skip(2L);

    // Act and Assert
    assertEquals(135, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Then return one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenReturnOneHundredTwentyEight() throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertEquals(128, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Then return {@link Double#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenReturnSize() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 4, 1L, true);
    ccittFaxDecoderStream.skip(2L);

    // Act and Assert
    assertEquals(Double.SIZE, ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.read());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#read()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#read()}
   */
  @Test
  @DisplayName("Test read(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CCITTFaxDecoderStream.read()"})
  void testRead_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new IllegalArgumentException());
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ccittFaxDecoderStream.read());
    verify(stream).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip2() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);

    // Act and Assert
    assertEquals(-1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip3() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip4() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 2, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip5() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), -1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip6() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip7() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, false);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip8() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, false);

    // Act and Assert
    assertEquals(-1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip9() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip10() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, true);
    ccittFaxDecoderStream.read(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}, 2, 3);

    // Act and Assert
    assertEquals(-1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip11() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    ccittFaxDecoderStream.read(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}, 2, 3);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip12() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 4, 1L, false);
    ccittFaxDecoderStream.read(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}, 2, 3);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip13() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 4, 1L, true);
    ccittFaxDecoderStream.read(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}, 2, 3);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with one and {@code X}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName(
      "Test skip(long); given ByteArrayInputStream(byte[]) with array of byte with one and 'X'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithArrayOfByteWithOneAndX_thenReturnOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with one and {@code X}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName(
      "Test skip(long); given ByteArrayInputStream(byte[]) with array of byte with one and 'X'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithArrayOfByteWithOneAndX_thenReturnOne2()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with zero and {@code X}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName(
      "Test skip(long); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX_thenReturnOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertEquals(1L, ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.skip(1L));
  }

  /**
   * Test {@link CCITTFaxDecoderStream#skip(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CCITTFaxDecoderStream.skip(long)"})
  void testSkip_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream stream = mock(DataInputStream.class);
    when(stream.read()).thenThrow(new IllegalArgumentException());
    CCITTFaxDecoderStream ccittFaxDecoderStream = new CCITTFaxDecoderStream(stream, 1, 4, 1L, true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ccittFaxDecoderStream.skip(1L));
    verify(stream).read();
  }

  /**
   * Test {@link CCITTFaxDecoderStream#markSupported()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CCITTFaxDecoderStream.markSupported()"})
  void testMarkSupported_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Act and Assert
    assertFalse(ccittFaxDecoderStream.markSupported());
  }

  /**
   * Test {@link CCITTFaxDecoderStream#reset()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxDecoderStream#reset()}
   */
  @Test
  @DisplayName("Test reset(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxDecoderStream.reset()"})
  void testReset_thenThrowIOException() throws IOException {
    // Arrange
    CCITTFaxDecoderStream ccittFaxDecoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);

    // Act and Assert
    assertThrows(IOException.class, () -> ccittFaxDecoderStream.reset());
  }
}
