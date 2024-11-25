package org.apache.pdfbox.util.filetypedetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileTypeDetectorDiffblueTest {
  /**
   * Test {@link FileTypeDetector#detectFileType(byte[])} with {@code fileBytes}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeDetector#detectFileType(byte[])}
   */
  @Test
  @DisplayName("Test detectFileType(byte[]) with 'fileBytes'; when 'A'")
  void testDetectFileTypeWithFileBytes_whenA() {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link FileTypeDetector#detectFileType(byte[])} with {@code fileBytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeDetector#detectFileType(byte[])}
   */
  @Test
  @DisplayName("Test detectFileType(byte[]) with 'fileBytes'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  void testDetectFileTypeWithFileBytes_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link FileTypeDetector#detectFileType(byte[])} with {@code fileBytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeDetector#detectFileType(byte[])}
   */
  @Test
  @DisplayName("Test detectFileType(byte[]) with 'fileBytes'; when empty array of byte")
  void testDetectFileTypeWithFileBytes_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(new byte[]{}));
  }

  /**
   * Test {@link FileTypeDetector#detectFileType(BufferedInputStream)} with
   * {@code inputStream}.
   * <p>
   * Method under test:
   * {@link FileTypeDetector#detectFileType(BufferedInputStream)}
   */
  @Test
  @DisplayName("Test detectFileType(BufferedInputStream) with 'inputStream'")
  void testDetectFileTypeWithInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector
        .detectFileType(new BufferedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1)));
  }

  /**
   * Test {@link FileTypeDetector#detectFileType(BufferedInputStream)} with
   * {@code inputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileTypeDetector#detectFileType(BufferedInputStream)}
   */
  @Test
  @DisplayName("Test detectFileType(BufferedInputStream) with 'inputStream'; then throw IOException")
  void testDetectFileTypeWithInputStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> FileTypeDetector.detectFileType(new BufferedInputStream(new ByteArrayInputStream(new byte[]{}), 1)));
  }

  /**
   * Test {@link FileTypeDetector#detectFileType(BufferedInputStream)} with
   * {@code inputStream}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileTypeDetector#detectFileType(BufferedInputStream)}
   */
  @Test
  @DisplayName("Test detectFileType(BufferedInputStream) with 'inputStream'; when 'A'; then return 'UNKNOWN'")
  void testDetectFileTypeWithInputStream_whenA_thenReturnUnknown() throws IOException {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(
        new BufferedInputStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1)));
  }
}
