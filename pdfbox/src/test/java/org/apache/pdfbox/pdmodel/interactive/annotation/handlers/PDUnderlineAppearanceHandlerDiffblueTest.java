package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDUnderlineAppearanceHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDUnderlineAppearanceHandler#PDUnderlineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDUnderlineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDUnderlineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
