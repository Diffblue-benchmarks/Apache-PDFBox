package org.apache.pdfbox.util.filetypedetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileTypeDetectorDiffblueTest {
  /**
   * Method under test:
   * {@link FileTypeDetector#detectFileType(BufferedInputStream)}
   */
  @Test
  void testDetectFileType() throws IOException {
    // Arrange, Act and Assert
    assertEquals(FileType.UNKNOWN, FileTypeDetector
        .detectFileType(new BufferedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1)));
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(
        new BufferedInputStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}), 1)));
    assertThrows(IOException.class,
        () -> FileTypeDetector.detectFileType(new BufferedInputStream(new ByteArrayInputStream(new byte[]{}), 1)));
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertEquals(FileType.UNKNOWN, FileTypeDetector.detectFileType(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link FileTypeDetector#detectFileType(BufferedInputStream)}
   */
  @Test
  void testDetectFileType2() throws IOException {
    // Arrange
    DataInputStream dataInputStream = mock(DataInputStream.class);
    when(dataInputStream.available()).thenReturn(1);
    when(dataInputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);

    // Act
    FileType actualDetectFileTypeResult = FileTypeDetector.detectFileType(new BufferedInputStream(dataInputStream, 1));

    // Assert
    verify(dataInputStream, atLeast(1)).read(Mockito.<byte[]>any(), anyInt(), anyInt());
    verify(dataInputStream, atLeast(1)).available();
    assertEquals(FileType.UNKNOWN, actualDetectFileTypeResult);
  }
}
