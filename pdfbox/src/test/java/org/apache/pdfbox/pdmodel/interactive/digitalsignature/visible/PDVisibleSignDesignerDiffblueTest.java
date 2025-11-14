package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDVisibleSignDesignerDiffblueTest {
  /**
   * Test {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return SignatureFieldName is {@code sig}.
   * </ul>
   *
   * <p>Method under test: {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument,
   * BufferedImage, int)}
   */
  @Test
  @DisplayName(
      "Test new PDVisibleSignDesigner(PDDocument, BufferedImage, int); given PDPage(); then return SignatureFieldName is 'sig'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDVisibleSignDesigner.<init>(PDDocument, BufferedImage, int)"})
  void testNewPDVisibleSignDesigner_givenPDPage_thenReturnSignatureFieldNameIsSig() {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act
    PDVisibleSignDesigner actualPdVisibleSignDesigner =
        new PDVisibleSignDesigner(document, image, 1);

    // Assert
    assertEquals("sig", actualPdVisibleSignDesigner.getSignatureFieldName());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getHeight());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getWidth());
    assertEquals(100.0f, actualPdVisibleSignDesigner.getImageSizeInPercents());
    assertEquals(612.0f, actualPdVisibleSignDesigner.getPageWidth());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getPageHeight());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getTemplateHeight());
    assertSame(image, actualPdVisibleSignDesigner.getImage());
    assertArrayEquals(
        new int[] {0, 0, 1, 1}, actualPdVisibleSignDesigner.getFormatterRectangleParameters());
  }
}
