package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDUnderlineAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDUnderlineAppearanceHandler#PDUnderlineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDUnderlineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDUnderlineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDUnderlineAppearanceHandler actualPdUnderlineAppearanceHandler = new PDUnderlineAppearanceHandler(annotation);
    actualPdUnderlineAppearanceHandler.generateDownAppearance();
    actualPdUnderlineAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdUnderlineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdUnderlineAppearanceHandler.getAnnotation());
  }
}
