package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CreateSignedTimeStampDiffblueTest {
  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File)} with {@code file}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File)}
   */
  @Test
  @DisplayName("Test signDetached(File) with 'file'; then throw FileNotFoundException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CreateSignedTimeStamp.signDetached(File)"})
  void testSignDetachedWithFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");

    // Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> createSignedTimeStamp.signDetached(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Test {@link CreateSignedTimeStamp#signDetached(File, File)} with {@code inFile}, {@code outFile}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSignedTimeStamp#signDetached(File, File)}
   */
  @Test
  @DisplayName("Test signDetached(File, File) with 'inFile', 'outFile'; then throw FileNotFoundException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CreateSignedTimeStamp.signDetached(File, File)"})
  void testSignDetachedWithInFileOutFile_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("https://example.org/example");
    File inFile = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createSignedTimeStamp.signDetached(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link CreateSignedTimeStamp#sign(InputStream)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSignedTimeStamp#sign(InputStream)}
   */
  @Test
  @DisplayName("Test sign(InputStream); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CreateSignedTimeStamp.sign(InputStream)"})
  void testSign_thenReturnEmptyArrayOfByte() throws IOException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));
      CreateSignedTimeStamp createSignedTimeStamp = new CreateSignedTimeStamp("Opening connection to TSA server");

      // Act and Assert
      assertArrayEquals(new byte[]{},
          createSignedTimeStamp.sign(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    }
  }
}
