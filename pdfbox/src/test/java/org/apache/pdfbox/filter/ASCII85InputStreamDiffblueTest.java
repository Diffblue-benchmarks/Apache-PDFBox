package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCII85InputStreamDiffblueTest {
  /**
   * Test {@link ASCII85InputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85InputStream.close()"})
  void testClose_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenDoesNotThrow()
      throws IOException {
    // Arrange
    try (ASCII85InputStream ascii85InputStream =
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))) {}
  }

  /**
   * Test {@link ASCII85InputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85InputStream.close()"})
  void testClose_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenDoesNotThrow2()
      throws IOException {
    // Arrange
    try (ASCII85InputStream ascii85InputStream =
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))) {}
  }

  /**
   * Test {@link ASCII85InputStream#markSupported()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ASCII85InputStream.markSupported()"})
  void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .markSupported());
  }

  /**
   * Test {@link ASCII85InputStream#markSupported()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ASCII85InputStream.markSupported()"})
  void testMarkSupported2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .markSupported());
  }

  /**
   * Test {@link ASCII85InputStream#available()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.available()"})
  void testAvailable() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).available());
  }

  /**
   * Test {@link ASCII85InputStream#available()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.available()"})
  void testAvailable2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).available());
  }
}
