package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CCITTFactoryDiffblueTest {
  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   * <p>
   * Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CCITTFactory.createFromImage(document, new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[])} with {@code document}, {@code byteArray}.
   * <p>
   * Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[]) with 'document', 'byteArray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[])"})
  void testCreateFromByteArrayWithDocumentByteArray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)} with {@code document}, {@code byteArray}, {@code number}.
   * <p>
   * Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], int) with 'document', 'byteArray', 'number'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[], int)"})
  void testCreateFromByteArrayWithDocumentByteArrayNumber() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8"), 10));
  }
}
