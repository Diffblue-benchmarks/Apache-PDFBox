package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDSquigglyAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDSquigglyAppearanceHandler#PDSquigglyAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSquigglyAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSquigglyAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDSquigglyAppearanceHandler actualPdSquigglyAppearanceHandler = new PDSquigglyAppearanceHandler(annotation);
    actualPdSquigglyAppearanceHandler.generateDownAppearance();
    actualPdSquigglyAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdSquigglyAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdSquigglyAppearanceHandler.getAnnotation());
  }
}
