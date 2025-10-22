package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDPolylineAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPolylineAppearanceHandler#PDPolylineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDPolylineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDPolylineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolylineAppearanceHandler.<init>(PDAnnotation)",
      "void PDPolylineAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDPolylineAppearanceHandler.generateDownAppearance()",
      "void PDPolylineAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDPolylineAppearanceHandler actualPdPolylineAppearanceHandler = new PDPolylineAppearanceHandler(annotation);
    actualPdPolylineAppearanceHandler.generateDownAppearance();
    actualPdPolylineAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdPolylineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdPolylineAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDPolylineAppearanceHandler#getLineWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolylineAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDPolylineAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPolylineAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }
}
