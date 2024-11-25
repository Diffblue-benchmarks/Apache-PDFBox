package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateEmbeddedTimeStampDiffblueTest {
  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)} with {@code file}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)}
   */
  @Test
  @DisplayName("Test embedTimeStamp(File) with 'file'; then throw FileNotFoundException")
  void testEmbedTimeStampWithFile_thenThrowFileNotFoundException() throws IOException, URISyntaxException {
    // Arrange
    CreateEmbeddedTimeStamp createEmbeddedTimeStamp = new CreateEmbeddedTimeStamp("https://example.org/example");

    // Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> createEmbeddedTimeStamp.embedTimeStamp(Paths.get(System.getProperty("java.io.tmpdir"), "name").toFile()));
  }

  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)} with
   * {@code inFile}, {@code outFile}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)}
   */
  @Test
  @DisplayName("Test embedTimeStamp(File, File) with 'inFile', 'outFile'; then throw FileNotFoundException")
  void testEmbedTimeStampWithInFileOutFile_thenThrowFileNotFoundException() throws IOException, URISyntaxException {
    // Arrange
    CreateEmbeddedTimeStamp createEmbeddedTimeStamp = new CreateEmbeddedTimeStamp("https://example.org/example");
    File inFile = Paths
        .get(System.getProperty("java.io.tmpdir"), "org.apache.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange")
        .toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createEmbeddedTimeStamp.embedTimeStamp(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
