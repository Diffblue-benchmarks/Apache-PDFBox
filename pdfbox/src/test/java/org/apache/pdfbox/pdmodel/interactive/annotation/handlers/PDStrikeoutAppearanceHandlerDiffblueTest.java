package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDStrikeoutAppearanceHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDStrikeoutAppearanceHandler#PDStrikeoutAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDStrikeoutAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDStrikeoutAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDStrikeoutAppearanceHandler actualPdStrikeoutAppearanceHandler = new PDStrikeoutAppearanceHandler(annotation);
    actualPdStrikeoutAppearanceHandler.generateDownAppearance();
    actualPdStrikeoutAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdStrikeoutAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdStrikeoutAppearanceHandler.getAnnotation());
  }
}
