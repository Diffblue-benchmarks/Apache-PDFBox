package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JPEGFactoryDiffblueTest {
  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'; then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage_thenCOSObjectReturnCOSStream() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    assertTrue(actualCreateFromImageResult.getCOSObject() instanceof COSStream);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
    assertEquals("jpg", actualCreateFromImageResult.getSuffix());
    assertNull(actualCreateFromImageResult.getRawImage());
    assertNull(actualCreateFromImageResult.getColorKeyMask());
    assertNull(actualCreateFromImageResult.getDecode());
    assertNull(actualCreateFromImageResult.getMetadata());
    assertNull(actualCreateFromImageResult.getOptionalContent());
    assertNull(actualCreateFromImageResult.getMask());
    assertNull(actualCreateFromImageResult.getSoftMask());
    assertEquals(-1, actualCreateFromImageResult.getStructParent());
    assertEquals(1, actualCreateFromImageResult.getHeight());
    assertEquals(1, actualCreateFromImageResult.getWidth());
    assertEquals(8, actualCreateFromImageResult.getBitsPerComponent());
    assertFalse(actualCreateFromImageResult.getInterpolate());
    assertFalse(actualCreateFromImageResult.isEmpty());
    assertFalse(actualCreateFromImageResult.isStencil());
  }
}
