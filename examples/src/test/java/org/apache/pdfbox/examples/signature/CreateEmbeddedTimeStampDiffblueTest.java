package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class CreateEmbeddedTimeStampDiffblueTest {
  /**
   * Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)}
   */
  @Test
  void testEmbedTimeStamp() throws IOException, URISyntaxException {
    // Arrange
    CreateEmbeddedTimeStamp createEmbeddedTimeStamp = new CreateEmbeddedTimeStamp("https://example.org/example");

    // Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> createEmbeddedTimeStamp.embedTimeStamp(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)}
   */
  @Test
  void testEmbedTimeStamp2() throws IOException, URISyntaxException {
    // Arrange
    CreateEmbeddedTimeStamp createEmbeddedTimeStamp = new CreateEmbeddedTimeStamp("https://example.org/example");
    File inFile = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> createEmbeddedTimeStamp.embedTimeStamp(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
