package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CCITTFactoryDiffblueTest {
  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   * <p>
   * Method under test:
   * {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage)")
  void testCreateFromImage() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CCITTFactory.createFromImage(document, new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[])} with
   * {@code document}, {@code byteArray}.
   * <p>
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[]) with 'document', 'byteArray'")
  void testCreateFromByteArrayWithDocumentByteArray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)} with
   * {@code document}, {@code byteArray}, {@code number}.
   * <p>
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], int) with 'document', 'byteArray', 'number'")
  void testCreateFromByteArrayWithDocumentByteArrayNumber() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link CCITTFactory#createFromFile(PDDocument, File)} with
   * {@code document}, {@code file}.
   * <p>
   * Method under test: {@link CCITTFactory#createFromFile(PDDocument, File)}
   */
  @Test
  @DisplayName("Test createFromFile(PDDocument, File) with 'document', 'file'")
  void testCreateFromFileWithDocumentFile() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromFile(document,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link CCITTFactory#createFromFile(PDDocument, File, int)} with
   * {@code document}, {@code file}, {@code number}.
   * <p>
   * Method under test: {@link CCITTFactory#createFromFile(PDDocument, File, int)}
   */
  @Test
  @DisplayName("Test createFromFile(PDDocument, File, int) with 'document', 'file', 'number'")
  void testCreateFromFileWithDocumentFileNumber() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromFile(document,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), 10));
  }
}
