package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDTextAppearanceHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDTextAppearanceHandler#PDTextAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDTextAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDTextAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDTextAppearanceHandler actualPdTextAppearanceHandler = new PDTextAppearanceHandler(annotation);
    actualPdTextAppearanceHandler.generateDownAppearance();
    actualPdTextAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdTextAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdTextAppearanceHandler.getAnnotation());
  }
}
