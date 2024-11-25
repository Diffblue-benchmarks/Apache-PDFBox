package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDVisibleSignDesignerDiffblueTest {
  /**
   * Test
   * {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}.
   * <ul>
   *   <li>Then return SignatureFieldName is {@code sig}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}
   */
  @Test
  @DisplayName("Test new PDVisibleSignDesigner(PDDocument, BufferedImage, int); then return SignatureFieldName is 'sig'")
  void testNewPDVisibleSignDesigner_thenReturnSignatureFieldNameIsSig() {
    // Arrange
    new IllegalArgumentException("foo");

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act
    PDVisibleSignDesigner actualPdVisibleSignDesigner = new PDVisibleSignDesigner(document, image, 1);

    // Assert
    assertEquals("sig", actualPdVisibleSignDesigner.getSignatureFieldName());
    AffineTransform transform = actualPdVisibleSignDesigner.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getHeight());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getWidth());
    assertEquals(100.0f, actualPdVisibleSignDesigner.getImageSizeInPercents());
    assertEquals(612.0f, actualPdVisibleSignDesigner.getPageWidth());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getPageHeight());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getTemplateHeight());
    assertTrue(transform.isIdentity());
    assertSame(image, actualPdVisibleSignDesigner.getImage());
    assertArrayEquals(new int[]{0, 0, 1, 1}, actualPdVisibleSignDesigner.getFormatterRectangleParameters());
  }
}
